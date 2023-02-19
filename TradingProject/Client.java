public class Client extends User {    
     
    private Account account;
    private premiumAccount premiumAccount;

    //makes a new account or premiumAccount object based off of the variable premium which was passed down as a parameter
    public Client(String name, boolean premium){
	    super(name);
        if(premium == false){
            this.account = new Account();
        }else{
            this.premiumAccount = new premiumAccount();
        }
    }

    //sets account's balance to what the parameter wants it to be set as
    public void deposit(double amount, boolean premium){
        if (premium == false){
            this.account.deposit(amount);
        }else{
            this.premiumAccount.deposit(amount);
        }
    }

    //withdraws the amount of money that is given by the parameter from the saved balance from either account specified
    public void withdraw(double amount, boolean premium){
        if(premium == false){
            this.account.withdraw(amount);
        }else{
            this.premiumAccount.withdraw(amount);
        }
    }

    //returns the saved balance from either account specified
    public double getFunds(boolean premium){
        if(premium == false){
            return this.account.getBalance();
        }else{
            return this.premiumAccount.getBalance();
        }
    }

    //returns the amount of shares the user has
    public double getGameStopShares(boolean premium){
        if(premium == false){
            return this.account.getGameStopShares();
        }else{
            return this.premiumAccount.getGameStopShares();
        }
    }

    //returns the amount of shares the user has
    public double getAppleShares(boolean premium){
        if(premium == false){
            return this.account.getAppleShares();
        }else{
            return this.premiumAccount.getAppleShares();
        }
    }

    //sells the shares based off of the amount given by the parameter
    public void sellGameStopShare(double shares, boolean premium){
        if(premium == false){
            this.account.sellGameStopShare(shares);
        }else{
            this.premiumAccount.sellGameStopShare(shares);
        }
    }

    //sells the shares based off of the amount given by the parameter
    public void sellAppleShare(double shares, boolean premium){
        if(premium == false){
            this.account.sellAppleShare(shares);
        }else{
            this.premiumAccount.sellAppleShare(shares);
        }
    }

    //buys the shares based off of the amount given by the parameter
    public void buyGameStopShares(double shares, boolean premium){
        if(premium == false){
            this.account.buyGameStopShares(shares);
        }else{
            this.premiumAccount.buyGameStopShares(shares);
        }
    }

    //buys the shares based off of the amount given by the parameter
    public void buyAppleShares(double shares, boolean premium){
        if(premium == false){
            this.account.buyAppleShares(shares);
        }else{
            this.premiumAccount.buyAppleShares(shares);
        }
    }

    //sells all the shares available and would deposit the translated money into the account's balance
    public void sellAllSecurities(boolean premium){
        if(premium == false){
            this.account.sellAllShares();
        }else{
            this.premiumAccount.sellAllShares();
        }
    }
}
