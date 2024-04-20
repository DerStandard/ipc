package eu.thelair.views.ipc;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import eu.thelair.views.layout.AddressLayout;
import eu.thelair.views.layout.EntryLayout;
import eu.thelair.views.layout.InvoiceLayout;

@PageTitle("IPC")
@Route(value = "")
public class IPCView extends VerticalLayout {

    private FormLayout formLayout = new FormLayout();

    private AddressLayout addressLayout = new AddressLayout();
    private InvoiceLayout invoiceLayout = new InvoiceLayout();
    private EntryLayout entryLayout = new EntryLayout();

    public IPCView() {
        formLayout.setWidth("100%");
        formLayout.add(addressLayout, invoiceLayout);

        setPadding(true);
        add(formLayout, entryLayout);
    }
}
