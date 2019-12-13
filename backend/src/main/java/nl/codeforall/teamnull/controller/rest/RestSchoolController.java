package nl.codeforall.teamnull.controller.rest;


import nl.codeforall.teamnull.command.SchoolDto;
import nl.codeforall.teamnull.converter.SchoolConverter;
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

import java.util.LinkedList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/school")
public class RestSchoolController {

    private GenericService<School> service;

    private SchoolConverter converter;

    @Autowired
    @Qualifier("schoolService")
    public void setService(GenericService<School> service) {
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

        List<School> schools = service.list();
        List<SchoolDto> schoolDtos = new LinkedList<>();
        for (School school : schools) {
            schoolDtos.add(converter.schoolToDto(school));
        }

        return new ResponseEntity<>(schoolDtos, HttpStatus.OK);
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SchoolDto> listSchool(@PathVariable Integer id) {

        School school = service.list().get(id - 1);

        return new ResponseEntity<>(converter.schoolToDto(school), HttpStatus.OK);
    }

    @PostMapping(
            value = "/add",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> addSchool(@RequestBody SchoolDto schoolDto, UriComponentsBuilder uriComponentsBuilder) {

        School savedSchool = service.save(converter.dtoToSchool(schoolDto));

        UriComponents uriComponents = UriComponentsBuilder.fromPath("/api/school/" + savedSchool.getId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @GetMapping(
            value = "{/id}/match}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> matchWithTeachers(@PathVariable Integer id) {

        return new ResponseEntity<>(service.match(id), HttpStatus.OK);
    }


}
