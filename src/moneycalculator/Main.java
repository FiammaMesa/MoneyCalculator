package moneycalculator;

import moneycalculator.Control.CalculateCommand;
import moneycalculator.Control.Command;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moneycalculator.UserInterface.ApplicationFrame;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import moneycalculator.UserInterface.ActionListenerFactory;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException, SQLException {  
        new Main().execute();
    }

    private HashMap<String, Command> commandMap;

    private void execute() throws SQLException {
        createCommands(createApplicationFrame());
    }

    private void createCommands(ApplicationFrame frame) {
        commandMap = new HashMap<>();
        commandMap.put("calculate", new CalculateCommand(
                frame.getMoneyDialog(),
                frame.getCurrencyDialog(),
                frame.getMoneyViewer())
        );
        
        commandMap.put("exit", new Command() {

            @Override
            public void execute() {
                System.exit(0);
            }
        });
    }

    private ApplicationFrame createApplicationFrame() throws SQLException {
        return new ApplicationFrame(new ActionListenerFactory() {

            @Override
            public ActionListener createActionListener(final String action) {
                return new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Command command = commandMap.get(action);
                        if (command == null) {
                            return;
                        }
                        command.execute();
                    }
                };
            }
        });

    }
        
}
