package ar.edu.unq.desapp.grupoA.models;

import javax.swing.*;

public class Product {

    private String name;
    private ImageIcon photo;
    private int stock;
    private int pointCost;

    public Product(String name, int stock, int pointCost) {
        this.name = name;
        this.stock= stock;
        this.pointCost = pointCost;
    }

    public String getName() {
        return name;
    }

    public int getPointCost() {
        return pointCost;
    }
}
