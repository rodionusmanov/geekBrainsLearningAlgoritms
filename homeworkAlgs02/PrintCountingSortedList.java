package homeworkAlgs02;

public class PrintCountingSortedList {
    public static void printCountingSorted(int[][][] count) {
        for (int i = 0; i < 31; i++) {                          //Цикл проходящий по цене
            for (int j = 0; j < 6; j++) {                       //Цикл проходящий по оперативной памяти
                for (int k = 0; k < 5; k++) {                   //Цикл проходящий по производителю
                    for (int l = 0; l < count[k][j][i]; l++) {  //Печать в консоль каждой конфигурации такое число раз,
                                                                //которое указано в соответствующей этой конфигурации переменной трехмерного массива
                        System.out.println("Ноутбук с ценой: " + ((i * 50) + 500) + ", оперативной памятью: " + (j + 1) * 4 + ", производитель: " + RandomFill.makerName[k]);
                    }
                }
            }
        }
    }
}
