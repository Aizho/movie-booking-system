
public class Seat{

	private int chosenRow;
	private int chosenColumn;

	public Seat(){
		chosenRow = 0;
		chosenColumn = 0;
	}

	public Seat(int chosenRow,int chosenColumn){
		this.chosenRow = chosenRow;
		this.chosenColumn = chosenColumn;
	}

	public void setRow(int row){
		chosenRow = row;
	}

	public void setColumn(int column){
		chosenColumn = column;
	}

	public int getRow(){ return chosenRow; }
	public int getColumn(){ return chosenColumn; }

	public void displaySeat(){

    	//Header ROW
    	System.out.print("Display seat : " + "(" + chosenRow + "," + chosenColumn + ")\n");
   		System.out.print("				  ");
    	for (int i = 1; i <= 8; i++) {
            System.out.print(i + " ");
        }
            System.out.println();


        for (int i = 1; i <= 8; i++) {
        	System.out.print("				");
            System.out.print(i + " ");
            for (int j = 0; j < 8 ; j++) {

            if ((chosenRow == i) && (chosenColumn == j + 1)) {
        	    System.out.print('X' + " ");
            } 
            else
                System.out.print('-' + " ");
            }
        
        	System.out.println();
 		}
	}

	public String toString(){
		return "Hi";
	}
}