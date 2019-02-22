package Calculator;
import java.io.FileNotFoundException;

import javax.swing.*;

public class Calculator {

	public static void main(String[] args) throws FileNotFoundException {
		CalculatorFrame frame = new CalculatorFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
