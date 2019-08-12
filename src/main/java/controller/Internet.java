package controller;

public class Internet extends Source {

  public Internet(String name, String forename, String year, String title, String link, String retrievalDay,
      String retrievalMonth, String retrievalYear) {
    data.put("name", name);
    data.put("forename", forename);
    data.put("year", year);
    data.put("title", title);
    data.put("link", link);
    data.put("retrievalDay", retrievalDay);
    data.put("retrievalMonth", retrievalMonth);
    data.put("retrievalYear", retrievalYear);
  }

  public String toString() {
    if (data.isEmpty())
      return "Error. Objekt nicht korrekt erstellt.";

    StringBuilder sb = new StringBuilder("");
    String name = data.get("name");
    String forename = data.get("forename");
    String year = data.get("year");
    String title = data.get("title");
    String link = data.get("link");
    String retrievalDay = data.get("retrievalDay");
    String retrievalMonth = data.get("retrievalMonth");
    String retrievalYear = data.get("retrievalYear");

    if (!name.isEmpty()) {
      sb.append(name);
      if (!forename.isEmpty())
        sb.append(", " + forename);
    }

    if (!year.isEmpty())
      sb.append(" (" + year + ")");

    sb.append(": ");

    sb.append(title + ", [online] " + link + " [" + retrievalDay + "." + retrievalMonth + "." + retrievalYear
        + "].\r\n");
    return sb.toString();
  }
}
