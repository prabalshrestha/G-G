package com.bookstore.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class USConstants {

    public final static String US = "US";

    public final static Map<String, String> mapOfUSStates = new HashMap<String, String>() {
        {
            put("Province No. 1", "Province No. 1");
            put("Province No. 2", "Province No. 2");
            put("Bagmati", "Bagmati Province");
            put("Gandaki", "Gandaki Province");
            put("Lumbini", "Lumbini Province");
            put("Karnali", "Karnali Province");
            put("Sudurpashchim", "Sudurpashchim Province");
            
        }
    };

    public final static List<String> listOfUSStatesCode = new ArrayList<>(mapOfUSStates.keySet());
    public final static List<String> listOfUSStatesName = new ArrayList<>(mapOfUSStates.values());
}
