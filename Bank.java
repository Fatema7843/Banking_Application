
import java.util.ArrayList;
 public class Bank 
 {
	private Account[] List;
	 public Bank()
	 {
		 this.List = new Account[0];
	 }
	 public void addAccount(Account account)
	 {
		 int l = this.List.length;
		Account[] tmp = new Account[l + 1];
			tmp[l] = account;
			for(int i=0;i<l;i++)
			{
				tmp[i] = List[i];
			}
			List = tmp;
	 }
	 /*public void removeAccount(Account account)
	    {
		 int l = this.List.length;
		 int f=-1;
		Account[] tmp = new Account[l - 1];
		for(int i=0;i<List.length;i++)
		{
			if(List[i].getAccountNumber() == account.getAccountNumber())
			{
				f=i;
				break;
			}
		}
		for(int i=0;i<f;i++)
		{
			tmp[i] = List[i];
		}
		for(int i=f;i<List.length-1;i++)
		{
			tmp[i] = List[i+1];
		}
		List = tmp;
	 }*/
	public void Transfer(Account sender,Account receiver,double amount)
	{
		if(sender.withdraw(amount,true))
		{
			if(receiver.deposite(amount,true)){
				System.out.println("Transfer successfully done");
				sender.addTransaction(sender, receiver, amount, "Transfer");
				receiver.addTransaction(sender, receiver, amount, "Transfer");
			}
			else
			{
				sender.deposite(amount,true);
				System.out.println("Something went wrong");
			}
		}
		else{
			System.out.println("Something went wrong");
		}
		
		
	}
	public void showAllAccount()
	{
	  for(Account acc : List)
	  {
		  System.out.println("============================================");
		  acc.showDetails();
		  
	  }
	}
	public Account searchByNumber(int number)
	{
		Account account = null;
		for(int i = 0;i<List.length;i++)
		{
			if(List[i].getAccountNumber() == number){
				  account = List[i];
				  break;
			  }
		}
		return account;
	}
}
