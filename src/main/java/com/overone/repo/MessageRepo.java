package com.overone.repo;

import com.overone.model.Message;
import com.overone.utils.DBUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepo {
    public List<Message> findAll() {
        List<Message> messageList = new ArrayList<>();

        try (Connection dbConn = DBUtils.getDBConn();
             Statement allMessages = dbConn.createStatement();
             ResultSet rs = allMessages.executeQuery("SELECT * FROM " +
                     "(SELECT * FROM chat.message " +
                     "ORDER BY id desc " +
                     "LIMIT 12) o " +
                     "ORDER BY id asc ")
        ) {
            while (rs.next()) {
                messageList.add(new Message(rs.getInt("id"),
                        rs.getString("time"),
                        rs.getString("sender"),
                        rs.getString("text")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return messageList;
    }

    public List<Message> findAllHiber() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Message> messageList = session.createQuery("from Message").list();
        transaction.commit();
        session.close();
        return messageList;
    }

    public boolean save(Message message) {
        try (Connection dbConn = DBUtils.getDBConn()
        ) {
            PreparedStatement saveMessage = dbConn.prepareStatement("Insert into message (time, sender, text) values (?, ?, ?)");
            saveMessage.setString(1, message.getTime());
            saveMessage.setString(2, message.getSender());
            saveMessage.setString(3, message.getText());
            return saveMessage.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
