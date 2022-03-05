package ru.yvzorin.someservice.application.userapplication;


import ru.yvzorin.someservice.domain.model.kafedra.Kafedra;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * @author Yury Zorin
 */
public class KafedraSaveRequest {

    @NotBlank(message = "The last name is required.")
    private String lastName;

    @NotBlank(message = "The name is required.")
    private String name;

    private String middleName;

    @NotNull(message = "The birth date is required.")
    @PastOrPresent
    private LocalDate birthDate;

    private List<AnalysisData> analyses;

    public KafedraSaveRequest(@NotBlank String lastName,
                              @NotBlank String name,
                              String middleName,
                              @NotNull LocalDate birthDate,
                              List<AnalysisData> analyses) {
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.analyses = analyses;
    }

    public String lastName() {
        return lastName;
    }

    public String name() {
        return name;
    }

    public String middleName() {
        return middleName;
    }

    public LocalDate birthDate() {
        return birthDate;
    }

    public List<AnalysisData> analyses() {
        return Collections.unmodifiableList(analyses);
    }

    public Kafedra toDomain() {
        return null;
    }

    private static class AnalysisData {

        @NotBlank(message = "The analysis is required.")
        private String analysis;

        public AnalysisData(@NotBlank String analysis) {
            this.analysis = analysis;
        }
    }
}
