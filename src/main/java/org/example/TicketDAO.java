package org.example;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketDAO extends CrudRepository<Ticket, Integer> {
    @Query("select t from Ticket t where t.id=?1")
    Ticket getTicketById(int id);
    @Query("select t from Ticket t where t.userId=?1")
    List<Ticket> getTicketsByUserId(int userId);

    @Modifying
    @Query(value = "update Ticket t set t.ticketType=?1 where t.id=?2",
            nativeQuery = true)
    void updateTicket(String ticketType, int ticketId);
}
