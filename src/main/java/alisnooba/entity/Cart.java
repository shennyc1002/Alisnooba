package main.java.alisnooba.entity;

import java.util.List;

public class Cart {

    List<LineItem> lineItem;

    public List<LineItem> getLineItem() {
        return lineItem;
    }

    public void setLineItem(List<LineItem> lineItem) {
        this.lineItem = lineItem;
    }

}
