package labTerminalB;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
		private String _name;
		private Vector<Rental> _rentals = new Vector<Rental>();
		public Customer (String name){
			_name = name;
		};
		public void addRental(Rental arg) {
			_rentals.addElement(arg);
		}
		public String getName (){
			return _name;
		};
		
		/*
		 * TODO 4
		 * Identify the bad smells in the statement method and refactor the code
		 * In case you add a new method also provide specifications for new method
		 * after refactoring all test cases must still be passed
		 * Commit after each change and include a meaningful message about the change you made
		 * e.g. Method Move methodName();
		 * 
		 */
		
		/**
		 * 
		 * The statement method going to calculate total amount of movies with perspective of Regular, NewRelease, Childrens.
		 * The statement method in refactoring stage will Extract Method, Renaming, Move Method and Replace Temp With Query. We end up with better code that enable us to easily add the implementation for a HTML statement.
         * Three cases created using amountFor method (RegularPrice, NewReleasePrice and Childrens Price) all extending an abstract Price class. Movie uses this class and the charge calculation is moved to it. Then, you can start to override the implementation of this calculation. The same is done with the frequent renter points calculation.
		 * 
		 * @param (it doesn't take any parameter)
		 * @return string that contain total amounts and renter points
		 * 
		 **/
		public String statement() {
			Enumeration rentals = _rentals.elements();
			String result = "Rental Record for " + getName() + "\n";
			while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle()+ "\t" +
			String.valueOf(each.getCharge()) + "\n";
			}
			//add footer lines
			result += "Amount owed is " +
			String.valueOf(getTotalCharge()) + "\n";
			result += "You earned " +
			String.valueOf(getTotalFrequentRenterPoints()) +
			" frequent renter points";
			return result;
			}
			
		private double getTotalCharge() {
		double result=0;
		Enumeration<Rental>rentals=_rentals.elements();
		while(rentals.hasMoreElements()){
			Rental each=(Rental)rentals.nextElement();
			result+=each.getCharge();
			
		}
		return result;
		}
			private int getTotalFrequentRenterPoints(){
			int result = 0;
			Enumeration rentals = _rentals.elements();
			while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getFrequentRenterPoints();
			}
			return result;
			}
	}
