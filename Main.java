
import java.util.Scanner;
import java.util.Date;
import javax.swing.JOptionPane;

public class Main{

	//Function definition
	public static void displayCustomer(String Name, long IC, int Age, char Gender){
		System.out.println("\n\n ------ Your details ------");
		System.out.println("Customer name: " + Name + "\nCustomer IC: 0" + IC + "\nCustomer age: " + Age + "\nCustomer gender: " + Gender);
	}

	public static void display(){

		Date today = new Date();
		System.out.print("\n|-----------------WELCOME TO ONLINE TICKET MOVIE BOOKING SYSTEM-----------------|");
		System.out.print("\n|-------------------------------------------------------------------------------|");
		System.out.print("\n|	Available			|	Code	|	Time		|");
		System.out.print("\n|	Mat Kilau			|	 1   	|	8AM-12PM	|");	
		System.out.print("\n|	Fast Furious 6			|	 2   	|	8AM-12PM	|");	
		System.out.print("\n|	Kimi no Nawa			|	 3   	|	8AM-12PM	|");			
		System.out.print("\n|-------------------------------------------------------------------------------|");		
		System.out.print("\n|	Food Menu	|	Code	|	Sizes	|	Prices		|");
		System.out.print("\n|	Hotdog  	|	1   	|	S|L 	|	2.00|3.00	|");
		System.out.print("\n|	Popcorn  	|	2   	|	S|L 	|	3.00|5.00	|");
		System.out.print("\n|	Fries   	|	3   	|	S|L 	|	2.50|3.50	|");		
		System.out.print("\n|-------------------------------------------------------------------------------|");		
		System.out.print("\n|	Drink Menu	|	Code	|	Sizes	|	Prices		|");
		System.out.print("\n|	Water   	|	1   	|	S|L 	|	1.00|2.00	|");
		System.out.print("\n|	Coffee  	|	2   	|	S|L 	|	2.50|3.50	|");
		System.out.print("\n|	Soda    	|	3   	|	S|L 	|	2.00|3.00	|");	
		System.out.print("\n|-------------------------------------------------------------------------------|");
		System.out.print("\n Current Date : " + today.toString());
	}	

	//Main
	public static void main(String[] args){

		//Variables for parameter
		int[] choose = new int[4];
		double[] total = new double[3];
		int row, column;
		int type;
		String time;
		char size;
		Boolean addon = false;

		//Variable for user
		String name; 
		long noIC;
		int age;
		char gender;


		//instantiate Scanner object
		Scanner input = new Scanner(System.in);
		
		//instantiate Movie object
		Movie myMovie = new Movie();
		
		//instantiate MovieTicket object
		MovieTicket myTicket = new MovieTicket();

		//instantiate Seat object
		Seat mySeat = new Seat();

		//instantiate FoodandDrink object
		FoodandDrink addons = new FoodandDrink();

		//instatiate file writer
		Database db = new Database();
		
		display();

		noIC = Long.parseLong(JOptionPane.showInputDialog("Please enter your no IC: "));
		if(noIC == db.userRead()){
			name = db.getName();
			age = db.getAge();
			gender = db.getGender();
			System.out.println("\nYour data is already there\n");
		}
		else{
			name = JOptionPane.showInputDialog("Please enter your name: ");
			age = Integer.parseInt(JOptionPane.showInputDialog("(Below 18+ will be discounted)\nPlease enter your age : "));
			gender = JOptionPane.showInputDialog("Please enter your gender (F|M): ").charAt(0);
			gender = Character.toUpperCase(gender);
			db.setAttributes(noIC,name,age,gender);
			db.userWrite();
		}

		
		while(true){

			choose[0] = Integer.parseInt(JOptionPane.showInputDialog("\n1. Choose Movie \n2. Choose seat \n3. Display seat \n4. Foods & Drinks \n0. Exit \nEnter number: "));
			
			switch(choose[0]){
			case 1 :	
				choose[1] = Integer.parseInt(JOptionPane.showInputDialog("\nEnter movie code: "));
				myMovie.movieChoose(choose[1]);
				time = JOptionPane.showInputDialog("\nEnter movie time: ");
				myMovie.setTime(time);
				continue;
			case 2 :
	      		row = Integer.parseInt(JOptionPane.showInputDialog("\nEnter a row number: "));
	        	mySeat.setRow(row);

	        	column = Integer.parseInt(JOptionPane.showInputDialog("Enter a seat number in that row: "));
	       		mySeat.setColumn(column);
				continue;
			case 3 : 
				System.out.println();
	       		mySeat.displaySeat();
				continue;
			case 4 :
				addon = true;  
				while(true){
					;//tukar displayMenu() nanti
					choose[3] = Integer.parseInt(JOptionPane.showInputDialog("\nFoods and Drinks \n1. Foods \n2. Drinks \n3. Exit \nEnter Number : "));

					switch(choose[3]){
					case 1 :
						type = Integer.parseInt(JOptionPane.showInputDialog("Food types: "));
						size = JOptionPane.showInputDialog("Food sizes: ").charAt(0);
						size = Character.toUpperCase(size);

						addons.setFoods(type,size);
						total[1] = total[1] + addons.calcFoodPrice();
						continue;
					case 2 : 
						type = Integer.parseInt(JOptionPane.showInputDialog("Drink types: "));
						size = JOptionPane.showInputDialog("Drink sizes: ").charAt(0);
						size = Character.toUpperCase(size);

						addons.setDrinks(type,size);
						total[2] = total[2] + addons.calcDrinkPrice();
						continue;
					default : 
						break;
					}
					
					total[0] = total[1] + total[2];
					myTicket.setAmount(total[0]) ;
					break;
				}
				continue;
			default :
				myTicket.calcPrice(age); 
				break;
			}

			break;
	    }

	    myTicket.Ticket(myMovie.getName());
		displayCustomer(name, noIC, age, gender);

		System.out.println(myMovie.toString());
		System.out.println(myTicket.toString(addon));
		
	}
}

