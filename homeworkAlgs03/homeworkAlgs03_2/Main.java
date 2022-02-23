package homeworkAlgs03_2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    static Random random = new Random();
    public static void main(String[] args) {
        Queue q = new Queue(5);
        /*q.insert(1);
        System.out.println(Arrays.toString(q.queue));
        q.insert(2);
        System.out.println(Arrays.toString(q.queue));
        q.insert(3);
        System.out.println(Arrays.toString(q.queue));
        q.insert(4);
        System.out.println(Arrays.toString(q.queue));
        q.insert(5);
        System.out.println(Arrays.toString(q.queue));
        q.insert(6);
        System.out.println(Arrays.toString(q.queue));
        q.remove();
        System.out.println(Arrays.toString(q.queue));
        q.remove();
        System.out.println(Arrays.toString(q.queue));
        q.remove();
        System.out.println(Arrays.toString(q.queue));
        q.insert(7);
        System.out.println(Arrays.toString(q.queue));
        q.remove();
        System.out.println(Arrays.toString(q.queue));
        q.remove();
        System.out.println(Arrays.toString(q.queue));
        q.remove();
        System.out.println(Arrays.toString(q.queue));
        q.remove();
        System.out.println(Arrays.toString(q.queue));
        q.insert(8);
        System.out.println(Arrays.toString(q.queue));*/
        for (int i = 1; i < 20; i++) {
            if (random.nextInt(2) == 0){
                q.insert(i);
            } else {
                System.out.println(i + " : " + Arrays.toString(q.queue) + " - извлечен элемент " + q.remove());
            }
        }
    }
}
