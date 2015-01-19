package persistence;

import model.CurrencySet;

import java.sql.SQLException;

public interface CurrencySetLoader {

    public CurrencySet load(String dbName) throws SQLException;

}
