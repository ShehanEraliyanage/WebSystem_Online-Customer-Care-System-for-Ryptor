package ControllerHelper;

import Model.Request;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class RequestHelper implements InterfaceRequest {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;

    @Override
    public int insertRequest(Request request) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.INSERT_REQUEST));
            preparedStatement.setString(1, request.getTitle());
            preparedStatement.setString(2, request.getRequest());
            preparedStatement.setInt(3, request.getCustomer_id());
            preparedStatement.setString(4, request.getNumber());
            preparedStatement.setInt(5, request.getAgent_id());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(RequestHelper.class.getName(), (SQLException) e);
            Log.logMessage(RequestHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(RequestHelper.class.getName(), (SQLException) e);
                Log.logMessage(RequestHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public List<Request> getAllRequestByEmployeeType(int id, String type) {

        List<Request> request = new ArrayList<>();
        try {
            connection = DBConnection.estamblishConnnection();
            if (type.equals("agent")) {
                preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_ALL_REQUEST_BY_AGENT));
            }
            if (type.equals("admin")) {
                preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_ALL_REQUEST_BY_ADMIN));
            }
            if (type.equals("manager")) {
                preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_ALL_REQUEST_BY_MANAGER));
            }
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                request.add(new Request(
                        result.getInt("id"),
                        result.getString("title"),
                        result.getString("request"),
                        result.getInt("customer_id"),
                        result.getString("number"),
                        result.getString("date_time"),
                        result.getInt("agent_id"),
                        result.getInt("admin_id"),
                        result.getInt("manager_id"),
                        result.getInt("status")
                ));
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(RequestHelper.class.getName(), (SQLException) e);
            Log.logMessage(RequestHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(RequestHelper.class.getName(), (SQLException) e);
                Log.logMessage(RequestHelper.class.getName(), e);
            }
        }
        return request;
    }

    @Override
    public List<Request> getAllRequestByCustomer(int customer_id) {

        List<Request> request = new ArrayList<>();
        try {
            connection = DBConnection.estamblishConnnection();

            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_ALL_REQUEST_BY_CUSTOMER));

            preparedStatement.setInt(1, customer_id);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                request.add(new Request(
                        result.getInt("id"),
                        result.getString("title"),
                        result.getString("request"),
                        result.getInt("customer_id"),
                        result.getString("number"),
                        result.getString("date_time"),
                        result.getInt("agent_id"),
                        result.getInt("admin_id"),
                        result.getInt("manager_id"),
                        result.getInt("status")
                ));
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(RequestHelper.class.getName(), (SQLException) e);
            Log.logMessage(RequestHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(RequestHelper.class.getName(), (SQLException) e);
                Log.logMessage(RequestHelper.class.getName(), e);
            }
        }
        return request;
    }

    @Override
    public int toConfirmRequest(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.TO_CONFIRM_REQUEST));
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(RequestHelper.class.getName(), (SQLException) e);
            Log.logMessage(RequestHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(RequestHelper.class.getName(), (SQLException) e);
                Log.logMessage(RequestHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int toRejectRequest(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.TO_REJECT_REQUEST));
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(RequestHelper.class.getName(), (SQLException) e);
            Log.logMessage(RequestHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(RequestHelper.class.getName(), (SQLException) e);
                Log.logMessage(RequestHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int fowardRequest(int id, int userID, String type) {

        try {
            connection = DBConnection.estamblishConnnection();
            if (type.equals("agent")) {
                preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.AGENT_FOEARD_REQUEST_TO_ADMIN));
                preparedStatement.setInt(1, userID);
                preparedStatement.setInt(2, id);
            } else {
                preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.ADMIN_FOEARD_REQUEST_TO_MANAGER));
                preparedStatement.setInt(1, id);
            }

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(RequestHelper.class.getName(), (SQLException) e);
            Log.logMessage(RequestHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(RequestHelper.class.getName(), (SQLException) e);
                Log.logMessage(RequestHelper.class.getName(), e);
            }
        }
        return 0;
    }
      public int deleteRequest(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.DELETE_REQUEST));
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(AdminHelper.class.getName(), (SQLException) e);
            Log.logMessage(AdminHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(AdminHelper.class.getName(), (SQLException) e);
                Log.logMessage(AdminHelper.class.getName(), e);
            }
        }

        return 0;
    }

}
