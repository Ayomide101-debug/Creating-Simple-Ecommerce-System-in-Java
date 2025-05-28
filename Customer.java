package com.ecommerce;

import com.ecommerce.orders.Order;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private List<Product> shoppingCart;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
    }

    public void addToCart(Product product) {
        shoppingCart.add(product);
        System.out.println("Added to cart: " + product.getName());
    }

    public void removeFromCart(Product product) {
        if (shoppingCart.remove(product)) {
            System.out.println("Removed from cart: " + product.getName());
        } else {
            System.out.println("Product not in cart: " + product.getName());
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : shoppingCart) {
            total += product.getPrice();
        }
        return total;
    }

    public Order placeOrder() {
        if (shoppingCart.isEmpty()) {
            System.out.println("Error: Cannot place empty order");
            return null;
        }
        
        String orderId = "ORD-" + System.currentTimeMillis();
        double total = calculateTotal();
        Order order = new Order(orderId, this, new ArrayList<>(shoppingCart), total);
        
        shoppingCart.clear();
        System.out.println("Order placed successfully! Order ID: " + orderId);
        return order;
    }

    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public List<Product> getShoppingCart() {
        return new ArrayList<>(shoppingCart);
    }

    @Override
    public String toString() {
        return String.format("Customer[ID: %s, Name: %s]", customerId, name);
    }
}
