package swing;

import model.Currency;
import model.Exchange;
import model.Money;
import ui.ExchangeDialog;

import javax.swing.*;
import java.awt.*;


public class ExchangeDialogPanel extends JPanel implements ExchangeDialog {

    private JTextField amount;
    private JComboBox<Currency> fromCurrency;
    private JComboBox<Currency> toCurrency;
    private Currency[] currencies;
    private JTextArea result;


    public ExchangeDialogPanel(Currency[] currencies) {
        this.currencies = currencies;
        this.setLayout(new FlowLayout());
        this.createWidgets();
    }


    private void createWidgets() {
        this.add(createAmountWidget(), BorderLayout.CENTER);
        this.add(createFromCurrencyWidget(), BorderLayout.CENTER);
        this.add(createToCurrencyWidget(), BorderLayout.CENTER);
        this.add(createResultWidget(), BorderLayout.CENTER);
    }

    private Component createResultWidget() {
        JTextArea resultText = new JTextArea();
        resultText.setText("Introduce una cantidad");
        result = resultText;
        return  resultText;
    }


    private JComponent createAmountWidget() {
        JTextField input = new JTextField(10);
        this.amount = input;
        return input;
    }

    private Component createFromCurrencyWidget() {
        JComboBox<Currency> input = new JComboBox<Currency>(currencies);
        this.fromCurrency = input;
        return input;
    }


    private Component createToCurrencyWidget() {
        JComboBox<Currency> input = new JComboBox<Currency>(currencies);
        this.toCurrency = input;
        return input;
    }


    @Override
    public Exchange getExchange() {
        return new Exchange(getMoney(), getCurrency(toCurrency));
    }


    @Override
    public void setResultText(Money money) {
        if (money == null)
            money = getMoney();
        result.setText((float)money.getAmount() + "   " + money.getCurrency());
    }


    private Money getMoney() {
        return new Money(getAmount(), getCurrency(fromCurrency));
    }


    private double getAmount() {
        try {
            return Double.parseDouble(amount.getText());
        } catch (Exception e) {
            return 0.0;
        }
    }


    private Currency getCurrency(JComboBox<Currency> comboBox) {
        return comboBox.getItemAt(comboBox.getSelectedIndex());
    }


}
