package com.ctrlcutter.frontend.util.script;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WindowsProcessKiller {

    private static final String TASKLIST = "tasklist";
    private static final String KILL = "taskkill /IM ";

    public boolean isProcessRunning(String serviceName) {
        try {
            Process process = Runtime.getRuntime().exec(TASKLIST);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(serviceName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            throw new WindowProcessKillerException("Error during file reading while checking process running status.", e);
        }

        return false;
    }

    public static void killProcess(String serviceName) {
        try {
            Runtime.getRuntime().exec(KILL + serviceName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
