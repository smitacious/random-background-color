/************************************************************************************************************************
* <SNUnit6Ch15.java>
* <Norris Smith >
* <11/29/15>
* <SNUnit7Ch15 is designed to show a dialog box with a randomly chosen color from a predetermined list, this color will
*  be used to fill the background color of a JFrame window. At the point the window with the chosen background color
*  will prompt the user to enter their name, the color of the text is also predetermined which depends on the randomly
*  chosen color for the JFrame window. Once the user enter's their information in the text box and presses "Enter" the
*  next screen output mimics the randomly and predetermined colors and thanks for user for playing by their information
*  entered>
************************************************************************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class SNUnit7Ch17 extends JFrame // loads the standard functions of windows
{

	static Color labelColor;
    static JFrame theJframe = new JFrame("Color Changing Frame");
    static JLabel prompt= new JLabel("Enter your name :");
    final static JTextField namebox = new JTextField(20);

	public static int randNum() // Randomly picks a number
	{
		Random randNum = new Random();
     	int rNum = randNum.nextInt(5);  // randomly assigned rNum a number
 	 	return rNum;  // returns value of rNum
 	} // ends randNum

	private static void showMessage()
    {
		JFrame frame = new JFrame("Message"); // lets the window know the title will be "Message"
 		int i=randNum(); // sets randNum to i
 		String color;  // declares color as a string

 		switch(i) // sorts through numbers to apporpiate number is selected
 		{
			case 1:theJframe.getContentPane().setBackground(Color.YELLOW); // sets background color to Yellow
 				prompt.setForeground(Color.BLACK); //sets text color to black
 				labelColor = Color.BLACK; // sets final text color
 				color="YELLOW"; //sets string color to YELLOW
 				break;
 			case 2:theJframe.getContentPane().setBackground(Color.GREEN); // sets background color to Green
 				prompt.setForeground(Color.BLUE); // sets text color to blue
 				labelColor = Color.BLUE; // sets final text color
 				color="GREEN"; // sets string color to GREEN
 				break;
 			case 3:theJframe.getContentPane().setBackground(Color.RED); // sets background color to Red
 				prompt.setForeground(Color.WHITE); //sets text color to white
 				labelColor = Color.WHITE; // sets final text color
 				color="RED"; // sets string color to RED
 				break;
 			case 4:theJframe.getContentPane().setBackground(Color.BLUE); // sets background color to Blue
 				prompt.setForeground(Color.WHITE); // sets text color to white
 				labelColor = Color.WHITE; // sets final text color
 				color="BLUE"; // sets string color to BLUE
 				break;
 			case 5:theJframe.getContentPane().setBackground(Color.WHITE); // sets background color to white
 				prompt.setForeground(Color.BLACK); // sets text color to black
 				labelColor = Color.BLACK; // sets final text color
 				color="WHITE"; // sets string color to WHITE
 				break;
			default:theJframe.getContentPane().setBackground(Color.WHITE); // sets background color to white
				prompt.setForeground(Color.BLACK); // sets text color to black
     			color="WHITE"; // sets string color to WHITE
				break;
 		} // ends switch function

 		JOptionPane.showMessageDialog(frame, "The Following window color will be randomly chosen from\n" +  // text to be output to opening message box
 				"Red, White, Yellow, Green, Blue\n\n" + 		// second line of text in the message
		 		"Your Color will be: " + color);				// thrid line of text in the message
		theJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // function to ensure the program is closed when desired
 		theJframe.add(prompt); // adds the text of prompt
 		theJframe.add(namebox); // adds the box for user to enter their name
 		theJframe.getContentPane().setLayout(new FlowLayout()); // adds the components to the upper right corner
 		theJframe.setBounds(0,0,550,250); // sets the size of the window
 		theJframe.setVisible(true); // sets the window to visible
 		namebox.addActionListener(new SNUnit7Ch17().new Listener()); // adds a Listener
	} // ends showMessage

	private class Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
	 	{
		 	String finName = namebox.getText(); // sets the text of namebox to the string finName
		 	theJframe.remove(prompt); // removes text of prompt
			theJframe.remove(namebox); // removes the text box
		 	final JLabel finalout = new JLabel("Thanks for playing " + finName); // creates the final output text
		 	finalout.setForeground(labelColor); // calls the final color of the text
 		 	theJframe.add(finalout); // adds the final output line on the screen
		 	theJframe.validate(); // validates the final screen to ensure everything is ok
		 	theJframe.repaint(); // refreshes the screen
		 } // ends actionPerformed
	} // ends Listener

	public static void main(String[] args)
	{
		showMessage(); // calls showMessage()
 	} // ends maindf
} //endsSNUnit7Ch17
