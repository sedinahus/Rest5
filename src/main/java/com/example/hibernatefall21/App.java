package com.example.hibernatefall21;

import javax.persistence.*;

@Entity
@Table(name= "apptbl", schema = "myapps", catalog = "")
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
//    private String content;

    public App() {
        this.id = id;
        this.name = name;
    }

    public App(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Basic
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "App{" +
                "id=" + id +
                ", content='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        App app = (App) o;

        if (id != app.id) return false;
        if (name != null ? !name.equals(app.name) : app.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

//    @Basic
//    @Column(name = "content")
//    public String getContent() {
//        return content;
//    }

//    public void setContent(String content) {
//        this.content = content;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        App app = (App) o;
//
//        if (id != app.id) return false;
//        if (content != null ? !content.equals(app.content) : app.content != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (content != null ? content.hashCode() : 0);
//        return result;
//    }
}