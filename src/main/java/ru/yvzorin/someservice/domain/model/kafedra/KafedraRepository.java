package ru.yvzorin.someservice.domain.model.kafedra;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Yury Zorin
 */
public interface KafedraRepository extends JpaRepository<Kafedra, Long> {

    Optional<Kafedra> findByNumber(int number);
}
