package org.example;

import java.sql.Date;

public class Ticket {

    private int id;

    private int userId;

    private String ticketType;

    private Date creationDate;

    public Ticket(int userId, String ticketType, Date creationDate) {
        this.userId = userId;
        this.ticketType = ticketType;
        this.creationDate = creationDate;
    }

    public Ticket() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public java.sql.Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}
