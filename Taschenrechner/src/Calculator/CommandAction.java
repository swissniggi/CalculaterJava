package Calculator;
import java.awt.event.*;

class CommandAction implements ActionListener {
	
	CommandAction(CalculatorPanel calculatorPanel) {
		panel = calculatorPanel;
	}
	
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if (command.contentEquals("x\u00B2")) {
			double x = Double.parseDouble(panel.display.getText());
			panel.display.setText("" + Math.round(x*x));
		} else if (command.contentEquals("\u221A")) {
			double x = Double.parseDouble(panel.display.getText());
			panel.display.setText("" + Math.sqrt(x));
		} else if (command.contentEquals("CE")) {
			panel.lastCommand = "=";
			panel.result = 0;
			panel.display.setText("");
			panel.start = true;
		} else if (panel.start) {
			if (command.contentEquals("-")) {
				panel.display.setText(command);
				panel.start = false;
			}  else {
				panel.lastCommand = command;
			}
		} else {
			calculate(Double.parseDouble(panel.display.getText()));
			panel.lastCommand = command;
			panel.start = true;
		}
	}
	
	public void calculate(double x) {
		if (panel.lastCommand.contentEquals("+")) panel.result += x;
		else if (panel.lastCommand.contentEquals("-")) panel.result -= x;
		else if (panel.lastCommand.contentEquals("*")) panel.result *= x;
		else if (panel.lastCommand.contentEquals("/")) panel.result /= x;
		else if (panel.lastCommand.contentEquals("=")) panel.result = x;
		else if (panel.lastCommand.contentEquals("%")) panel.result = panel.result % x;
		panel.display.setText("" + panel.result);
	}
	
	private CalculatorPanel panel;
}
