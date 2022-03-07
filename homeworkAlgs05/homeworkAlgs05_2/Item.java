package homeworkAlgs05_2;

import java.util.Random;

public class Item implements Cloneable {

    Random random = new Random();
    String[] namePool = {"Тарелка", "Вилка", "Ложка", "Телевизор", "Ноутбук", "Микроволновка", "Смартфон", "Статуэтка", "Драгоценность", "Сладкий рулет"};

    String name;
    int price;
    Double weight;

    public Item() {
        this.name = namePool[random.nextInt(10)];
        this.price = random.nextInt(100) * 10 + 10;
        this.weight = Math.ceil((random.nextInt(79) * 0.1 + 0.1) * 10) / 10;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Предмет: " + name + ", ценность: " + price + ", вес: " + weight;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
