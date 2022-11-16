package ControllerHelper;

import Model.Customer;
import Model.UserCredentials;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class CustomerHelper implements InterfaceCustomer {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;

    @Override
    public Customer validateCustomer(UserCredentials customer) {

        Customer setcustomer = null;
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.VALIDATE_CUSTOMER));
            preparedStatement.setString(1, customer.getEmail());
            preparedStatement.setString(2, customer.getPassword());

            result = preparedStatement.executeQuery();

            while (result.next()) {
                setcustomer = new Customer(
                        result.getInt("id"),
                        result.getString("nic"),
                        result.getString("user_name")
                );
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(CustomerHelper.class.getName(), (SQLException) e);
            Log.logMessage(CustomerHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(CustomerHelper.class.getName(), (SQLException) e);
                Log.logMessage(CustomerHelper.class.getName(), e);
            }
        }
        return setcustomer;
    }

    @Override
    public int insertCustomer(Customer customer) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.INSERT_CUSTOMER));
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getNic());
            preparedStatement.setString(3, customer.getUserName());
            preparedStatement.setString(4, customer.getPassword());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getContactNo());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(CustomerHelper.class.getName(), (SQLException) e);
            Log.logMessage(CustomerHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(CustomerHelper.class.getName(), (SQLException) e);
                Log.logMessage(CustomerHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public List<Customer> getAllCustomers() {

        List<Customer> customer = new ArrayList<>();
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_ALL_CUSTOMER));

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
            FuntionHelper.printSQLException(CustomerHelper.class.getName(), (SQLException) e);
            Log.logMessage(CustomerHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(CustomerHelper.class.getName(), (SQLException) e);
                Log.logMessage(CustomerHelper.class.getName(), e);
            }
        }
        return customer;
    }

    @Override
    public Customer selectCustomer(int id) {

        Customer customer = null;
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.SELECT_CUSTOMER));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                customer = new Customer(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("nic"),
                        result.getString("user_name"),
                        result.getString("password"),
                        result.getString("address"),
                        result.getString("email"),
                        result.getString("contact_number")
                );
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(CustomerHelper.class.getName(), (SQLException) e);
            Log.logMessage(CustomerHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(CustomerHelper.class.getName(), (SQLException) e);
                Log.logMessage(CustomerHelper.class.getName(), e);
            }
        }
        return customer;

    }

    @Override
    public int deleteCustomer(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.DELETE_CUSTOMER));
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(CustomerHelper.class.getName(), (SQLException) e);
            Log.logMessage(CustomerHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(CustomerHelper.class.getName(), (SQLException) e);
                Log.logMessage(CustomerHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int updateCustomer(Customer customer) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.UPDATE_CUSTOMER));
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getNic());
            preparedStatement.setString(3, customer.getUserName());
            preparedStatement.setString(4, customer.getPassword());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getContactNo());
            preparedStatement.setInt(8, customer.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(CustomerHelper.class.getName(), (SQLException) e);
            Log.logMessage(CustomerHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(CustomerHelper.class.getName(), (SQLException) e);
                Log.logMessage(CustomerHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int CountCustomer() {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.COUNT_CUSTOMER));

            result = preparedStatement.executeQuery();
            result.next();
            return result.getInt(1);

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(CustomerHelper.class.getName(), (SQLException) e);
            Log.logMessage(CustomerHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(CustomerHelper.class.getName(), (SQLException) e);
                Log.logMessage(CustomerHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public String getCustomerName(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_CUSTOMER_NAME));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();
            result.next();
            return result.getString("name");

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(CustomerHelper.class.getName(), (SQLException) e);
            Log.logMessage(CustomerHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(CustomerHelper.class.getName(), (SQLException) e);
                Log.logMessage(CustomerHelper.class.getName(), e);
            }
        }
        return null;
    }

}
