package com.kcymerys.java.kstreamprocessor;

public enum OperationType {
    ADDITION("ADDITION"),
    SUBTRACTION("SUBTRACTION"),
    MULTIPLICATION("MULTIPLICATION"),
    DIVISION("DIVISION");

    private final String type;

    private OperationType (String type) {
        this.type = type;
    }

}
