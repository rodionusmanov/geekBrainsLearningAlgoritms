package homeworkAlgs06;

public class Node <T extends Comparable<? super T>>{

    private T value;
    private Node<T> leftChild;
    private Node<T> rightChild;
    private int repeat;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isLeftChild(T value) {
        return getValue().compareTo(value) > 0;
    }

    public boolean isRightChild(T value) {
        return getValue().compareTo(value) < 0;
    }



}
