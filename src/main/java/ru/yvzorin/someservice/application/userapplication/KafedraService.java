package ru.yvzorin.someservice.application.userapplication;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yvzorin.someservice.domain.model.kafedra.Kafedra;
import ru.yvzorin.someservice.domain.model.kafedra.KafedraRepository;

/**
 * @author Yury Zorin
 */
@Service
@RequiredArgsConstructor
@Transactional
public class KafedraService {

    @Autowired
    private KafedraRepository repository;

    public void saveKafedra(KafedraSaveRequest request) {
        this.repository.save(request.toDomain());
    }

    public Kafedra getKafedra(Integer number) {
        return this.repository.findByNumber(number)
                .orElseThrow(() -> new RuntimeException("Кафедра с номером " + number + " не найдена."));
    }
}
