package ControllerHelper;

import Model.Services;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class ServicesHelper implements InterfaceServices {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;

    public static String SERVICETYPE = null;

    @Override
    public int insertServices(Services services) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.INSERT_SERVICES));
            preparedStatement.setString(1, services.getName());
            preparedStatement.setString(2, services.getDescription());
            preparedStatement.setInt(3, Integer.parseInt(services.getServicetype_id()));

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(ServicesHelper.class.getName(), (SQLException) e);
            Log.logMessage(ServicesHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(ServicesHelper.class.getName(), (SQLException) e);
                Log.logMessage(ServicesHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public List<Services> getAllServices() {

        List<Services> services = new ArrayList<>();
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_ALL_SERVICES));

            result = preparedStatement.executeQuery();

            while (result.next()) {
                services.add(new Services(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("description"),
                        new ServicesTypeHelper().getServicesTypeName(result.getInt("servicetype_id"))
                ));
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(ServicesHelper.class.getName(), (SQLException) e);
            Log.logMessage(ServicesHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(ServicesHelper.class.getName(), (SQLException) e);
                Log.logMessage(ServicesHelper.class.getName(), e);
            }
        }
        return services;
    }

    @Override
    public Services selectServices(int id) {

        Services services = null;
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.SELECT_SERVICES));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                SERVICETYPE = new ServicesTypeHelper().getServicesTypeName(result.getInt("servicetype_id"));
                services = new Services(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("description"),
                        new ServicesTypeHelper().getServicesTypeName(result.getInt("servicetype_id"))
                );
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(ServicesHelper.class.getName(), (SQLException) e);
            Log.logMessage(ServicesHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(ServicesHelper.class.getName(), (SQLException) e);
                Log.logMessage(ServicesHelper.class.getName(), e);
            }
        }
        return services;

    }

    @Override
    public int deleteServices(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.DELETE_SERVICES));
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();

       } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(ServicesHelper.class.getName(), (SQLException) e);
            Log.logMessage(ServicesHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(ServicesHelper.class.getName(), (SQLException) e);
                Log.logMessage(ServicesHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int updateServices(Services services) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.UPDATE_SERVICES));
            preparedStatement.setString(1, services.getName());
            preparedStatement.setString(2, services.getDescription());
            preparedStatement.setInt(3, Integer.parseInt(services.getServicetype_id()));
            preparedStatement.setInt(4, services.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(ServicesHelper.class.getName(), (SQLException) e);
            Log.logMessage(ServicesHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(ServicesHelper.class.getName(), (SQLException) e);
                Log.logMessage(ServicesHelper.class.getName(), e);
            }
        }
        return 0;
    }

}
