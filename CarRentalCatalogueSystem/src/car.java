
public class car {
	
	//Setting car / class properties: Fields, Global Variables
	String carModel;
	int numberPlate;
	int passengers;
	boolean isCheckedOut; //Whether the car is checked out already
	int dayCheckedOut = -1;
	
	//Constructor --
	public car(String carModelType, int carNumberPlate, int carPassengers) {
		this.carModel = carModelType;
		this.numberPlate = carNumberPlate;
		this.passengers = carPassengers;
		isCheckedOut = false;
	}
	
	//Getters --> Instances
	public String getCarModel() {
		return this.carModel;
	}
	
	public int getNumberPlate() {
		return this.numberPlate;
	}
	
	public int getPassengers() {
		return this.passengers;
	}
	
	public boolean getIsCheckedOut() {
		return this.isCheckedOut;
	}
	
	public int getDayCheckedOut(){
		return this.dayCheckedOut;
	}
	
	//Setters
	public void setIsCheckedOut(boolean newIsCheckedOut, int currentDayCheckedOut) {
		this.isCheckedOut = newIsCheckedOut;
		setDayCheckedOut(currentDayCheckedOut);	 	
	}
	
	private void setDayCheckedOut(int day) {
		this.dayCheckedOut = day;
	}
	
	
}
