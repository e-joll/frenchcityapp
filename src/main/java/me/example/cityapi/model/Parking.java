package me.example.cityapi.model;

public class Parking {
    private String name;
    private int availableSpaces;
    private int userSpaces;

    public Parking(String name, int availableSpaces, int userSpaces) {
        this.name = name;
        this.availableSpaces = availableSpaces;
        this.userSpaces = userSpaces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailableSpaces() {
        return availableSpaces;
    }

    public void setAvailableSpaces(int availableSpaces) {
        this.availableSpaces = availableSpaces;
    }

    public int getUserSpaces() {
        return userSpaces;
    }

    public void setUserSpaces(int userSpaces) {
        this.userSpaces = userSpaces;
    }
} 