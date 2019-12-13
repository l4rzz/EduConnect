package nl.codeforall.teamnull.converter;

import nl.codeforall.teamnull.command.SchoolDto;
import nl.codeforall.teamnull.persistence.model.School;
import nl.codeforall.teamnull.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SchoolConverter {

    private SchoolService service;

    @Autowired
    public void setService(SchoolService service) {
        this.service = service;
    }

    public School dtoToSchool(SchoolDto schoolDto) {

        School school = (schoolDto.getId() != null ? service.get(schoolDto.getId()) : new School());

        school.setName(schoolDto.getName());
        school.setEmail(schoolDto.getEmail());
        school.setImageLink(schoolDto.getImageLink());
        school.setCity(schoolDto.getCity());
        school.setCountry(schoolDto.getCountry());
        school.setSubjects(schoolDto.getSubjects());
        school.setTeachers(schoolDto.getTeachers());
        school.setStartDate(schoolDto.getStartDate());
        school.setEndDate(schoolDto.getEndDate());

        return school;
    }

    public SchoolDto schoolToDto(School school) {

        SchoolDto schoolDto = new SchoolDto();

        schoolDto.setName(school.getName());
        schoolDto.setEmail(school.getEmail());
        schoolDto.setImageLink(school.getImageLink());
        schoolDto.setCity(school.getCity());
        schoolDto.setCountry(school.getCountry());
        schoolDto.setSubjects(school.getSubjects());
        schoolDto.setTeachers(school.getTeachers());
        schoolDto.setEndDate(school.getEndDate());
        schoolDto.setStartDate(school.getStartDate());

        return schoolDto;
    }
}
