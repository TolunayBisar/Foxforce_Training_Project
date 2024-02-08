package com.foxforce.study.basefunctions;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author : ahamu
 * @created : 2023-10-20,7:41 p.m.
 * @Email : alimhamut.job@gmail.com
 **/
public class VerifySQLScript {
    FunctionLibrary functionLibrary = new FunctionLibrary();

    //product, customer, category
    //get product info in Database
//    public Boolean getProductInfo(Connection connection, String productName) {
//        functionLibrary.sleep(10);
//        boolean isProductExist = false;
//        Statement statement = null;
//        ResultSet resultset = null;
//        CachedRowSet cachedRowSet = null;
//        try {
//            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            statement = connection.createStatement();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        String sqlScriptForProduct = String.format("select product_id,name,price from cc_CubeCart_inventory where name='%s'", productName);
//        try {
//            resultset = statement.executeQuery(sqlScriptForProduct);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        if (resultset == null) {
//            System.out.println("No Records found");
////            return isProductExist;
//        } else {
//            try {
//                cachedRowSet.populate(resultset);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            int rowCount = 0;
//            while (true) {
//                try {
//                    if (!cachedRowSet.next()) {
//                        break;
//                    }
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//                try {
//                    int product_id = cachedRowSet.getInt("product_id");
//                    String name = cachedRowSet.getString("name");
//                    double price = cachedRowSet.getDouble("price");
//                    System.out.println(String.format("product_id=%d name=%s price=%.2f", product_id, name, price));
//                    rowCount = cachedRowSet.getRow();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                if (rowCount >= 1) {
//                    isProductExist = true;
//                }
//            }
//        }
//        return isProductExist;
//    }
    public Boolean getProductInfo(Connection connection, String productName) {
        functionLibrary.sleep(5);
        boolean isProductExist = false;
        int maxAttempts = 3;
// Maximum number of reconnection attempts
        long delayMillis = 1000;
// 1 second (adjust as needed)
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            Statement statement = null;
            ResultSet resultset = null;
            try {
                statement = connection.createStatement();
                String sqlScriptForProduct = String.format("SELECT product_id, name, price FROM mycubecartdb.alim_cubecart_inventory WHERE name='%s'", productName);
                resultset = statement.executeQuery(sqlScriptForProduct);
                System.out.println(resultset.first());
                functionLibrary.sleep(5);
                if (resultset.first()) {
                    // Product found
                    isProductExist = true;
                    int product_id = resultset.getInt("product_id");
                    String name = resultset.getString("name");
                    double price = resultset.getDouble("price");
                    System.out.println(String.format("Product found: product_id=%d, name=%s, price=%.2f", product_id, name, price));
                } else {
                    System.out.println("No Records found");
                }
                break;
// Successful query execution, exit the loop
            } catch (SQLException e) {
                if (attempt == maxAttempts) {
// Max attempts reached, rethrow the exception
                    throw new RuntimeException("Maximum retry attempts reached", e);
                }
// Handle the exception
                System.err.println("Error executing query: " + e.getMessage());
// Sleep before retrying to avoid flooding the server
                System.out.println("Retrying in " + delayMillis + " milliseconds...");
                try {
                    Thread.sleep(delayMillis);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            } finally {
                try {
                    if (resultset != null) {
                        resultset.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException ex) {
                    System.err.println("Error closing statement or resultset: " + ex.getMessage());
                }
            }
        }
        return isProductExist;
    }

    public boolean getCustomerInfo(Connection connection, String emailAddress) {
        boolean isCustomerExist = false;
        Statement statement = null;
        ResultSet resultSet = null;
        String sqlScriptForCustomer = String.format("select customer_id,first_name,last_name,email from cc_CubeCart_customer where email='%s'", emailAddress);
        CachedRowSet cachedRowSet = null;
        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlScriptForCustomer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultSet != null) {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            int rowCount = 0;
            while (true) {
                try {
                    if (!cachedRowSet.next()) {
                        break;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    int customerId = cachedRowSet.getInt("customer_id");
                    String firstName = cachedRowSet.getString(2);
                    String lastName = cachedRowSet.getString("last_name");
                    String email = cachedRowSet.getString("email");
                    System.out.println(String.format("Customer ID = %d | First Name = %s | Last Name = %s | Email Address = %s", customerId, firstName, lastName, email));
                    rowCount = cachedRowSet.getRow();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (rowCount > 0) {
                    isCustomerExist = true;
                }
            }
        } else {
            System.out.println("No Records found");
        }
        return isCustomerExist;
    }
}
