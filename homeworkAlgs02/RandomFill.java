package homeworkAlgs02;

import java.util.Random;

public class RandomFill {

    private static Random random = new Random();
    protected static String[] makerName = {"Xamiou", "Eser", "MacNote", "Asos", "Lenuvo"};  //Массив с названиями производителей

    public static String randomMaker() {                //Присвоение случайного производителя
        int randomMake = random.nextInt(5);       //Выбор случайного номера количества производителей
        return makerName[randomMake];                   //Присвоение названия производителя в соответствии с выбранным номером
    }

    public static int randomPrice() {                   //Присвоение случайной цены
        return random.nextInt(31) * 50 + 500;     //ВЫбор случайного значения из заданного интервала с заданным шагом
    }

    public static int randomRam() {                     //Присвоение случайной оперативной памяти
        return random.nextInt(1, 7) * 4;    //ВЫбор случайного значения из заданного интервала с заданным шагом
    }

}
