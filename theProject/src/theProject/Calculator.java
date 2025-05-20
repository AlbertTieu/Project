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
* Version: 2025-03-25
*/
package theProject;

import java.util.LinkedList;
import java.text.DecimalFormat;
import java.util.Hashtable;

/**
 * Purpose: The reponsibility of Calculator is ...
 *
 * Calculator is-a ...
 * Calculator is ...
 */
public class Calculator
{
	// fields
	
	private int totalDamage;
	private double elapsedTime;
	private int headshotChance;
	private int hitChance;
	private int reloadAt;
	
	private Gun gun;
	private LinkedList<Enemy> enemies;
	
	DecimalFormat CALCULATED_FORMAT = new DecimalFormat("#.##");
	
	// constructors

	public Calculator()
	{
		gun = new Gun();
		enemies = new LinkedList<Enemy>();
	}
	
	public Calculator(Gun initGun, LinkedList<Enemy> initEnemies)
	{
		gun = initGun;
		enemies = initEnemies;
	}
	
	// methods

	// getters
	
	public int getDamage()
	{
		return totalDamage;
	}
	
	public double getTime()
	{
		return elapsedTime;
	}
	
	public int getHeadshotChance()
	{
		return headshotChance;
	}
	
	public int getHitChance()
	{
		return hitChance;
	}
	
	public int getReloadAt()
	{
		return reloadAt;
	}

	public Gun getGun()
	{
		return gun;
	}
	
	public LinkedList<Enemy> getEnemies()
	{
		return enemies;
	}
	
	// setters
	
	public void setDamage(int newDamage)
	{
		totalDamage = newDamage;
	}
	
	public void setTime(double newTime)
	{
		elapsedTime = newTime;
	}
	
	public void setHeadshotChance(int newHeadshotChance)
	{
		headshotChance = newHeadshotChance;
	}
	
	public void setHitChance(int newHitChance)
	{
		hitChance = newHitChance;
	}
	
	public void setReloadAt(int newReloadAt)
	{
		reloadAt = newReloadAt;
	}

	public void setGun(Gun newGun)
	{
		gun = newGun;
	}
	
	public void setEnemies(LinkedList<Enemy> newEnemies)
	{
		enemies = newEnemies;
	}
	
	// misc
	
	public void addEnemy(Enemy enemy)
	{
		enemies.add(enemy);
	}
	
	public void shoot(Gun theGun)
	{
		double damageMulti;
		
		// is the shot a hit?
		if( (Math.random() * 100) < hitChance )
		{
			damageMulti = 1.0; //yes, it deals damage
			
			// since it hits, does it headshot?
			if( (Math.random() * 100) < headshotChance )
			{
				System.out.println("Headshot!");
				damageMulti = theGun.getHeadshotMulti(); //yes: the headshot multi is applied
			}
		}
		else 
		{
			System.out.println("Miss!");
			damageMulti = 0; //no: it does not deal damage
		}
		
		int hits = theGun.getHitCount();
		
		for(int i = 0; i < enemies.size(); i++)
		{
			if(hits > 0)
			{
				Enemy theEnemy = enemies.get(i);
				int damage = theEnemy.takeDamage( (int) (theGun.getDamage() * damageMulti) );
				totalDamage += damage;
				
				System.out.println(theEnemy.getName() + " took " + damage + " damage!" + " (" + (theEnemy.getHealth() + damage) + " -> " + theEnemy.getHealth() + ")");
				
				// lose damage per enemy pierced
				damageMulti = theGun.getPenMulti() * damageMulti;
				if(theEnemy.getHealth() == 0)
				{
					System.out.println(theEnemy.getName() + " has died!");
				}
				hits--;
			}
			
		}
		
		for(int i = enemies.size() - 1; i >= 0; i--)
		{
			Enemy theEnemy = enemies.get(i);
			if(theEnemy.getHealth() == 0)
			{
				enemies.remove(i);
			}
		}
		
		elapsedTime +=  (double) (1/ (double) (theGun.getAttackRate()/60));
		
	}
	
	public double shootTacticalUntilClear(Gun theGun, int reloadAt)
	{
		while(enemies.size() > 0)
		{
			if(theGun.getCurrentMagazine() > reloadAt)
			{
				shoot(theGun);
				
				theGun.setCurrentMagazine(theGun.getCurrentMagazine() - 1);
				
				System.out.println("Magazine: (" + theGun.getCurrentMagazine() + '/' + theGun.getMagazineSize() + ')' + '\n');
			}
			else 
			{
				double reloadingTime = theGun.getReloadTime();
				elapsedTime += reloadingTime;
				theGun.reload();
				System.out.println("Reloading!" + '\n' + "Time: " + reloadingTime + '\n');
			}
		}
		
		System.out.println("Damage dealt: " + totalDamage);
		System.out.println("Elapsed time: " + CALCULATED_FORMAT.format(elapsedTime) + 's');
		
		double DPS = totalDamage/elapsedTime;
		return DPS;
	}
	
	/**
	 * 
	 * Purpose: main method, run a test simulation
	 * @param args idk
	 */
	public static void main(String[] args)
	{
		Calculator main = new Calculator();
		
		main.setHitChance(100);
		main.setHeadshotChance(100);
		main.setReloadAt(1);
		
		main.addEnemy(new Enemy("Slasher", 100));
		main.addEnemy(new Enemy("Charger", 70));
		main.addEnemy(new Enemy("Smasher", 1000));
		
		Hashtable<String, Gun> gunTable = new Hashtable<String, Gun>();
		
		gunTable.put("M4A1", new MagazineLoadedGun("M4A1", 25, 800, 2, 1.5, 3.0, 30, 0.5, 2.6));
		gunTable.put("Winchester 1873", new SingleLoadedGun("Winchester 1873", 25, 300, 3, 5.4, 4.4, 8, 1.0, 1, 0.425, 1.0));
		
		main.setGun(gunTable.get("M4A1"));
		
		System.out.println(main.getGun().toString());
		
		main.setTime(0);
		
		LinkedList<Enemy> enemyList = main.getEnemies();
		for(Enemy e : enemyList)
		{
			System.out.println(e.toString());
		}
		
		System.out.println('\n' + "Simulation Start!" + '\n');
		
		System.out.println("DPS: " + main.CALCULATED_FORMAT.format(main.shootTacticalUntilClear(main.getGun(), main.getReloadAt())));
	}
	
}
