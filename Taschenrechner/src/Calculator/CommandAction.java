package Calculator;
import java.awt.event.*;

class CommandAction implements ActionListener {
	
	CommandAction(CalculatorPanel calculatorPanel) {
		panel = calculatorPanel;
	}
	
	@Override
	// führt die gewünschte Aktion aus
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		// Quadrat-Funktion
		if (command.contentEquals("x\u00B2")) {
			double x = Double.parseDouble(panel.display.getText());
			panel.display.setText("" + x*x);
			
		// Wurzel-Funktion
		} else if (command.contentEquals("\u221A")) {
			double x = Double.parseDouble(panel.display.getText());
			panel.display.setText("" + Math.sqrt(x));
			
		// Display resetten
		} else if (command.contentEquals("CE")) {
			panel.lastCommand = "=";
			panel.result = 0;
			panel.display.setText("");
			panel.start = true;
			
		// Fakultät-Funktion
		} else if (command.contentEquals("!")) {
			double x = Double.parseDouble(panel.display.getText());
			panel.display.setText("" + calculateFaculty(x));
			
		// 1/x-Funktion
		} else if (command.contentEquals("1/x")) {
			double x = Double.parseDouble(panel.display.getText());
			panel.display.setText("" + 1/x);
			
		// Negative Zahl oder Operation mit zwei Zahlen
		} else if (panel.start) {
			if (command.contentEquals("\u2212")) {
				panel.display.setText("-");
				panel.start = false;
			}  else {
				panel.lastCommand = command;
			}
			
		// ausrechnen
		} else {
			calculate(Double.parseDouble(panel.display.getText()));
			panel.lastCommand = command;
			panel.start = true;
		}
	}
	
	// führt Operation mit zwei Zahlen aus
	public void calculate(double x) {
		if (panel.lastCommand.contentEquals("+")) panel.result += x;
		else if (panel.lastCommand.contentEquals("\u2212")) panel.result -= x;
		else if (panel.lastCommand.contentEquals("\u00D7")) panel.result *= x;
		else if (panel.lastCommand.contentEquals("\u00F7")) panel.result /= x;
		else if (panel.lastCommand.contentEquals("=")) panel.result = x;
		else if (panel.lastCommand.contentEquals("%")) panel.result = panel.result % x;
		panel.display.setText("" + panel.result);
	}
	
	// berechnet die Fakultät einer Zahl
	public double calculateFaculty(double x) {
		double faculty = 1;
		for (int i = 2; i <= x; i++) {
			faculty *= i;
		}
		
		return faculty;
	}
	
	private CalculatorPanel panel;
}
