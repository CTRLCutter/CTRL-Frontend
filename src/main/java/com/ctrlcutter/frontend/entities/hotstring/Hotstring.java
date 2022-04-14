package com.ctrlcutter.frontend.entities.hotstring;

import java.util.ArrayList;
import java.util.List;

public class Hotstring {

    private List<String> options;
    private String command;
    private String outputValue;

    public Hotstring(String command, String outputValue) {
        this(new ArrayList<>(), command, outputValue);
    }

    public Hotstring(List<String> options, String command, String outputValue) {
        this.options = options;
        this.command = command;
        this.outputValue = outputValue;
    }

    public String getStringRepresentation() {
        StringBuilder hotstringStringValueBuilder = new StringBuilder();
        hotstringStringValueBuilder.append(command);
        hotstringStringValueBuilder.append(" -> ");
        hotstringStringValueBuilder.append(outputValue);

        if (options.size() > 0) {
            hotstringStringValueBuilder.append(System.lineSeparator());
            hotstringStringValueBuilder.append("Options: ");
            hotstringStringValueBuilder.append(options);
            // TODO Deconstruct Hotstring Options to clear readable values...
        }

        return hotstringStringValueBuilder.toString();
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCommand() {
        return command;
    }

    public String getOutputValue() {
        return outputValue;
    }
}
