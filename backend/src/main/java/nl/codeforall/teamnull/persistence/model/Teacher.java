package nl.codeforall.teamnull.persistence.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends Model {

    @NotNull
    @NotBlank
    private String subject;

    @NotNull
    @NotBlank
    private String biography;

    @NotNull
    @NotBlank
    private List<String> preferredCountries;

    @ManyToOne
    private School school;

    @NotNull
    @NotBlank
    private Date startDate;

    @NotNull
    @NotBlank
    private Date endDate;


}
