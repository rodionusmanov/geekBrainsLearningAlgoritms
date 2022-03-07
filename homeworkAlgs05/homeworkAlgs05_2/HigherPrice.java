package homeworkAlgs05_2;

import java.util.ArrayList;

public class HigherPrice {

    public static ArrayList<Item> findHigherCost(ArrayList<Item> items, int numberOfItems, double weightLimit) throws CloneNotSupportedException {

        if (lastItemInWeightLimit(items, weightLimit)) { //Проверка на случай единственного оставшегося предмета в списке
            return items;
        }
        if (lastItemOutOfWeightLimit(items, weightLimit)) {
            items.get(0).price = 0;
            return items;
        }

        if (currentItemsInWeightLimit(items, weightLimit)) { //Проверка на удовлетворение условиям ограничения веса
            return items;
        }

        ArrayList<Item> maxItems = new ArrayList<>();
        int maxPrice = 0;

        for (int i = 0; i < items.size(); i++) {        //Цикл, на каждую итерацию создающий список клонов предметов
                                                        //исключая предмет с номером итерации
            ArrayList<Item> clonedItems = new ArrayList<>();
            for (int j = 0; j < items.size(); j++) {    //Цикл заполнения нового списка клонами предметов исключая i-й
                if (j != i) {
                    Item clonedItem = (Item) items.get(j).clone();
                    clonedItems.add(clonedItem);
                }
            }

            int currentPrice = 0;
            clonedItems = findHigherCost(clonedItems, clonedItems.size(), weightLimit); //Рекурсивая часть
            for (int j = 0; j < clonedItems.size(); j++) {  //Цикл высчитывающий суммарную стоимость предметов,
                                                            //возвращенных из рекурсивной части
                currentPrice += clonedItems.get(j).price;
            }
            if (currentPrice >= maxPrice) {     //Сравнение стоимости полученного списка предметов с актуальной максимальной
                maxPrice = currentPrice;
                maxItems = clonedItems;
            }
        }
        return maxItems;    //Возврат списка с максимальной стоимостью
    }

    //Проверка суммарного веса предметов в списке на соответствие весовому ограничению
    private static boolean currentItemsInWeightLimit(ArrayList<Item> items, double weightLimit) {
        double sumWeight = 0.0;
        for (int i = 0; i < items.size(); i++) {
            sumWeight += items.get(i).weight;
        }
        if (sumWeight <= weightLimit) {
            return true;
        }
        return false;
    }

    //Проверка последнего предмета в списке на несоответствие весовому ограничению
    private static boolean lastItemOutOfWeightLimit(ArrayList<Item> items, double weightLimit) {
        if (items.size() == 1) {
            if (items.get(0).weight > weightLimit) {
                return true;
            }
        }
        return false;
    }

    //Проверка последнего предмета в списке на соответствие весовому ограничени
    private static boolean lastItemInWeightLimit(ArrayList<Item> items, double weightLimit) {
        if (items.size() == 1) {
            if (items.get(0).weight <= weightLimit) {
                return true;
            }
        }
        return false;
    }

}
