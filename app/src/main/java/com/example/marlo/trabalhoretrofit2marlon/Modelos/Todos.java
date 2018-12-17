package com.example.marlo.trabalhoretrofit2marlon.Modelos;

public class Todos {

    protected  Integer userId;
    protected Integer id;
    protected String title;
    protected String completed;


    public Todos(){

    }

    public Todos(Integer userId, Integer id, String title, String completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }


    @Override
    public String toString() {
        return "Todos{" +
                "userId=" + userId +
                ", id=" + id +
                ", Titulo='" + title + '\'' +
                ", Complemento='" + completed + '\'' +
                '}';
    }
}
