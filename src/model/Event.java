package model;
import java.time.LocalDate;
public class Event{

    //Attributes
	private TypeEvent type;
    private String nameOrganizer;	
    private double value;
    private String description;
	private LocalDate date;

    //Methods
	/**
	*Event.<br>
	*Constructor for the class Event.<br>
	*@param type, a number indicaing the type of the event (1. for mantenience, 2. for school visit, 3.for upgrade activity, 4. fro celebraation).
	*@param nameOrganizer, the name from the person who's organizing the event. 
	*@param value, the value from the event.
	*@param description, a description from the event.
	*@param day, the day when is planned the event.
	*@param month, the month when is planned the event.
	*@param year, the year when is planned the event.
	*/
    public Event(int type, String nameOrganizer, double value, String description, int day, int month, int year){     
		switch(type){
			case 1:
			this.type=TypeEvent.MANTENIENCE;
			break;
			case 2:
			this.type=TypeEvent.SCHOOL_VISIT;
			break;
			case 3:
			this.type=TypeEvent.UPGRADE_ACTIVITY;
			break;
			case 4:
			this.type=TypeEvent.CELEBRATION;
			break;
		}
		this.nameOrganizer=nameOrganizer;
        this.value=value;
        this.description=description;
		date=LocalDate.of(year,month,day);
    }
	
	/**
	*getType.<br>
	*Returns the type from the event.<br>
	*@return type, the type from the event.
	*/
    public TypeEvent getType(){
        return type;
    }
	/**
	*setType.<br>
	*The method sets the type of the event.<br>
	*@param type, a number indicaing the type of the event (1. for mantenience, 2. for school visit, 3.for upgrade activity, 4. fro celebraation).
	*/
    public void setType(int type){
       switch(type){
			case 1:
			this.type=TypeEvent.MANTENIENCE;
			break;
			case 2:
			this.type=TypeEvent.SCHOOL_VISIT;
			break;
			case 3:
			this.type=TypeEvent.UPGRADE_ACTIVITY;
			break;
			case 4:
			this.type=TypeEvent.CELEBRATION;
			break;
		}
    }
	
	/**
	*getNameOrganizer.<br>
	**Returns the name from the organizer of the event.<br>
	*@return type, the name from the organizer.
	*/
	public String getNameOrganizer(){
		return nameOrganizer;
	}
	
	/**
	*setNameOrganize.<br>
	*The method sets the name of the organizer.<br>
	*@param nameOrganizer, the name from the person who's organizing the event.
	*/
	public void setNameOrganize(String nameOrganizer){
		this.nameOrganizer=nameOrganizer;
	}
	
	/**
	*getValue.<br>
	**Returns the value of the event.<br>
	*@return value, the value from the event.
	*/
	public double getValue(){
		return value;
	}
	
	/**
	*setValue.<br>
	*The method sets the value from the event.<br>
	*@param value, the value from the event.
	*/
	public void setValue(double value){
		this.value=value;
	}
	
	/**
	*getDescription.<br>
	*The method returns the description from the event.<br>
	*@return description, a description from the event.
	*/
	public String getDescription(){
		return description;
	}
	
	/**
	*setDescription.<br>
	*The method sets the description from the event.<br>
	*@param description, a description from the event.
	*/
	public void setDescription(String description){
		this.description=description;
	}
	
	/**
	*getYear.<br>
	*The method return the year from the event.<br>
	*@return yearE, the year from the event
	*/
	public int getYear(){
		int yearE=date.getYear();
		return yearE;
	}
}