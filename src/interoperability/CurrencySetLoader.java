package interoperability;

import model.Currency;
import model.CurrencySet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CurrencySetLoader implements persistence.CurrencySetLoader{


    @Override
    public CurrencySet load(String dbName) throws SQLException {
        try {
            return getCurrencies(createConnection(dbName).createStatement().executeQuery("SELECT * FROM currency_info"));
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar a la base de datos");
            return null;
        }
    }
    
    private static Connection createConnection(String databasePath) throws SQLException {
        DriverManager.registerDriver(new org.sqlite.JDBC());
        return DriverManager.getConnection("jdbc:sqlite:" + databasePath);
    }


    private CurrencySet getCurrencies(ResultSet resultSet) throws SQLException {
        CurrencySet set = new CurrencySet();
        while(resultSet.next())
            set.add(getCurrencyInfo(resultSet));
        return set;
    }


    private Currency getCurrencyInfo(ResultSet resultSet) throws SQLException {
        return new Currency(resultSet.getString("code"), resultSet.getString("name"), resultSet.getString("symbol"));
    }

}
