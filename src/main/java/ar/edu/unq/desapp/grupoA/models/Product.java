package ar.edu.unq.desapp.grupoA.models;

import javax.persistence.*;
import javax.swing.*;

@Entity
@Table(name = "UserModel")
public class Product {

    @Id()
    @GeneratedValue()
    @Column(name = "USER_ID")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "photo")
    private ImageIcon photo;
    @Column(name = "stock")
    private int stock;
    @Column(name = "point_cost")
    private int pointCost;

    public Product(String name, int stock, int pointCost) {
        this.name = name;
        this.stock = stock;
        this.pointCost = pointCost;
    }

    public String getName() {
        return name;
    }

    public int getPointCost() {
        return pointCost;
    }
}
