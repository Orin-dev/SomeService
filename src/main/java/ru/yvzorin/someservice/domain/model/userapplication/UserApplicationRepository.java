package ru.yvzorin.someservice.domain.model.userapplication;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yury Zorin
 */
public interface UserApplicationRepository extends JpaRepository<UserApplication, Long> {
}
