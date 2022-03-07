package homeworkAlgs05_2;

import java.util.*;

public class RoomFiller {
    //Заполнение списка случайными предметами
    public static ArrayList<Item> roomFill(int numberOfItems) {

        ArrayList<Item> items = new ArrayList<Item>();
        for (int i = 0; i < numberOfItems; i++) {
            items.add(new Item());
        }
        return items;
    }
}
