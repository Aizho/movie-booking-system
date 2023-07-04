
public class MovieTicket extends FoodandDrink{

	//Delcare attribute
	private String ticketCode;
	public double ticketPrice;
	private double amount;


	//Declare default and normal constructor
	public MovieTicket(){
		super();
		ticketCode = "unknown";
		amount = 0.0;
	}

	public MovieTicket(int typeFoods, int typeDrinks, char sizeFoods, char sizeDrinks, String ticketCode, double amount){
		super(typeFoods, typeDrinks, sizeFoods, sizeDrinks);
		this.ticketCode = ticketCode;
		this.amount = amount;
	}

	public String getTicketCode(){ return ticketCode;}
	public double getAmount(){ return amount;}

	public void setTicketCode(String ticketCode){
		this.ticketCode = ticketCode;
	}
	public void setAmount(double amount){
		this.amount = amount;
	}

	//Declare processor(Overriding method)

	public void Ticket(String movie){
		if(movie.equalsIgnoreCase("Mat Kilau")){
			ticketCode = "A1";
		}
		else if(movie.equalsIgnoreCase("Kuda Kepang")){
			ticketCode = "B1";
		}
		else if(movie.equalsIgnoreCase("Mineral Water")){
			ticketCode = "C1";
		}
	}
	public double calcPrice(int age){

		ticketPrice = 15.0;
		if(age < 18){

			ticketPrice = ticketPrice - (ticketPrice*0.2);
		}
		
		amount = amount + ticketPrice ;

		return amount;
		
	}

	//Declare printer
	public String toString(Boolean addon){
		if(addon == true){

			return super.toString() + "\nTicket code: " + ticketCode + "\nTotal amount: " + amount + "\nTicket Price: " + ticketPrice  ;
		}
		else{
			return "\nTicket code: " + ticketCode + "\nTotal amount: " + amount + "\n" ;
		}		
	}

}