package domain;

import java.io.Serializable;
import java.util.Objects;


public class Homework implements Serializable {
    private int id;
    private String name;
    private String context;

    private Course course;

    public Homework(int id, String name, String context, Course course) {
        this.id = id;
        this.name = name;
        this.context = context;
        this.course = course;
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Homework homework = (Homework) o;
        return id == homework.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
