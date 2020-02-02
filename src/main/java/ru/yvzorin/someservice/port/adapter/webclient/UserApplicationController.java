package ru.yvzorin.someservice.port.adapter.webclient;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yvzorin.someservice.application.userapplication.UserApplicationRequest;
import ru.yvzorin.someservice.application.userapplication.UserApplicationService;

import javax.validation.Valid;

/**
 * @author Yury Zorin
 */
@RestController
@RequiredArgsConstructor
public class UserApplicationController {

    @Autowired
    private UserApplicationService userApplicationService;

    @PostMapping("/api/application")
    ResponseEntity<Object> createApplication(@RequestBody @Valid UserApplicationRequest request) {
        this.userApplicationService.saveUserApplication(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/application/{id}")
    ResponseEntity<Object> getApplication(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(this.userApplicationService.getUserApplication(id));
    }
}
