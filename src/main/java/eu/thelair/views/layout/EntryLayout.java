package eu.thelair.views.layout;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import eu.thelair.views.entity.Entry;

import java.math.BigDecimal;

public class EntryLayout extends HorizontalLayout {

    private final Grid<Entry> entryGrid = new Grid<>();

    public EntryLayout() {

        entryGrid.addColumn(Entry::getAmount).setHeader("Anzahl");
        entryGrid.addColumn(Entry::getDescription).setHeader("Beschreibung");
        entryGrid.addColumn(Entry::getPrice).setHeader("Preis");
        entryGrid.addColumn(val -> val.getAmount() * val.getPrice().doubleValue()).setHeader("Gesamt");
        entryGrid.addComponentColumn(entry -> {
            return new Button("Löschen");
        }).setHeader("Löschen");

        entryGrid.setItems(new Entry("Test", BigDecimal.valueOf(1.0), 1), new Entry("Test2", BigDecimal.valueOf(2.0), 2));

        setWidthFull();
        add(entryGrid);
    }
}
