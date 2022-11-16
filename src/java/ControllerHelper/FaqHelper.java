package ControllerHelper;

import Model.FAQ;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class FaqHelper implements InterfaceFaq {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;

    public static String SERVICETYPE = null;

    @Override
    public int insertFAQ(FAQ faq) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.INSERT_FAQ));
            preparedStatement.setString(1, faq.getQuestion());
            preparedStatement.setString(2, faq.getAnswer());

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(FaqHelper.class.getName(), (SQLException) e);
            Log.logMessage(FaqHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(FaqHelper.class.getName(), (SQLException) e);
                Log.logMessage(FaqHelper.class.getName(), e);
            }
        }
        return 0;
    }

    @Override
    public List<FAQ> getAllFAQ() {

        List<FAQ> faq = new ArrayList<>();
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.GET_ALL_FAQ));

            result = preparedStatement.executeQuery();

            while (result.next()) {
                faq.add(new FAQ(
                        result.getInt("id"),
                        result.getString("question"),
                        result.getString("answer")
                ));
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(FaqHelper.class.getName(), (SQLException) e);
            Log.logMessage(FaqHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(FaqHelper.class.getName(), (SQLException) e);
                Log.logMessage(FaqHelper.class.getName(), e);
            }
        }
        return faq;
    }

    @Override
    public FAQ selectFAQ(int id) {

        FAQ faq = null;
        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.SELECT_FAQ));
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                faq = new FAQ(
                        result.getInt("id"),
                        result.getString("question"),
                        result.getString("answer")
                );
            }

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(FaqHelper.class.getName(), (SQLException) e);
            Log.logMessage(FaqHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(FaqHelper.class.getName(), (SQLException) e);
                Log.logMessage(FaqHelper.class.getName(), e);
            }
        }
        return faq;
    }

    @Override
    public int deleteFAQ(int id) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.DELETE_FAQ));
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(FaqHelper.class.getName(), (SQLException) e);
            Log.logMessage(FaqHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(FaqHelper.class.getName(), (SQLException) e);
                Log.logMessage(FaqHelper.class.getName(), e);
            }
        }

        return 0;
    }

    @Override
    public int updateFAQ(FAQ faq) {

        try {
            connection = DBConnection.estamblishConnnection();
            preparedStatement = connection.prepareStatement(QueryUtil.queryByID(QueryConstant.UPDATE_FAQ));
            preparedStatement.setString(1, faq.getQuestion());
            preparedStatement.setString(2, faq.getAnswer());
            preparedStatement.setInt(3, faq.getId());

            return preparedStatement.executeUpdate(); 

        } catch (SQLException | ParserConfigurationException | SAXException | IOException | NullPointerException e) {
            FuntionHelper.printSQLException(FaqHelper.class.getName(), (SQLException) e);
            Log.logMessage(FaqHelper.class.getName(), e);
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
                FuntionHelper.printSQLException(FaqHelper.class.getName(), (SQLException) e);
                Log.logMessage(FaqHelper.class.getName(), e);
            }
        }
        return 0;
    }

}
