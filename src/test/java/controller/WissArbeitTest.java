package controller;

import static org.junit.Assert.*;

import org.junit.Test;
import controller.WissArbeit;

public class WissArbeitTest {

	@Test
	public void test() {
		System.out.println("WissArbeitTest started...");
		
		System.out.println("---- with all parameters:");
		WissArbeit test = new WissArbeit("Bahr", "Jonas", "2008", "Marktversagen als Rechtfertigung für ein staatliches Eingreifen in die Finanzierung von Hochschulbildung",
				"Diplomarbeit", "Volkswirtschaftslehre", "Humboldt-Universität", "Berlin");	
		
		String expected = "Bahr, Jonas (2008): Marktversagen als Rechtfertigung für ein staatliches Eingreifen in die Finanzierung von Hochschulbildung, Diplomarbeit im Fach Volkswirtschaftslehre d. Humboldt-Universität in Berlin.\r\n";
		String actual = test.toString();
		System.out.printf("Expected: %s\r\n", expected);
		System.out.printf("Actual  : %s", actual);
		assertEquals(expected, actual);

		
	}

}
