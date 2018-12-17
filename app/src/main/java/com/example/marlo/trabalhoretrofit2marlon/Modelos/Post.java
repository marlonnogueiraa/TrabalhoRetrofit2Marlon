package com.example.marlo.trabalhoretrofit2marlon.Modelos;

public class Post {

    protected String userId ;
    protected  String id ;
    protected String title ;
    protected  String body ;




    public Post(String userId, String id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
            "userId=" + userId +"\n"+
                ", id=" + id + "\n"+
                ", Titulo='" + title + "\n" +
                ", Corpo='" + body + "\n" +
                '}';
    }
}
