package hust.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> trackList = new ArrayList<>();
    private int length = -1;

    CompactDisc(String title, String artist, String category, double cost, String director, int length) {
        setTitle(title);
        setCost(cost);
        setCategory(category);
        setDirector(director);
        setLength(length);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        trackList.add(track);
    }

    public void addTracks(ArrayList<Track> tracks) {
        trackList.addAll(tracks);
    }

    public void removeTrack(Track track) {
        trackList.remove(track);
    }

    public void removeTracks(ArrayList<Track> tracks) {
        trackList.removeAll(tracks);
    }

    public int getLength(){
        if(length == -1) {
            length = 0;
            for (Track track : trackList) {
                length += track.getLength();
            }
        }
        return length;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {return this.artist;}
    public void play(){
        System.out.println("Playing " + getTitle() + " by " + getArtist() + ": ");
        for(Track track : trackList) {
            track.play();
        }
    }
}
