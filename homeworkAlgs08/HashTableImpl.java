package homeworkAlgs08;

import java.util.ArrayList;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private final ArrayList<Item<K, V>>[] data;
    private final Item<K, V> notExisted;
    private int size;

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "\nтовар: " + key + ", цена: " + value;
        }
    }

    public HashTableImpl(int initialCapacity) {
        this.data = new ArrayList[initialCapacity * 2];
        notExisted = new Item<>(null, null);
    }

    public HashTableImpl() {
        this.data = new ArrayList[16];
        notExisted = new Item<>(null, null);
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }

        int index = hashFunc(key);

        if (data[index] == null) {
            Item<K, V> itemToAdd = new Item<>(key, value);
            data[index] = new ArrayList<>();
            data[index].add(itemToAdd);
        } else if (data[index] != null) {
            Item<K, V> itemToAdd = new Item<>(key, value);
            data[index].add(itemToAdd);
        }
        size++;

        return true;
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        if (data[index] == null) {
            System.out.println("Товара нет в базе данных");
            return notExisted.getValue();
        }
        for (int i = 0; i < data[index].size(); i++) {
            if (data[index].get(i).key.equals(key)) {
                return data[index].get(i).getValue();
            }
        }
        System.out.println("Товара нет в базе данных");
        return notExisted.getValue();
    }

    @Override
    public V remove(K key) {

        int index = hashFunc(key);
        if (data[index] == null) {
            System.out.println("Товара нет в базе данных");
            return notExisted.getValue();
        }
        Item<K, V> removed = null;
        for (int i = 0; i < data[index].size(); i++) {
            if (data[index].get(i).key.equals(key)) {
                removed = data[index].get(i);
                if (data[index].size() == 1) {
                    data[index] = null;
                } else {
                    data[index].remove(i);
                }
                break;
            }
            if (i == data[index].size() - 1) {
                System.out.println("Товара нет в базе данных");
                return notExisted.getValue();
            }
        }

        return removed.getValue();
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
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%s = [%s]%n", i, data[i]));
        }
        return sb.toString();
    }
}
