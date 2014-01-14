package moneycalculator.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CurrencySetLoader {

    private static final String URL = "jdbc:oracle:thin:@" + "localhost:101:orcl";
    private static final String USER = "system";
    private static final String PASSWORD = "orcl";
    
    public static void load() throws SQLException {
        DriverManager.registerDriver(new OracleDriver()); 
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CAMBIO_EUR_A");
        while (resultSet.next()) {
            System.out.print(resultSet.getString("DIVISA"));
            System.out.println(resultSet.getBigDecimal("CAMBIO"));
        }
        connection.close();
    }
    
    /* private static CurrencySetLoader instances;
    
    public CurrencySetLoader() {
    }
    
    public static CurrencySetLoader getInstance(){
        if (instances == null) instances = new CurrencySetLoader();
        return instances;
    }

    public static void load(){
        CurrencySet set = CurrencySet.getInstance();
        if (set.search()){
            set.add(new Currency("Dolar americano", "USD", "$"));
            set.add(new Currency("Dolar canadiense", "CAD", "$"));
            set.add(new Currency("Euro", "EUR", "€"));
        }*/
    
}