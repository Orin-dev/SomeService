package ru.yvzorin.someservice.domain.model.userapplication;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import ru.yvzorin.someservice.domain.model.analysis.Analysis;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

/**
 * @author Yury Zorin
 */
@Entity
@Table(name = "applications")
@JsonAutoDetect(fieldVisibility = ANY)
public class UserApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "application_id_generator")
    private long id;

    @Column(nullable = false, updatable = false)
    private String lastName;

    @Column(nullable = false, updatable = false)
    private String firstName;

    @Column
    private String middleName;

    @Column(nullable = false, updatable = false)
    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "application", cascade = CascadeType.ALL)
    private List<Analysis> analyses;

    public UserApplication(String lastName,
                           String firstName,
                           String middleName,
                           LocalDate birthDate,
                           List<Analysis> analyses) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.analyses = analyses;
    }

    protected UserApplication() {
        // for JPA
    }

    public String lastName() {
        return lastName;
    }

    public String firstName() {
        return firstName;
    }

    public String middleName() {
        return middleName;
    }

    public LocalDate birthDate() {
        return birthDate;
    }

    public List<Analysis> analyses() {
        return Collections.unmodifiableList(analyses);
    }

}
