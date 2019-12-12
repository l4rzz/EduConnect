package nl.codeforall.teamnull.persistence.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "schools")
public class School extends Model {

    @NotNull
    @NotBlank
    private String city;

    @NotNull
    @NotBlank
    private String country;

    @NotNull
    @NotBlank
    private List<String> subjects;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "schools",
            fetch = FetchType.EAGER
    )
    private List<Teacher> teachers;

    @NotNull
    @NotBlank
    private Date startDate;

    @NotNull
    @NotBlank
    private Date endDate;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
