package com.ecommerce.main;

import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.orders.Order;

public class Main {
    public static void main(String[] args) {
        // Create products
        Product laptop = new Product("P100", "MacBook Pro", 1299.99);
        Product phone = new Product("P101", "iPhone 15", 799.99);
        Product headphones = new Product("P102", "AirPods Pro", 249.99);

        // Create customer
        Customer customer = new Customer("C100", "Ayomide Oyekunle");
        
        System.out.println("=== WELCOME TO AYOMIDE'S ECOMMERCE SYSTEM ===");
        System.out.println("\nAvailable Products:");
        System.out.println("1. " + laptop);
        System.out.println("2. " + phone);
        System.out.println("3. " + headphones);

        // Shopping process
        System.out.println("\n=== SHOPPING PROCESS ===");
        customer.addToCart(laptop);
        customer.addToCart(phone);
        
        System.out.println("\nCurrent Cart Contents:");
        for (Product product : customer.getShoppingCart()) {
            System.out.println(" - " + product.getName() + ": $" + product.getPrice());
        }
        System.out.printf("Cart Total: $%.2f%n", customer.calculateTotal());

        // Place order
        System.out.println("\n=== CHECKOUT ===");
        Order order = customer.placeOrder();
        
        if (order != null) {
            System.out.println("\n=== ORDER DETAILS ===");
            System.out.println(order.generateSummary());
            
            // Update order status
            System.out.println("\nUpdating order status...");
            order.updateStatus("Shipped");
            System.out.println("\nUpdated Order Details:");
            System.out.println(order.generateSummary());
        }
    }
}
