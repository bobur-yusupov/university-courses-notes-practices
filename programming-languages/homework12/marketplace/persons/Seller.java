package marketplace.persons;

import java.util.List;

import marketplace.droids.*;

public interface Seller {
    public int sellDroid(List<Droid> buyList);
    public int sellDroidParts(List<DroidPart> buyList);
}