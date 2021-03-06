package sweeper;

import java.util.ArrayList;

public class Ranges {
    private static Coord size;
    private static ArrayList<Coord> allCords;

    static void setSize(Coord _size) {
        size = _size;
        allCords = new ArrayList<Coord>();
        for (int y = 0; y < size.y; y++)
            for (int x = 0; x < size.x; x++)
                allCords.add(new Coord(x, y));
    }
    public static Coord getSize() {
        return size;
    }
    public static ArrayList<Coord> getAllCords() {
        return allCords;
    }
    static  boolean inRange (Coord coord){
        return  coord.x >= 0 && coord.x < size.x &&
                coord.y >= 0 && coord.y < size.y;
    }
}

