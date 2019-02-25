package Calculator;

import javax.swing.*;

class CalculatorFrame extends JFrame {
	
	public CalculatorFrame() {
		setTitle("Taschenrechner");
		CalculatorPanel panel = new CalculatorPanel();
		add(panel);	
		pack();
		setSize(500, 300);
	}
}
