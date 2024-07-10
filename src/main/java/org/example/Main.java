package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@ComponentScan
public class Main {

    private static List<String> tickets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        /*
        Ticket ticket = new Ticket(user.getId(), "DAY", Date.valueOf(LocalDate.now()));
        dao.save(ticket);*/
        //DAO.fetchTicket(ticket.getId());
        /*ApplicationContext ap = new AnnotationConfigApplicationContext(MyConfiguration.class);
        DAO dao = ap.getBean(DAO.class);
        User user = new User("Sam", Date.valueOf(LocalDate.now()));
        dao.save(user);*/
        ApplicationContext ap = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Resource file = ap.getResource("classpath:input.txt");
        //loadToList(file.getFile());
        //System.out.println(tickets);
        User user = new User("Max", Date.valueOf(LocalDate.now()));
        UserDAO userDAO = new UserDAO();
        userDAO.save(user);
        Ticket ticket = new Ticket("DAY", Date.valueOf(LocalDate.now()));
        ticket.setUser(user);
        TicketDAO ticketDAO = new TicketDAO();
        ticketDAO.save(ticket);

    }

    public static void loadToList(File file) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                tickets.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
