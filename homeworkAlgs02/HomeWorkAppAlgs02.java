package homeworkAlgs02;

import java.util.Arrays;

public class HomeWorkAppAlgs02 {
    public static int[][][] count = new int[5][6][31];  //трехмерный массив для сортировки подсчетом
    public static final int numberOfNotebooks = 10000;  //количество сравниваемых ноутбуков

    public static void main(String[] args) {
        Notebook[] notebook = new Notebook[numberOfNotebooks];
        for (int i = 0; i < numberOfNotebooks; i++) {   //Создание и заполнение списка сравниваемых ноутбуков случайными значениями
            notebook[i] = new Notebook();
            notebook[i].printInfo();
        }
        System.out.println();                           //Разделительная строка между неотсортированным и отсортированным списками

        /*count = CountingSort.countSort(notebook, numberOfNotebooks);  //Сортировка подсчетом
        PrintCountingSortedList.printCountingSorted(count);*/           //Вывод отсортированного списка

        SelectionSort.selectSort(notebook);             //Сортировка выбором
        for (int i = 0; i < numberOfNotebooks; i++) {   //Вывод отсортированного списка
            notebook[i].printInfo();
        }
    }
}
