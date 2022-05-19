package model;

import java.util.Objects;

public class Developers {

    private int id;
    private String name;
    private String email;
    private String password;

    public Developers(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developers developer = (Developers) o;
        return id == developer.id && name.equals(developer.name) && email.equals(developer.email) && password.equals(developer.password);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
