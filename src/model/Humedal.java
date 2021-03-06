package model;
public class Humedal{
    //Attributes
    private String name;
    private UbicationType location;
    private HumedalType tipe;
    private String url;
    private boolean protect;
	// usado para la evaluacio pratica private int like;
    
	//Constants
	private static final int MAX_SPECIES=100;
	private static final int MAX_EVENTS=10;
	
    //Relations
    private Specie[] species;
    private Event[] events;

    //Methods
	//usado para la evaluacion pratica , int like
	/**
	*Humedal.<br>
	*The constructor for the class Humedal.<br>
	*<b>pos: </b>The arrays for the species and the events are initialized
	*@param name, The name of the humedal.
	*@param location, a number indicating the the location of the humedal(1. for rural, 2. for urban).
	*@param tipe, a number indicating the type of the humedal(1. for public 2. for private).
	*@param url, the url from a phot of the humedal.
	*@param protect, a boolean variable saying if the humedal is protected or no.
	*/
    public Humedal(String name, int location, int tipe, String url, boolean protect){
        this.name=name;
		switch(location){
			case 1:
			this.location=UbicationType.RURAL;
			break;
			case 2:
			this.location=UbicationType.URBAN;
			break;
		}
		switch(tipe){
			case 1:
			this.tipe=HumedalType.PUBLIC;
			break;
			case 2:
			this.tipe=HumedalType.PRIVATED;
			break;
		}      
        this.url=url;
        this.protect=protect;
		//usado para la evaluacion pratica this.like=like;
		species=new Specie[MAX_SPECIES];
		events=new Event[MAX_EVENTS];
    }
	
	/**
	*getName.<br>
	*returns the name of the humedal.<br>
	*@return name, the name of the humedal.
	*/
    public String getName(){
        return name;
    }
	
	/**
	*setName.<br>
	*The method sets the name of the humedal.<br>
	*@param name, name of the humedal.
	*/
    public void setName(String name){
        this.name=name;
    }
	
	/**
	*getLocation.<br>
	*Returns the location from the humedal(RURAL or URBAN).<br>
	*@return location, the location from the humedal.
	*/
    public UbicationType getLocation(){
        return location;
    }
	/**
	*setLocation.<br>
	*Sets the location of the humedal.<br>
	*@param location, a number indicating the the location of the humedal(1. for rural, 2. for urban).
	*/
    public void setLocation(int location){
       switch(location){
			case 1:
			this.location=UbicationType.RURAL;
			break;
			case 2:
			this.location=UbicationType.URBAN;
			break;
		}
    }
	
	/**
	*getTipe.<br>
	*returns the type of the humedal(PUBLIC or PRIVATE).<br>
	*@return tipe, the tipe of the humedal.
	*/
    public HumedalType getTipe(){
        return tipe;
    }

	/**
	*setTipe.<br>
	*Sets the tipe of the humedal.<br>
	*@param tipe, a number indicating the type of the humedal(1. for public 2. for private).
	*/
    public void setTipe(int tipe){
        switch(tipe){
			case 1:
			this.tipe=HumedalType.PUBLIC;
			break;
			case 2:
			this.tipe=HumedalType.PRIVATED;
			break;
		}
    }
	
	/**
	*getUrl.<br>
	*Returns the url from the photo of the humedal.<br>
	*@return url, the url from the photo of the humedal.
	*/
    public String getUrl(){
        return url;
    }
	
	/**
	*setUrl.<br>
	*Sets the url.
	*@param url.
	*/
    public void setUrl(String url){
        this.url=url;
    }
	/**
	*getProtect.<br>
	*Returns if the humedal is protected or no.<br>
	*@return protect.
	*/
    public boolean getProtect(){
        return protect;
    }
	
	/**
	*setProtect.<br>
	*Sets if the humedal is protected or no.
	*@param protect.
	*/
    public void setProtect(boolean protect){
        this.protect=protect;
    }
	
