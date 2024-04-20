package eu.thelair.views.entity;


public class Entry {

    private String description;
    private Integer amount;
    private float price;
    private float total;

    public Entry(String description, float price, Integer amount) {
        this.description = description;
        this.price = price;
        this.amount = amount;

        this.total = amount * price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public float getTotal() {
        return total;
    }

}
