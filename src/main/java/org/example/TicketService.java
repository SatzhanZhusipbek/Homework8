package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketService {

    private TicketDAO ticketDAO;
    @Autowired
    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO=ticketDAO;
    }

    public Ticket findTicket(int id) {
        return ticketDAO.getTicketById(id);
    }

    public List<Ticket> findTicketsByUserId(int userId) {
        return ticketDAO.getTicketsByUserId(userId);
    }

    public void saveTicket(Ticket ticket) {
        ticketDAO.save(ticket);
    }

    public void updateTicketType(Ticket ticket) {

        ticketDAO.updateTicket(ticket.getTicketType(), ticket.getId());
    }

    public void deleteTicket(Ticket ticket) {
        ticketDAO.delete(ticket);
    }
}
