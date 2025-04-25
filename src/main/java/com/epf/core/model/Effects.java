package com.epf.core.model;

import com.epf.core.exception.BadAttributeException;

public enum Effects {
    NORMAL, SLOW_LOW, SLOW_MEDIUM, SLOW_STOP;

    public static Effects fromString(String input) {
        try {
            String output = input.replace(" ", "_");
            return Effects.valueOf(output.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BadAttributeException("Invalid Effect : " + input, e);
        }
    }

    public static String intoString(Effects input) {
        try {
            String output = input.toString();
            output = output.replace("_", " ");
            return output.toLowerCase();
        } catch (IllegalArgumentException e) {
            throw new BadAttributeException("Invalid Effect : " + input, e);
        }
    }
}
