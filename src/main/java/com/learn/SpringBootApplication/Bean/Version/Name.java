package com.learn.SpringBootApplication.Bean.Version;

public class Name {
    private String firstname;
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Name(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
