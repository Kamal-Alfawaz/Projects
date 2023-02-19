public class User{

    private String name;
    
    //sets the variable name to whatever is given from the parameter
    public User(String name){
	this.name = name;
    }

    //returns the name 
    public String getName(){
	return this.name;
    }

    //changes the name to what was gievn as a parameter
    public void setName(String name){
	this.name=name;
    }
    
}
