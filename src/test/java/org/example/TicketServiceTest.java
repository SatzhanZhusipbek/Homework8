package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {

    private TicketService ticketService;

    private TicketDAO ticketDAO;

    @BeforeEach
    void setUp() {
        ticketDAO = Mockito.mock(TicketDAO.class);
        ticketService = new TicketService(ticketDAO);
    }

    @Test
    void findTicket() {
        int searchId = 3;
        Ticket ticket = new Ticket();
        User user = new User(); user.setId(11);
        ticket.setId(3); ticket.setUserId(user); ticket.setCreationDate(Date.valueOf("2024-07-10"));
        ticket.setTicketType("DAY");

        when(ticketService.findTicket(searchId)).thenReturn(ticket);
        Assertions.assertEquals(ticket, ticketService.findTicket(3));

        when(ticketService.findTicket(23)).thenReturn(null);
        Assertions.assertEquals(null, ticketService.findTicket(23));

        Ticket ticket2 = new Ticket();
        User user2 = new User(); user2.setId(20);
        ticket2.setId(22); ticket2.setUserId(user); ticket2.setCreationDate(Date.valueOf("2024-07-10"));
        ticket2.setTicketType("DAY");
        when(ticketService.findTicket(22)).thenReturn(ticket2);
        Assertions.assertEquals(ticket2, ticketService.findTicket(22));
    }

    @Test
    void findTicketsByUserId() {
        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket3 = new Ticket();
        User user3 = new User(); user3.setId(10);
        ticket3.setId(5); ticket3.setUserId(user3); ticket3.setCreationDate(Date.valueOf("2024-07-10"));
        ticket3.setTicketType("DAY");
        Ticket ticket4 = new Ticket();
        ticket4.setId(6); ticket4.setUserId(user3); ticket4.setCreationDate(Date.valueOf("2024-07-10"));
        ticket4.setTicketType("DAY");
        tickets.add(ticket3); tickets.add(ticket4);

        when(ticketService.findTicketsByUserId(10)).thenReturn(tickets);
        Assertions.assertEquals(tickets, ticketService.findTicketsByUserId(10));

        when(ticketService.findTicketsByUserId(27)).thenReturn(null);
        Assertions.assertEquals(null, ticketService.findTicketsByUserId(27));

        List<Ticket> tickets2 = new ArrayList<>();
        Ticket ticket5 = new Ticket();
        User user4 = new User(); user4.setId(20);
        ticket5.setId(5); ticket5.setUserId(user4); ticket5.setCreationDate(Date.valueOf("2024-07-10"));
        ticket5.setTicketType("DAY");
        Ticket ticket6 = new Ticket();
        ticket5.setId(6); ticket6.setUserId(user4); ticket6.setCreationDate(Date.valueOf("2024-07-10"));
        ticket6.setTicketType("DAY");
        tickets2.add(ticket5); tickets2.add(ticket6);

        when(ticketService.findTicketsByUserId(20)).thenReturn(tickets2);
        Assertions.assertEquals(tickets2, ticketService.findTicketsByUserId(20));

    }

    @Test
    void saveTicket() {
        Ticket ticket = new Ticket();
        User user = new User(); user.setId(18);
        ticket.setId(8); ticket.setUserId(user); ticket.setCreationDate(Date.valueOf("2024-07-10"));
        ticket.setTicketType("DAY");
        Ticket ticket2 = new Ticket();
        ticket2.setId(8); ticket2.setUserId(user); ticket2.setCreationDate(Date.valueOf("2024-07-10"));
        ticket2.setTicketType("DAY");
        ticketService = Mockito.mock(TicketService.class);
        ticketService.saveTicket(ticket);
        verify(ticketService, times(1)).saveTicket(ticket);
        when(ticketService.findTicket(8)).thenReturn(ticket);
        Assertions.assertSame(ticket, ticketService.findTicket(8));
        Assertions.assertNotSame(ticket2, ticketService.findTicket(8));
    }

    @Test
    void updateTicketType() {
        Ticket ticket = new Ticket();
        ticket.setId(8); ticket.setTicketType("WEEK");
        ticketService = Mockito.mock(TicketService.class);
        ticketService.updateTicketType(ticket);
        verify(ticketService, times(1)).updateTicketType(ticket);
        when(ticketService.findTicket(8)).thenReturn(ticket);
        Assertions.assertEquals(ticket.getTicketType(), ticketService.findTicket(8).getTicketType());
        Assertions.assertNotEquals("MONTH", ticketService.findTicket(8).getTicketType());
    }

    @Test
    void deleteTicket() {
        Ticket ticket = new Ticket(); Ticket ticket2 = new Ticket();
        ticket.setId(9); ticket2.setId(10);
        ticketService = Mockito.mock(TicketService.class);
        ticketService.deleteTicket(ticket);
        verify(ticketService, times(1)).deleteTicket(ticket);
        when(ticketService.findTicket(9)).thenReturn(null);
        Assertions.assertNull(ticketService.findTicket(9));
        when(ticketService.findTicket(10)).thenReturn(ticket2);
        Assertions.assertNotNull(ticketService.findTicket(10));
    }
}
