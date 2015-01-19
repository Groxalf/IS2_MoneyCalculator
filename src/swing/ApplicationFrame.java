package swing;

import console.ExchangeDisplay;
import control.ExchangeOperation;
import model.Currency;
import ui.ExchangeDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class ApplicationFrame extends JFrame {

    private final Currency[] currencies;
    private ActionListener actionListener;
    private ExchangeDialog exchangeDialog;


    public ApplicationFrame(Currency[] currencies) throws HeadlessException {
        this.currencies = currencies;
        this.setTitle("Money calculator");
        this.setSize(250, 120);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createWidgets();
        this.setResizable(false);
        this.setVisible(true);
        setActionListener();
    }


    private void createWidgets() {
        this.add(createCalculateButton(), BorderLayout.SOUTH);
        this.add(createExchangeDialogPanel());
    }


    private Component createExchangeDialogPanel() {
        ExchangeDialogPanel panel = new ExchangeDialogPanel(currencies);
        this.exchangeDialog = panel;
        return panel;
    }


    private Component createCalculateButton() {
        JButton button = new JButton("Calculate");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionListener.actionPerformed(e);
            }
        });

        return button;
    }


    private void setActionListener() {
        this.actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ExchangeOperation(exchangeDialog, new ExchangeDisplay()).execute();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        };
    }

}
