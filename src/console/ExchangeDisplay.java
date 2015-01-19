package console;

import model.Money;


public class ExchangeDisplay implements ui.ExchangeDisplay {

    @Override
    public void display(Money money) {
        if (money == null) return;
        System.out.println(money.getAmount() + " " + money.getCurrency());
    }
    
}
