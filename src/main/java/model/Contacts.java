package model;

import java.util.Objects;

public class Contacts {

    private String name;
    private String email;
    private String subject;
    private String message;
    private int id;

    public Contacts(String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.id = id;
    }

    public Contacts(String name, String email, String subject, String message, int id) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts contacts = (Contacts) o;
        return id == contacts.id &&
                Objects.equals(name, contacts.name) &&
                Objects.equals(email, contacts.email) &&
                Objects.equals(subject, contacts.subject) &&
                Objects.equals(message, contacts.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, subject, message, id);
    }
}

