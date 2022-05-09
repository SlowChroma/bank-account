import javax.swing.JOptionPane;
//this class represents a bank account object
public class Account {
	
	private String name;
	private int id;
	private double balance;
	private boolean isFrozen;
	private String creationDate;
	//constructor, creates a new account with the specified name, id, balance, state and creation date.
	public Account(String name, int id, double balance, boolean isFrozen, String creationDate)
	{
		this.name = name;
		this.id = id;
		this.balance = balance;
		this.isFrozen = isFrozen;
		this.creationDate = creationDate;
	}
	//returns the name of the bank account
	public String getName()
	{
		return name;
	}
	//returns the ID of the bank account
	public int getID()
	{
		return id;
	}
	//returns the balance of the bank account
	public double getBalance()
	{
		return balance;
	}
	//returns the status of the bank account
	public boolean getStatus()
	{
		return isFrozen;
	}
	//returns a string to represent the status of the bank account
	public String printStatus()
	{
		if (isFrozen == true)
		{
			return "this account is frozen, please call the bank";
		}
		else
		{
			return "this account is not frozen";
		}
	}
	//returns the creation date
	public String getCreationDate()
	{
		return creationDate;
	}
	//displays the information for the account
	public String displayInfo()
	{
		return "name: " + name +
				"\nID: " + id +
				"\nbalance: $" + balance +
				"\nis it frozen?: " + isFrozen +
				"\ndate of creation: " + creationDate + "\n";
				
	}
	//displays the name and creation date of the account
	public String displayNameAndCreationDate()
	{
		return "name: " + name +
				"\nID: " + id + "\n\n";
	}
	//creates a menu for the account
	public void accountMenu()
	{
		boolean run = true;
		while (run)
		{
			String[] accountMenuOptions = {"deposit", "withdraw", "freeze/unfreeze", "go back"};
			int accountMenuSelection = JOptionPane.showOptionDialog(null, 
					displayInfo() +
					"\nplease choose one of the options below", "Российская Международная Банковская Ассоциация", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, accountMenuOptions, 0);
			if (accountMenuSelection == 0)
			{
				
				if (isFrozen == false)
				{
					double depositAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "How much money do you want to deposit?"));
					balance += depositAmount;	
				}
				else
				{
					JOptionPane.showMessageDialog(null, "this account is frozen, you cannot interact with it");
				}
			}
			else if (accountMenuSelection == 1)
			{
				
				if (isFrozen == false)
				{
					double withdrawAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "How much money do you want to withdraw?"));
					if (withdrawAmount <= balance)
					{
						
						balance -= withdrawAmount;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "you are trying to withdraw more money than you have in your account");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "this account is frozen, you cannot interact with it");
				}
				
			}
			else if (accountMenuSelection == 2)
			{
				if (isFrozen == true)
				{
					isFrozen = false;
				}
				else
				{
					isFrozen = true;
				}
			}
			else
			{
				run = false;
			}
		}
		
	}

}
