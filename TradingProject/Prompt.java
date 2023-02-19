import java.awt.*;
import java.awt.event.*;
public class Prompt extends Frame{

    private Button submit;
    
	//constructor that would make a new small window where it would have a submit button, which when it would be clicked on it would close the window
    public Prompt(){
	this.setLayout(new GridLayout(0,2));
	submit = new Button("Submit");
	submit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    dispose();
		}
	    });
	this.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent evt) {
		    ((Frame)(evt.getSource())).dispose();
		}
	    });	
    }

    public void addSubmitListener(ActionListener listener){
	submit.addActionListener(listener);
    }    

	//method that would make the prompt active 
    public void activate(){	
        this.add(submit);
	this.pack(); // Resizes to tightly fit all its components
	this.setLocationRelativeTo(null); // Centers the window on the screen
	this.setVisible(true);
    }
}
