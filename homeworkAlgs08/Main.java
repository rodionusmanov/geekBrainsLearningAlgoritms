package homeworkAlgs08;

public class Main {
    public static void main(String[] args) {

        HashTable<Product, Integer> hashTable = new HashTableImpl<>(3);

        hashTable.put(new Product(1, "яблоко"), 10);
        hashTable.put(new Product(17, "апельсин"), 13);
        hashTable.put(new Product(21, "крыжовник"), 15);
        hashTable.put(new Product(11, "рамбутан"), 21);
        hashTable.put(new Product(112, "банан"), 17);
        hashTable.put(new Product(20, "ананас"), 94);
        hashTable.put(new Product(411, "арбуз"), 80);

        System.out.println("Size is " + hashTable.size());
        hashTable.display();

        System.out.println("Цена товара " + hashTable.get(new Product(11, "рамбутан")));
        System.out.println();
        System.out.println("Цена товара " + hashTable.get(new Product(2, "груша")));

        hashTable.remove(new Product(21, "крыжовник"));
        hashTable.display();
    }
}
