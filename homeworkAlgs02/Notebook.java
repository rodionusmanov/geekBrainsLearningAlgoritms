package homeworkAlgs02;

public class Notebook {
    protected String maker;
    protected int price;
    protected int ram;

    public Notebook() {                         //Присвоение случайных значений параметрам ноутбука
        this.maker = RandomFill.randomMaker();  //Присвоение случайного производителя
        this.price = RandomFill.randomPrice();  //Присвоение случайной цены
        this.ram = RandomFill.randomRam();      //Присвоение случайной оперативной памяти
    }

    @Override
    public String toString() {
        return "Ноутбук с ценой: " + price + ", оперативной памятью: " + ram + ", производитель: " + maker;
    }

    public void printInfo() {
        System.out.println(toString());
    }
}
