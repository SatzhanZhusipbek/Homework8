package org.example;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Data
@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="ticket_type")
    private String ticketType;

    @Column(name="creation_date")
    private Date creationDate;

    @ManyToOne(fetch=FetchType.LAZY)
    private User user;

    public Ticket(String ticketType, Date creationDate) {
        this.ticketType = ticketType;
        this.creationDate = creationDate;
    }

    public Ticket() {

    }
    private int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket )) return false;
        return id != 0 && id == ((Ticket) o).getId();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
