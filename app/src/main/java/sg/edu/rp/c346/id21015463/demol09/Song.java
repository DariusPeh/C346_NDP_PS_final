package sg.edu.rp.c346.id21015463.demol09;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String songTitle;
    private String songSinger;
    private int songYear;
    private int songRating;

    public Song(int id, String songTitle, String songSinger, int songYear, int songRating) {
        this.id = id;
        this.songTitle = songTitle;
        this.songSinger = songSinger;
        this.songYear = songYear;
        this.songRating = songRating;
    }

    public int getId() {return id;}

    public String getSongTitle() {return songTitle;}
    public String getSongSinger() {return songSinger;}
    public int getSongYear() {return songYear;}
    public int getSongRating() {return songRating;}

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public void setSongSinger(String songSinger) {
        this.songSinger = songSinger;
    }

    public void setSongYear(int songYear) {
        this.songYear = songYear;
    }

    public void setSongRating(int songRating) {
        this.songRating = songRating;
    }

    public void getAll(int id, String songTitle, String songSinger, int songYear, int songRating)
    {this.id = id; this.songTitle = songTitle; this.songSinger = songSinger; this.songYear = songYear;
        this.songRating = songRating;}

    @Override
    public String toString() { return "ID:" + id + ", " + songTitle + ", "
            + songSinger + ", " + songYear + ", " + songRating; }


}
