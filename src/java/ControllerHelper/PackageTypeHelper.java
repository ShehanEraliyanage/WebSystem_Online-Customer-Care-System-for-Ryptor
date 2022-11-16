package ControllerHelper;

import Model.PackageType;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class PackageTypeHelper implements InterfacePackageType {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;

    @Override
    public int insertPackageType(PackageType packageType) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.INSERT_PACKAGE_TYPE));
            preparedStatement.setString(1, packageType.getName());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageTypeHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageTypeHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageTypeHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageTypeHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public List<PackageType> getAllPackageType() {

        List<PackageType> packageType = new ArrayList<>();
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_ALL_PACKAGE_TYPE));

            result = preparedStatement.executeQuery();

            while (result.next()) {
                packageType.add(new PackageType(
                        result.getInt("id"),
                        result.getString("name")
                ));
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageTypeHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageTypeHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageTypeHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageTypeHelper.class.getName(), e);
            }
        }
        return packageType;
    }

    @Override
    public PackageType selectPackageType(int id) {

        PackageType packageType = null;
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.SELECT_PACKAGE_TYPE));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                packageType = new PackageType(
                        result.getInt("id"),
                        result.getString("name")
                );
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageTypeHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageTypeHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageTypeHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageTypeHelper.class.getName(), e);
            }
        }
        return packageType;
    }

    @Override
    public int deletePackageType(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.DELETE_PACKAGE_TYPE));
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageTypeHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageTypeHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageTypeHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageTypeHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int updatePackageType(PackageType packageType) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.UPDATE_PACKAGE_TYPE));
            preparedStatement.setString(1, packageType.getName());
            preparedStatement.setInt(2, packageType.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageTypeHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageTypeHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageTypeHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageTypeHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public String getPackageTypeName(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_PACKAGE_TYPE_NAME));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();
            result.next();
            return result.getString("name");

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageTypeHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageTypeHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageTypeHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageTypeHelper.class.getName(), e);
            }
        }
        return null;
    }

}
