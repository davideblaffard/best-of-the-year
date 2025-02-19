package org.lessons.java.bestof.best_of_the_year.models;

public class Song {
    private int id;
    private String title;


    public Song(int id, String title){
        this.id = id;
        this.title = title;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
