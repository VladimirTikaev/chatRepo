package com.overone.repo;

import com.overone.model.Message;
import com.overone.utils.DBUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepo {
    public List<Message> findAll() {
        List<Message> messageList = new ArrayList<>();

        try (Connection dbConn = DBUtils.getDBConn();
             Statement allMessages = dbConn.createStatement();
             ResultSet rs = allMessages.executeQuery("Select * from message");
        ) {
            while (rs.next()) {
                messageList.add(new Message(rs.getLong("id"),
                        rs.getString("time"),
                        rs.getString("sender"),
                        rs.getString("text")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return messageList;
    }

}
