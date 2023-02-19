
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class Stonks extends Frame{

	private Manager Manager;
    private Panel clientButtonsPanel;
	private boolean premium;
	private String name;
	TextArea infoArea = new TextArea();

	public Stonks(boolean premium, String name){

		this.name = name;
		this.premium = premium;
		String version = "";
		if(premium == false){
			version = "Normal";
		}else{//if statement used so that different strings would be outputted whenever a person chooses premium or non premium account
			version = "Premium";
		}
		print("Hello "+ name +", this is "+ version +" Stonks where you will achieve only 69% "+ "\n" +"profit from trading!" + "\n" + "\n");
		
		this.Manager = new Manager();
		this.setLayout(new FlowLayout());
		
		//button that would call the method which would print the client's current portfolio onto a txt file
		Button savePortfolio = new Button("Save Portfolio");
		savePortfolio.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				textClientInfo(0);
			}
		});
		this.add(savePortfolio);	
		this.setVisible(true);

		//button that would call the method which would output the client's current portfolio onto the GUI textArea
		Button viewPortfolio = new Button("view Portfolio");
		viewPortfolio.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				printClientInfo(0);
			}
		});
		this.add(viewPortfolio);	
		this.setVisible(true);
			
		//button that would make a textfield and make a prompt class object and would then call the method that would deposit money onto the client's account
			Button depositButton = new Button("Deposit");
		depositButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				Prompt acp = new Prompt();
	
				TextField field = new TextField("Enter the amount to deposit");
				acp.add(field);
	
				acp.addSubmitListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt) {
						try{
							int depositAmount = Integer.parseInt(field.getText());
							deposit(name, depositAmount);
						}catch(Exception e){
							print("Please input numbers only");
						}
					}
				});
				acp.activate();
			}
		});
		this.add(depositButton);
	
		//button that would make a textfield and make a prompt class object and would then call the method that would withdraw money from the client's account
		Button withdrawButton = new Button("Withdraw");
		withdrawButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				Prompt acp = new Prompt();
	
				TextField field = new TextField("Enter the amount to withdraw");
				acp.add(field);
	
				acp.addSubmitListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt) {
						try{
							int withdrawAmount = Integer.parseInt(field.getText());
							withdraw(name, withdrawAmount);
						}catch(Exception e){
							print("Please input numbers only");
						}
					}
				});
				acp.activate();
			}
		});
		this.add(withdrawButton);

		//button that would make 2 textfields and make a prompt class object and would then call the method that would sell the current specified security from the client's account
		Button sellSecuritiesButton = new Button("SellSecurities");
		sellSecuritiesButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				Prompt acp = new Prompt();
	
				TextField field = new TextField("Enter the security");
				acp.add(field);
				TextField field2 = new TextField("Enter the amount in £");
				acp.add(field2);
	
				acp.addSubmitListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt) {
						String stock = field.getText().toString();
						try{
							double sellSecurities = Double.parseDouble(field2.getText());
							sellSecurities(stock,sellSecurities);
						}catch(Exception e){
							print("Please input numbers only");
						}
					}
				});
				acp.activate();
			}
		});
		this.add(sellSecuritiesButton);

		//button that would make 2 textfield and make a prompt class object and would then call the method that would buy the specified security and put it into the client's account
		Button buySecuritiesButton = new Button("buySecurities");
		buySecuritiesButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				Prompt acp = new Prompt();
	
				TextField field = new TextField("Enter the security");
				acp.add(field);
				TextField field2 = new TextField("Enter the amount in £");
				acp.add(field2);
	
				acp.addSubmitListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt) {
						String stock = field.getText().toString();
						try{
							double buySecurities = Double.parseDouble(field2.getText());
							buySecurities(stock,buySecurities);
						}catch(Exception e){
							print("Please input numbers only");
						}
					}
				});
				acp.activate();
			}
		});
	
		this.add(buySecuritiesButton);

		//button that would make textfield and make a prompt class object and would then call the method that would sell all the securities the client has 
		Button sellAllSecuritiesButton = new Button("Sell All Stocks");
		sellAllSecuritiesButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				Prompt acp = new Prompt();
	
				TextField field = new TextField("Are you sure you want to sell all shares?");
				acp.add(field);
				field.setEditable(false); //makes the text in the textfield not be editable 

				acp.addSubmitListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt) {
						sellAllSecurities();
					}
				});
				acp.activate();
			}
		});
	
		this.add(sellAllSecuritiesButton);

		
		infoArea.setEditable(false);
		this.add(infoArea);	
	
		clientButtonsPanel = new Panel();
		clientButtonsPanel.setLayout(new GridLayout(0,1));
		clientButtonsPanel.setVisible(true);
		this.add(clientButtonsPanel);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		this.setSize(500,300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	
		this.addClient();
		}

    public void print(String text){
	infoArea.setText(text);
    }    

	//error checking if the client can actually deposit into their account or not
	public void deposit(String client, int depositAmount){
		boolean found = Manager.deposit(client, depositAmount, premium);
		if (found == false){
			print("Error");
		}else{
			print("Successfully deposited");
		}
	}

	//error checking if the client can actually withdraw from their account or not
	public void withdraw(String client, int withdrawAmount){
		boolean found = Manager.withdraw(client, withdrawAmount, premium);
		if (found == false){
			print("Error");
		}else{
			print("Successfully withdrawn");
		}
	}

	//error checking if the client can actually sell their securites or not
	public void sellSecurities(String stock, double amount){
		boolean found = Manager.sellSecurities(stock, amount, premium);
		if(found == false){
			print("Error");
		}else{
			print("Successfully sold");
		}
	}

	//error checking if the client can actually buy securites into their account or not
	public void buySecurities(String stock, double amount){
		boolean found = Manager.buySecurities(stock, amount, premium);
		if(found == false){
			print("Error");
		}else{
			print("Successfully bought");
		}
	}

	//calls the method from the manager class
	public void sellAllSecurities(){
		Manager.sellAllShares(premium);
	}
    
	//calls the method from the manager class and whatever is returned would be printed on the GUI textArea
    public void printClientInfo(int index){
	String text = Manager.getClientInfo(index, premium);
	print(text);	
    }
    
	//calls the method from the manager class to add a client by making a client object 
	public void addClient(){
	Manager.addClient(new Client(this.name, premium));
    }

	//writes the client's portfolio onto the txt file named "Portfolio.txt"
	public void textClientInfo(int index){
		try{
			FileWriter myWriter = new FileWriter("Portfolio.txt");
			myWriter.write(Manager.getClientInfo(index, premium));
			myWriter.close();
			print("Successfully Printed to file.");
		}catch(IOException e){
			print("An error occurred.");
			e.printStackTrace();
		}
	}
}
