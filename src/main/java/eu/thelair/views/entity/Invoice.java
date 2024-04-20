package eu.thelair.views.entity;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private String firstName;
    private String lastName;
    private String company;
    private String street;
    private String zip;
    private String city;
    private String invoiceNumber;
    private String invoiceOrderNumber;
    private String invoiceDate;
    private float invoiceTotal;
    private float invoiceTax;
    private String invoicePayUntil;
    private String invoiceDeliveryDate;
    private String customerNumber;
    private float inovoiceEntrySum;
    private List<Entry> entries = new ArrayList<>();

    // Konstruktor mit last and first name
    public Invoice(String firstName, String lastName, String street, String zip, String city, String invoiceNumber, String invoiceOrderNumber, String invoiceDate, float invoiceTotal, float invoiceTax, String invoicePayUntil, List<Entry> entries, String invoiceDeliveryDate, String customerNumber, float invoiceEntrySum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.invoiceNumber = invoiceNumber;
        this.invoiceOrderNumber = invoiceOrderNumber;
        this.invoiceDate = invoiceDate;
        this.invoiceTotal = invoiceTotal;
        this.invoiceTax = invoiceTax;
        this.invoicePayUntil = invoicePayUntil;
        this.entries = entries;
        this.invoiceDeliveryDate = invoiceDeliveryDate;
        this.customerNumber = customerNumber;
        this.inovoiceEntrySum = invoiceEntrySum;
    }
// Konstruktor mit Company
    public Invoice(String company, String street, String zip, String city, String invoiceNumber, String invoiceOrderNumber, String invoiceDate, float invoiceTotal, float invoiceTax, String invoicePayUntil, List<Entry> entries, String invoiceDeliveryDate, String customerNumber, float invoiceEntrySum) {
        this.company = company;
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.invoiceNumber = invoiceNumber;
        this.invoiceOrderNumber = invoiceOrderNumber;
        this.invoiceDate = invoiceDate;
        this.invoiceTotal = invoiceTotal;
        this.invoiceTax = invoiceTax;
        this.invoicePayUntil = invoicePayUntil;
        this.entries = entries;
        this.invoiceDeliveryDate = invoiceDeliveryDate;
        this.customerNumber = customerNumber;
        this.inovoiceEntrySum = invoiceEntrySum;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceOrderNumber() {
        return invoiceOrderNumber;
    }

    public void setInvoiceOrderNumber(String invoiceOrderNumber) {
        this.invoiceOrderNumber = invoiceOrderNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public float getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(float invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public float getInvoiceTax() {
        return invoiceTax;
    }

    public void setInvoiceTax(float invoiceTax) {
        this.invoiceTax = invoiceTax;
    }

    public String getInvoicePayUntil() {
        return invoicePayUntil;
    }

    public void setInvoicePayUntil(String invoicePayUntil) {
        this.invoicePayUntil = invoicePayUntil;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public String getInvoiceDeliveryDate() {
        return invoiceDeliveryDate;
    }

    public void setInvoiceDeliveryDate(String invoiceDeliveryDate) {
        this.invoiceDeliveryDate = invoiceDeliveryDate;
    }

    public float getInovoiceEntrySum() {
        return inovoiceEntrySum;
    }

    public void setInovoiceEntrySum(float inovoiceEntrySum) {
        this.inovoiceEntrySum = inovoiceEntrySum;
    }
}
