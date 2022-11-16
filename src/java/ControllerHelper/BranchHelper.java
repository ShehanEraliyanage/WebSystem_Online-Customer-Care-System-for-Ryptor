package ControllerHelper;

import Model.Branch;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class BranchHelper implements InterfaceBranch {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;
  

    @Override
    public int insertBranch(Branch branch) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.INSERT_BRANCH));
            preparedStatement.setString(1, branch.getName());
            preparedStatement.setString(2, branch.getLocation());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(BranchHelper.class.getName(), (SQLException) e);
            Log.logMessage(BranchHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(BranchHelper.class.getName(), (SQLException) e);
                Log.logMessage(BranchHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public List<Branch> getAllBranch() {

        List<Branch> branch = new ArrayList<>();
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_ALL_BRANCH));

            result = preparedStatement.executeQuery();

            while (result.next()) {
                branch.add(new Branch(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("location")
                ));
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(BranchHelper.class.getName(), (SQLException) e);
            Log.logMessage(BranchHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(BranchHelper.class.getName(), (SQLException) e);
                Log.logMessage(BranchHelper.class.getName(), e);
            }
        }
        return branch;
    }

    @Override
    public Branch selectBranch(int id) {

        Branch branch = null;
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.SELECT_BRANCH));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                branch = new Branch(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("location")
                );
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(BranchHelper.class.getName(), (SQLException) e);
            Log.logMessage(BranchHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(BranchHelper.class.getName(), (SQLException) e);
                Log.logMessage(BranchHelper.class.getName(), e);
            }
        }
        return branch;

    }

    @Override
    public int deleteBranch(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.DELETE_BRANCH));
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(BranchHelper.class.getName(), (SQLException) e);
            Log.logMessage(BranchHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(BranchHelper.class.getName(), (SQLException) e);
                Log.logMessage(BranchHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int updateBranch(Branch branch) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.UPDATE_BRANCH));
            preparedStatement.setString(1, branch.getName());
            preparedStatement.setString(2, branch.getLocation());
            preparedStatement.setInt(3, branch.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(BranchHelper.class.getName(), (SQLException) e);
            Log.logMessage(BranchHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(BranchHelper.class.getName(), (SQLException) e);
                Log.logMessage(BranchHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public String getBranchName(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_BRANCH_NAME));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();
            result.next();
            return result.getString("name");

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(BranchHelper.class.getName(), (SQLException) e);
            Log.logMessage(BranchHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(BranchHelper.class.getName(), (SQLException) e);
                Log.logMessage(BranchHelper.class.getName(), e);
            }
        }
        return null;

    }

    @Override
    public int CountBranch() {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.COUNT_BRANCH));

            result = preparedStatement.executeQuery();
            result.next();
            return result.getInt(1);

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(BranchHelper.class.getName(), (SQLException) e);
            Log.logMessage(BranchHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(BranchHelper.class.getName(), (SQLException) e);
                Log.logMessage(BranchHelper.class.getName(), e);
            }
        }
        return 0;
    }

}
