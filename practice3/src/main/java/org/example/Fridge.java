package org.example;

public class Fridge {
    private Integer seria;
    private String views;
    private String brand;
    private String country;
    private Integer height;
    private Integer width;
    private Integer depth;

    public Fridge() {
    }

    public Fridge(Integer seria, String views, String brand, String country, Integer height, Integer width, Integer depth)
    {
        this.seria = seria;
        this.views = views;
        this.brand = brand;
        this.country = country;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public void setSeria(Integer seria)
    {
        this.seria = seria;
    }

    public void setViews(String views)
    {
        this.views = views;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

    public void setDepth(Integer depth)
    {
        this.depth = depth;
    }
    public String getBrand()
    {
        return brand;
    }

    public Integer getseria()
    {
        return seria;
    }
    public String getCountry()
    {
        return country;
    }

    public String getViews()
    {
        return views;
    }

    public Integer getHeight()
    {
        return height;
    }

    public Integer getWidth()
    {
        return width;
    }

    public Integer getDepth()
    {
        return depth;
    }

    @Override
    public String toString() {
        return "Холодильник под номером " + seria + "\n" +
                "Вид: "  + views + "\n" +
                "Бренд: "  + brand + "\n" +
                "Страна изготовитель: "  + country + "\n" +
                "Высота: "  + height + "\n" +
                "Ширина: "  + width + "\n" +
                "Объём: "  + depth;
    }
}
