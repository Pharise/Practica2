package CinemaWeb.entities;

import org.hibernate.annotations.Table;
import org.jetbrains.annotations.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(appliesTo = "Cinema")
public class Cinema {
    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "model", nullable = false)
    private String model;
    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "material", nullable = false)
    private String material;
    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "typeOfCinema", nullable = false)
    private String typeOfCinema;
    //    @NotEmpty(message = "Поле не должно быть пустым")
//    @Size(min = 1, message = "Минимальное значение - 1")
    @NotNull(message = "Not Null")
    @Column(name = "price", nullable = false)
    private int price;
    @NotNull(message = "Поле не должно быть пустым")
    @Min(1)
    @Column(name = "volume", nullable = false)
    private int volume;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    @Min(value = 0)
    public int id;

    public Cinema() {
    }

    public Cinema(String model, String material, String typeOfCinema, int price, int volume) {
        this.model = model;
        this.material = material;
        this.typeOfcinema = typeOfCinema;
        this.price = price;
        this.volume = volume;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTypeOfCinema(String typeOfCinema) {
        this.typeOfCinema = typeOfCinema;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public String getTypeOfCinema() {
        return typeOfCinema;
    }

    public String getMaterial() {
        return material;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Cinema{" +
                "model='" + model + '\'' +
                ", typeWood='" + material + '\'' +
                ", typeOfCinema='" + typeOfCinema + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", id=" + id +
                '}';
    }
}
