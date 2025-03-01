/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author THINH
 */
public class GamesDTO {
    private String gameId, title, description,publisher;
    private double price;
    private Date releaseDate;
    private int isDLC;

    public GamesDTO() {
    }

    public GamesDTO(String id, String title, String description, String publisher, double price, Date releaseDate, int isDLC) {
        this.gameId = id;
        this.title = title;
        this.description = description;
        this.publisher = publisher;
        this.price = price;
        this.releaseDate = releaseDate;
        this.isDLC = isDLC;
    }
    

    public String getId() {
        return gameId;
    }

    public void setgameId(String id) {
        this.gameId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getIsDLC() {
        return isDLC;
    }

    public void setIsDLC(int isDLC) {
        this.isDLC = isDLC;
    }
    
    
    
}
