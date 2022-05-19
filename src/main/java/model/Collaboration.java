package model;

import java.util.Date;
import java.util.Objects;

public class Collaboration {
    private int id;
    private String username;

    private String resume;
    private String project_code;
    private Date date;

    public Collaboration(String username, String resume, String project_code, Date date) {
        this.username = username;
        this.resume = resume;
        this.project_code = project_code;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getProject_code() {
        return project_code;
    }

    public void setProject_code(String project_code) {
        this.project_code = project_code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Collaboration)) return false;
        Collaboration that = (Collaboration) o;
        return id == that.id && Objects.equals(username, that.username) && Objects.equals(resume, that.resume) && Objects.equals(project_code, that.project_code) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username,resume, project_code,date);
    }
}
