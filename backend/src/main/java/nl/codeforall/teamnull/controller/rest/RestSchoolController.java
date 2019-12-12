package nl.codeforall.teamnull.controller.rest;


import nl.codeforall.teamnull.persistence.model.School;
import nl.codeforall.teamnull.services.GenericService;
import nl.codeforall.teamnull.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/school")
public class RestSchoolController {

    private GenericService<School> service;

    @Autowired
    @Qualifier("schoolService")
    public void setService(GenericService<School> service) {
        this.service = service;
    }

    @GetMapping(
            value = {"", "/"},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<School>> listSchools() {

        List<School> schools = service.list();

        return new ResponseEntity<>(schools, HttpStatus.OK);
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<School> listSchool(@PathVariable Integer id) {

        School school = service.list().get(id - 1);

        return new ResponseEntity<>(school, HttpStatus.OK);
    }

    @PostMapping(
            value = "/add"
    )
    public ResponseEntity<?> addSchool(@RequestBody School school, UriComponentsBuilder uriComponentsBuilder) {

        School savedSchool = service.save(school);

        UriComponents uriComponents = UriComponentsBuilder.fromPath("/api/school/" + savedSchool.getId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.OK);
    }


}
