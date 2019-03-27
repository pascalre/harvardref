package controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompleteWorksTest {

  @Test
  public void test() {

    System.out.println("CompleteWorksTest started...");
    
    System.out.println("---- with all parameters:");
    CompleteWorks test = new CompleteWorks("Blankart", "Charles B.",
        "2006", "Finanzen in der Demokratie",
        "irgendeinHerausgeber", "irgendeine Bindung", "6", "Munich",
        "Verlag Franz Vahlen");

    String expected = "Blankart, Charles B. (2006): Finanzen in der Demokratie, in: irgendeinHerausgeber (Hrsg.), Bd. irgendeine Bindung GA, 6. Aufl., Munich: Verlag Franz Vahlen.\r\n";
    String actual = test.toString();
    System.out.printf("Expected: %s\r\n", expected);
    System.out.printf("Actual  : %s", actual);
    assertEquals(expected, actual);

    System.out.println("\r\n---- without publisher:");
    test = new CompleteWorks("Blankart", "Charles B.",
        "2006", "Finanzen in der Demokratie",
        "", "irgendeine Bindung", "6", "Munich",
        "Verlag Franz Vahlen");

    expected = "Blankart, Charles B. (2006): Finanzen in der Demokratie, Bd. irgendeine Bindung GA, 6. Aufl., Munich: Verlag Franz Vahlen.\r\n";
    actual = test.toString();
    System.out.printf("Expected: %s\r\n", expected);
    System.out.printf("Actual  : %s", actual);
    assertEquals(expected, actual);

    System.out.println("\r\n---- without edition:");
    test = new CompleteWorks("Blankart", "Charles B.",
        "2006", "Finanzen in der Demokratie",
        "irgendeinHerausgeber", "irgendeine Bindung", "", "Munich",
        "Verlag Franz Vahlen");

    expected = "Blankart, Charles B. (2006): Finanzen in der Demokratie, in: irgendeinHerausgeber (Hrsg.), Bd. irgendeine Bindung GA, Munich: Verlag Franz Vahlen.\r\n";
    actual = test.toString();
    System.out.printf("Expected: %s\r\n", expected);
    System.out.printf("Actual  : %s", actual);
    assertEquals(expected, actual);

    System.out.println("\r\n---- without publisher and edition:");
    test = new CompleteWorks("Blankart", "Charles B.",
        "2006", "Finanzen in der Demokratie",
        "", "irgendeine Bindung", "", "Munich",
        "Verlag Franz Vahlen");

    expected = "Blankart, Charles B. (2006): Finanzen in der Demokratie, Bd. irgendeine Bindung GA, Munich: Verlag Franz Vahlen.\r\n";
    actual = test.toString();
    System.out.printf("Expected: %s\r\n", expected);
    System.out.printf("Actual  : %s", actual);
    assertEquals(expected, actual);

    System.out.println("Test finished!");
  }
}
