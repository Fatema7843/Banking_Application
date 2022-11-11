
public class Account {

	private int accountNumber;
	private String accountHolderName;
	private double balance;
	private String accountType;
	private double interestRate;
	private Transaction [] listOfTransaction;
	private int totalNumberOfTransaction;
	
	public int getTotalNumberOfTransaction() 
	{
		return totalNumberOfTransaction;
	}
	public void setTotalNumberOfTransaction(int totalNumberOfTransaction) 
	{
		this.totalNumberOfTransaction = totalNumberOfTransaction;
	}
	public double getInterestRate()
	{
		return interestRate;
	}
	public void setInterestRate(double interestRate)
	{
		this.interestRate = interestRate;
	}
	public String getAccountType()
	{
		return accountType;
	}
	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}
	public int getAccountNumber()
	{
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName()
	{
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName)
	{
		this.accountHolderName = accountHolderName;
	}
	public double getBalance()
	{
		return balance;
	}
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	public Account()
	{
		this.listOfTransaction = new Transaction[0];
	}
	public Account(int accountNumber, String accountHolderName, double balance, String accountType,double interestRate)
	{
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.accountType = accountType;
		this.interestRate = interestRate;
		this.listOfTransaction = new Transaction[0];
	}
	
	public boolean deposite(double amount,boolean isTransfar)
   {
		if(amount<0)
		{
			System.out.println();
			System.out.println("Invalid amount");
			return false;
		}
		System.out.println();
		this.balance+=amount;
		System.out.println("Successfully Deposited");
		if(!isTransfar)
		{
			System.out.println();
			this.addTransaction(this, this, amount, "Deposite");
			//System.out.println();
		}
		return true;
	}
	public boolean withdraw(double amount,boolean isTransfar)
	{
		if(this.balance<amount)
		{
			 System.out.println();
			System.out.println("Invalid amount");
			
			return false;
		}
		double tmp = this.balance-amount;
		if(this.accountType.equals("Saving") && tmp>=100)
		{
			System.out.println();
			this.balance -= amount;
			System.out.println("Successfully Withdrawn");
			if(!isTransfar)
			{
				this.addTransaction(this, this, amount, "Withdraw");
			}
			
		}
		
		else if(this.accountType.equals("Current"))
		{
			 System.out.println();
			this.balance -= amount;
			System.out.println("Successfully Withdrawn");
			if(!isTransfar)
			{
				this.addTransaction(this, this, amount, "Withdraw");
			}
			//System.out.println();
		}
		else
		{
			 System.out.println();
			System.out.println("Insufficient Balance!!!!!");
			//System.out.println();
			return false;
		}
		//System.out.println();
		return true;
	}
	public void addInterest()
	{
		if(this.accountType.equals("Saving"))
		{
			System.out.println();
			this.balance += (this.interestRate/100)*this.balance;
			System.out.println("Interest added successfully");
			//System.out.println();
		}
		else
		{
			System.out.println();
			System.out.println("Invalid operation!!! Interest is applicable only for the Saving account");
			//System.out.println();
		}
		
	}
	public void addTransaction(Account sender, Account receiver, double amount, String info)
	{
		int l = this.listOfTransaction.length;
		Transaction[] tmp = new Transaction[l + 1];
		Transaction tran = new Transaction(sender, receiver, amount, info);
		tmp[l] = tran;
		for(int i=0;i<l;i++)
		{
			tmp[i] = listOfTransaction[i];
		}
		listOfTransaction = tmp;
		this.totalNumberOfTransaction++;
	}
	public void showDetails()
	{
		System.out.println("Account Number: "+this.getAccountNumber());
		System.out.println("Account Holder Name: "+this.getAccountHolderName());
		System.out.println("Balance: "+this.getAccountType());
		System.out.println("Balance: "+this.getBalance());
	}
	public void showAllTranscation() 
	{
		System.out.println("======Transaction History of " +this.accountHolderName+ "======");
		System.out.println("Total number transactions :"+this.totalNumberOfTransaction);
		for(int i=0;i<listOfTransaction.length;i++)
		{
			listOfTransaction[i].showInfo();
			System.out.println("===============================");
		}
	}
}


