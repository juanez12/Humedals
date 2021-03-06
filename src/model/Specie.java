package model;
public class Specie{
    //Attributes
    private String name;
    private String scienceName;
    private boolean migration;
    private TypeSpecies type;

    //Methods
    public Specie(String name, String scienceName, boolean migration, int type){
        this.name=name;
        this.scienceName=scienceName;
        this.migration=migration;
		switch(type){
			
			case 1:
				this.type=TypeSpecies.FLORAL_EARTH;
			break;
			
			case 2:
				this.type=TypeSpecies.FLORAL_ACUATIC;
			break;
			
			case 3:
				this.type=TypeSpecies.BIRD;
			break;
			
			case 4:
				this.type=TypeSpecies.MAMMAL;
			break;
			
			case 5:
				this.type=TypeSpecies.ACUATIC_ANIMAL;
			break;
			
		}
        
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getScienceName(){
        return scienceName;
    }

    public void setScienceName(String scienceName){
        this.scienceName=scienceName;
    }

    public boolean getMigration(){
        return migration;
    }

    public void setMigration(boolean migration){
        this.migration=migration;
    }

    public TypeSpecies getType(){
        return type;
    }

    public void setType(int type){
        switch(type){
			
			case 1:
				this.type=TypeSpecies.FLORAL_EARTH;
			break;
			
			case 2:
				this.type=TypeSpecies.FLORAL_ACUATIC;
			break;
			
			case 3:
				this.type=TypeSpecies.BIRD;
			break;
			
			case 4:
				this.type=TypeSpecies.MAMMAL;
			break;
			
			case 5:
				this.type=TypeSpecies.ACUATIC_ANIMAL;
			break;
			
		}
    }
	
	public String toString(){
		String message="The name of the specie is: " +name+ " the scientific name is: " +scienceName+ " is a migratory specie?: " +migration+ " and the species is from the tipe: " +type;
		return message;
	}
}