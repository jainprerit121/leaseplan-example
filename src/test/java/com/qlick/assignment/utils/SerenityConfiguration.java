package com.qlick.assignment.utils;

import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public enum SerenityConfiguration {
    BASE_URL("baseUrl");

    private static final String ENVIRONMENT = "environment";
    private static final String SELECTED = "selected";
    private static final String DOT = ".";

    private static EnvironmentVariables environmentVariables = Injectors.getInjector().getInstance(EnvironmentVariables.class);
    private String key;

    SerenityConfiguration(String key) {
        this.key = key;
    }

    public String value() {
        String selectedEnvironment = environmentVariables.getProperty(ENVIRONMENT + DOT + SELECTED);
        return environmentVariables.getProperty(ENVIRONMENT + DOT + selectedEnvironment + DOT + key);
    }
}
