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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * Purpose: The reponsibility of ImportExportListener is ...
 *
 * ImportExportListener is-a ...
 * ImportExportListener is ...
 */
public class ImportExportListener implements ActionListener
{
	
	private ImportExportGUI importExport;
	private CalculatorGUIGun calculatorGUI;
	private Calculator calculator;
	
	public ImportExportListener(ImportExportGUI theGUI, CalculatorGUIGun theCalcGUI, Calculator theCalc)
	{
		importExport = theGUI;
		calculatorGUI = theCalcGUI;
		calculator = theCalc;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Export"))
		{
			PrintWriter write = null;
			try
			{
				File theFile = new File(importExport.getGunName() + ".txt");
				
				if (theFile.createNewFile())
				{
					write = new PrintWriter(theFile);
					write.print(importExport.getGunData());
					JOptionPane.showMessageDialog(importExport, "created file: " + importExport.getGunName() + ".txt");
					calculatorGUI.update();
					importExport.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(importExport, importExport.getGunName() + " already exists");
				}
			}
//			catch (NullPointerException nulled)
//			{
//				JOptionPane.showMessageDialog(importExport, "one of the fields is blank");
//
//			}
			catch (IOException uhoh)
			{
				System.out.println("something went wrong");
			}
			finally
			{
				write.close();
			}
		}
		else
		{
			Scanner read = null;
			try
			{
				File theFile = new File(importExport.getFileName() + ".txt");
				
				System.out.println(importExport.getFileName() + ".txt");
				
				
				read = new Scanner(theFile);
				read.useDelimiter(",");
				
				System.out.print(read.next());
				
				Gun gun = new MagazineLoadedGun(read.next(), 
												Integer.getInteger(read.next()), 
												Integer.getInteger(read.next()), 
												Integer.getInteger(read.next()),
												Double.valueOf(read.next()), 
												Double.valueOf(read.next()), 
												Integer.getInteger(read.next()),
												Double.valueOf(read.next()), 
												Double.valueOf(read.next()));
				
				calculator.addGun(gun.getName(), gun);

				Object[] toConvert = calculator.getGunTable().keySet().toArray();
				calculatorGUI.setGunsList(new String[toConvert.length]);
				int index = 0;
				for(Object convertee : toConvert)
				{
					calculatorGUI.getGunsList()[index] = String.valueOf(convertee);
					index++;
				}
				
				DefaultComboBoxModel<String> gunsListModel = new DefaultComboBoxModel<String>(calculatorGUI.getGunsList());
				calculatorGUI.getComboBox().setModel(gunsListModel);
				
				JOptionPane.showMessageDialog(importExport, "success!");
				importExport.dispose();
			}
//			catch (NullPointerException nulled)
//			{
//				JOptionPane.showMessageDialog(importExport, "one of the fields is blank");
//
//			}
			catch (IOException uhoh)
			{
				System.out.println("something went wrong with files");
			}
			finally
			{
				if(read == null) {
					
				}else {
					read.close();
				}
				
			}
		}
	}
	
	
	
}
