package model;

import java.util.Objects;

public class fullstack {

    private String name;
    private String owner;
    private String owner_contact;
    private int id;


    public fullstack(String name, String owner, String owner_contact) {
        this.name = name;
        this.owner = owner;
        this.owner_contact = owner_contact;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getOwner_contact() {
        return owner_contact;
    }
    public void setOwner_contact(String owner_contact) {
        this.owner_contact = owner_contact;
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
        fullstack fullstack = (fullstack) o;
        return id == fullstack.id &&
                Objects.equals(name, fullstack.name) &&
                Objects.equals(owner, fullstack.owner) &&
                Objects.equals(owner_contact, fullstack.owner_contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, owner, owner_contact, id);
    }
}