
public class Transaction {
	
		private Account sender ;
		private Account receiver;
		private double amount;
		private String additionalInfo;
		public Account getSender() 
		{
			return sender;
		}
		public void setSender(Account sender)
		{
			this.sender = sender;
		}
		public Account getReceiver() 
		{
			return receiver;
		}
		public void setReceiver(Account receiver)
		{
			this.receiver = receiver;
		}
		public double getAmount()
		{
			return amount;
		}
		public void setAmount(double amount)
		{
			this.amount = amount;
		}
		public String getAdditionalInfo() 
		{
			return additionalInfo;
		}
		public void setAdditionalInfo(String additionalInfo)
		{
			this.additionalInfo = additionalInfo;
		}
		public Transaction(Account sender, Account receiver, double amount, String additionalInfo)
		{
			this.sender = sender;
			this.receiver = receiver;
			this.amount = amount;
			this.additionalInfo = additionalInfo;
		}
		public Transaction()
		{
			System.out.println();
			System.out.println("Empty Constructor!!!!!");
		}
		public void showInfo() 
		{
			System.out.println();
			System.out.println("Sender id: " + sender.getAccountNumber() + " ;  Sender Name: "  + sender.getAccountHolderName());
			//System.out.println();
			System.out.println("Receiver id: " + receiver.getAccountNumber() + " ;  Receiver Name: "  + receiver.getAccountHolderName());
			//System.out.println();
			System.out.println("Amount: " + this.amount);
			//System.out.println();
			System.out.println("Additional Info: " +this.additionalInfo);
		}
		
		
	}


