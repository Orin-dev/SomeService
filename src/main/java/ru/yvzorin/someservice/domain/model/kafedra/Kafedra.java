package ru.yvzorin.someservice.domain.model.kafedra;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private int yearOfEstablishment;

    @Id
    @Column(nullable = false, updatable = false)
    private int number;

    @Column(nullable = false, updatable = true)
    private String zavKaf; //у колонки должно быть zav_kaf

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

    public Kafedra() {
        //empty
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
