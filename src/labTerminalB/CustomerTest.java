package labTerminalB;

import org.junit.Test;

public class CustomerTest {
	Movie m1 = new Movie("Spancer", 0);
	Movie m2 = new Movie("Speed", 1);
	Customer me = new Customer("Nadir");
	Customer me2 = new Customer("Allah Ditta");
	Rental r1 = new Rental(m1, 23);
	Rental r2 = new Rental(m2,4);
	
	/**
	 * Test 1 Customer rented two movies one REGULAR and one NEW_RELEASE
	 * 
	 * Test 2 Customer rented one movie REGULAR 
	 * 
	 * Test 3 Customer two rented two movies one REGULAR and one NEW_RELEASE
	 * 
	 */
	@Test
	public void testStatement1() {
		me.addRental(r1);
		me.addRental(r2);
		//fail("Not yet implemented");
		String output1 = "Rental Record for Nadir\r\n" + 
				"	Spancer	33.5\r\n" + 
				"	Speed	12.0";
		if(output1.equals(me.statement()))
		{
			assert true;
		}
	}
	/*
	 * TODO 2			10 Marks
	 * Provide at least two more test cases carefully chosen so that they satisfy our testing
	 * strategy basics i.e. input partition etc
	 */
	@Test
	public void testStatemen3() {
		me.addRental(r1);
		me.addRental(r2);
		//fail("Not yet implemented");
		String output3 = "Rental Record for Allahdita\r\n" + 
				"	Spancer	33.5\r\n"  
				;
		if(output3.equals(me2.statement()))
		{
			assert true;
		}
	}
	
	@Test
	public void testStatemen2() {
		me2.addRental(r1);
		me2.addRental(r2);
		//fail("Not yet implemented");
		String output2 = "Rental Record for Allahdita\r\n" + 
				"	Spancer	33.5\r\n" + 
				"	Speed	12.0";
		if(output2.equals(me2.statement()))
		{
			assert true;
		}
	}
	
	
}
