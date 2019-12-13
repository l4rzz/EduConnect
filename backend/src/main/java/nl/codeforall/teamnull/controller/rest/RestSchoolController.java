package nl.codeforall.teamnull.controller.rest;


import nl.codeforall.teamnull.command.SchoolDto;
import nl.codeforall.teamnull.converter.SchoolConverter;
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
@RequestMapping("/api/school")
public class RestSchoolController {

    private GenericService<School, Teacher> service;

    private SchoolConverter converter;

    @Autowired
    @Qualifier("schoolService")
    public void setService(GenericService<School, Teacher> service) {
        this.service = service;
    }

    @Autowired
    public void setConverter(SchoolConverter converter) {
        this.converter = converter;
    }

    @GetMapping(
            value = {"", "/"},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<SchoolDto>> listSchools() {

        List<SchoolDto> schoolDtos = new LinkedList<>();
        for (School school : service.list()) {
            schoolDtos.add(converter.schoolToDto(school));
        }

        return new ResponseEntity<>(schoolDtos, HttpStatus.OK);
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SchoolDto> listSchool(@PathVariable Integer id) {

        School school = service.list().get(id);

        return new ResponseEntity<>(converter.schoolToDto(school), HttpStatus.OK);
    }

    @PostMapping(
            value = "/add",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> addSchool(@RequestBody SchoolDto schoolDto, UriComponentsBuilder uriComponentsBuilder) {

        School savedSchool = service.save(converter.dtoToSchool(schoolDto));

        UriComponents uriComponents = uriComponentsBuilder.path("/api/school/" + savedSchool.getId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @GetMapping(
            value = "/{id}/match",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> matchWithTeachers(@PathVariable Integer id) {

        return new ResponseEntity<>(service.match(id), HttpStatus.OK);
    }

    @DeleteMapping(
            value = "/{id}/remove",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity removeSchool(@PathVariable Integer id) {

        service.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(
            value = "/{id}/update",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> updateSchool(@PathVariable Integer id, @RequestBody SchoolDto schoolDto) {
        schoolDto.setId(id);
        if (schoolDto.getId().equals(id)) {
            School school = converter.dtoToSchool(schoolDto);
            service.save(school);
            return new ResponseEntity<>(school, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
