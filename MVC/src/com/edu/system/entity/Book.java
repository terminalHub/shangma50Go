package com.edu.system.entity;

import java.math.BigDecimal;

public class Book {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String type;


    public Book() {
    }

    public Book(Integer id, String name, BigDecimal price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "Book{id = " + id + ", name = " + name + ", price = " + price + ", type = " + type + "}";
    }
}