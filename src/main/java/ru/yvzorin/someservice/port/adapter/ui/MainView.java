package ru.yvzorin.someservice.port.adapter.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import ru.yvzorin.someservice.application.userapplication.KafedraService;
import ru.yvzorin.someservice.domain.model.kafedra.Kafedra;

/**
 * @author Yury Zorin <yuri.zorin@bostongene.com>
 */
@Route("")
public class MainView extends VerticalLayout {

    private final KafedraService kafedraService;

    Grid<Kafedra> grid = new Grid<>(Kafedra.class);
    TextField filterText = new TextField();
    KafedraForm form;

    public MainView(@Autowired KafedraService service) {
        this.kafedraService = service;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        configureForm();

        add(getToolbar(), getContent());
        showAll();
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, form);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, form);
        content.addClassNames("content1");
        content.setSizeFull();
        return content;
    }

    private void configureForm() {
        form = new KafedraForm(kafedraService);
        form.setWidth("25em");
    }

    private void configureGrid() {
        grid.addClassNames("kafedras-grid1");
        grid.setSizeFull();

        grid.addColumn(Kafedra::zavKaf).setHeader("Зеведующий");
        grid.addColumn(Kafedra::number).setHeader("Номер");
        grid.addColumn(Kafedra::yearOfEstablishment).setHeader("Год основания");
        grid.addColumn(Kafedra::zamZavkaf).setHeader("Заместитель заведующего");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by year...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button kafedraButton = new Button("Показать все");

        kafedraButton.addClickListener(event -> showAll());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, kafedraButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void showAll() {
        grid.setItems(kafedraService.getAllKafedras());
    }

    private void updateList() {
        Integer year = null;
        if (!filterText.getValue().equals("")) {
            year = Integer.valueOf(filterText.getValue());
        }
        grid.setItems(kafedraService.getAllKafedras(year));
    }

//    public MainView(@Autowired KafedraService kafedraService) {
//        this.kafedraService = kafedraService;
//
//        // Use TextField for standard text input
//        TextField kafedraNumber = new TextField("Номер кафедры");
//        TextField zavkaf = new TextField("Заведующий");
//        TextField zamzavKaf = new TextField("Заместитель");
//        TextField year = new TextField("Год основания");
//
//
//        TextField searchKafNumber = new TextField("поиск по номеру");
//        Text showKafedraNumber = new Text("Номер кафедры");
//        Text showZavkaf = new Text("Заведующий");
//        Text showZamzavKaf = new Text("Заместитель");
//        Text showYear = new Text("Год основания");
//
//        // Button click listeners can be defined as lambda expressions
//        Button saveButton = new Button("Сохранить кафедру",
//                e -> Notification.show("Сохраняем кафедру"));
//        saveButton.addClickListener(event -> {
//            KafedraSaveRequest request = new KafedraSaveRequest(
//                    Integer.valueOf(kafedraNumber.getValue()),
//                    zavkaf.getValue(),
//                    zamzavKaf.getValue(),
//                    Integer.valueOf(year.getValue())
//            );
//            this.kafedraService.saveKafedra(request);
//        });
//
//        Button searchButton = new Button("Найти кафедру",
//                e -> Notification.show("Ищем кафедру"));
//
//        searchButton.addClickListener(event -> {
//            Kafedra kafedra = this.kafedraService.getKafedra(Integer.valueOf(searchKafNumber.getValue()));
//            showKafedraNumber.setText(String.valueOf(kafedra.number()));
//            showZavkaf.setText(kafedra.zavKaf());
//            showZamzavKaf.setText((kafedra.zamZavkaf()));
//            showYear.setText(String.valueOf(kafedra.yearOfEstablishment()));
//        });
//        // Theme variants give you predefined extra styles for components.
//        // Example: Primary button is more prominent look.
//        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
//
//        // You can specify keyboard shortcuts for buttons.
//        // Example: Pressing enter in this view clicks the Button.
//        saveButton.addClickShortcut(Key.ENTER);
//
//        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
//        addClassName("centered-content");
//
//        VerticalLayout saveLayout = new VerticalLayout();
//        saveLayout.add(kafedraNumber, zavkaf, zamzavKaf, year, saveButton);
//
//        VerticalLayout showLayout = new VerticalLayout();
//        saveLayout.add(showKafedraNumber, showZavkaf, showZamzavKaf, showYear, searchKafNumber, searchButton);
//
//        add(saveLayout, showLayout);
//    }
}
