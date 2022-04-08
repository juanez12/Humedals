package ui;
import java.util.Scanner;
import model.Dagma;
public class Main{
	
	public static Scanner lector=new Scanner(System.in);
	
	//Relations
	private Dagma dagma;
	
	//Methods
	/**
	*Main.<br>
	*Constructor for class main, creates the object that connects the ui with the model. <br>
	*<b>post: </b> The object dagma is created.<br>
	*@param nit, is the nit from the dagma empress.
	*@param telephone, is the the telephone from the dagma empress.
	*/
	public Main(String nit, String telephone){
		dagma=new Dagma(nit, telephone);
	}
	
	/**
	*main.<br>
	*Is the main method from the program, is created the object Main principal that connects the method main with the rest of the methods from the class Main.<br>
	*@param args[] are the args from the method:
	*/
    public static void main(String[] args){
		
		System.out.println("Starting the program");
		Main principal=new Main("100098", "3175639678");
		int option=1;
		
		do{
			
			System.out.println("Select which option do you want to realize");
			System.out.println("0. Exit the program");
			System.out.println("1. Add Humedal");
			System.out.println("2. Register new species on an humedal");
			System.out.println("3. Register a new event");
			System.out.println("4. See the manteniences on an humedal");
			System.out.println("5. Show the humedal's name with the less number of species");
			System.out.println("6. Show the humedals' name that has an specefic specie");
			System.out.println("7. Show the information of the humedals");
			System.out.println("8. Show the humedal's name with the most number of animals");
			System.out.println("9. Give like to an humedal");
			System.out.println("10. Show how many likes have the humedals");
			System.out.println("11. Show the humedal with the most amount of likes");
			
		}while(option!=0);
		
		switch(option){
			case 0:
				System.out.println("Exiting from the program, see you later");
			break;
			case 1:
				String result1=principal.addHumedal();
				System.out.println(result1);
			break;
			
			case 2:
				String result2=principal.addSpecie();
				System.out.println(result2);
			break;
			
			case 3:
				String result3=principal.addEvent();
				System.out.println(result3);
			break;
			case 4:
				String result4=principal.showMantenience();
				System.out.println(result4);
			break;
			case 5:
				String result5=principal.lessFlora();
				System.out.println(result5);
			break;
			case 6: 
				String result6=principal.searchSpecie();
				System.out.println(result6);
			break;
			case 7:
				String result7=principal.infoHumedal();
				System.out.println(result7);
			break;
			case 8:
				String result8=principal.mostAnimals();
				System.out.println(result8);
			break;
			/*
			usado para la evaluacion practica
			case 9:
				String result9=principal.giveLikes();
			break;
			case 10:
				String result10=principal.showLikes();
				System.out.println(result10);
			break;
			case 11:
				String result11=principal.showMostLikes();
				System.out.println(result11);
			break;*/
			default: System.out.println("Invalid option please select a valid option");
		}
		
    }
	
	/**
	*addHumedal.<br>
	*This method pass the parameter to create an humedal to the class dagma on the model.<br>
	*<b>pos: </b> The parameters to create an humedal are passed to the class dagma.<br>
	@return message, a message indicating if the humedal was created or no.
	*/
	public String addHumedal(){
		
		String message="";
		System.out.println("Write the humedal's name");
		String nameH=lector.nextLine();
		System.out.println("Write the humedal's location, 1 if it's on a rural zone of 2 if it's on a urban zone");
		int loc=lector.nextInt();
		lector.nextLine();
		if(loc<1 || loc>2){
			System.out.println("Invalid option please write it again");
			loc=lector.nextInt();
			lector.nextLine();
		}
		System.out.println("Write the humedal's tipe 1 for public, 2 for private");
		int tipeH=lector.nextInt();
		lector.nextLine();
		if(tipeH<1 || tipeH>2){
			System.out.println("Invalid option please write it again");
			tipeH=lector.nextInt();
			lector.nextLine();
		}
		System.out.println("Write the url from a humedal's photo");
		String urlH=lector.nextLine();
		System.out.println("Write if the humedal is protected or no (write 1 for yes or 2 for no)");
		int optionp=lector.nextInt();
		lector.nextLine();
		if(optionp<1 || optionp>2){
			System.out.println("Invalid option please write it again");
			optionp=lector.nextInt();
			lector.nextLine();
		}
		//int likeH=0; usado para la evaluacion practica
		message=dagma.addHumedal(nameH, loc, tipeH, urlH, optionp);
		//,likeH usado para la evaluacion practica
		return message;
		
	}
	
