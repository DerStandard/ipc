package eu.thelair.views.ipc;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import eu.thelair.views.entity.Entry;
import eu.thelair.views.entity.Invoice;
import eu.thelair.views.layout.AddressLayout;
import eu.thelair.views.layout.EntryLayout;
import eu.thelair.views.layout.InvoiceLayout;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@PageTitle("IPC")
@Route(value = "")
public class IPCView extends VerticalLayout {

    private FormLayout formLayout = new FormLayout();

    private AddressLayout addressLayout = new AddressLayout();
    private InvoiceLayout invoiceLayout = new InvoiceLayout();
    private EntryLayout entryLayout = new EntryLayout();
    private Button createPDFButton = new Button("PDF erstellen");

    public IPCView() {
        formLayout.setWidth("100%");
        formLayout.add(addressLayout, invoiceLayout);

        createPDFButton.addClickListener(event -> {
            try {
                Entry entry1 = new Entry("Test", 1.0f, 1);
                Entry entry2 = new Entry("Test2", 2.0f, 2);
                Entry entry3 = new Entry("Test3", 3.0f, 3);
                ArrayList<Entry> entries = new ArrayList<>(Arrays.asList(entry1, entry2, entry3));

                Invoice invoice = new Invoice("Max",
                                              "Mustermann",
                                              "Musterstraße 1",
                                              "12345",
                                              "Musterstadt",
                                              "R123",
                                              "A123",
                                              "01.01.2021",
                                              100.0f,
                                              100.0f,
                                              "01.02.2021",
                                              entries,
                                              "01.01.2021",
                                              "123",
                                              100.0f
                );
                createPDF(invoice);
            } catch (JRException | IOException e) {
                e.printStackTrace();
            }
        });

        setPadding(true);
        add(formLayout, entryLayout, createPDFButton);
    }

    public void createPDF(Invoice invoice) throws JRException, IOException {
        System.out.println(invoice.getEntries());
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("rechnungsnr", invoice.getInvoiceNumber());
        parameters.put("rechdat", invoice.getInvoiceDate());
        parameters.put("faelligdat", invoice.getInvoicePayUntil());
        parameters.put("lieferdat", invoice.getInvoiceDeliveryDate());
        parameters.put("kundnr", invoice.getCustomerNumber());
        if (invoice.getCompany() == null) {
            parameters.put("kunde", invoice.getFirstName() + " " + invoice.getLastName());
        } else {
            parameters.put("kunde", invoice.getCompany());
        }
        parameters.put("strassehr", invoice.getStreet());
        parameters.put("plzort", invoice.getZip() + " " + invoice.getCity());
        parameters.put("summe", invoice.getInovoiceEntrySum());
        parameters.put("ust", invoice.getInvoiceTax());
        parameters.put("rechnungsbetrag", invoice.getInvoiceTotal());

        final JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(invoice.getEntries());

        final JasperReport invoiceReport = JasperCompileManager.compileReport(new File(".").getCanonicalPath() + "/src/main/resources/Blank_A4.jrxml");

        final JasperPrint print = JasperFillManager.fillReport(invoiceReport, parameters, dataSource);

        JasperExportManager.exportReportToPdfFile(print, "invoice.pdf");
        Notification.show("PDF erstellt!");
    }
}
