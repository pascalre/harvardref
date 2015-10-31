package controller;

import java.util.HashMap;
import java.util.Map;

public interface Quelle {
	Map<String, String> data = new HashMap<String, String>();
	abstract String toString();
}
