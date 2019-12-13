package nl.codeforall.teamnull.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends Model {


    private String subject;
    private String biography;

    @Column
    @ElementCollection(targetClass = String.class ,fetch = FetchType.EAGER)
    private List<String> preferredCountries = new ArrayList<>();

    @ManyToOne
    private School school;

    private Date startDate;
    private Date endDate;
    private String city;
    private String country;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<String> getPreferredCountries() {
        return preferredCountries;
    }

    public void setPreferredCountries(List<String> preferredCountries) {
        this.preferredCountries = preferredCountries;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
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
}
