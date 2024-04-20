package eu.thelair.views.layout;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.List;
import java.util.Locale;

public class InvoiceLayout extends FormLayout {
    private final TextField invoiceNumberField = new TextField("Rechnungsnummer");
    private final TextField invoiceOrderNumberField = new TextField("Auftragsnummer");
    private final DatePicker invoiceDateField = new DatePicker("Datum");
    private final DatePicker.DatePickerI18n germanI18n = new DatePicker.DatePickerI18n();

    public InvoiceLayout() {
        germanI18n.setMonthNames(List.of("Januar", "Februar", "März", "April",
                                         "Mai", "Juni", "Juli", "August", "September", "Oktober",
                                         "November", "Dezember"));
        germanI18n.setWeekdays(List.of("Sonntag", "Montag", "Dienstag",
                                       "Mittwoch", "Donnerstag", "Freitag", "Samstag"));
        germanI18n.setWeekdaysShort(
                List.of("So", "Mo", "Di", "Mi", "Do", "Fr", "Sa"));
        germanI18n.setToday("Heute");
        germanI18n.setCancel("Abbrechen");
        germanI18n.setFirstDayOfWeek(1);
        germanI18n.setDateFormat("dd.MM.yyyy");

        invoiceDateField.setLocale(Locale.GERMANY);
        invoiceDateField.setI18n(germanI18n);

        setResponsiveSteps(new ResponsiveStep("0", 1));

        add(invoiceDateField, invoiceOrderNumberField, invoiceNumberField);
    }

}
