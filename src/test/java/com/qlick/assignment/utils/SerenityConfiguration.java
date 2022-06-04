package com.qlick.assignment.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public enum SerenityConfiguration {
    BASE_URL("baseUrl");

    private static EnvironmentVariables environmentVariables = Injectors.getInjector().getInstance(EnvironmentVariables.class);
    private String key;

    SerenityConfiguration(String key) {
        this.key = key;
    }

    public String value() {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(key);
    }
}
