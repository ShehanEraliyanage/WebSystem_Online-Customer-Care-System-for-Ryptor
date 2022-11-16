package ControllerHelper;

import Model.Admin;
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

public class AdminHelper implements InterfaceAdmin {   

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;

    public static String BRANCHNAME = null;
    
  

    @Override
    public int validateAdmin(UserCredentials admin) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.VALIDATE_ADMIN));
            preparedStatement.setString(1, admin.getEmail());
            preparedStatement.setString(2, admin.getPassword());

            result = preparedStatement.executeQuery();
            result.next();

            return result.getInt("id");

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

    @Override
    public int insertAdmin(Admin admin) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.INSERT_ADMIN));
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getNic());
            preparedStatement.setString(3, admin.getEmail());
            preparedStatement.setString(4, admin.getPassword());
            preparedStatement.setInt(5, Integer.parseInt(admin.getManagerId()));
            preparedStatement.setInt(6, Integer.parseInt(admin.getBranchId()));

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

    @Override
    public List<Admin> getAllAdmin() {

        List<Admin> admin = new ArrayList<>();
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_ALL_ADMIN));

            result = preparedStatement.executeQuery();

            while (result.next()) {
                admin.add(new Admin(
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
        return admin;
    }

    @Override
    public Admin selectAdmin(int id) {

        Admin admin = null;
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.SELECT_ADMIN));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                BRANCHNAME = new BranchHelper().getBranchName(result.getInt("branch_id"));
                admin = new Admin(
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
        return admin;

    }

    @Override
    public Admin getNameAndImageAdmin(int id) {

        Admin admin = null;
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_NAME_AND_IMAGE_ADMIN));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                admin = new Admin(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("image")
                );
            }

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
        return admin;
    }

    @Override
    public int deleteAdmin(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.DELETE_ADMIN));
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

    @Override
    public int updateAdmin(Admin admin) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.UPDATE_ADMIN));
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getNic());
            preparedStatement.setString(3, admin.getEmail());
            preparedStatement.setString(4, admin.getPassword());
            preparedStatement.setInt(5, Integer.parseInt(admin.getBranchId()));
            preparedStatement.setInt(6, admin.getId());

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

    @Override
    public int updateProfileImageAndData(Admin admin) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.UPDATE_PROFILE_IMAGE_AND_DATA_ADMIN));
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getNic());
            preparedStatement.setString(3, admin.getEmail());
            preparedStatement.setString(4, admin.getImage());
            preparedStatement.setInt(5, admin.getId());

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

    @Override
    public int updateProfileData(Admin admin) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.UPDATE_PROFILE_DATA_ADMIN));
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getNic());
            preparedStatement.setString(3, admin.getEmail());
            preparedStatement.setInt(4, admin.getId());

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

    @Override
    public int CountAdmin() {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.COUNT_ADMIN));

            result = preparedStatement.executeQuery();
            result.next();
            return result.getInt(1) - 1;

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

    @Override
    public int selectChangePasswordAdmin(int id, String curuntPassword) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.SELECT_CHANGE_PASSWORD_ADMIN));
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, curuntPassword);

            result = preparedStatement.executeQuery();
            result.next();
            return result.getInt("id");

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

    @Override
    public int changePasswordAdmin(int id, String newPassword) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.CHANGE_PASSWORD_ADMIN));
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, id);

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
