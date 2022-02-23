package homeworkAlgs03_1;

import java.util.Arrays;
import java.util.Random;

public class LineFiller {
    private static final Random random = new Random();
    public static int[] fillLine(int lineLength){
        int[] line = new int[lineLength - 1];
        int position = random.nextInt(lineLength);
/*        System.out.println(position + 1);*/
        int i = 0;
        while(i != position){
            line[i] = i + 1;
            i++;
        }
        while(i < line.length){
            line[i] = i + 2;
            i++;
        }
        System.out.println(Arrays.toString(line));
        return line;
    }
}
