package Calculator;
import java.io.FileNotFoundException;

import javax.swing.*;

class CalculatorFrame extends JFrame {
	
	public CalculatorFrame() throws FileNotFoundException {
		setTitle("Taschenrechner");
		CalculatorPanel panel = new CalculatorPanel();
		add(panel);	
		pack();
		setSize(500, 300);
	}
}
