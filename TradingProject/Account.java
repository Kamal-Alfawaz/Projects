public class Account extends sellAll{

    private double balance;
    private double gameStopShares;
    private double appleShares;
    
    //sets the account's balance to default of 0
    public Account(){
        this.balance = 0;
        this.gameStopShares = 0;
        this.appleShares = 0;
    }

    //sets account's balance to what the parameter wants it to be set as
    public Account(double balance){
        this.balance = balance;
    }

    //returns the saved balance
    public double getBalance(){
        return this.balance;
    }    

    //deposits the amount of money that is given by the parameter to the saved balance
    public void deposit(double amount){
        this.balance += amount;
    }    

    //withdraws the amount of money that is given by the parameter from the saved balance
    public void withdraw(double amount){
        this.balance -= amount;
    }

    //returns the amount of shares the user has
    public double getGameStopShares(){
        return this.gameStopShares;
    }

    //returns the amount of shares the user has
    public double getAppleShares(){
        return this.appleShares;
    }

    //sells the shares based off of the amount given by the parameter
    public void sellGameStopShare(double shares){
        this.gameStopShares -= shares;
    }

    //sells the shares based off of the amount given by the parameter
    public void sellAppleShare(double shares){
        this.appleShares -= shares;
    }

    //buys the shares based off of the amount given by the parameter
    public void buyGameStopShares(double shares){
        this.gameStopShares += shares;
    }

    //buys the shares based off of the amount given by the parameter
    public void buyAppleShares(double shares){
        this.appleShares += shares;
    }

    //sells all the shares available and would deposit the translated money into the account's balance
    public void sellAllShares() {
        this.balance += this.gameStopShares*69;
        this.balance += this.appleShares*40;
        this.appleShares = 0;
        this.gameStopShares = 0;
    }
    
    public String toString(){
	return "Balance: " + this.balance;
    }
    
}
