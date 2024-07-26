package org.example;

import java.util.List;

public class TicketService {

    private TicketDAO ticketDAO = new TicketDAO();

    public TicketService() {

    }

    public Ticket findTicket(int id) {
        return ticketDAO.findTicketById(id);
    }

    public List<Ticket> findTicketsByUserId(int userId) {
        return ticketDAO.findTicketsByUserId(userId);
    }

    public void saveTicket(Ticket ticket) {
        ticketDAO.save(ticket);
    }

    public void updateTicket(Ticket ticket) {
        ticketDAO.update(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        ticketDAO.delete(ticket);
    }
}
