package nl.codeforall.teamnull.converter;

import nl.codeforall.teamnull.command.TeacherDto;
import nl.codeforall.teamnull.persistence.model.School;
import nl.codeforall.teamnull.persistence.model.Teacher;
import nl.codeforall.teamnull.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TeacherConverter {

    private GenericService<Teacher, School> teacherService;


    @Autowired
    @Qualifier("teacherService")
    public void setTeacherService(GenericService<Teacher, School> teacherService) {
        this.teacherService = teacherService;
    }

    public Teacher dtoToTeacher(TeacherDto teacherDto){

        Teacher teacher = (teacherDto.getId() != null ? teacherService.get(teacherDto.getId()) : new Teacher());

        teacher.setName(teacherDto.getName());
        teacher.setId(teacherDto.getId());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setBiography(teacherDto.getBiography());
        teacher.setCity(teacherDto.getCity());
        teacher.setCountry(teacherDto.getCountry());
        teacher.setImageLink(teacherDto.getImageLink());
        teacher.setPreferredCountries(teacherDto.getPreferredCountries());
        teacher.setSubject(teacherDto.getSubject());
        teacher.setStartDate(teacherDto.getStartDate());
        teacher.setEndDate(teacherDto.getEndDate());

        return teacher;

    }

    public TeacherDto teacherToDto(Teacher teacher){

        TeacherDto teacherDto = new TeacherDto();

        teacherDto.setName(teacher.getName());
        teacherDto.setId(teacher.getId());
        teacherDto.setEmail(teacher.getEmail());
        teacherDto.setBiography(teacher.getBiography());
        teacherDto.setCity(teacher.getCity());
        teacherDto.setImageLink(teacher.getImageLink());
        teacherDto.setCountry(teacher.getCountry());
        teacherDto.setPreferredCountries(teacher.getPreferredCountries());
        teacherDto.setSubject(teacher.getSubject());
        teacherDto.setStartDate(teacher.getStartDate());
        teacherDto.setEndDate(teacher.getEndDate());

        return teacherDto;
    }
}
