package ControllerHelper;

import Model.ServicesType;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class ServicesTypeHelper implements InterfaceServicesType {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;

    @Override
    public int insertServicesType(ServicesType servicesType) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.INSERT_SERVICES_TYPE));
            preparedStatement.setString(1, servicesType.getName());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(ServicesTypeHelper.class.getName(), (SQLException) e);
            Log.logMessage(ServicesTypeHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(ServicesTypeHelper.class.getName(), (SQLException) e);
                Log.logMessage(ServicesTypeHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public List<ServicesType> getAllServicesType() {

        List<ServicesType> servicesType = new ArrayList<>();
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_ALL_SERVICES_TYPE));

            result = preparedStatement.executeQuery();

            while (result.next()) {
                servicesType.add(new ServicesType(
                        result.getInt("id"),
                        result.getString("name")
                ));
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(ServicesTypeHelper.class.getName(), (SQLException) e);
            Log.logMessage(ServicesTypeHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(ServicesTypeHelper.class.getName(), (SQLException) e);
                Log.logMessage(ServicesTypeHelper.class.getName(), e);
            }
        }
        return servicesType;
    }

    @Override
    public ServicesType selectServicesType(int id) {

        ServicesType servicesType = null;
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.SELECT_SERVICES_TYPE));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                servicesType = new ServicesType(
                        result.getInt("id"),
                        result.getString("name")
                );
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(ServicesTypeHelper.class.getName(), (SQLException) e);
            Log.logMessage(ServicesTypeHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(ServicesTypeHelper.class.getName(), (SQLException) e);
                Log.logMessage(ServicesTypeHelper.class.getName(), e);
            }
        }
        return servicesType;
    }

    @Override
    public int deleteServicesType(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.DELETE_SERVICES_TYPE));
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(ServicesTypeHelper.class.getName(), (SQLException) e);
            Log.logMessage(ServicesTypeHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(ServicesTypeHelper.class.getName(), (SQLException) e);
                Log.logMessage(ServicesTypeHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int updateServicesType(ServicesType servicesType) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.UPDATE_SERVICES_TYPE));
            preparedStatement.setString(1, servicesType.getName());
            preparedStatement.setInt(2, servicesType.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(ServicesTypeHelper.class.getName(), (SQLException) e);
            Log.logMessage(ServicesTypeHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(ServicesTypeHelper.class.getName(), (SQLException) e);
                Log.logMessage(ServicesTypeHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public String getServicesTypeName(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_SERVICES_TYPE_NAME));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();
            result.next();
            return result.getString("name");

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(ServicesTypeHelper.class.getName(), (SQLException) e);
            Log.logMessage(ServicesTypeHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(ServicesTypeHelper.class.getName(), (SQLException) e);
                Log.logMessage(ServicesTypeHelper.class.getName(), e);
            }
        }
        return null;

    }

}
