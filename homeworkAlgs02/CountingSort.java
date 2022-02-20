package homeworkAlgs02;

public class CountingSort {

    public static int[][][] countSort(Notebook[] notebook, int numberOfNotebooks) {
        int[][][] count = new int[5][6][31];    //Инициализация трехмерного массива
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 5; k++) {
                    count[k][j][i] = 0;
                }
            }

        }
        for (int i = 0; i < numberOfNotebooks; i++) {   //Заполнение трехмерного массива количеством экземпляров соответствующих каждой возможной конфигурации ноутбука
            outerloop:
            for (int j = 0; j < 31; j++) {              //Цикл проходящий по цене
                for (int k = 0; k < 6; k++) {           //Цикл проходящий по оперативной памяти
                    for (int l = 0; l < 5; l++) {       //Цикл проходящий по производителю
                        if ((notebook[i].price == (j * 50) + 500) && (notebook[i].ram == (k + 1) * 4) && (notebook[i].maker == RandomFill.makerName[l])) {
                            count[l][k][j]++;           //Увеличение соответсвующей переменной при полном совпадении конфигурации проверяемого экземпляра
                            break outerloop;            //Прерывание итерации массива проходящего по цене при совпадении конфигурации данного ноутбука с искомой
                        }
                    }
                }
            }
        }
        return count;                                   //Возвращение трехмерного массива с количеством экземпляров каждой конфигурации
    }
}
