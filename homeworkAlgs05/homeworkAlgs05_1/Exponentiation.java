package homeworkAlgs05_1;

public class Exponentiation {
    public static double exponentiation(int number, int exp){
        if (exp == 0) {
            return 1.0;
        } else if (exp > 0) {
            return posExponentiation(number, exp);
        } else {
            return negExponentiation(number, exp);
        }
    }

    private static double negExponentiation(int number, int exp) {
        if (exp == 0){
            return 1;
        }
        return negExponentiation(number, ++exp) / number;
    }

    private static double posExponentiation(int number, int exp) {
        if (exp == 0){
            return 1.0;
        }
        return number * posExponentiation(number, --exp);
    }
}
