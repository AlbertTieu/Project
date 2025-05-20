/**
* Lead Author(s):
* @author albert; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-05-14
*/
package theProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Purpose: The reponsibility of CalculatorGUIGun is to provide a Graphical User Interface for the Calculator, specifically for Gun calculations 
 *
 * CalculatorGUIGun is ...
 */
public class CalculatorGUIGun extends JFrame implements ActionListener
{
	
	private Calculator calculator;
	
	private String[] gunsList = {
			"None",
			"M4A1",
			"Winchester 1873"
	};
	

	
	public CalculatorGUIGun()
	{
		calculator = new Calculator();
		
		JComboBox<String> gunsComboBox;
		JLabel gunSelectLabel = new JLabel("Select Gun");
		gunsComboBox = new JComboBox<String>(gunsList);
		JLabel selectedGunLabel = new JLabel(gunsList[0] + " selected");
		
		this.setLayout(new BorderLayout());
		
		// GUN PANEL \\
		
		JPanel gunSelectPanel = new JPanel();
		gunSelectPanel.setLayout(new FlowLayout());
		gunSelectPanel.add(gunSelectLabel);
		gunSelectPanel.add(gunsComboBox);
		gunSelectPanel.add(selectedGunLabel);
		
		this.add(gunSelectPanel, BorderLayout.NORTH);
		
		// SCENARIO PANEL \\
		JTextArea gunInfoArea = new JTextArea(calculator.getGun().toString());
		gunInfoArea.setEditable(false);
		
		JPanel scenarioPanel = new JPanel();
		scenarioPanel.setLayout(new GridLayout(3,2));
		
		JLabel headshotLabel = new JLabel("Headshot Chance (%)");
		JTextField headshotChance = new JTextField();
		
		JLabel accuracyLabel = new JLabel("Hit Chance (%)");
		JTextField hitChance = new JTextField();
		
		JLabel reloadLabel = new JLabel("Reload at (rounds in magazine)");
		JTextField reloadAt = new JTextField();
		
		scenarioPanel.add(gunInfoArea);
		scenarioPanel.add(headshotLabel);
		scenarioPanel.add(headshotChance);
		scenarioPanel.add(accuracyLabel);
		scenarioPanel.add(hitChance);
		scenarioPanel.add(reloadLabel);
		scenarioPanel.add(reloadAt);
		
		this.add(scenarioPanel, BorderLayout.CENTER);
		
		// CALCULATE PANEL \\
		JPanel caclulatePanel = new JPanel();
		caclulatePanel.setLayout(new FlowLayout());
		JButton calculateButton = new JButton("Calculate DPS");
		caclulatePanel.add(calculateButton);
		
		this.add(caclulatePanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// how the program will terminate itself
		pack();												// set a size for the GUI that will display all its elements
		setVisible(true);									// shows the GUI
	}
	
	public void update()
	{
		
	}
	
	public static void main(String[] args)
	{
		CalculatorGUIGun main = new CalculatorGUIGun();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		update();
	}
}
