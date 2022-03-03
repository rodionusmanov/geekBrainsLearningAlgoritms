package homeworkAlgs04.Deque;

public interface Deque<E> {

    void insertLeft(E value);

    void insertRight(E value);

    void insert(E value, int index);

    E removeLeft();

    E removeRight();

    E removeByIndex(int index);

    int indexOfFromLeft(E value);

    int size();

    boolean isEmpty();

    void displayFromLeft();

    void displayFromRight();

    class Node<E> {
        E item;
        Node<E> linkToRight;
        Node<E> linkToLeft;

        public Node(E item, Node<E> linkToRight, Node<E> linkToLeft) {
            this.item = item;
            this.linkToRight = linkToRight;
            this.linkToLeft = linkToLeft;
        }
    }
}
