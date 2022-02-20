package homeworkAlgs02;

public class SelectionSort {
    public static Notebook[] selectSort(Notebook[] notebook) {
        for (int i = 0; i < notebook.length; i++) {     //Цикл на каждую итерацию задающий позицию и начальное значение
            Notebook min = notebook[i];                 //минимального и максимального элементов
            int minPosition = i;
            Notebook max = notebook[notebook.length - i - 1];
            int maxPosition = notebook.length - i - 1;
            boolean isArrayChanged = false;              //Переменная, отмечающая изменение позиций в списке ноутбуков
            for (int j = i + 1; j < notebook.length - i - 1; j++) { //Вложенный цикл, ищущий минимально и максимально возможные эелементы внутри неотсортированной части списка
                if (isLowerMin(min, notebook[j])) {                 //Проверка на минимальный элемент
                    min = notebook[j];                              //Отметка значения минимального элемента
                    minPosition = j;                                //Отметка позиции минимального элемента
                    isArrayChanged = true;                          //Отметка о предстоящем изменении списка
                }
                if (isHigherMax(max, notebook[j])) {                //Проверка на минимальный элемент
                    max = notebook[j];                              //Отметка значения максимального элемента
                    maxPosition = j;                                //Отметка позиции максимального элемента
                    isArrayChanged = true;                          //Отметка о предстоящем изменении списка
                }
            }
            if (isArrayChanged) {   //Проверка состояния отметки о предстоящем изменении списка
                Notebook tempNotebook = notebook[minPosition];              //Обмен найденного минимального элемента с элементом,
                notebook[minPosition] = notebook[i];                        //занимающим отведенную под минимальный элемент позицию
                notebook[i] = tempNotebook;
                tempNotebook = notebook[maxPosition];                       //Обмен найденного максимального элемента с элементом,
                notebook[maxPosition] = notebook[notebook.length - i - 1];  //занимающим отведенную под максимальный элемент позицию
                notebook[notebook.length - i - 1] = tempNotebook;
            } else {
                break;              //При состоянии отметки "false" список считается отсортированным и цикл прерывается
            }
        }
        return notebook;            //Возвращение отсортированного списка
    }


    private static boolean isLowerMin(Notebook min, Notebook currentNotebook) { //Проверка на минимальный элемент
        if (min.price > currentNotebook.price) {
            return true;
        } else if (min.price == currentNotebook.price && min.ram > currentNotebook.ram) {   //Проверка на минимальный элемент при равенстве цен
            return true;
        } else                              //Проверка на минимальный элемент при равенстве цен и оперативной памяти
            if (min.price == currentNotebook.price && min.ram == currentNotebook.ram && getNumberOfMaker(min.maker) > getNumberOfMaker(currentNotebook.maker)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isHigherMax(Notebook max, Notebook currentNotebook) {    //Проверка на максимальный элемент
        if (max.price < currentNotebook.price) {
            return true;
        } else if (max.price == currentNotebook.price && max.ram < currentNotebook.ram) {   //Проверка на максимальный элемент при равенстве цен
            return true;
        } else                              //Проверка на максимальный элемент при равенстве цен и оперативной памяти
            if (max.price == currentNotebook.price && max.ram == currentNotebook.ram && getNumberOfMaker(max.maker) < getNumberOfMaker(currentNotebook.maker)) {
            return true;
        } else {
            return false;
        }
    }

    private static int getNumberOfMaker(String maker) { //Метод возвращающий порядковый номер производителя из списка в виде числа
        for (int i = 0; i < 5; i++) {
            if (maker == RandomFill.makerName[i]) {
                return i;
            }
        }
        return 4;
    }
}
