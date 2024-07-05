package org.example;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class DAO {


    public void save(User user) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_ticket_service_db",
                "postgres", "malboro");
        con.setAutoCommit(false);
        PreparedStatement statement =
                con.prepareStatement("INSERT INTO Person " +
                        "(name, creation_date)" +
                        "VALUES (?, ?)");
        statement.setString(1, user.getName());
        statement.setDate(2, user.getCreationDate());
        try {
            statement.executeUpdate();
            con.commit();
            con.close();
        } catch (SQLException e) {
            con.rollback();
        }
    }

    public void save(Ticket ticket) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_ticket_service_db",
                "postgres", "malboro");
        con.setAutoCommit(false);
        PreparedStatement statement =
                con.prepareStatement("INSERT INTO Ticket " +
                        "(user_id, ticket_type, creation_date)" +
                        "VALUES (?, ?, ?)");
        statement.setInt(1, ticket.getUserId());
        statement.setString(2, ticket.getTicketType());
        statement.setDate(3, ticket.getCreationDate());
        try {
            statement.executeUpdate();
            con.commit();
            con.close();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }
    }


    public Ticket fetchTicket(int id) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_ticket_service_db",
                "postgres", "malboro");
        Ticket searchedTicket = new Ticket();
        try {
            PreparedStatement statement =
                    con.prepareStatement("SELECT * FROM Ticket WHERE id=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                searchedTicket.setId(rs.getInt("id"));
                searchedTicket.setUserId(rs.getInt("user_id"));
                searchedTicket.setTicketType(rs.getString("ticket_type"));
                searchedTicket.setCreationDate(rs.getDate("creation_date"));
            }
            con.close();
            return searchedTicket;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public List<Ticket> fetchTicketsByUserId(int userId) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_ticket_service_db",
                "postgres", "malboro");
        List<Ticket> listOfTickets = new ArrayList<>();
        try {
            PreparedStatement statement =
                    con.prepareStatement("SELECT * FROM Ticket WHERE user_id=?");
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Ticket searchedTicket = new Ticket();
                searchedTicket.setId(rs.getInt("id"));
                searchedTicket.setUserId(rs.getInt("user_id"));
                searchedTicket.setTicketType(rs.getString("ticket_type"));
                searchedTicket.setCreationDate(rs.getDate("creation_date"));
                listOfTickets.add(searchedTicket);
            }
            con.close();
            return listOfTickets;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public User fetchUserById(int id) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_ticket_service_db",
                "postgres", "malboro");
        try {
            PreparedStatement statement =
                    con.prepareStatement("SELECT * FROM Person WHERE id=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            User searchedUser = new User();
            while (rs.next()) {
                searchedUser.setId(rs.getInt("id"));
                searchedUser.setName(rs.getString("name"));
                searchedUser.setCreationDate(rs.getDate("creation_date"));
            }
            con.close();
            return searchedUser;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void updateTicketType(String type, int id) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_ticket_service_db",
                "postgres", "malboro");
        try {
            con.setAutoCommit(false);
            PreparedStatement statement =
                    con.prepareStatement("UPDATE Ticket " +
                            "SET ticket_type=? " +
                            "WHERE id=?");
            statement.setInt(1, id);
            statement.setString(3, type);
            statement.executeUpdate();
            con.commit();
            con.close();
        } catch (SQLException e) {
            con.rollback();
        }
    }

    public void delete(User user) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_ticket_service_db",
                "postgres", "malboro");
        try {
            con.setAutoCommit(false);
            PreparedStatement statement =
                    con.prepareStatement("SELECT * FROM Ticket " +
                            "WHERE user_id=?");
            statement.setInt(2, user.getId());
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                System.out.println("This user has no tickets!");
            } else {
                PreparedStatement statement2 =
                        con.prepareStatement("DELETE FROM Ticket " +
                                "WHERE user_id=?");
                statement2.setInt(2, user.getId());
                statement2.executeUpdate();
            }
            PreparedStatement statement3 =
                    con.prepareStatement("DELETE FROM Person " +
                            "WHERE id=?");
            statement3.setInt(1, user.getId());
            statement3.executeUpdate();
            con.commit();
            con.close();
        } catch (SQLException e) {
            con.rollback();
        }
    }
}

