package homeworkAlgs04.Deque;

public class Dequeue<E> implements Deque<E> {
    protected int size;
    protected Node<E> left;
    protected Node<E> right;

    @Override
    public void insertLeft(E value) {
        if (isEmpty()) {
            left = new Node<>(value, left, null);
            right = left;
        } else {
            Node<E> current = left;
            left = new Node<>(value, left, null);
            current.linkToLeft = left;
        }
        size++;
    }

    @Override
    public void insertRight(E value) {
        if (isEmpty()) {
            left = new Node<>(value, left, null);
            right = left;
        } else {
            Node<E> current = right;
            right = new Node<>(value, null, current);
            current.linkToRight = right;
        }
        size++;
    }

    @Override
    public void insert(E value, int index) {
        if (index == 0) {
            insertLeft(value);
            return;
        }
        if (index == size - 1) {
            insertRight(value);
            return;
        }
        int count = 0;
        Node<E> current = left;
        while (index != count) {
            current = current.linkToRight;
            count++;
        }
        size++;
        Node<E> insertion = new Node<>(value, current, current.linkToLeft);
        current.linkToLeft = insertion;

        count = 0;
        current = left;
        while (index - 1 != count) {
            current = current.linkToRight;
            count++;
        }
        current.linkToRight = insertion;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = left;
        left = removedNode.linkToRight;
        removedNode.linkToRight = null;
        removedNode.linkToLeft = null;
        size--;
        System.out.println("Удаление слева: " + removedNode.item);
        return removedNode.item;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = right;
        right = removedNode.linkToLeft;
        right.linkToRight = null;
        removedNode.linkToRight = null;
        removedNode.linkToLeft = null;
        size--;
        System.out.println("Удаление справа: " + removedNode.item);
        return removedNode.item;
    }

    @Override
    public E removeByIndex(int index) {
        int count = 0;
        Node<E> current = left;
        while (index != count) {
            current = current.linkToRight;
            count++;
        }
        Node<E> behindRevoval = current.linkToRight;
        Node<E> beforeRevoval = current.linkToLeft;
        behindRevoval.linkToLeft = beforeRevoval;
        beforeRevoval.linkToRight = behindRevoval;
        return current.item;
    }

    @Override
    public int indexOfFromLeft(E searchedItem) {
        int index = 0;
        Node<E> current = left;

        while (current.item != searchedItem) {
            current = current.linkToRight;
            index++;
        }
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder("Слева направо L[");
        Node<E> current = left;

        while (current != null) {
            sB.append(current.item);
            if (current.linkToRight != null) {
                sB.append(" -> ");
            }
            current = current.linkToRight;
        }
        return sB.append("]R").toString();
    }

    @Override
    public void displayFromLeft() {
        System.out.println(this);

    }

    public String toStringRight() {
        StringBuilder sB = new StringBuilder("Справа налево R[");
        Node<E> current = right;

        while (current != null) {
            sB.append(current.item);
            if (current.linkToLeft != null) {
                sB.append(" <- ");
            }
            current = current.linkToLeft;
        }
        return sB.append("]L").toString();
    }

    public void displayFromRight() {
        System.out.println(this.toStringRight());

    }

}