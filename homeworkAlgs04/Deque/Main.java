package homeworkAlgs04.Deque;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> dequeue = new Dequeue<>();
        dequeue.insertLeft(1);
        dequeue.insertLeft(2);
        dequeue.insertRight(3);
        dequeue.insertLeft(4);
        dequeue.insertLeft(5);
        dequeue.insertRight(6);
        dequeue.insertLeft(7);
        dequeue.insertRight(8);
        dequeue.displayFromLeft();
        dequeue.displayFromRight();

        System.out.println("Удаление " + dequeue.removeByIndex(6));
        dequeue.displayFromLeft();
        System.out.println("Вставка числа 9 по индексу 5");
        dequeue.insert(9, 5);
        dequeue.displayFromLeft();
        dequeue.removeLeft();
        dequeue.displayFromLeft();
        dequeue.removeRight();
        dequeue.displayFromLeft();
        System.out.println("Удаление элемента под 3 индексом");
        dequeue.removeByIndex(3);
        dequeue.displayFromLeft();

    }

}
