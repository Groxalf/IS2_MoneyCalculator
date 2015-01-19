package control;

import ui.ExchangeDialog;
import ui.ExchangeDisplay;

import java.sql.SQLException;

public class ExchangeOperation {
    
    private final ExchangeDialog exchangeDialog;
    private final ExchangeDisplay exchangeDisplay;

    public ExchangeOperation(ExchangeDialog exchangeDialog, ExchangeDisplay exchangeDisplay) {
        this.exchangeDialog = exchangeDialog;
        this.exchangeDisplay = exchangeDisplay;
    }

    public void execute() throws SQLException {
        exchangeDialog.setResultText(exchangeDialog.getExchange().getMoney());
        exchangeDisplay.display(exchangeDialog.getExchange().getMoney());
    }
}
