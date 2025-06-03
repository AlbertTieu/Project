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
* Version: 2025-06-02
*/
package theProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Purpose: The reponsibility of ImportExportGUI is ...
 *
 * ImportExportGUI is-a ...
 * ImportExportGUI is ...
 */
public class ImportExportGUI extends JFrame
{
	// fields
	
	private CalculatorGUIGun calculatorGUI;
	
	JLabel nameLabel = new JLabel("Gun Name");
	JTextField nameField = new JTextField();
	
	JLabel damageLabel = new JLabel("Damage");
	JTextField damageField = new JTextField();
	
	JLabel labelRPM = new JLabel("Rounds Per Minute");
	JTextField fieldRPM = new JTextField();
	
	JLabel pierceLabel = new JLabel("Pierce");
	JTextField pierceField = new JTextField();
	
	JLabel headshotLabel = new JLabel("Headshot Multiplier");
	JTextField headshotField = new JTextField();
	
	JLabel reloadLabel = new JLabel("Reload Time");
	JTextField reloadField = new JTextField();
	
	JLabel magazineLabel = new JLabel("Magazine Capacity");
	JTextField magazineField = new JTextField();
	
	JLabel penetrationLabel = new JLabel("Penetration Multiplier");
	JTextField penetrationField = new JTextField();
	
	JLabel tacReloadLabel = new JLabel("Tactical Reload Time");
	JTextField tacReloadField = new JTextField();
	
	JLabel importFileLabel = new JLabel("Name of File to Import");
	JTextField importFileField = new JTextField();
	
	// constructors
	
	public ImportExportGUI(CalculatorGUIGun theCalcGUI)
	{
		calculatorGUI = theCalcGUI;
		
		// STATS PANEL \\
		
		JPanel statsPanel = new JPanel();
		statsPanel.setLayout(new GridLayout(10,2));
		
		//1
		statsPanel.add(nameLabel);
		statsPanel.add(nameField);
		//2
		statsPanel.add(damageLabel);
		statsPanel.add(damageField);
		//3
		statsPanel.add(labelRPM);
		statsPanel.add(fieldRPM);
		//4
		statsPanel.add(pierceLabel);
		statsPanel.add(pierceField);
		//5
		statsPanel.add(headshotLabel);
		statsPanel.add(headshotField);
		//6
		statsPanel.add(reloadLabel);
		statsPanel.add(reloadField);
		//7
		statsPanel.add(magazineLabel);
		statsPanel.add(magazineField);
		//8
		statsPanel.add(penetrationLabel);
		statsPanel.add(penetrationField);
		//9
		statsPanel.add(tacReloadLabel);
		statsPanel.add(tacReloadField);
		//10
		statsPanel.add(importFileLabel);
		statsPanel.add(importFileField);
		
		this.add(statsPanel, BorderLayout.CENTER);
		
		// BUTTONS PANEL \\
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());
		JButton importButton = new JButton("Import");
		importButton.addActionListener(new ImportExportListener(this, calculatorGUI , calculatorGUI.getCalculator()));
		JButton exportButton = new JButton("Export");
		exportButton.addActionListener(new ImportExportListener(this, calculatorGUI , calculatorGUI.getCalculator()));
		
		buttonsPanel.add(importButton);
		buttonsPanel.add(exportButton);
		
		this.add(buttonsPanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// how the program will terminate itself
		pack();												// set a size for the GUI that will display all its elements
		setVisible(true);									// shows the GUI
	}
	
	// methods
	
	public String getGunName()
	{
		return nameField.getText();
	}
	
	public String getGunData()
	{
		String data = nameField.getText() + ',' +
				damageField.getText() + ',' +
				fieldRPM.getText() + ',' +
				pierceField.getText() + ',' +
				headshotField.getText() + ',' +
				reloadField.getText() + ',' +
				magazineField.getText() + ',' +
				penetrationField.getText() + ',' +
				tacReloadField.getText();
		
		System.out.println(data);
		return data;
	}
	
	public String getFileName()
	{
		return importFileField.getText();
	}
	
}
