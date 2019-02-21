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
		display.setPreferredSize(new Dimension(500, 40));
		display.setFont(new Font("Arial", Font.PLAIN, 18));		
		display.setEnabled(false);
		add(display, BorderLayout.NORTH);
		
		ActionListener insert = new InsertAction(this);
		ActionListener command = new CommandAction(this);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 5));
		
		addButton("7", insert, "O");
		addButton("8", insert, "O");
		addButton("9", insert, "O");
		addButton("CE", command, "Y");
		addButton("/", command, "P");
		
		addButton("4", insert, "O");
		addButton("5", insert, "O");
		addButton("6", insert, "O");
		addButton("+", command, "P");		
		addButton("\u2212", command, "P");
				
		
		addButton("1", insert, "O");
		addButton("2", insert, "O");
		addButton("3", insert, "O");
		addButton("\u00D7", command, "P");
		addButton("%", command, "P");
		
		addButton(".", insert, "O");
		addButton("0", insert, "O");
		addButton("\u03C0", insert, "O");
		addButton("1/x", command, "P");
		addButton("x\u00B2", command, "P");	
		
				
		addButton("",null,null);
		addButton("",null,null);		
		addButton("=", command, "G");
		addButton("!", command, "P");
		addButton("\u221A", command, "P");		
		
		add(panel, BorderLayout.CENTER);
	}
	
	private void addButton(String label, ActionListener listener, String color) {
		JButton button = new JButton(label);
		button.addActionListener(listener);
		
		if (color == "Y") {
			button.setBackground(Color.yellow);
		} else if (color == "G") {
			button.setBackground(Color.green);
		} else if (color == "O") {
			button.setBackground(Color.orange);
		} else if (color == "P") {
			button.setBackground(Color.pink);
			button.setFont(new Font("SegoeUISymbol", Font.BOLD, 16));
		}
		panel.add(button);
	}
	
	protected JButton display;
	private JPanel panel;
	protected double result;
	protected String lastCommand;
	protected boolean start;
}
