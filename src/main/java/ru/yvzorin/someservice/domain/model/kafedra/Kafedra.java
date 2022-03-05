package ru.yvzorin.someservice.domain.model.kafedra;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

/**
 * @author Yury Zorin <yuri.zorin@bostongene.com>
 */
@Entity
@Table(name = "kafedras")
@JsonAutoDetect(fieldVisibility = ANY)
public class Kafedra {
    @Column(nullable = false, updatable = false)
    private final int yearOfEstablishment;
    @Column(nullable = false, updatable = false)
    private final int number;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "application_id_generator")
    private long id;
    @Column(nullable = false, updatable = true)
    private String zavKaf;

    @Column(nullable = false, updatable = true)
    private String zamZavkaf;

    public Kafedra(String zavKaf, String zamZavkaf, int yearOfEstablishment, int number) {
        if (yearOfEstablishment <= 0 || number <= 0)
            throw new RuntimeException("Числа не могут быть отрицательными");
        this.yearOfEstablishment = yearOfEstablishment;
        this.zavKaf = zavKaf;
        this.zamZavkaf = zamZavkaf;
        this.number = number;
    }

    public void changeZavKaf(String zavKaf) {
        this.zavKaf = zavKaf;
    }

    public void changeZamZavkaf(String zamZavkaf) {
        this.zamZavkaf = zamZavkaf;
    }

    public void printInformation() {
        System.out.println("Кафедра " + this.number + "\n Заведующий: " + this.zavKaf + "\n Заместитель: "
                + this.zamZavkaf + "\n Год основания" + this.yearOfEstablishment);
    }

    public void methodWithException() throws Exception {
        throw new Exception("Просто эксепшн, чтоб был");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kafedra kafedra = (Kafedra) o;
        return yearOfEstablishment == kafedra.yearOfEstablishment && number == kafedra.number && Objects.equals(zavKaf, kafedra.zavKaf) && Objects.equals(zamZavkaf, kafedra.zamZavkaf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(yearOfEstablishment, number, zavKaf, zamZavkaf);
    }
}