	/* usado para la evaluacion pratica
	public int getLike(){
		return like;
	}
	
	public void setLike(int like){
		this.like=like;
	}
	
	public double moneyDonated(){
		double money=like*0.25;
		return money;
	}
	
	public String likesInfo(){
		double moneyD=moneyDonated();
		String message="The humedals: " +name+ " has received: " +like+ " so the amount donated to the humedal has been: " +moneyD;
		return message;
	}*/

	/**
	*addSpecie.<br>
	*Adds a new specie to the humedal.<br>
	*<b>pre: </b> It has there must be space on the array of species to add a new specie.<br>
	*@param nameSp, the name of the specie.
	*@param sciName, the scientific name of the specie.
	*@param migratory, a number that indicates if the specie is migratory or no (1. for yes 2. for no).
	*@param typeSP, a number that indicates from which type is the specie (1. Earth flora 2. for Acuatic flora 3. for bird 4. for mammal 5. for acuatic animal).
	*@return message, a message saying if the specie was added correctly.
	*/
	public String addSpecie(String nameSp, String sciName, int migratory, int typeSP){
		String message="The specie was added correctly";
		boolean continuar=true;
		boolean migratorySp=true;
		for(int i=0; i<MAX_SPECIES && continuar; i++){
			if(species[i]==null){
				switch(migratory){
					case 1:
					migratorySp=true;
					break;
					case 2:
					migratorySp=false;
					break;
				}	
				species[i]=new Specie(nameSp, sciName, migratorySp, typeSP);
				continuar=false;
			}
		} 
		if(continuar)
			message="There's no more space to add a new specie to the humedal";
		return message;
	}
	
	public String addEvent(int typeE, String nameO, double valueE, String desc, int dayE, int monthE, int yearE){
		String message="Event added correctly";
		boolean continuar=true;
		for(int i=0; i<MAX_EVENTS && continuar; i++){
			if(events[i]==null){
				events[i]=new Event(typeE, nameO, valueE, desc, dayE, monthE, yearE);
				continuar=false;
			}
		}
		if(continuar)
			message="There's no more space to add a new event";
		return message;
	}
	
	public String showManteniencesYear(int yearE){
		String message="";
		String type="";
		int counter=0;
		for(int i=0; i<MAX_EVENTS; i++){
			if(events[i]!=null){
				type=""+events[i].getType();
				if(type.equals("MANTENIENCE") && events[i].getYear()==yearE){
					counter++;
				}				
			}			
		} 
		message+="There are " +counter+ " manteniences planned for the humedal " +name+ " on the year " +yearE;
		return message;
	}
	
	public int getFlora(){
		int amountF=0;
		String tipeSp="";
		for(int i=0; i<MAX_SPECIES; i++){
			if(species[i]!=null){
				tipeSp=""+species[i].getType();
				if(tipeSp.equals("FLORAL_EARTH") || tipeSp.equals("FLORAL_ACUATIC")){
					amountF++;
				}
			}		
		}
		return amountF;
	}
	
	public boolean hasSpecie(String nameSearchSp){
		boolean found=false;
		for(int i=0; i<MAX_SPECIES && !found; i++){
			if(species[i]!=null && species[i].getName().equalsIgnoreCase(nameSearchSp)){
				found=true;
			}
		}
		return found;
	}
	
	public String toString(){
		String result="";
		result="The name of the humedal is: " +name+ " , is located in a " +location+ " zone, is a " +tipe+ " humedal, the image from the humedal is: " +url+ " and is it protected?: " +protect+ "\n";
		for(int i=0; i<MAX_SPECIES; i++){
			if(species[i]!=null){
				result+=species[i].toString();
			}		
		}
		return result;
	}
	
	public int getAnimals(){
		int amountA=0;
		String typeSp="";
		for(int i=0; i<MAX_SPECIES; i++){
			if(species[i]!=null){
				typeSp=""+species[i].getType();
				if(typeSp.equals("MAMMAL") || typeSp.equals("BIRD") || typeSp.equals("ACUATIC_ANIMAL")){
					amountA++;
				}
			}
		}
		return amountA;
	}
}