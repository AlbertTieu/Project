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
 * Purpose: The reponsibility of ComboBoxListener is ...
 *
 * ComboBoxListener is-a ...
 * ComboBoxListener is ...
 */
public class ComboBoxListener implements ActionListener
{
	
	Calculator calculator;
	CalculatorGUIGun gunGUI;
	JComboBox<String> combo;

	public ComboBoxListener(Calculator theCalculator, CalculatorGUIGun theGUI, JComboBox<String> theCombo)
	{
		calculator = theCalculator;
		gunGUI = theGUI;
		combo = theCombo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String gunName = String.valueOf(combo.getSelectedItem());
		calculator.setGun(calculator.getGunTable().get(gunName));
		gunGUI.update();
	}
	
}
