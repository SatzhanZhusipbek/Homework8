package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public TicketDAO() {
    }

    public Ticket findTicketById(int id) {
        return SessionFactoryProvider.getSessionFactory()
                .openSession().get(Ticket.class, id);
    }

    public List<Ticket> findTicketsByUserId(int userId) {
       String jpqlQuery = "SELECT t from Ticket t WHERE t.user_id = "+userId;
       Query query = entityManager.createQuery(jpqlQuery, Ticket.class);
       return query.getResultList();
    }

    public void save(Ticket ticket) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(ticket);
        transaction.commit();
        session.close();
    }

    public void update(Ticket ticket) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(ticket);
        transaction.commit();
        session.close();
    }

    public void delete(Ticket ticket) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(ticket);
        transaction.commit();
        session.close();
    }
}
