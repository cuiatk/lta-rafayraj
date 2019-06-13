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
		 * TODO 4		20 Marks
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
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
			//determine amounts for each line
			thisAmount = amountFor(thisAmount, each);
			// add frequent renter points
			frequentRenterPoints ++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&&
					each.getDaysRented() > 1) frequentRenterPoints ++;
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle()+ "\t" +
					String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) +
				"\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
		+
		" frequent renter points";
		return result;
	}
		private double amountFor(double result, Rental aRental) {
			switch (aRental.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				result += 2;
				if (aRental.getDaysRented() > 2)
					result += (aRental.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				result += aRental.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				result += 1.5;
				if (aRental.getDaysRented() > 3)
					result += (aRental.getDaysRented() - 3) * 1.5;
				break;
			}
			return result;
		}
}
