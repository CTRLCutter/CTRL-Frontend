package com.ctrlcutter.frontend.util.rest;


public class OSUtility {

    public static String getUserOperatingSystem() {
        return System.getProperty("os.name");
    }
    
}
