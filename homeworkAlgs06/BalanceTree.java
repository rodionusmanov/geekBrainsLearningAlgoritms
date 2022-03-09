package homeworkAlgs06;

import java.util.Stack;

public class BalanceTree<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;
    private int size;

    private class NodePair {
        private Node<E> current;
        private Node<E> parent;

        public NodePair(Node<E> current, Node<E> parent) {
            this.current = current;
            this.parent = parent;
        }
    }

    @Override
    public boolean contains(E value) {
        NodePair nodePair = doFind(value);
        return (nodePair.current != null);
    }

    private NodePair doFind(E value) {
        Node<E> current = root;
        Node<E> parent = null;
        while (current != null) {
            Main.level++;
            if (Main.level == 5){
                return new NodePair(null, parent);
            }
            if (current.getValue().equals(value)) {
                return new NodePair(current, parent);
            }
            parent = current;
            if (current.isLeftChild(value)) {
                current = current.getLeftChild();
            } else if (current.isRightChild(value)) {
                current = current.getRightChild();
            }   /*repeat*/

        }
        return new NodePair(null, parent);
    }

    @Override
    public boolean add(E value) {
        NodePair nodePair = doFind(value);

        if (nodePair.current != null) {
            return false;
        }
        Node<E> parent = nodePair.parent;
        Node<E> node = new Node<>(value);

        if (isEmpty()) {
            root = node;
        } else if (parent.isLeftChild(value)) {
            parent.setLeftChild(node);
        } else {
            parent.setRightChild(node);
        }
        size++;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return 0;
    }
    public static boolean isBalancedTree(BalanceTree tree){
        return isBalanced(tree.root);
    }

    public static boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) && isBalanced(node.getRightChild()) && Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    @Override
    public void display() {
        Stack<Node<E>> stack = new Stack<>();
        stack.push(root);
        int nBlanks = 64;
        boolean isRowEmpty = false;
//        System.out.println("................................................................................................................................");

        while (!isRowEmpty) {
            Stack<Node<E>> localStack = new Stack<>();
            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }
            while (!stack.isEmpty()) {
                Node<E> temp = (Node<E>) stack.pop();
                if (temp != null) {
                    System.out.print(temp.getValue());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null || temp.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("[]");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println(" ");
            nBlanks = nBlanks / 2;
            while (!localStack.isEmpty()) {
                stack.push(localStack.pop());
            }
            System.out.println("..................................................................................................................................");
        }

    }
}
