/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventario;

import java.util.ArrayList;
import java.util.List;

/**
 * @Fecha de Creación 5 jul 2024
 * @author CRISTIAN R. PAZ
 */
public class InventoryManagerp {

    private final List<Product> products;

    public InventoryManagerp() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(String productId) {
        this.products.removeIf(product -> product.getId().equals(productId));
    }

    public Product findProductById(String productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }
    
    

    public void updateProductQuantity(String productId, int quantity) {
        Product product = findProductById(productId);
        if (product != null) {
            product.setQuantity(quantity);
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void printInventory() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
