package ru.yvzorin.someservice.domain.model.analysis;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.yvzorin.someservice.domain.model.userapplication.UserApplication;

import javax.persistence.*;

/**
 * @author Yury Zorin
 */
@Entity
@Table(name = "analyses")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Analysis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "analysis_id_generator")
    private long id;

    @Column(updatable = false, insertable = false)
    private String analysis;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private UserApplication application;

    public Analysis(String analysis) {
        this.analysis = analysis;
    }

    @JsonProperty
    public String analysis() {
        return analysis;
    }

}
