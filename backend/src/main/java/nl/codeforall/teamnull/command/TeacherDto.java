package nl.codeforall.teamnull.command;

import nl.codeforall.teamnull.persistence.model.School;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class TeacherDto {

    private Integer id;

    @NotBlank(message = "Name is mandatory")
    @NotNull(message = "Name is mandatory")
    @Size(min = 3, max = 64)
    private String name;

    @NotBlank(message = "Email is mandatory")
    @NotNull(message = "Email is mandatory")
    @Pattern(regexp = "^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$", message = "Invalid email")
    private String email;

    @NotBlank(message = "City is mandatory")
    @NotNull(message = "City is mandatory")
    @Size(min = 3, max = 64)
    private String city;

    @NotBlank(message = "Country is mandatory")
    @NotNull(message = "Country is mandatory")
    @Size(min = 3, max = 64)
    private String country;

    @NotBlank(message = "Give at least one country")
    @NotNull(message = "Give at least one country")
    private List<String> preferredCountries;

    @NotBlank
    @NotNull
    private String imageLink;

    @NotBlank(message = "Biography is mandatory")
    @NotNull(message = "Biography is mandatory")
    @Size(min = 50, max = 500)
    private String biography;

    @NotBlank(message = "Subject is mandatory")
    @NotNull(message = "Subject is mandatory")
    @Size(min = 3, max = 64)
    private String subject;


    @NotBlank(message = "Please give a start date")
    @NotNull(message = "Please give a start date")
    private Date startDate;

    @NotBlank(message = "Please give an end date")
    @NotNull(message = "Please give an end date")
    private Date endDate;

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
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

    public List<String> getPreferredCountries() {
        return preferredCountries;
    }

    public void setPreferredCountries(List<String> preferredCountries) {
        this.preferredCountries = preferredCountries;
    }
}
