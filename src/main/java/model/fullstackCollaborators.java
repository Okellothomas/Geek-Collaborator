package model;

import java.util.Objects;

public class fullstackCollaborators {

    private String name;
    private String language;
    private String contact;
    private String role;
    private int id;


    public fullstackCollaborators(String name, String language, String contact, String role) {
        this.name = name;
        this.language = language;
        this.role = role;
        this.contact = contact;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        fullstackCollaborators that = (fullstackCollaborators) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(language, that.language) &&
                Objects.equals(contact, that.contact) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, language, contact, role, id);
    }
}
