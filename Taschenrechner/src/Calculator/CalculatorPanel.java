package Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CalculatorPanel extends JPanel {
	
	public CalculatorPanel() {
		setLayout(new BorderLayout());
		
		result = 0;
		lastCommand = "=";
		start = true;
		
		display = new JButton("0");
		display.setEnabled(false);
		add(display, BorderLayout.NORTH);
		
		ActionListener insert = new InsertAction(this);
		ActionListener command = new CommandAction(this);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 5));
		
		addButton("7", insert);
		addButton("8", insert);
		addButton("9", insert);
		addButton("CE", command);
		addButton("/", command);
		
		addButton("4", insert);
		addButton("5", insert);
		addButton("6", insert);
		addButton("+", command);		
		addButton("-", command);
				
		
		addButton("1", insert);
		addButton("2", insert);
		addButton("3", insert);
		addButton("*", command);
		addButton("%", command);
		
		addButton("0", insert);
		addButton(".", insert);			
		addButton("\u221A", command);		
		addButton("x\u00B2", command);	
		addButton("Pi", insert);
		
		addButton("!", command);
		addButton("",null);
		addButton("",null);
		addButton("",null);
		addButton("=", command);
		
		add(panel, BorderLayout.CENTER);
	}
	
	private void addButton(String label, ActionListener listener) {
		JButton button = new JButton(label);
		button.addActionListener(listener);
		panel.add(button);
	}
	
	protected JButton display;
	private JPanel panel;
	protected double result;
	protected String lastCommand;
	protected boolean start;
}
