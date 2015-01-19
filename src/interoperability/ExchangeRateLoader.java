package interoperability;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import model.Currency;
import model.ExchangeRate;

public class ExchangeRateLoader implements persistence.ExchangeRateLoader{

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            URL url = new URL("http://quote.yahoo.com/d/quotes.csv?f=l1&s=" + from + to + "=X");
            String line = new BufferedReader(new InputStreamReader(url.openStream())).readLine();
            return new ExchangeRate(from, to, Float.parseFloat(line));
        } catch (IOException | NumberFormatException e) {
            System.out.println("No se pudo obtener el valor del cambio de divisa");
            return null;
        }
    }
}
