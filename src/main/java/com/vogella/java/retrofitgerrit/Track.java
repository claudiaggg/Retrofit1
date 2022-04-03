package com.vogella.java.retrofitgerrit;

public class Track {
    String title;
    String singer;
    String id;

    public String getTitle() {
        return title;
    }
    public String getSinger() {
        return singer;
    }
    public String getId(){return id;}

    public void setTitle(String title){
        this.title=title;
    }
    public void setSinger(String singer){
        this.singer=singer;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setTrack(String title , String author) {
        this.title = title;
        this.singer=author;

    }

}
