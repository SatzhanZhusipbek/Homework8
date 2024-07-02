package org.example;

public class User {

    private int id;

    private String name;

    private java.sql.Date creationDate;

    public User(String name, java.sql.Date creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.sql.Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.sql.Date date) {
        this.creationDate=date;
    }
}
