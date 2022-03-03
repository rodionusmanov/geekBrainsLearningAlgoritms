package homeworkAlgs04.IteratorInsert;

import java.util.ArrayList;

public class ArrayIterator {
    ArrayList<Integer> arr;
    int index;

    public ArrayIterator(ArrayList<Integer> arr) {
        this.arr = arr;
        this.index = 0;
    }

    public boolean hasNext() {
        if (index == arr.size()) {
            return false;
        }
        return true;
    }

    public Integer next() {
        return arr.get(index++);
    }

    public boolean findNumber(int numberToFind) {
        index = 0;
        while (hasNext()) {
            if (next() == numberToFind) {
                return true;
            }
        }
        return false;
    }

    public void remove(int numberToRemove) {
        this.index = 0;
        while (hasNext()) {
            if (next() == numberToRemove) {
                arr.set(index - 1, null);
                break;
            }
        }
        index = 0;
    }

    public void removeWithDeleting(int numberToRemove) {
        while (findNumber(numberToRemove)) {
            remove(numberToRemove);
            while (next() != null) {
            }
            do {
                if (index != arr.size()) {
                    arr.set(index - 1, arr.get(index++));
                }
            } while (index != arr.size());
            arr.remove(arr.size() - 1);
        }
        index = 0;
    }

    public void insert(int numberToInsert, int positionToInsert) {
        arr.add(0);
        index = arr.size() - 1;
        while (index != positionToInsert - 1) {
            arr.set(index, arr.get(--index));
        }
        arr.set(index, numberToInsert);
        index = 0;
    }

}
