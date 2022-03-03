package homeworkAlgs04.IteratorInsert;

import java.util.ArrayList;

public class Main {
    private static final int numOfElements = 13;
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList();
        for (int i = 0; i < numOfElements; i++) {
            arr.add(i % 5);
        }

        ArrayIterator arrayIterator = new ArrayIterator(arr);
        while(arrayIterator.hasNext()){
            System.out.println(arrayIterator.next());
        }

        System.out.println();
        arrayIterator.removeWithDeleting(2);
        while(arrayIterator.hasNext()){
            System.out.println(arrayIterator.next());
        }

        System.out.println();
        arrayIterator.insert(6,4);
        while(arrayIterator.hasNext()){
            System.out.println(arrayIterator.next());
        }
    }
}
