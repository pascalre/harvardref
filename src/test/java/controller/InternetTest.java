package controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class InternetTest {

  @Test
  public void test() {
    System.out.println("InternetTest started...");

    System.out.println("---- with all parameters:");
    Internet test = new Internet("Statistisches Bundesamt Deutschland", "",
        "2006", "Fast 30% aller Kinder kamen 2005 außerehelich zur Welt", "http://www.destatis.de/presse/deutsch/pm2007/zdw4.htm",
        "25", "01", "2007");

    String expected = "Statistisches Bundesamt Deutschland (2006): Fast 30% aller Kinder kamen 2005 außerehelich zur Welt, [online] http://www.destatis.de/presse/deutsch/pm2007/zdw4.htm [25.01.2007].\r\n";
    String actual = test.toString();
    System.out.printf("Expected: %s\r\n", expected);
    System.out.printf("Actual  : %s", actual);
    assertEquals(expected, actual);

    System.out.println("Test finished!");
  }

}
