import java.util.ArrayList;

import javax.swing.JOptionPane;
//this is the Main class, which holds the main method but nothing else
public class Main {
	//main method, runs the code and holds almost everything for the bank accounts.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean works = false;
		while (!works)
		
			try
			{
				ArrayList<Account> bank = new ArrayList<Account>();
				bank.add (new Account ("RicoTheGreat", 123456, 100.00, false, "11/14/2021"));
				bank.add (new Account ("Arturo", 2, 100.00, false, "11/14/2021"));
				bank.add (new Account ("Rodrigo", 3, 100.00, false, "11/14/2021"));
				bank.add (new Account ("Atlas", 4, 100.00, false, "11/14/2021"));
				bank.add (new Account ("Austin", 5, 100.00, false, "11/14/2021"));
				bank.add (new Account ("Connor", 6, 100.00, false, "11/14/2021"));
				bank.add (new Account ("Evelyn", 7, 100.00, false, "11/14/2021"));
				bank.add (new Account ("Victoria", 8, 100.00, false, "11/14/2021"));
				bank.add (new Account ("GucciGlasses", 9, 100.00, false, "11/14/2021"));
				bank.add (new Account ("Nichole", 10, 100.00, false, "11/14/2021"));
				boolean run = true;
				while (run)
				{
				Double totalBankAmount = 0.0;
				for (int i = 0; i < bank.size(); i++)
				{
					totalBankAmount += bank.get(i).getBalance();
				}
				String[] mainMenuOptions = {"search account", "add an account", "terminate an account", "list of all accounts", "exit"};
				int mainMenuSelection = JOptionPane.showOptionDialog(null, "total amount in bank: $" + totalBankAmount + "\nchoose one of the options below", "Российская Международная Банковская Ассоциация", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, mainMenuOptions, 0);
				if (mainMenuSelection == 0)
				{
					String[] searchMenuOptions = { "search account by name", "search account by ID", "go back"};
					int searchMenuSelection = JOptionPane.showOptionDialog(null, "choose one of the options below", "Российская Международная Банковская Ассоциация", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, searchMenuOptions, 0);
					if (searchMenuSelection == 0)
					{
						String searchName = JOptionPane.showInputDialog(null, "please input your name");
						for (int i = 0; i < bank.size(); i++)
						{
							if (bank.get(i).getName().equals(searchName))
							{
								bank.get(i).accountMenu();
							}
							else
							{
								
							}
						}
					}
					else if (searchMenuSelection == 1)
					{
						int searchID = Integer.parseInt(JOptionPane.showInputDialog(null, "please input the ID"));
						for (int i = 0; i < bank.size(); i++)
						{
							if (bank.get(i).getID() == searchID)
							{
								bank.get(i).accountMenu();
							}
							else
							{
								
							}
						}
					}
					else
					{
						
					}
				}
				else if (mainMenuSelection == 1)
				{
					boolean works1 = false;
					while (!works1)
					{
						try
						{
							String name = JOptionPane.showInputDialog(null, "what is your name?");
							int ID = Integer.parseInt(JOptionPane.showInputDialog(null, "what will be your password?"));
							boolean IDTaken = false;
							for (int i = 0; i < bank.size(); i++)
							{
								
								if (bank.get(i).getID() == ID)
								{
									JOptionPane.showMessageDialog(null, "that ID is already taken");
									IDTaken = true;
								}
								else
								{
									
								}
							}
							if (IDTaken)
							{
								
							}
							else
							{
								double balance = Double.parseDouble(JOptionPane.showInputDialog(null, "how much money are you putting into that account?"));
								String creationDate = JOptionPane.showInputDialog(null, "What is the date today?");
								bank.add(new Account(name, ID, balance, false, creationDate));
							}
							works1 = true;
						}
						catch (Exception e)
						{
							JOptionPane.showMessageDialog(null, "something went wrong");
						}
					}				
				}
				else if (mainMenuSelection == 2)
				{
					boolean terminationConfirmed = false;
					JOptionPane.showMessageDialog(null, "in order to delete an account, you will have to provide both the name and correct ID");
									
					String terminationName = JOptionPane.showInputDialog(null, "What is the name associated with the account you are terminating?");
					int terminationID = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the ID associated with the account you are terminating?"));
					for (int i = 0; i < bank.size(); i++)
					{
						if (terminationName.equals(bank.get(i).getName()) && terminationID == bank.get(i).getID())
						{
							bank.remove(i);
						}
						else
						{
							
						}
					}	
				}
				else if (mainMenuSelection == 3)
				{
					String displayedInfo = "";
					for (int i = 0; i < bank.size(); i++)
					{
						displayedInfo += bank.get(i).displayNameAndCreationDate();
					}
					JOptionPane.showMessageDialog(null, displayedInfo);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "closing application");
					run = false;
				}
			}
			
			works = true;
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			JOptionPane.showMessageDialog(null, "reebooting program");
		}
	}
}
