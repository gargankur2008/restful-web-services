package com.ankur.springboot.web.restfulwebservices.post;

public class Post {

    private int Id;

    private int userId;

    private String heading;

    private String content;

    public Post(){}

    public Post(int id, int userId, String heading, String content) {
        Id = id;
        this.userId = userId;
        this.heading = heading;
        this.content = content;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
