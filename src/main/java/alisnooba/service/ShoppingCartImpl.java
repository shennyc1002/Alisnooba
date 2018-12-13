package main.java.alisnooba.service;

import main.java.alisnooba.entity.Cart;
import main.java.alisnooba.entity.LineItem;
import main.java.alisnooba.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartImpl {

    Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public ShoppingCartImpl()
    {
        cart = new Cart();
    }

    public void add(Product product)
    {

        List<LineItem> lineItems = cart.getLineItem();
        LineItem lineItem = null;
        boolean productFound = false;
        System.out.println("LineItems impl class "+lineItems);
        if(lineItems!=null)
        {

            for (LineItem item : lineItems) {

                    System.out.println("Item is "+item.getProduct().getProductName());
                    int count=item.getCount();
                    if(item.getProduct().getProductId()== product.getProductId())
                    {
                        item.setCount(count++);
                        lineItem=item;
                        productFound = true;
                    }


            }

                System.out.println("Product Found "+productFound);
                if(!productFound)

                {
                    System.out.println("Inside product found "+product.getProductName());
                    lineItem = new LineItem();
                    lineItem.setProduct(product);
                    lineItem.setCount(1);
                    lineItems.add(lineItem);
                }


        }
        else
        {
            lineItems = new ArrayList<LineItem>();
            lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setCount(1);
            lineItems.add(lineItem);
        }

        cart.setLineItem(lineItems);

    }

    public void delete(Product product)
    {

        List<LineItem> lineItems = cart.getLineItem();
        LineItem lineItem = null;
        boolean productFound = false;
        System.out.println("LineItems impl class "+lineItems);

        if(lineItems!=null) {

            for (LineItem item : lineItems) {

                System.out.println("Item is " + item.getProduct().getProductName());

                if (item.getProduct().getProductId() == product.getProductId()) {
                    System.out.println("inside the if looop for checking product id ");
                    System.out.println("inside the if " + item.getProduct().getProductId());
                    lineItem = item;
                }


            }
        }
        if(lineItem.getCount()>1)
        {
            int count = lineItem.getCount();
            lineItem.setCount(count--);
        }
        else
        {
            lineItems.remove(lineItem);
        }
        cart.setLineItem(lineItems);
    }

    public void displayCart()
    {
            this.getCart().getLineItem().forEach(item->{
            System.out.println("Item is "+item.getProduct().getProductName());
            System.out.println("Count is  "+item.getCount());
            System.out.println("Product Price "+item.getProduct().getPrice());
            System.out.println("Product Price "+item.getProduct().getDiscountedPrice());
            int totalPrice = item.getProduct().getPrice()*item.getCount();
            int totalDiscountedPrice = item.getProduct().getDiscountedPrice()*item.getCount();
            int totalSavings = totalPrice-totalDiscountedPrice;
            System.out.println("Total Savings "+totalSavings);
        });
    }
}
