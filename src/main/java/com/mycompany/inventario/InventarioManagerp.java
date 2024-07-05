/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.inventory;

import com.mycompany.inventario.InventoryManagerp;
import com.mycompany.inventario.Product;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InventarioManagerp extends Application {

    private InventoryManagerp inventoryManager = new InventoryManagerp();
    private TableView<Product> table = new TableView<>();
    private ObservableList<Product> productList;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Inventory Management System");

        productList = FXCollections.observableArrayList(inventoryManager.getProducts());
        table.setItems(productList);

        TableColumn<Product, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));

        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));

        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getQuantity()));

        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrice()));

        table.getColumns().addAll(idColumn, nameColumn, quantityColumn, priceColumn);

        TextField idField = new TextField();
        idField.setPromptText("ID");
        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        TextField quantityField = new TextField();
        quantityField.setPromptText("Quantity");
        TextField priceField = new TextField();
        priceField.setPromptText("Price");

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            Product product = new Product(
                    idField.getText(),
                    nameField.getText(),
                    Integer.parseInt(quantityField.getText()),
                    Double.parseDouble(priceField.getText())
            );
            inventoryManager.addProduct(product);
            productList.setAll(inventoryManager.getProducts());
        });

        VBox vbox = new VBox();
        vbox.getChildren().addAll(table, idField, nameField, quantityField, priceField, addButton);

        Scene scene = new Scene(vbox, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
