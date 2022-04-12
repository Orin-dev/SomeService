package ru.yvzorin.someservice.application.userapplication;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Value;
import ru.yvzorin.someservice.domain.model.kafedra.Kafedra;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Yury Zorin
 */
@Value
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class KafedraSaveRequest {

    @NotNull(message = "Должно быть задано")
    Integer number;

    @NotBlank(message = "Должно быть задано")
    String zavKaf;

    @NotBlank(message = "Должно быть задано")
    String zamZavkaf;

    @NotNull(message = "Должно быть задано")
    Integer yearOfEstablishment;

    public KafedraSaveRequest(Integer number, String zavKaf, String zamZavkaf, Integer yearOfEstablishment) {
        this.number = number;
        this.zavKaf = zavKaf;
        this.zamZavkaf = zamZavkaf;
        this.yearOfEstablishment = yearOfEstablishment;
    }

    public Kafedra toDomain() {
        return new Kafedra(this.zavKaf, this.zamZavkaf, this.yearOfEstablishment, this.number);
    }

    public Integer number() {
        return number;
    }
}
