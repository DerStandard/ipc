package eu.thelair.views.layout;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.combobox.ComboBoxVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;

public class AddressLayout extends FormLayout {

    private final ComboBox<String> salutationBox = new ComboBox<>("Anrede");

    private final TextField firstNameField = new TextField("Vorname");
    private final TextField lastNameField = new TextField("Nachname");

    private final TextField companyField = new TextField("Firma");
    private final TextField streetField = new TextField("Straße");

    private final NumberField zipField = new NumberField("PLZ");
    private final TextField cityField = new TextField("Ort");

    public AddressLayout() {
        setupComboBox();
        setupTextFields();

        setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("500px", 2));

        add(salutationBox, firstNameField, lastNameField, companyField, streetField, zipField, cityField);
    }

    private void setupTextFields() {
        firstNameField.setVisible(false);
        lastNameField.setVisible(false);
        companyField.setVisible(false);

        firstNameField.addThemeVariants(TextFieldVariant.LUMO_SMALL);
        lastNameField.addThemeVariants(TextFieldVariant.LUMO_SMALL);
        companyField.addThemeVariants(TextFieldVariant.LUMO_SMALL);
        streetField.addThemeVariants(TextFieldVariant.LUMO_SMALL);
        zipField.addThemeVariants(TextFieldVariant.LUMO_SMALL);
        cityField.addThemeVariants(TextFieldVariant.LUMO_SMALL);

        setColspan(companyField, 2);
        setColspan(streetField, 2);
    }

    private void setupComboBox() {
        setColspan(salutationBox, 2);
        salutationBox.addThemeVariants(ComboBoxVariant.LUMO_SMALL);
        salutationBox.setItems("Herr", "Frau", "Firma");

        salutationBox.addValueChangeListener(event -> {
            if (event.getValue().equals("Firma")) {
                firstNameField.setVisible(false);
                lastNameField.setVisible(false);
                companyField.setVisible(true);
            } else {
                firstNameField.setVisible(true);
                lastNameField.setVisible(true);
                companyField.setVisible(false);
            }
        });
    }
}
