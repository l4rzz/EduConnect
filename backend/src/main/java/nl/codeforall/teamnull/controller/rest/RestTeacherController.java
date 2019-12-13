package nl.codeforall.teamnull.controller.rest;

import nl.codeforall.teamnull.command.SchoolDto;
import nl.codeforall.teamnull.command.TeacherDto;
import nl.codeforall.teamnull.converter.TeacherConverter;
import nl.codeforall.teamnull.persistence.model.School;
import nl.codeforall.teamnull.persistence.model.Teacher;
import nl.codeforall.teamnull.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.LinkedList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/teacher")
public class RestTeacherController {

    private GenericService<Teacher, School> teacherService;

    private TeacherConverter converter;

    @Autowired
    @Qualifier("teacherService")
    public void setTeacherService(GenericService<Teacher, School> teacherService) {
        this.teacherService = teacherService;
    }

    @Autowired
    public void setConverter(TeacherConverter converter) {
        this.converter = converter;
    }

    @GetMapping(path = {"/", ""})
    public ResponseEntity<List<TeacherDto>> listTeachers() {
        List<TeacherDto> teacherDtos = new LinkedList<>();
        for (Teacher teacher : teacherService.list()) {
            teacherDtos.add(converter.teacherToDto(teacher));
        }

        return new ResponseEntity<>(teacherDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TeacherDto> listTeacher(@PathVariable Integer id) {

        Teacher teacher = teacherService.list().get(id);

        return new ResponseEntity<>(converter.teacherToDto(teacher), HttpStatus.OK);

    }

    @PostMapping(
            path = "/add",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> addTeacher(@RequestBody TeacherDto teacherDto, UriComponentsBuilder uriComponentsBuilder) {

        Teacher savedTeacher = teacherService.save(converter.dtoToTeacher(teacherDto));

        UriComponents uriComponents = uriComponentsBuilder.path("/api/teacher/" + savedTeacher.getId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping(
            path = "/{id}/match",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> matchWithSchools(@PathVariable Integer id) {

        return new ResponseEntity<>(teacherService.match(id), HttpStatus.OK);
    }

    @DeleteMapping(
            path = "/{id}/remove",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> removeTeacher(@PathVariable Integer id) {

        teacherService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(
            path = "/{id}/update",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id, @RequestBody TeacherDto teacherDto) {
        teacherDto.setId(id);
        if (teacherDto.getId().equals(id)) {
            Teacher teacher = converter.dtoToTeacher(teacherDto);
            teacherService.save(teacher);
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
