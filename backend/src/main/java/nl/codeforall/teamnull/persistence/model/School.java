package nl.codeforall.teamnull.persistence.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "schools")
public class School extends Model {


    private String city;
    private String country;

    @Column
    @ElementCollection(
            targetClass = String.class,
            fetch = FetchType.EAGER
    )
    @Fetch(value = FetchMode.SELECT)
    private List<String> subjects = new LinkedList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "school",
            fetch = FetchType.EAGER
    )
    @Fetch(FetchMode.SELECT)
    private List<Teacher> teachers = new ArrayList<>();

    private Date startDate;
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
