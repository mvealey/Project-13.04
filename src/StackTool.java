import javax.swing.JFrame;


public class StackTool {

	public static void main(String[] args) {
		JFrame stackFrame = new JFrame("Stack Tool");
		stackFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		StackToolPanel stackPanel = new StackToolPanel();
		stackFrame.getContentPane().add(stackPanel);

		stackFrame.pack();
		stackFrame.setVisible(true);
		
	}
		
}
