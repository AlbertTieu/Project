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
* Version: 2025-05-26
*/
package theProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Purpose: The reponsibility of ButtonListener is ...
 *
 * ButtonListener is-a ...
 * ButtonListener is ...
 */
public class ButtonListener implements ActionListener
{
	Calculator calculator;
	CalculatorGUIGun gunGUI;
	JTextField headshotField;
	JTextField hitField;
	JTextField reloadField;
	JButton button;
	
	public ButtonListener(Calculator theCalculator, CalculatorGUIGun theGUI, JButton theButton,
			JTextField theHeadshotField, JTextField theHitField, JTextField theReloadField)
	{
		calculator = theCalculator;
		gunGUI = theGUI;
		button = theButton;
		headshotField = theHeadshotField;
		hitField = theHitField;
		reloadField = theReloadField;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(calculator.getGun().equals(new Gun()))
		{
			JOptionPane.showMessageDialog(gunGUI, "Please select a gun.");
		}
		else
		{
		try
		{
			calculator.setHeadshotChance(Integer.valueOf(headshotField.getText()));
			calculator.setHitChance(Integer.valueOf(hitField.getText()));
			calculator.setReloadAt(Integer.valueOf(reloadField.getText()));
			
			JOptionPane.showMessageDialog(gunGUI, "simulated DPS: " + calculator.shootTacticalUntilClear(calculator.getGun(), calculator.getReloadAt()));
			gunGUI.update();
		}
		catch(NumberFormatException numberError)
		{
			JOptionPane.showMessageDialog(gunGUI, "One of the scenario fields has an invalid input.");
		}
//		catch (Exception error)
//		{
//			System.out.println("Something bad has happened");
//		}
		finally
		{
			
		}
		}
		
	}
}
