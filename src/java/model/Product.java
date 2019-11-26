/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author NguyenDinhTien
 */
public class Product implements Serializable{
    private static final long serialVersionUID = -2228058387100752978L;
    private String IDcode;
    private String name, author,date;
    private int numberPage;
    private float price;

    public Product() {
    }

    public Product(String IDcode, String name, String author, String date, int numberPage, float price) {
        this.IDcode = IDcode;
        this.name = name;
        this.author = author;
        this.date = date;
        this.numberPage = numberPage;
        this.price = price;
    }

    public String getIDcode() {
        return IDcode;
    }

    public void setIDcode(String IDcode) {
        this.IDcode = IDcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "IDcode=" + IDcode + ", name=" + name + ", author=" + author + ", date=" + date + ", numberPage=" + numberPage + ", price=" + price + '}';
    }
}
