package eu.thelair.views.entity;

import java.math.BigDecimal;

public class Entry {

    private Integer amount;
    private String description;
    private BigDecimal price;

    public Entry(String description, BigDecimal price, Integer amount) {
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
