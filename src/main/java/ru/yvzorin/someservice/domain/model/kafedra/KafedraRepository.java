package ru.yvzorin.someservice.domain.model.kafedra;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Yury Zorin
 */
public interface KafedraRepository extends JpaRepository<Kafedra, Long> {

    List<Kafedra> findByNumber(int number);
}
