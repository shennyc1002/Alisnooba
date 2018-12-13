import main.java.alisnooba.entity.Product;
import main.java.alisnooba.service.ShoppingCartImpl;

public class Main {

    public static void main(String[] args) {


        Product product = new Product();
        product.setProductId(1);
        product.setProductName("First Prodcut");

        Product product1 = new Product();
        product1.setProductId(2);
        product1.setProductName("Second Prodcut");

        Product product2 = new Product();
        product2.setProductId(2);
        product2.setProductName("Second Prodcut");

        ShoppingCartImpl impl = new ShoppingCartImpl();

        impl.add(product);

        System.out.println("Cart first is "+impl.getCart().getLineItem().get(0).getProduct().getProductId());
        impl.add(product1);
        impl.add(product2);
        System.out.println("Cart second is "+impl.getCart().getLineItem().get(1).getProduct().getProductName());

        System.out.println("*****************************************");
        impl.displayCart();
        System.out.println("*****************************************");
        impl.delete(product1);
        impl.getCart().getLineItem().forEach(item->{
            System.out.println("Item is "+item.getProduct().getProductName());
        });

    }


}
