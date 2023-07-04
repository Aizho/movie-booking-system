
public class FoodandDrink{

	//Delcare attribute
	protected int typeFoods;
	protected int typeDrinks;
	protected char sizeFoods;
	protected char sizeDrinks;

	//Declare default and normal constructor
	public FoodandDrink(){
		typeFoods = 0;
		typeDrinks = 0;
		sizeFoods = '0';
		sizeDrinks = '0';
 
	}

	public FoodandDrink(int typeFoods, int typeDrinks, char sizeFoods, char sizeDrinks){
		this.typeFoods = typeFoods;
		this.typeDrinks = typeDrinks;
		this.sizeFoods = sizeFoods;
		this.sizeDrinks = sizeDrinks;

	}

	public void setFoods(int typeFoods, char sizeFoods){
		this.typeFoods = typeFoods;
		this.sizeFoods = sizeFoods;
	}
	public void setDrinks(int typeDrinks, char sizeDrinks){
		this.typeDrinks = typeDrinks;
		this.sizeDrinks = sizeDrinks;
	}

	public int getTypeFoods(){ return typeFoods;}
	public int getTypeDrinks(){ return typeDrinks;}
	public int getSizeFoods(){ return sizeFoods;}
	public int getSizeDrinks(){ return sizeDrinks;}
	
	//Declare processor(Overriding method)
	public double calcFoodPrice(){
		double price = 0.0;

		if(typeFoods == 1){//Hotdog
			if(sizeFoods == 'S'){
				price = 2.0;
			}
			else if(sizeFoods == 'L'){
				price = 3.0;
			}
		}
		else if(typeFoods == 2){//Popcorn
			if(sizeFoods == 'S'){
				price = 3.0;
			}
			else if(sizeFoods == 'L'){
				price = 5.0;
			}
		}
		else if(typeFoods == 3){//Fries
			if(sizeFoods == 'S'){
				price = 2.5;
			}
			else if(sizeFoods == 'L'){
				price = 3.5;
			}
		}

		return price;
	}

	public double calcDrinkPrice(){
		double price = 0.0;

		if(typeDrinks == 1){//Mineral
			if(sizeDrinks == 'S'){
				price = 1.0;
			}
			else if(sizeDrinks == 'L'){
				price = 2.0;
			}
		}
		else if(typeDrinks == 2){//Coffee
			if(sizeDrinks == 'S'){
				price = 2.5;
			}
			else if(sizeDrinks == 'L'){
				price = 3.0;
			}
		}
		else if(typeDrinks == 3){//Soda
			if(sizeDrinks == 'S'){
				price = 1.5;
			}
			else if(sizeDrinks == 'L'){
				price = 2.5;
			}
		}
		return price;
	}

	//Declare printer
	public String toString(){
		return "\n------ Food and Drinks added ------" ;
	}
}
