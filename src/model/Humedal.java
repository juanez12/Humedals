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

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public UbicationType getLocation(){
        return location;
    }

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
    public HumedalType getTipe(){
        return tipe;
    }

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
    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url=url;
    }

    public boolean getProtect(){
        return protect;
    }

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