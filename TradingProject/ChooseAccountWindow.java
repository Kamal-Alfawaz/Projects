import java.awt.*;
import java.awt.event.*;

public class ChooseAccountWindow extends Frame{

    public ChooseAccountWindow(){

        this.setLayout(new FlowLayout());

    //makes a new button and then when clicked a window would appear asking for the user's name
    Button accountButton = new Button("Normal Account");
	accountButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
            Prompt acp = new Prompt();

            TextField field = new TextField("Enter your name");
            acp.add(field);

            acp.addSubmitListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    String name = field.getText().toString();
                    new Stonks(false, name);//the main class would run with these 2 set arguments because the user either chose premium or not
                    dispose();
                }
            });
            acp.activate();
		}
	});
    this.add(accountButton);
    this.setVisible(true);

    Button premiumAccount = new Button("Premium Account");
	premiumAccount.addActionListener(new ActionListener(){    
		public void actionPerformed(ActionEvent evt){
            Prompt acp = new Prompt();

            TextField field = new TextField("Enter your name");
            acp.add(field);

            acp.addSubmitListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    String name = field.getText().toString();
                    new Stonks(true, name);//the main class would run with these 2 set arguments because the user either chose premium or not
                    dispose();
                }
            });
            acp.activate();
		}
	});
    this.add(premiumAccount);
    this.setVisible(true);

    addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            dispose();
        }
    });

	this.setSize(300,200);
	this.setLocationRelativeTo(null);
	this.setVisible(true);

    }
    public static void main(String[] args){
        new ChooseAccountWindow();
    }
}