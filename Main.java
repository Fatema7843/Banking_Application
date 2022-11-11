import java.util.Scanner;

public class Main {
		public static void main(String[] args)
		{
			Scanner KB = new Scanner(System.in);
			Bank dbbl = new Bank();
			System.out.println("                                                           **NILKHETIAN BANK**                       ");
			System.out.println("                                                           Welcome To Our Bank                  ");
			System.out.println();
			System.out.println();
	        System.out.print("How Many Customer You Want to Input : ");
	        int n = KB.nextInt();
	        for (int i = 0; i < n; i++)
	        {
	        	//System.out.println();
	        	System.out.println();
	        	System.out.print("Enter Account No: ");
	            int accno = KB.nextInt();
	            System.out.print("Enter Account holder's Name: ");
	            KB.nextLine();
	            String name = KB.nextLine();
	            //System.out.println();
	            System.out.print("Enter Balance: ");
	            double balance = KB.nextDouble();
	            System.out.println();
	            System.out.println("Select an option for account type:");
	            
	            System.out.println("             1.Saving");
	            System.out.println("             2.Current");
	            System.out.println();
	            System.out.print("Your choice is: ");
	            int type = KB.nextInt();
	            System.out.println();
	            System.out.println("......Thank You......");
	            String accType = "";
	            if(type == 1)
	            {
	            	accType = "Saving";
	            }
	            else
	            {
	            	accType = "Current";
	            }
	            Account acc = new Account(accno,name,balance,accType,0);
	            dbbl.addAccount(acc);
	        }
	        int ch;
	        do 
	        {
	        	 System.out.println();
	        	 //System.out.println("Here This Is The Main Menu");
	        	 System.out.println();
	            System.out.println("________[Main Menu]________");
	            System.out.println();
	            System.out.println("         1. Display All");
	            System.out.println("         2. Search By Account");
	            System.out.println("         3. Deposit");
	            System.out.println("         4. Withdrawal");
	            System.out.println("         5. Transfer");
	            System.out.println("         6. Change savings interest rate");
	            System.out.println("         7. Add interest ");
	            System.out.println("         8. Show all transaction ");
	            System.out.println("         9. Exit");
	            System.out.println();
	            System.out.print("Please Enter Your Choice : "); 
	            ch = KB.nextInt();
	                switch (ch)
	                {
	                    case 1:
	                    	System.out.println();
	                        dbbl.showAllAccount();
	                        break;

	                    case 2:
	                    	System.out.println();
	                        System.out.print("Enter Account No You Want to Search : ");
	                        int acn = KB.nextInt();
	                        Account acc1 = dbbl.searchByNumber(acn);
	                        if(acc1 == null)
	                        {
	                        	System.out.println();
	                        	System.out.println("Not found!!!!!");
	                        }
	                        else
	                        {
	                        	System.out.println();
	                        	acc1.showDetails();
	                        }
	                        break;

	                    case 3:
	                    	System.out.println();
	                        System.out.print("Enter Account No : ");
	                        int acn1 = KB.nextInt();
	                        Account acc2 = dbbl.searchByNumber(acn1);
	                        if(acc2 != null)
	                        {
	                        	//System.out.println();
	                        	System.out.print("Enter amount for Deposit: ");
	                        	double amount1 = KB.nextDouble();
	                        	acc2.deposite(amount1,false);
	                        }
	                        else
	                        {
	                        	System.out.println();
	                        	System.out.println("Not found!!!!!");
	                        }
	                        break;

	                    case 4:
	                    	System.out.println();
	                    	System.out.print("Enter Account No : ");
	                        int acn2 = KB.nextInt();
	                        Account acc3 = dbbl.searchByNumber(acn2);
	                        if(acc3 != null)
	                        {
	                        	//System.out.println();
	                        	System.out.print("Enter amount for Withdraw: ");
	                        	double amount1 = KB.nextDouble();
	                        	acc3.withdraw(amount1,false);
	                        	
	                        }
	                        else
	                        {
	                        	System.out.println();
	                        	System.out.println("Not found!!!!!");
	                        }
	                        break;

	                    case 5:
	                    	System.out.println();
	                    	System.out.print("Enter Account No From: ");
	                        int from = KB.nextInt();
	                        Account accFrom = dbbl.searchByNumber(from);
	                        
	                        System.out.print("Enter Account No To: ");
	                        int to = KB.nextInt();
	                        Account accTo = dbbl.searchByNumber(to);
	                        if(accFrom == null || accTo == null)
	                        {
	                        	System.out.println();
	                        	System.out.println("One of the account is not found!!!!!");
	                        }
	                        else
	                        {
	                        	System.out.println();
	                        	System.out.print("Enter amount : ");
	                        	double amount = KB.nextDouble();
	                        	dbbl.Transfer(accFrom, accTo, amount);
	                        }
	                        break;
	                    case 6:
	                    	System.out.println();
	                    	System.out.print("Enter Account No : ");
	                        int acn3 = KB.nextInt();
	                        Account acc4 = dbbl.searchByNumber(acn3);
	                        if(acc4 != null)
	                        {
	                        	//System.out.println();
	                        	if(acc4.getAccountType().equals("Current"))
	                        	{
	                        		//System.out.println();
	                            	System.out.println("Interest is applicable for Saving account not for the Current Account");
	                            }
	                            else
	                            {
	                            	//System.out.println();
	                            	System.out.print("Enter Interest in Percentage % : ");
	                            	double interest = KB.nextDouble();
	                            	acc4.setInterestRate(interest);
	                            	System.out.println("Interest rate is updated...");
	                            }
	                        	
	                        }
	                        else
	                        {
	                        	System.out.println();
	                        	System.out.println("Not found!!!!!");
	                        }
	                        
	                        break;
	                    case 7:
	                    	System.out.println();
	                    	System.out.print("Enter Account No : ");
	                        int acn4 = KB.nextInt();
	                        Account acc5 = dbbl.searchByNumber(acn4);
	                        if(acc5 != null)
	                        {
	                        	acc5.addInterest();
	                        }
	                        else
	                        {
	                        	System.out.println();
	                        	System.out.println("Not found!!!!!");
	                        }
	                        
	                        break;
	                    case 8:
	                    	System.out.println();
	                    	System.out.print("Enter Account No : ");
	                        int acn6 = KB.nextInt();
	                        Account acc6 = dbbl.searchByNumber(acn6);
	                        if(acc6 != null)
	                        {
	                        	 System.out.println();
	                        	acc6.showAllTranscation();
	                        }
	                        else
	                        {
	                        	System.out.println();
	                        	System.out.println("Not found!!!!!");
	                        }
	                        
	                    	break;
	                    case 9:
	                    	 System.out.println();
	                    	 System.out.println("_____Good Bye_____");
	                    	 break;
	                    default:
	                 	   System.out.println();
                    	  System.out.println("Try again");
                       System.out.println("Please choose the Menu's option....  ");
                      
	                }
	                
	            }
	        
	            while (ch != 9);
	       System.out.println(".......Thank you..ALLAH HAFEZ......"); 
		}
		
		
	}


