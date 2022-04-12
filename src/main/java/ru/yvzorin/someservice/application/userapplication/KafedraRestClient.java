package ru.yvzorin.someservice.application.userapplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.yvzorin.someservice.domain.model.kafedra.Kafedra;

import java.util.Map;

/**
 * @author Yury Zorin
 */
@Service
public class KafedraRestClient {

    @Value("kafedraService")
    public String addressOfService;

    private RestTemplate restTemplate;

    public KafedraRestClient() {
        this.restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:8080")
                .build();
    }

    public void saveKafedra(KafedraSaveRequest request) {
        ResponseEntity<String> response = this.restTemplate.postForEntity("/api/kafedra", request, String.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Соединение не удалось" + response);
        }
    }

    public Kafedra getKafedra(Integer number) {
        ResponseEntity<Kafedra> response = this.restTemplate.getForEntity("/api/kafedras/" + number, Kafedra.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Соединение не удалось" + response);
        }
        return response.getBody();
    }


    public void posWithParamsExample() {
        Map<String, ?> parameters = Map.of("patientName", "Vasya",
                "imagePath", "papka/papka/papka");
        ResponseEntity<String> response = this.restTemplate.postForEntity("/api/example-with-params",
                "My test request",
                String.class,
                parameters
        );
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Соединение не удалось" + response);
        }
    }

}
