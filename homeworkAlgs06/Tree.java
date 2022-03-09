package homeworkAlgs06;

public interface Tree<E extends Comparable<? super E>> {

    boolean contains(E value);

    boolean add(E value);

    boolean isEmpty();

    int size();

    void display();
}
