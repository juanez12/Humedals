package model;
public class Dagma{
	
	//Attributes
	private String nit;
	private String telephone;
	
	//Constants
	private static final int MAX_HUMEDALS=80;
	
	//Relations
	private Humedal[] humedals;
	
	//Methods
	/**
	*Dagma.<br>
	*Constructor for the class dagma.<br>
	*<b>pos: </b> The array of the humedals is initialized.<br>
	*@param nit, The nit from dagma.
	*@param telephone, The telephone from dagma.
	*/
	public Dagma(String nit, String telephone){
		this.nit=nit;
		this.telephone=telephone;
		humedals=new Humedal[MAX_HUMEDALS];
	}
	/**
	*getNit.<br>
	*Retunrs the attribute nit.<br>
	*@return nit.
	*/
	public String getNit(){
		return nit;
	}
	/**
	*setNit.<br>
	*Sets the nit for the class.<br>
	*@param nit.
	*/
	public void setNit(String nit){
		this.nit=nit;
	}
	/**
	*getTelephone.<br>
	*Returns the attribute telephone.<br>
	*@return telephone.
	*/
	public String getTelephone(){
		return telephone;
	}
	/**
	*setNit.<br>
	*Sets the telephone for the class.<br>
	*@param telephone.
	*/
	public void setTelephone(String telephone){
		this.telephone=telephone;
	}
	/**
	*existHumedal.<br>
	*The methods return if an humedal already exists or no.<br>
	*<b>pre: </b> To the method is passed the name from the humedal it wants to be searched.<br>
	*@param nH, the name form the humedal that is being searched.
	*@return found, a boolean variable indicating if the humedal already exists or no.
	*/
	public boolean existHumedal(String nH){
		boolean found=false;
		for(int i=0; i<MAX_HUMEDALS && !found; i++){
			if(humedals[i]!=null && humedals[i].getName().equals(nH))
				found=true;
		}
		return found;
	}
	
	/**
	*addHumedal.<br>
	*The method adds a new humedal to the array of humedals.<br>
	*<b>pre: </b> The parameters for the new humedal are passed from the class main.<br>
	*@param nameH, The name from the humedal.
	*@param loc, a number that indicates where is located the humedal (1. for rural, 2. for urban).
	*@param tipeH, a number that indicates which type is the humedal (1. for public, 2. for private).
	*@param urlH, the url from an humedal's photo.
	*@param optionP, a number that indicates if the humedal is protected or no (1. for protected, 2. for no protected).
	*@return message, a message saying if the humedal was added correctly or no.
	*/
	//, int likeHu usado para la evaluacion practica
	public String addHumedal(String nameH, int loc, int tipeH, String urlH, int optionP){
		String message="Humedal added succesfully";
		boolean continuar=true;
		boolean option=true;
		for(int i=0; i<MAX_HUMEDALS && continuar; i++){
			if(humedals[i]==null && !existHumedal(nameH)){
				switch(optionP){
					case 1: 
					option=true;
					break;
					case 2:
					option=false;
					break;
				}
				humedals[i]=new Humedal(nameH, loc, tipeH, urlH, option);
				continuar=false;
				//, likeHu
			}
			else if(existHumedal(nameH))
				message="That humedal already exists";
		}
		if(continuar)
			message="There is no more space to add a new humedal";
		return message;
	}
	
	/**
	*addSpecie.<br>
	*Pass the parameters to add a new Specie to the class humedal.<br>
	*<b>pre: </b> The parameters for the new specie are passed from the class main.<br>
	*@param nameH, The name from the humedal where the specie is going to be added.
	*@param nameS, The name from the specie.
	*@param sciName, The scientific name from the specie.
	*@param migratory, a number that indicates if the specie is migratory (1. for yes 2. for no).
	*@param typeSp, a number that indicates which type is the specie(1. for earth flora 2. for acuatic flora 3. for bird 4. for mammal 5. for acuatic animal)
	*@return message, a message saying if the specie was added correctly.
	*/
	public String addSpecie(String nameH, String nameS, String sciName, int migratory, int typeSp){
		boolean continuar=true;
		String message="";
		for(int i=0; i<MAX_HUMEDALS && continuar; i++){
			if(humedals[i]!=null && humedals[i].getName().equals(nameH)){
				message=humedals[i].addSpecie(nameS, sciName, migratory, typeSp);
				continuar=false;
			}
		}
		return message;
	}
	/* usado para la evaluacion practica
	public String giveLikeHumedal(String nameH){
		String message="You have liked the humedal " +nameH;
		int likesTotal=0;
		boolean continuar=true;
		for(int i=0; i<MAX_HUMEDALS && continuar; i++){
			if(humedals[i]!=null && humedals[i].getName().equals(nameH)){
				likesTotal=humedals[i].getLike()+1;
				humedals[i].setLike(likesTotal);
				continuar=false;
			}
		}
		if(continuar)
			message="There wasn't found an humedal with the name: " +nameH;
		return message;
	}
	
	public String showHumedalsLikes(){
		String message="";
		for(int i=0; i<MAX_HUMEDALS; i++){
			if(humedals[i]!=null)
				message=humedals[i].likesInfo();
		} 
		return message;
	}
	
	public String humedalMostLiked(){
		String message="";
		int max=0;
		for(int i=0; i<MAX_HUMEDALS; i++){
			if(humedals[i]!=null && humedals[i].getLike()>max){
				max=humedals[i].getLike();
				message="The humedal " +humedals[i].getName()+ " is the humedal with the most likes";
			}
		}
		return message;
	}*/
	
