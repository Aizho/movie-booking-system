//GROUP 6

public class Movie{

	private String movieName;
	private String movieGenre;
	private String movieTime;

	//Declare default and normal constructor
	public Movie (){
		movieName = "unknown";
		movieGenre = "unknown";
		movieTime = "unknown";
	}

	public Movie (String movieName, String movieGenre, String movieTime){
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieTime = movieTime;
	}
	
	//Declare setter (mutator)
	public void setName(String movieName){
		this.movieName = movieName;
	}
	public void setGenre(String movieGenre){
		this.movieGenre = movieGenre;
	}
	public void setTime(String movieTime){
		this.movieTime = movieTime;
	}

	//Declare getter (accessor)
	public String getName(){ return movieName;}
	public String getGenre(){ return movieGenre;}
	public String getTime(){ return movieTime;}

	public void movieChoose(int choose){

		switch (choose){
		case 1 :
			setName("Mat kilau");
			setGenre("Action");
			break;
		case 2 : 
			setName("Fast Furious 6");
			setGenre("Racing");
			break;
		case 3 :
			setName("Kimi no Nawa");
			setGenre("Anime");
			break;
		default : 
			System.out.println("We dont have option for your choose.");
			break;
		}
	}

	//Declare printer
	public String toString(){
		return "\nMovie name: " + movieName + "\nMovie genre: " + movieGenre + "\nMovie time: " + movieTime ;
	}
}