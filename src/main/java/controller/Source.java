package controller;

import java.util.HashMap;
import java.util.Map;

public interface Source {
  Map<String, String> data = new HashMap<String, String>();

  abstract String toString();
}