	/**
	*addEvent.<br>
	*Pass the parameters to add a new event to the class humedal.<br>
	*<b>pre: </b> The parameters for the new event are passed from the class main.<br>
	*@param nH, The name from the humedal where the specie is going to be added.
	*@param typeE, A number indicating the type of the event (1. for a mantenience 2. for a school visit 3. for an upgrade activity 4. for a celebration).
	*@param nameO, The name from the ones who organizes the event.
	*@param valueE, The value that cost the event.
	*@param desc, A description from the event.
	*@param day, The day where the event is planned to happen.
	*@param month, The month where the event is planned to happen.
	*@param year, The year where the event is planned to happen.
	*@return message, a message saying if the event was added correctly.
	*/
	public String addEvent(String nH, int typeE, String nameO, double valueE, String desc, int day, int month, int year){
		String message="";
		boolean continuar=true;
		for(int i=0; i<MAX_HUMEDALS && continuar; i++){
			if(humedals[i]!=null && humedals[i].getName().equals(nH)){
				message=humedals[i].addEvent(typeE, nameO, valueE, desc, day, month, year);
				continuar=false;
			}
		}
		return message;
	}
	
	/**
	*showManteniences.<br>
	* The method returns for all the humedal how many manteniences are planned depending the year written by the user.<br>
	*<b>pre: </b> The year where are searched how many manteniences are planned.<br>
	*@param yearC, the year where are searched the amount of manteniences.
	*@return message, a message saying all the manteniences planned for the year specified for all the humedals.
	*/
	public String showManteniences(int yearC){
		String message="";
		for(int i=0; i<MAX_HUMEDALS; i++){
			if(humedals[i]!=null){
				message+=" " +humedals[i].showManteniencesYear(yearC);
			}			
		}
		return message;
	}
	
	/**
	*lessFlora.<br>
	*The method shows the name of the humedal with the less amount of floral species.<br>
	*@return message, a message with name of the humedal with the less amount of floral species.
	*/
	public String lessFlora(){
		String message="";
		int compare=0;
		String humedalLess="";
		for(int i=0; i<MAX_HUMEDALS; i++){
			if(humedals[i]!=null){
				if(compare==0){
					compare=humedals[i].getFlora();
					humedalLess=humedals[i].getName();
				}
				else if(compare>humedals[i].getFlora()){
					humedalLess=humedals[i].getName();
				}
			}
		}
		message="The humedal with the less species of flora is " +humedalLess;
		return message;
	}
	
	/**
	*searchSpecie.<br>
	*The method searchs an specific specie in all the humedals.<br>
	*<b>pre: </b> The name of the species has to be passed.<br>
	*<b>pos: </b> The name of the species is passed to the class humedal.<br>
	*@param nameSpSearch, The name from the specie that is being searched.
	*@return message, A message showing which are the humedals that have the specie searched.
	*/
	public String searchSpecie(String nameSpSearch){
		String message="The humedals that have the specie: " +nameSpSearch+ " are: ";
		for(int i=0; i<MAX_HUMEDALS; i++){
			if(humedals[i]!=null){
				if(humedals[i].hasSpecie(nameSpSearch)){
					message+=humedals[i].getName()+ " ";
				}
			}
		}
		return message;
	}
	/**
	*infoHumedal.<br>
	*The method shows all the info from the humedals and the species, (doesn't include the information from the events).<br>
	*@return message, a message with all the information from the humedals and from the species.
	*/
	public String infoHumedal(){
		String message="";
		for(int i=0; i<MAX_HUMEDALS; i++){
			if(humedals[i]!=null)
				message+=humedals[i].toString()+ "\n";
		}
		return message;
	}
	
	/**
	*mostAnimals.<br>
	*The method search the humedal with the most amount of animals inhabiting it.<br>
	*@return message, a message showing which is the humedal with the most amount animals.
	*/
	public String mostAnimals(){
		String message="";
		String humedalMost="";
		int compare=0;
		for(int i=0; i<MAX_HUMEDALS; i++){
			if(humedals[i]!=null){
				if(compare<humedals[i].getAnimals()){
					compare=humedals[i].getAnimals();
					humedalMost=humedals[i].getName();
				}
			}
		}
		message="The humedal with the most amount of animals is: " +humedalMost;
		return message;
	}
}