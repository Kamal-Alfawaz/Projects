import java.util.ArrayList;
import java.util.Iterator;

public class Manager{

    private ArrayList<Client> clients;

    public Manager(){
	clients = new ArrayList<Client>();
    }

    public int getNumberOfClients(){
	return clients.size();
    }

	//prints out the client's info
    public String getClientInfo(int clientNumber, boolean premium){
    	Client c = clients.get(clientNumber);
		String text = "";
		text += "Name: " + c.getName() + "\n";
		text += "Funds: £" + c.getFunds(premium) + "\n" + "\n";
		text += "Stock: GameStop" + "\n";
		text += "Shares: " + c.getGameStopShares(premium) + "\n" + "\n";
        text += "Stock: Apple" + "\n";
        text += "Shares: " + c.getAppleShares(premium) + "\n"; 
		return text;
    }
        
    public void addClient(Client c){
	clients.add(c);
    }

	//checks if the user can deposit, as it iterates through a list of current clients (in this case there is only one client)
    public boolean deposit(String clientName, int amount, boolean premium){
	Iterator<Client> it = clients.iterator();
	boolean found = false;	
	while (it.hasNext()){
	    Client c = it.next();
	    if (c.getName().equals(clientName)){
		found = true;
		c.deposit(amount, premium);
	    }
	}
	return found;
    }

	//checks if the specified client has the funds to be able to withdraw how much they are asking to wihtdraw and would return a boolean whether they can or not
	public boolean withdraw(String clientName, double amount, boolean premium){
		Iterator<Client> it = clients.iterator();
		boolean found = false;	
		while (it.hasNext()){
			Client c = it.next();
			if (c.getName().equals(clientName)){
				if (amount <= c.getFunds(premium)){
					found = true;
					c.withdraw(amount, premium);		
				}
			}
		}
		return found;
	}

	//checks if the specified client has the funds to be able to buy whatever security they chose 
	public boolean buySecurities(String stockName, double amount, boolean premium){
		Iterator<Client> it = clients.iterator();
		boolean found = false;
		while(it.hasNext()){
			Client c = it.next();
			if(stockName.equals("GameStop")){
				if(withdraw(c.getName(), amount, premium) == true){//this is the part where it checks if the client has the money to be able to buy a security
					found = true;
					double shares = amount/69;
					c.buyGameStopShares(shares, premium);
				}
			}else if(stockName.equals("Apple")){
				if(withdraw(c.getName(), amount, premium) == true){
					found = true;
					double shares = amount/40;
					c.buyAppleShares(shares, premium);
				}
			}
		}
		return found;
	}

	//checks if the specified client has the specific security to be able to sell it
	public boolean sellSecurities(String stockName, double amount, boolean premium){
		Iterator<Client> it = clients.iterator();
		boolean found = false;
		while (it.hasNext()){
			Client c = it.next();
			if(stockName.equals("GameStop")){
				double shares = amount/69;
				if(shares <= c.getGameStopShares(premium)){//this is the part where it checks if the client has enough of the specific security to be able to sell it
					found = true;
					c.deposit(amount, premium);
					c.sellGameStopShare(shares, premium);
				}
			}else if(stockName.equals("Apple")){
				double shares = amount/40;
				if((shares) <= c.getAppleShares(premium)){
					found = true;
					c.deposit(amount, premium);
					c.sellAppleShare(shares, premium);
				}
			}
		}
		return found;
	}

	//sells all shares of the client at the first arraylist location
	public void sellAllShares(boolean premium){
		clients.get(0).sellAllSecurities(premium);
	}

}