	/**
	*addSpecie.<br>
	*This method pass the parameters to create a new specie on a specefied humedal.<br>
	*<b>pos: </b> The parameters to create a new specie are passed to the model class humedal.<br>
	*@return message, A message that says if the specie was added or no.
	*/
	public String addSpecie(){
		
		String message="";
		System.out.println("Write the humedal's name where is located the specie");
		String nH=lector.nextLine();
		System.out.println("Write the name of the specie");
		String nameS=lector.nextLine();
		System.out.println("Write the scientific name of the specie");
		String scienceName=lector.nextLine();
		System.out.println("Write if the specie is migratory(1 for yes 2 for no)");
		int migratory=lector.nextInt();
		lector.nextLine();
		System.out.println("Write the type of the specie, 1 for earth flora, 2 for acuatic flora, 3 for bird, 4 for mammal, 5 for acuatic animal");
		int typeS=lector.nextInt();
		lector.nextLine();
		if(typeS<1 || typeS>5){
			System.out.println("Invalid number please write it again");
			typeS=lector.nextInt();
			lector.nextLine();
		}
		message=dagma.addSpecie(nH,nameS, scienceName, migratory, typeS);
		return message;
	}
	
	/**
	*addEvent.<br>
	*This method pass the parameters to create a new evenet.<br>
	*<b>pos: </b> The parameters to create an event are passed to the model.<br>
	*@return message, A message saying if the event was created or no.
	*/
	public String addEvent(){
		String message="";
		System.out.println("Write the humedal's name where is located the specie");
		String nH=lector.nextLine();
		System.out.println("Write the tipe of the event, 1 for mantenience, 2 for school visit, 3 for an upgrade activity, 4 for celebration");
		int tipeE=lector.nextInt();
		lector.nextLine();
		if(tipeE<1 || tipeE>4){
			System.out.println("Wrong number please write it again");
			tipeE=lector.nextInt();
			lector.nextLine();
		}
		System.out.println("Write the name of the person who's organizing the event");
		String nameO=lector.nextLine();
		System.out.println("Write the value of the event");
		double valueE=lector.nextDouble();
		lector.nextLine();
		System.out.println("Write the description of the event");
		String desc=lector.nextLine();
		System.out.println("Write the day when the event is going to be happening");
		int dayE=lector.nextInt();
		System.out.println("Write the month when the event is going to be happening");
		int monthE=lector.nextInt();
		System.out.println("Write the year when the event is going to be happening");
		int yearE=lector.nextInt();
		lector.nextLine();
		message=dagma.addEvent(nH,tipeE, nameO, valueE, desc, dayE, monthE, yearE);
		return message;
	}
	
	/**
	*showMantenience.<br>
	*This method shows the manteniences planned for all the humedals on a year specefied by the user.<br>
	*<b>pre: </b> The user has to write the year to see the manteniences planned on that date for all the humedals.<br>
	*<b>pos: </b> The program shows all the manteniences the humedals have in the year specefied.<br>
	*@return message, A message saying all the manteniences that the humedals have in the year writted by the user.
	*/
	public String showMantenience(){
		System.out.println("Write the year which you want to know the manteniences");
		int yearC=lector.nextInt();
		lector.nextLine();
		String message=dagma.showManteniences(yearC);
		return message;
	}
	/**
	*lessFlora.<br>
	*Shows the name of the humedal with less species of flora.<br>
	*@return message, A message with the name of the humedal with the less species of flora.
	*/
	public String lessFlora(){
		String message=dagma.lessFlora();
		return message;
	}
	/**
	*searchSpecie.<br>
	*Shows all the humedals where is located a species introduced by the user.<br>
	*<b>pre: </b> The user has to write the name of the specie he/she wants to search.<br>
	*@return message, A message with the names of the humedals where the specie inhabits.
	*/
	public String searchSpecie(){
		String message="";
		System.out.println("Write the name of the specie you want to search");
		String nspSearch=lector.nextLine();
		message=dagma.searchSpecie(nspSearch);
		return message;
	}
	/**
	*infoHumedal.<br>
	*Shows the info of all the humedals that are created incluiding the species that has the humedal (the info from the events is not incluided).<br>
	*@return message, A message showing all the information. 
	*/
	public String infoHumedal(){
		String message="";
		message=dagma.infoHumedal();
		return message;
	}
	/*
	usado para la evaluacion practica
	public String giveLikes(){
		String message="";
		System.out.println("Write the humedal's name where you want to give like");
		String nh=lector.nextLine();
		message=dagma.giveLikeHumedal(nh);
		return message;
	}
	
	public String showLikes(){
		String message=dagma.showHumedalsLikes();
		return message;
	}
	
	public String showMostLikes(){
		String message="";
		message=dagma.humedalMostLiked();
		return message;
	}*/
	
	/**
	*mostAnimals.<br>
	*The method shows the name of the humedal with the most amount of animals inhabiting it.<br>
	*@return message, A message with the name of the humedal with the most amount of animals.
	*/
	public String mostAnimals(){
		String message="";
		message=dagma.mostAnimals();
		return message;
	}
}