package eu.thelair.views.layout;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import eu.thelair.views.entity.Entry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EntryLayout extends VerticalLayout {
    private final Button addEntryButton = new Button("Eintrag hinzufügen", new Icon(VaadinIcon.PLUS));
    private final Grid<Entry> entryGrid = new Grid<>();
    private List<Entry> entries = new ArrayList<>();

    public EntryLayout() {
        entryGrid.setItems(entries);

        entryGrid.addColumn(Entry::getAmount).setHeader("Anzahl");
        entryGrid.addColumn(Entry::getDescription).setHeader("Beschreibung");
        entryGrid.addColumn(Entry::getPrice).setHeader("Preis");
        entryGrid.addColumn(val -> val.getAmount() * val.getPrice()).setHeader("Gesamt");
        entryGrid.addComponentColumn(entry -> new Button(new Icon(VaadinIcon.TRASH), event -> {
            entries.remove(entry);
            entryGrid.getDataProvider().refreshAll();
            entryGrid.recalculateColumnWidths();
        }));

        entryGrid.getColumns().forEach(col -> {
            col.setAutoWidth(true);
            col.setFrozen(false);
        });
        entryGrid.recalculateColumnWidths();

        setWidthFull();
        add(addEntryButton, entryGrid);
    }

    private void configureAddEntryButton() {
        addEntryButton.addClickListener(event -> {
            entryGrid.getDataProvider().refreshAll();
            entryGrid.recalculateColumnWidths();
        });
    }
}
