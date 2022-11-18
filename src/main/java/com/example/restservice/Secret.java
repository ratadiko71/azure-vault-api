package com.example.restservice;

public class Secret {
    private final String key;
    private final String value;
    public Secret( String key, String value) {
        this.value = value;
        this.key = key;
    }
    public String getValue() {
        return value;
    }
    public String getKey() {
        return  key;
    }
}
