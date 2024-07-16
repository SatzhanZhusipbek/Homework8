package org.example;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    private TicketDAO ticketDAO;

    public UserService() {

    }

    public User findUser(int id) {
        return userDAO.findUserById(id);
    }

    public void saveUser(User user) {
        userDAO.save(user);
    }

    public void updateUser(User user) {
        userDAO.update(user);
    }

    public void deleteUser(User user) {
        userDAO.delete(user);
    }

    /*public void updateUserTickets(User user) {
        List<Ticket> tickets = ticketDAO.findTicketsByUserId(user.getId());
        for (int i = 0; i < tickets.size(); i++) {
            ticketDAO.update(tickets.get(i));
        }
        userDAO.update(user);
    }*/
}
