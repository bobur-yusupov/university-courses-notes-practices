package music.fan;

import music.recording.Artist;

public class Fan 
{
    private final String name;
    private final Artist favourite;
    private int moneySpent;

    public Fan(String name, Artist favourite) 
    {
        this.name = name;
        this.favourite = favourite;
    }

    public String getName() 
    {
        return name;
    }

    public Artist getFavourite() 
    {
        return favourite;
    }

    public int getMoneySpent() 
    {
        return moneySpent;
    }

    public int buyMerchandise(int n, Fan[] fans)
    {
        return 0;
    }

    public boolean favesAtSameLabel(Fan fan) {
        return false;
    }

    public String toString1() {
        return null;
    }

    public String toString2() {
        return null;
    }
    public String toString3() {
        return null;
    }

    public String toString4() {
        return null;
    }
}