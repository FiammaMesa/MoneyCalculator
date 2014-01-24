package moneycalculator.UserInterface;
import moneycalculator.Model.Money;
import MoneyCalculator.UserInterface.CurrencyDialog;
import MoneyCalculator.UserInterface.MoneyDialog;
import moneycalculator.Model.Number;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MoneyDialogPanel extends JPanel implements MoneyDialog{

    private String amount = "0";
    private CurrencyDialog currencyDialog;
    
    public MoneyDialogPanel() throws SQLException{
        super (new FlowLayout (FlowLayout.LEFT));
        this.createComponents();
    }

    @Override
    public Money getMoney() {
        return new Money (Number.parseNumber(amount), currencyDialog.getCurrency());
    }
    
    private void createComponents() throws SQLException {
        this.add(createAmountWidget());
        this.add(createCurrencyDialogPanel());   
    }

    private JTextField createAmountWidget() {
        final JTextField textField = new JTextField (amount, 10);
        textField.addKeyListener (new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                amount = textField.getText();
            }
        });
        return textField;
    }

    private JPanel createCurrencyDialogPanel() throws SQLException {
        CurrencyDialogPanel panel = new CurrencyDialogPanel();
        this.currencyDialog = (CurrencyDialog)panel;
        return panel;
    }   
}
