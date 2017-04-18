import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Stack;

public class StackToolPanel extends JPanel {

	private JButton pushButton;
	private JButton popButton;
	private JButton peekButton;
	private JButton displayButton;
	
	private JLabel displayLabel;
	
	private JTextField valueInput;
	
	private Stack<Integer> testStack;
	
	public StackToolPanel() {
		//create the stack
		testStack = new Stack<Integer>();
		
		//define the buttons
		pushButton = new JButton("Push");
		pushButton.addActionListener(new PushButtonListener());
		
		popButton = new JButton("Pop");
		popButton.addActionListener(new PopButtonListener());
		
		peekButton = new JButton("Peek");
		peekButton.addActionListener(new PeekButtonListener());
		
		displayButton = new JButton("Display");
		displayButton.addActionListener(new DisplayButtonListener());
		
		valueInput = new JTextField();
				
		displayLabel = new JLabel("empty stack");
		
		//build the panel
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(pushButton);
		add(popButton);
		add(peekButton);
		add(displayButton);
		add(valueInput);
		add(displayLabel);
		
		setPreferredSize (new Dimension(200, 150));
		
		valueInput.requestFocus();

	}
	
	private class PushButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (valueInput.getText().length() == 0) {
				displayLabel.setText("No value to enter");
			} else {
				testStack.push(new Integer(valueInput.getText()));
				displayLabel.setText(valueInput.getText() + " added.");
			}

			valueInput.setText("");
			valueInput.requestFocus();
		}
	}
	
	private class PopButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (testStack.isEmpty()) {
				displayLabel.setText("empty stack");
			} else {
				displayLabel.setText(Integer.toString(testStack.pop()) + " removed");
			}
				
			valueInput.setText("");
			valueInput.requestFocus();
		}
		
	}
	
	private class PeekButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			displayLabel.setText(Integer.toString(testStack.peek()) + " is top");

			valueInput.setText("");
			valueInput.requestFocus();
		}
		
	}
	
	private class DisplayButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			displayLabel.setText("Full stack: " + testStack.toString());

			valueInput.setText("");
			valueInput.requestFocus();
		}
		
	}

}

