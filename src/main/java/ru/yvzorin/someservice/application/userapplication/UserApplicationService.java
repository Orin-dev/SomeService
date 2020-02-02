package ru.yvzorin.someservice.application.userapplication;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yvzorin.someservice.domain.model.userapplication.UserApplication;
import ru.yvzorin.someservice.domain.model.userapplication.UserApplicationRepository;

/**
 * @author Yury Zorin
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserApplicationService {

    @Autowired
    private UserApplicationRepository repository;

    public void saveUserApplication(UserApplicationRequest request) {
        this.repository.save(request.toDomain());
    }

    public UserApplication getUserApplication(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("The application of id " + id + " not found."));
    }
}
