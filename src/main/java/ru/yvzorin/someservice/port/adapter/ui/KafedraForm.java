package ru.yvzorin.someservice.port.adapter.ui;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import ru.yvzorin.someservice.application.userapplication.KafedraSaveRequest;
import ru.yvzorin.someservice.application.userapplication.KafedraService;
import ru.yvzorin.someservice.domain.model.kafedra.Kafedra;

/**
 * @author Yury Zorin <yuri.zorin@bostongene.com>
 */
public class KafedraForm extends FormLayout {
    private final KafedraService kafedraService;
    TextField kafedraNumber = new TextField("Номер кафедры");
    TextField zavkaf = new TextField("Заведующий");
    TextField zamzavKaf = new TextField("Заместитель");
    TextField year = new TextField("Год основания");
    Button save = new Button("Save", e -> Notification.show("Сохраняем кафедру"));
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    public KafedraForm(KafedraService kafedraService) {

        this.kafedraService = kafedraService;

        addClassName("contact-form");

        save.addClickListener(event -> {
            KafedraSaveRequest request = new KafedraSaveRequest(
                    Integer.valueOf(kafedraNumber.getValue()),
                    zavkaf.getValue(),
                    zamzavKaf.getValue(),
                    Integer.valueOf(year.getValue())
            );
            this.kafedraService.saveKafedraByRest(request);
            Kafedra kafedra = this.kafedraService.getKafedraByRest(request.number());
        });

        add(kafedraNumber,
                zavkaf,
                zamzavKaf,
                year,
                createButtonsLayout());
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save, delete, close);
    }
}