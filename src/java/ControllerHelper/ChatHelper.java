package ControllerHelper;

import Model.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class ChatHelper implements InterfaceChat {
    
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;

    @Override
    public int sendMessage(Chat chat) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.SEND_MESSAGE));
            preparedStatement.setInt(1, chat.getCustomer_id());
            preparedStatement.setInt(2, chat.getAgent_id());
            preparedStatement.setString(3, chat.getMessage());
            preparedStatement.setInt(4, chat.getSend_by());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(ChatHelper.class.getName(), (SQLException) e);
            Log.logMessage(ChatHelper.class.getName(), e);
        } finally {
            /*
             *cloce the prepared statement and database connectivity at the end of transaction
             */
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                FuntionHelper.printSQLException(ChatHelper.class.getName(), (SQLException) e);
                Log.logMessage(ChatHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public List<Chat> getMessagesByCustomer(int customer_id) {
        
        List<Chat> chat = new ArrayList<>();
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_MESSAGE_BY_CUSTOMER));
            preparedStatement.setInt(1, customer_id);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                chat.add(new Chat(
                        result.getInt("id"),
                        result.getInt("customer_id"),
                        result.getInt("agent_id"),
                        result.getString("message"),
                        result.getInt("send_by"),
                        result.getString("sent_time")
                ));
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(ChatHelper.class.getName(), (SQLException) e);
            Log.logMessage(ChatHelper.class.getName(), e);
        } finally {
            /*
             *cloce the prepared statement and database connectivity at the end of transaction
             */
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                FuntionHelper.printSQLException(ChatHelper.class.getName(), (SQLException) e);
                Log.logMessage(ChatHelper.class.getName(), e);
            }
        }
        return chat;
    }

    @Override
    public List<Customer> getCustomerChatHeads() {
        
        List<Customer> customer = new ArrayList<>();
        try {
           connection = DBConnection.estamblishConnnection();
           preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_CUSTOMER_CHAT_HEADS));

            result = preparedStatement.executeQuery();

            while (result.next()) {
                customer.add(new Customer(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("nic"),
                        result.getString("user_name"),
                        result.getString("password"),
                        result.getString("address"),
                        result.getString("email"),
                        result.getString("contact_number")
                ));
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(ChatHelper.class.getName(), (SQLException) e);
            Log.logMessage(ChatHelper.class.getName(), e);
        } finally {
            /*
             *cloce the prepared statement and database connectivity at the end of transaction
             */
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                FuntionHelper.printSQLException(ChatHelper.class.getName(), (SQLException) e);
                Log.logMessage(ChatHelper.class.getName(), e);
            }
        }
        return customer;
    }


}
