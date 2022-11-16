package ControllerHelper;

import Model.Sim;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class SimHelper implements InterfaceSim {
    
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;

    @Override
    public int insertSim(Sim sim) {
        
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.INSERT_SIM));
            preparedStatement.setString(1, sim.getSimNumber());
            preparedStatement.setInt(2, sim.getStatus());
            preparedStatement.setString(3, sim.getCustomerNIC());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
            Log.logMessage(SimHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
                Log.logMessage(SimHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public List<Sim> getAllSim() {

        List<Sim> sim = new ArrayList<>();
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_ALL_SIM));

            result = preparedStatement.executeQuery();

            while (result.next()) {
                sim.add(new Sim(
                        result.getInt("id"),
                        result.getString("number"),
                        result.getInt("status"),
                        result.getString("customer_nic")
                ));
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
            Log.logMessage(SimHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
                Log.logMessage(SimHelper.class.getName(), e);
            }
        }
        return sim;
    }

    @Override
    public Sim selectSim(int id) {
        
        Sim sim = null;
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.SELECT_SIM));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                sim = new Sim(
                        result.getInt("id"),
                        result.getString("number"),
                        result.getInt("status"),
                        result.getString("customer_nic")
                );
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
            Log.logMessage(SimHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
                Log.logMessage(SimHelper.class.getName(), e);
            }
        }
        return sim;
    }

    @Override
    public int deleteSim(int id) {
        
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.DELETE_SIM));
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
            Log.logMessage(SimHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
                Log.logMessage(SimHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int updateSim(Sim sim) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.UPDATE_SIM));
            preparedStatement.setString(1, sim.getSimNumber());
            preparedStatement.setString(2, sim.getCustomerNIC());
            preparedStatement.setInt(3, sim.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
            Log.logMessage(SimHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
                Log.logMessage(SimHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int toActive(int id, int status) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.TO_ACTIVE_SIM));
            preparedStatement.setInt(1, status);
            preparedStatement.setInt(2, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
            Log.logMessage(SimHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
                Log.logMessage(SimHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int toDeactive(int id, int status) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.TO_DEACTIVE_SIM));
            preparedStatement.setInt(1, status);
            preparedStatement.setInt(2, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
            Log.logMessage(SimHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
                Log.logMessage(SimHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public List<Sim> getSimByNic(String nic) {

        List<Sim> sim = new ArrayList<>();
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_SIM_BT_NIC));
            preparedStatement.setString(1, nic);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                sim.add(new Sim(
                        result.getInt("id"),
                        result.getString("number"),
                        result.getInt("status"),
                        result.getString("customer_nic")
                ));
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
            Log.logMessage(SimHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
                Log.logMessage(SimHelper.class.getName(), e);
            }
        }
        return sim;
    }

    @Override
    public String getSimNumber(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_SIM_NUMBER));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();

            result.next();
            return result.getString("number");

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
            Log.logMessage(SimHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
                Log.logMessage(SimHelper.class.getName(), e);
            }
        }
        return null;
    }

    @Override
    public int CountSim() {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.COUNT_SIM));

            result = preparedStatement.executeQuery();
            result.next();
            return result.getInt(1);

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
            Log.logMessage(SimHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
                Log.logMessage(SimHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int CountActiveSim() {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.COUNT_ACTIVE_SIM));

            result = preparedStatement.executeQuery();
            result.next();
            return result.getInt(1);

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
            Log.logMessage(SimHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
                Log.logMessage(SimHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int CountDeactiveSim() {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.COUNT_DEACTIVE_SIM));

            result = preparedStatement.executeQuery();
            result.next();
            return result.getInt(1);

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
            Log.logMessage(SimHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(SimHelper.class.getName(), (SQLException) e);
                Log.logMessage(SimHelper.class.getName(), e);
            }
        }
        return 0;
    }

   
}
