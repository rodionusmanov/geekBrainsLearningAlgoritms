package homeworkAlgs05_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Item> resultItems;    //создание списка с переменными типа Item для итогового набора предметов
        System.out.println("Внимание! Расчет для 13+ предметов в комнате занимает от 30 секунд.\nВведите количество предметов в комнате:");
        int numberOfItems = scanner.nextInt();  //Ввод из консоли количества предметов в комнате
        ArrayList<Item> items = RoomFiller.roomFill(numberOfItems); //Создание и заполнение случайнми предметами полного списка
        int count = 0;
        while (count <= items.size() - 1) { //Вывод в консоль полного перечня предметов в комнате
            items.get(count).printInfo();
            count++;
        }
        System.out.println("Введите грузоподъемность рюкзака:");
        double weightLimit = scanner.nextDouble();  //Ввод из консоли ограничения по весу
        resultItems = HigherPrice.findHigherCost(items, count, weightLimit);    //Расчет оптимального по стоимости набора предметов
        count = 0;
        double sumWeight = 0.0;
        int sumPrice = 0;
        while (count < resultItems.size()) {        //Вывод в консоль оптимального набора предметов
            resultItems.get(count).printInfo();
            sumWeight += resultItems.get(count).weight;
            sumPrice += resultItems.get(count).price;
            count++;
        }
        System.out.println("Суммарный вес предметов в рюкзаке = " + sumWeight);
        System.out.println("Суммарная ценность предметов в рюкзаке = " + sumPrice);
        scanner.close();
    }
}