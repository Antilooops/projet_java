package com.epf.core.model;

public enum Effects {
    NORMAL, SLOW_LOW;

    public static Effects fromString(String input) {
        try {
            input = input.replace(" ", "_");
            return Effects.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid Effect : " + input, e);
        }
    }
}
