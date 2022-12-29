package main;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Cinema {

    @NotNull(message = "Value dont need be empty")
    @Min(value = 0, message = "Need positive number")
    private int id;

    @NotNull(message = "Value dont need be empty")
    @Min(value = 0, message = "Need positive number")
    private double cost;

    @NotNull(message = "Value dont need be empty")
    @Min(value = 0, message = "Need positive number")
    private double weight;

    @NotEmpty(message = "Value dont need be empty")
    private String brand;

    @NotEmpty(message = "Value dont need be empty")
    private String type;

    @NotEmpty(message = "Value dont need be empty")
    private String color;

    public Cinema() {
        id = 0;
        cost = 0;
        weight = 0;
        brand = null;
        type = null;
        color = null;
    }

    Cinema(int i, double c, double w, String b, String t, String col){
        id = i;
        cost = c;
        weight = w;
        brand = b;
        type = t;
        color = col;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", cost=" + cost +
                ", weight=" + weight +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema = (Cinema) o;
        return id == cinema.id && Double.compare(cinema.cost, cost) == 0 && Double.compare(cinema.weight, weight) == 0 && Objects.equals(brand, cinema.brand) && Objects.equals(type, cinema.type) && Objects.equals(color, cinema.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost, weight, brand, type, color);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }

    public double getWeight() {
        return weight;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }
}
