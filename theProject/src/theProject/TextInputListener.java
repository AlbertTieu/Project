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

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/**
 * Purpose: The reponsibility of TextInputListener is ...
 *
 * TextInputListener is-a ...
 * TextInputListener is ...
 */
public class TextInputListener implements KeyListener
{
	Calculator calculator;
	CalculatorGUIGun gunGUI;
	JTextField textField;

	public TextInputListener(Calculator theCalculator, CalculatorGUIGun theGUI, JTextField theTextField)
	{
		calculator = theCalculator;
		gunGUI = theGUI;
		textField = theTextField;
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
		calculator.setHitChance(Integer.valueOf(textField.getText()));
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
