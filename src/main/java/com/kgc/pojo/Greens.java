package com.kgc.pojo;

public class Greens {
    private Integer id;

    private String name;

    private String taste;

    private String url;

    private Double price;

    private String descript;

    @Override
    public String toString() {
        return "Greens{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taste='" + taste + '\'' +
                ", url='" + url + '\'' +
                ", price=" + price +
                ", descript='" + descript + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste == null ? null : taste.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }
}