package application;

import interoperability.CurrencySetLoader;
import java.sql.SQLException;
import model.CurrencySet;
import swing.ApplicationFrame;

public class Application {

    public static void main(String[] args) throws SQLException {
        String dbName = "currencies.db";
        CurrencySet currencySet = new CurrencySetLoader().load(dbName);
        new ApplicationFrame(currencySet.toArray());
    }
}
