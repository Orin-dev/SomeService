package ru.yvzorin.someservice.port.adapter.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import ru.yvzorin.someservice.application.userapplication.KafedraService;

import java.util.Map;

/**
 * @author Yury Zorin <yuri.zorin@bostongene.com>
 */
@Route("")
public class MainViewAppLayout extends AppLayout {

    private final KafedraService kafedraService;

    public MainViewAppLayout(@Autowired KafedraService kafedraService) {
        this.kafedraService = kafedraService;
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("TeleLeukemia web");
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        Tabs tabs = getTabs();

        addToDrawer(tabs);
        addToNavbar(toggle, title);
    }

    private Tabs getTabs() {
        Tab main = new Tab("Основная страница");
        Tab cellsExtraction = new Tab("Страница формирования выборки");
        Tab classicMethod = new Tab("Страница распознавания классическим методом");
        Tab neuralNetwork = new Tab("Страница распознавания нейросетью");

        Map<String, Component> contentById = Map.of("Основная страница", new MainView(this.kafedraService));

        Tabs tabs = new Tabs(main, cellsExtraction, classicMethod, neuralNetwork);
        tabs.addSelectedChangeListener(event ->
                setContent(contentById.get(event.getSelectedTab().getLabel()))
        );
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.setHeight("240px");
        tabs.setWidth("240px");
        return tabs;
    }
}
