package me.anwarshahriar.webservice;

public class Human {
    private String id;
    private String name;

    public Human(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
