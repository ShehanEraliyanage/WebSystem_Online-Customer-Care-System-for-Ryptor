package ControllerHelper;

import Model.Agent;
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

public class AgentHelper implements InterfaceAgent {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;

    public static String BRANCHNAME = null;

    @Override
    public int validateAgent(UserCredentials agent) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.VALIDATE_AGENT));
            preparedStatement.setString(1, agent.getEmail());
            preparedStatement.setString(2, agent.getPassword());

            result = preparedStatement.executeQuery();
            result.next();

            return result.getInt("id");

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
            Log.logMessage(AgentHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
                Log.logMessage(AgentHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int insertAgent(Agent agent) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.INSERT_AGENT));
            preparedStatement.setString(1, agent.getName());
            preparedStatement.setString(2, agent.getNic());
            preparedStatement.setString(3, agent.getEmail());
            preparedStatement.setString(4, agent.getPassword());
            preparedStatement.setInt(5, Integer.parseInt(agent.getBranchId()));

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
            Log.logMessage(AgentHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
                Log.logMessage(AgentHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public List<Agent> getAllAgent() {

        List<Agent> agent = new ArrayList<>();
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_ALL_AGENT));

            result = preparedStatement.executeQuery();

            while (result.next()) {
                agent.add(new Agent(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("nic"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("image"),
                        new BranchHelper().getBranchName(result.getInt("branch_id"))
                ));
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
            Log.logMessage(AgentHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
                Log.logMessage(AgentHelper.class.getName(), e);
            }
        }
        return agent;
    }

    @Override
    public Agent selectAgent(int id) {

        Agent agent = null;
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.SELECT_AGENT));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                BRANCHNAME = new BranchHelper().getBranchName(result.getInt("branch_id"));
                agent = new Agent(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("nic"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("image"),
                        new BranchHelper().getBranchName(result.getInt("branch_id"))
                );
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
            Log.logMessage(AgentHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
                Log.logMessage(AgentHelper.class.getName(), e);
            }
        }
        return agent;
    }

    @Override
    public Agent getNameAndImageAgent(int id) {

        Agent agent = null;
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_NAME_AND_IMAGE_AGENT));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                agent = new Agent(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("image")
                );
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
            Log.logMessage(AgentHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
                Log.logMessage(AgentHelper.class.getName(), e);
            }
        }
        return agent;
    }

    @Override
    public int deleteAgent(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.DELETE_AGENT));
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
            Log.logMessage(AgentHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
                Log.logMessage(AgentHelper.class.getName(), e);
            }
        }

        return 0;
    }

    @Override
    public int updateAgent(Agent agent) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.UPDATE_AGENT));
            preparedStatement.setString(1, agent.getName());
            preparedStatement.setString(2, agent.getNic());
            preparedStatement.setString(3, agent.getEmail());
            preparedStatement.setString(4, agent.getPassword());
            preparedStatement.setInt(5, Integer.parseInt(agent.getBranchId()));
            preparedStatement.setInt(6, agent.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
            Log.logMessage(AgentHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
                Log.logMessage(AgentHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int updateProfileImageAndData(Agent agent) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.UPDATE_PROFILE_IMAGE_AND_DATA_AGENT));
            preparedStatement.setString(1, agent.getName());
            preparedStatement.setString(2, agent.getNic());
            preparedStatement.setString(3, agent.getEmail());
            preparedStatement.setString(4, agent.getImage());
            preparedStatement.setInt(5, agent.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
            Log.logMessage(AgentHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
                Log.logMessage(AgentHelper.class.getName(), e);
            }
        }

        return 0;
    }

    @Override
    public int updateProfileData(Agent agent) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.UPDATE_PROFILE_DATA_AGENT));
            preparedStatement.setString(1, agent.getName());
            preparedStatement.setString(2, agent.getNic());
            preparedStatement.setString(3, agent.getEmail());
            preparedStatement.setInt(4, agent.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
            Log.logMessage(AgentHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
                Log.logMessage(AgentHelper.class.getName(), e);
            }
        }

        return 0;
    }

    @Override
    public int CountAgent() {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.COUNT_AGENT));

            result = preparedStatement.executeQuery();
            result.next();
            return result.getInt(1);

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
            Log.logMessage(AgentHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
                Log.logMessage(AgentHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int selectChangePasswordAgent(int id, String curuntPassword) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.SELECT_CHANGE_PASSWORD_AGENT));
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, curuntPassword);

            result = preparedStatement.executeQuery();
            result.next();
            return result.getInt("id");

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
            Log.logMessage(AgentHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
                Log.logMessage(AgentHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int changePasswordAgent(int id, String newPassword) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.CHANGE_PASSWORD_AGENT));
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
            Log.logMessage(AgentHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(AgentHelper.class.getName(), (SQLException) e);
                Log.logMessage(AgentHelper.class.getName(), e);
            }
        }
        return 0;
    }

}
