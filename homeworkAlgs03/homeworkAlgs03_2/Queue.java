package homeworkAlgs03_2;

import java.util.Arrays;

public class Queue {
    private int maxSize;
    protected int[] queue;
    private int front;
    private int rear;
    private int items;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.items = 0;
    }

    public void insert(int i) {
        if (this.isFull()) {
            System.out.println("Очередь заполнена, нет возможности добавить элемент");
        } else {
            if (rear == maxSize - 1) {
                rear = -1;
            }
            queue[++rear] = i;
            items++;
            System.out.println(i + ": " + Arrays.toString(this.queue) + " - добавлен элемент " + i);
        }
    }

    public int remove() {
        if (this.isEmpty()) {
            System.out.println("Очередь пуста, нет возможности извлечь элемент");
            return 0;
        } else {
            int temp = queue[front];
            this.queue[front] = 0;
            if (front == maxSize - 1) {
                this.front = -1;
            }
            this.front++;
            this.items--;
            return temp;
        }
    }

    public int peek() {
        return queue[front];
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }

}
