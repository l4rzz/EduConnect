package nl.codeforall.teamnull.controller.rest;

import nl.codeforall.teamnull.persistence.model.School;
import nl.codeforall.teamnull.persistence.model.Teacher;
import nl.codeforall.teamnull.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/teacher")
public class RestTeacherController {

    private GenericService<Teacher, School> teacherService;
    private GenericService<School, Teacher> schoolService;

    @Autowired
    @Qualifier("schoolService")
    public void setSchoolService(GenericService<School, Teacher> schoolService) {
        this.schoolService = schoolService;
    }

    @Autowired
    @Qualifier("teacherService")
    public void setTeacherService(GenericService<Teacher, School> teacherService) {
        this.teacherService = teacherService;
    }


    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public List<Teacher> listTeachers(){
        List<Teacher> result = teacherService.list();

        return result;
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addTeacher(@RequestBody Teacher teacher, UriComponentsBuilder uriComponentsBuilder) {

        Teacher savedTeacher = teacherService.save(teacher);

        UriComponents uriComponents = uriComponentsBuilder.path("/api/teacher/" + savedTeacher.getId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


}
