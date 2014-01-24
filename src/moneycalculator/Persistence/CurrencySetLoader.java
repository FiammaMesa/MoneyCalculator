package moneycalculator.Persistence;

import moneycalculator.Model.Currency;
import moneycalculator.Model.CurrencySet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CurrencySetLoader {

    private static final String URL = "jdbc:oracle:thin:@" + "localhost:1521:orcl";
    private static final String USER = "system";
    private static final String PASSWORD = "orcl";

    public static void load() throws SQLException {
        CurrencySet set = CurrencySet.getInstance();
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CAMBIO_EUR_A");
        if (set.isEmpty()) {
            while (resultSet.next()) {
                set.add(new Currency(resultSet.getString("DIVISA")));
            }
        }
        set.add(new Currency("EUR"));
        connection.close();
    }
}
