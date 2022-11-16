package ControllerHelper;

import Model.Packages;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class PackageHelper implements InterfacePackage {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;

    public static String PACKAGETYPE = null;

    @Override
    public int insertPackage(Packages packages) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.INSERT_PACKAGE));
            preparedStatement.setString(1, packages.getName());
            preparedStatement.setString(2, packages.getDescription());
            preparedStatement.setString(3, packages.getPrice());
            preparedStatement.setInt(4, packages.getValidityPeriod());
            preparedStatement.setString(5, packages.getAntData());
            preparedStatement.setString(6, packages.getNigthtData());
            preparedStatement.setInt(7, Integer.parseInt(packages.getPackageType()));

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public List<Packages> getAllPackage() {

        List<Packages> packages = new ArrayList<>();
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_ALL_PACKAGE));

            result = preparedStatement.executeQuery();

            while (result.next()) {
                packages.add(new Packages(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("description"),
                        result.getString("price"),
                        result.getInt("validity_period"),
                        result.getString("any_data"),
                        result.getString("night_data"),
                        new PackageTypeHelper().getPackageTypeName(result.getInt("package_type"))
                ));
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageHelper.class.getName(), e);
            }
        }
        return packages;
    }

    @Override
    public Packages selectPackage(int id) {

        Packages packages = null;
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.SELECT_PACKAGE));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                PACKAGETYPE = new PackageTypeHelper().getPackageTypeName(result.getInt("package_type"));
                packages = new Packages(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("description"),
                        result.getString("price"),
                        result.getInt("validity_period"),
                        result.getString("any_data"),
                        result.getString("night_data"),
                        new PackageTypeHelper().getPackageTypeName(result.getInt("package_type"))
                );
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageHelper.class.getName(), e);
            }
        }
        return packages;
    }

    @Override
    public int deletePackage(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.DELETE_PACKAGE));
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int updatePackage(Packages packages) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.UPDATE_PACKAGE));
            preparedStatement.setString(1, packages.getName());
            preparedStatement.setString(2, packages.getDescription());
            preparedStatement.setString(3, packages.getPrice());
            preparedStatement.setInt(4, packages.getValidityPeriod());
            preparedStatement.setString(5, packages.getAntData());
            preparedStatement.setString(6, packages.getNigthtData());
            preparedStatement.setInt(7, Integer.parseInt(packages.getPackageType()));
            preparedStatement.setInt(8, packages.getId());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public List<Packages> getAllSimPackage(int simID) {

        List<Packages> packages = new ArrayList<>();
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_ALL_SIM_PACKAGE));
            preparedStatement.setInt(1, simID);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                packages.add(new Packages(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("description"),
                        result.getString("price"),
                        result.getInt("validity_period"),
                        result.getString("any_data"),
                        result.getString("night_data"),
                        new PackageTypeHelper().getPackageTypeName(result.getInt("package_type"))
                ));
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageHelper.class.getName(), e);
            }
        }
        return packages;
    }

    @Override
    public int simPackageActive(int simID, int packageID) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.SIM_PACKAGE_ACTIVE));
            preparedStatement.setInt(1, simID);
            preparedStatement.setInt(2, packageID);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int simPackageDeactive(int simID, int packageID) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.SIM_PACKAGE_DEACTIVE));
            preparedStatement.setInt(1, simID);
            preparedStatement.setInt(2, packageID);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public int CountPackage() {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.COUNT_PACKAGE));

            result = preparedStatement.executeQuery();
            result.next();
            return result.getInt(1);

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageHelper.class.getName(), e);
            }
        }
        return 0;

    }
    
    @Override
    public int updateRentalPackage(int simID,int packageID){

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.UPDATE_RENTAL_PACKAGE));
            preparedStatement.setInt(1, packageID);
            preparedStatement.setInt(2, simID);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageHelper.class.getName(), e);
            }
        }
        return 0;
   }
    
    @Override
    public List<Packages> getAllPackageByType(int type) {
        
        List<Packages> packages = new ArrayList<>();
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_ALL_PACKAGE_BY_TYPE));
            preparedStatement.setInt(1, type);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                packages.add(new Packages(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("description"),
                        result.getString("price"),
                        result.getInt("validity_period"),
                        result.getString("any_data"),
                        result.getString("night_data"),
                        new PackageTypeHelper().getPackageTypeName(result.getInt("package_type"))
                ));
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
            Log.logMessage(PackageHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(PackageHelper.class.getName(), (SQLException) e);
                Log.logMessage(PackageHelper.class.getName(), e);
            }
        }
        return packages;
    }
    
   

}
