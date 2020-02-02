/* 
 * Program will contain a class called BMICalculator
 *   It will have a public instance method called readUserData
 *   which will use private instance methods called readUnitType 
 *   and readMeasurementData.
 *   	readMeasurementData will call private instance methods of either
 *   	readMetricData or readImperialData depending on user selection.
 *  
 *   It will have a public instance method called calculateBmi that calculates
 *   the users's BMI and BMI category.
 *   	There will be a private instance method called calculateBmiCategory 
 *   	that determines the user's BMI category.
 *   
 *   It will have a public instance method called displayBmi that prints the BMI 
 *   and the BMI category.
 * 	 
 * 	 There will be a public instance method called getWeight.
 *   There will be a private instance method called setWeight.
 *   
 *   There will be a public instance method called getHeight.
 *   There will be a private instance method called setHeight.
 *   
 *   There will be a public instance method called getBmi.
 *   There will be a public instance method called getBmiCategory.
 *   
 *   The program should exit if the user enters a negative height or weight.
 *   
 *   The user should be prompted to enter a type of units until they enter a valid value.
 */
import java.util.Scanner;

public class BMICalculator {

	static final Scanner scan = new Scanner(System.in);
	
	private int weight;
	private int height;
	private double bmi;
	private String bmiCategory;
	private int selection;
	
	public int getWeight() {				
		return weight;
	}
	
	private void setWeight(int w) {
		if (w<0) {
			System.out.println("Exception: Invalid Input");
			System.exit(0);
		}
		else {
			weight=w;
		}
	}
	
	public int getHeight() {
		return height;
	}
	
	private void setHeight(int h) {
		if (h<0) {
			System.out.println("Exception: Invalid Input");
			System.exit(0);
		}
		else {
			height=h;
		}
	}
	
	public double getBmi() {
		return bmi;
	}
	
	public String getBmiCategory() {
		return bmiCategory;
	}
	
	private void calculateBmiCategory() {
		double bmiCheck = getBmi();
		if(bmiCheck<18.5) {
			bmiCategory="Underweight";
		}
		if(bmiCheck >= 18.5 && bmiCheck <= 24.9) {
			bmiCategory="Normal Weight";
			
		}
		if(bmiCheck >= 25 && bmiCheck <= 29.9) {
			bmiCategory="Overweight";
			
		}
		if(bmiCheck >= 30) {
			bmiCategory="Obesity";
			
		}
	}
	
	private void readMetricData() {
		System.out.printf("\nPlease enter your height in CENTIMETERS: ");
		setHeight(scan.nextInt());
		System.out.printf("\nPlease enter your weight in KILOGRAMS: ");
		setWeight(scan.nextInt());
	}
	
	private void readImperialData() {
		System.out.printf("\nPlease enter your height in INCHES: ");
		setHeight(scan.nextInt());
		System.out.printf("\nPlease enter your weight in POUNDS: ");
		setWeight(scan.nextInt());
	}
	
	private int readUnitType() {
		do {
			System.out.print("Please enter 1 to select imperial units. Enter 2 for metric units. ");
			selection=scan.nextInt();
		} while(selection != 1 && selection != 2);
		return selection;
	}
	
	private void readMeasurementData(int selection) {
		if (selection==1) {
			this.readImperialData();
		}
		if(selection==2) {
			this.readMetricData();		
		}
	}
	
	public void readUserData() {
		//this.readUnitType();
		int selection=readUnitType();
		this.readMeasurementData(selection);
	}
	
	public void calculateBmi() {
		if (selection==1) {
			bmi = (703*weight)/(double)(height*height);
			
		}
		if (selection==2) {
			bmi = (weight)/(double)((height/100)*(height/100));
		}
		bmi = Math.floor(bmi*100)/100;
		this.calculateBmiCategory();
	}
	
	public void displayBmi() {
		System.out.printf("\nYour BMI is: "+getBmi());
		System.out.printf("\nYour BMI category is: "+getBmiCategory());
	}
	
	public static void main (String[] args) {
		BMICalculator app = new BMICalculator();
		
		app.readUserData();
		app.calculateBmi();
		app.displayBmi();
		
	}
	
	
	
}
