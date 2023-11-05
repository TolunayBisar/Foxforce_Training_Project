package basefunctions;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author : Anar
 * @created : 2023-10-16,23:40
 * @Email : abdanna369@gmail.com
 **/
public class VerifySQLScripts {
    public boolean getProductInfo(Connection connection, String productName) {
        boolean isPorductExist = false;
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSet cachedRowSet = null;
        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sqlScriptForProduct = String.
                format("select product_id,name,price from cc_CubeCart_inventory where name='%s'", productName);
        try {
            resultSet = statement.executeQuery(sqlScriptForProduct);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (resultSet == null) {
                System.out.println("No records found");
            } else {
                try {
                    cachedRowSet.populate(resultSet);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                int rowCount = 0;
                while (cachedRowSet.next()) {

                    try {
                        int product_id = cachedRowSet.getInt("product_id");
                        String name = cachedRowSet.getString("name");
                        double price = cachedRowSet.getDouble("price");
                        System.out.println(String.format("product_id=%d name=%s price=%.2f", product_id, name, price));
                        rowCount = cachedRowSet.getRow();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    if (rowCount >= 1) {
                        isPorductExist = true;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isPorductExist;
    }

    public boolean getCustomerInfo(Connection connection, String email) {
        boolean isCustomerExist = false;
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSet cachedRowSet = null;
        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sqlScriptForProduct = String.
                format("select email,first_name,last_name from cc_CubeCart_customer where email='%s'",
                        email);
        try {
            resultSet = statement.executeQuery(sqlScriptForProduct);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (resultSet == null) {
            System.out.println("No records found");
        } else {
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
                    String customerEmail = cachedRowSet.getString("email");
                    String firstName = cachedRowSet.getString("first_name");
                    String lastName = cachedRowSet.getString("last_name");
                    System.out.println(String.format("email=%s first_name=%s last_name=%s", customerEmail, firstName, lastName));
                    rowCount = cachedRowSet.getRow();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (rowCount >= 1) {
                    isCustomerExist = true;
                }
            }
        }

        return isCustomerExist;
    }
    public boolean getReviewInfo(Connection connection,String productName){
        boolean review = false;

        return review;
    }
}

