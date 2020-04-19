import java.util.HashMap;
import java.util.Map;

public class carCatalogue {
	
	
	//Properties / Fields / Global variables
	Map<String, car > carCollection = new HashMap<String, car>();
	int currentDay = 0;
	int lengthOfCheckOutPeriod = 7;
	double initialLateFee = 10.50;
	double feePerLateDay = 15.00;
	
	
	//constructors to initialize properties declared in class
	public carCatalogue(Map<String, car> collection) {
		this.carCollection = collection;
	}
	
	public carCatalogue(Map<String, car> collection, int LengthOfCheckOutPeriod, double initialLateFee, double feePerLateDay  ) {
		this.carCollection = collection;
		this.lengthOfCheckOutPeriod = LengthOfCheckOutPeriod;
		this.initialLateFee = initialLateFee;
		this.feePerLateDay = feePerLateDay;
	}
	
	//Getters
	public Map<String, car> getCarCollection() {
		return this.carCollection;
	}
	
	public car getCar(String carName) {
		return this.getCarCollection().get(carName);
	}
		
	public int getCurrentDay() {
		return this.currentDay;
	}
	
	public int getLengthOfCheckOutPeriod() {
		return this.lengthOfCheckOutPeriod;
	}
	
	public double getInitialLateFee() {
		return this.initialLateFee;
	}
	
	public double getFeePerLateDay() {
		return this.feePerLateDay;
	}
	
	
	//Setters 
	public void nextDay() {
		currentDay++;
	}
	
	public void setDay(int day) {
		currentDay = day;
	}
	
	//INSTANCE Methods:
	public void checkOutCar(String carName) {
		car Car = getCar(carName);
		if(Car.getIsCheckedOut()) {
			sorryCarAlreadyCheckedOut(Car);
		}else {
			Car.setIsCheckedOut(true, currentDay);
			System.out.println("You just checked out " +carName+". It is due in " +
			(getCurrentDay() + getLengthOfCheckOutPeriod() + " days time. Thank you"));
		}
	}
	
	public void carReturn(String carName) {
		car Car = getCar(carName);
		int daysLate = currentDay - (Car.getDayCheckedOut() + getLengthOfCheckOutPeriod());
		if(daysLate >0) {
			System.out.println("You owe the Car Rental Garage $" +(getInitialLateFee() + (daysLate*getFeePerLateDay()) + " because "
					+ "your rental is  " + daysLate+ " days overdue."));
		}else {
			System.out.println("Car has been returned on time. Thank you");
		}
		Car.setIsCheckedOut(false, -1);
	}
	
	public void sorryCarAlreadyCheckedOut(car Car) {
		System.out.println("Sorry, " +Car.getCarModel()+ " has already been checked out. It should be"
				+ "back in " +(Car.getDayCheckedOut() + getLengthOfCheckOutPeriod())+ " days time");
	} 
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, car> carCollection = new HashMap<String, car>();
		car BMW = new car("BMW Saloon", 042020, 5);
		carCollection.put("BMW Saloon", BMW);
		carCatalogue cat = new carCatalogue(carCollection);
		cat.checkOutCar("BMW Saloon");
		cat.nextDay();
		cat.nextDay();
		cat.checkOutCar("BMW Saloon");
		cat.setDay(17);
		cat.carReturn("BMW Saloon");
		cat.checkOutCar("BMW Saloon");
		
	}

}
