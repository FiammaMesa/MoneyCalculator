package moneycalculator.Persistence;

import moneycalculator.Model.Number;
import moneycalculator.Model.Currency;
import moneycalculator.Model.ExchangeRate;
import moneycalculator.Model.ExchangeRateSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExchangeRateLoader {

    private static final String URL = "jdbc:oracle:thin:@" + "localhost:1521:orcl";
    private static final String USER = "system";
    private static final String PASSWORD = "orcl";
    private static ExchangeRateLoader instances;

    private ExchangeRateLoader() {
    }

    public static ExchangeRateLoader getInstance() {
        if (instances == null) {
            instances = new ExchangeRateLoader();
        }
        return instances;
    }

    public static void load() throws SQLException {
        ExchangeRateSet rates = ExchangeRateSet.getInstance();
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        java.sql.Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CAMBIO_EUR_A");
        
        while (resultSet.next()) {
            rates.add(new ExchangeRate(new Currency("EUR"), new Currency(resultSet.getString("DIVISA")), Number.parseNumber(resultSet.getString("CAMBIO"))));
            System.out.println(resultSet.getString("CAMBIO"));
        }
        
        connection.close();
    }
}
