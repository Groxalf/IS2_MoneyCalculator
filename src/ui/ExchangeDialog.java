package ui;

import model.Exchange;
import model.Money;

public interface ExchangeDialog {

    public Exchange getExchange();

    void setResultText(Money money);
}
