package ru.yvzorin.someservice.port.adapter.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yvzorin.someservice.application.userapplication.KafedraSaveRequest;
import ru.yvzorin.someservice.application.userapplication.KafedraService;

import javax.validation.Valid;

/**
 * @author Yury Zorin
 */
@RestController
public class UserApplicationController {

    @Autowired
    private KafedraService kafedraService;

    public UserApplicationController(KafedraService kafedraService) {
        this.kafedraService = kafedraService;
    }

    @PostMapping("/api/application")
    ResponseEntity<Object> createApplication(@RequestBody @Valid KafedraSaveRequest request) {
        this.kafedraService.saveKafedra(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/kafedras/{id}")
    ResponseEntity<Object> getKafedra(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(this.kafedraService.getUserApplication(id));

    }
}
