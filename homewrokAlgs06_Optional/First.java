package homewrokAlgs06_Optional;

import java.math.BigInteger;

public class First {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("600851475143");
//        BigInteger a = new BigInteger("600851475674");
        BigInteger remains = a;
        BigInteger devider = new BigInteger("2");
        while (remains.compareTo(devider) >= 0) {
            if (remains.remainder(devider) == BigInteger.valueOf(0)) {
                System.out.println(devider);
                remains = remains.divide(devider);
            } else {
                devider = devider.add(BigInteger.valueOf(1));
            }
        }
        System.out.printf("Наибольший простой делитель числа %s - %s", a, devider);
    }
}
