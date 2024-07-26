package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Main {

    //private static List<String> tickets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Main.class, args);
        /*ApplicationContext ap = new AnnotationConfigApplicationContext(MyConfiguration.class);
        BeanMessage bm = ap.getBean(BeanMessage.class);
        System.out.println(bm.getMessage());*/
        /*
        Ticket ticket = new Ticket(user.getId(), "DAY", Date.valueOf(LocalDate.now()));
        dao.save(ticket);*/
        //DAO.fetchTicket(ticket.getId());
        /*ApplicationContext ap = new AnnotationConfigApplicationContext(MyConfiguration.class);
        DAO dao = ap.getBean(DAO.class);
        User user = new User("Sam", Date.valueOf(LocalDate.now()));
        dao.save(user);*/
       // ApplicationContext ap = new AnnotationConfigApplicationContext(MyConfiguration.class);
        //Resource file = ap.getResource("classpath:input.txt");
        //loadToList(file.getFile());
        //System.out.println(tickets);
//        User user = new User("Max", Date.valueOf(LocalDate.now()));
//        UserDAO userDAO = new UserDAO();
//        userDAO.save(user);
//        Ticket ticket = new Ticket("DAY", Date.valueOf(LocalDate.now()));
//        ticket.setUser(user);
//        TicketDAO ticketDAO = new TicketDAO();
//        ticketDAO.save(ticket);

    }

    /*public static void loadToList(File file) throws IOException {
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
    }*/
}
