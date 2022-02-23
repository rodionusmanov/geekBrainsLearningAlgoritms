package homeworkAlgs03_1;

public class BinarySearch {
    public static int findCutElement(int[] line) {
        int cut;
        int start = 0;
        int finish = line.length;
        int step;
        if (line.length == 0) {
            return 1;
        }
        if (line[0] != 1) {
            return 1;
        }
        if (line[line.length - 1] == line.length) {
            return line.length + 1;
        }
        while (true) {
            step = (finish + start) / 2;
            if (step == line[step - 1]) {
                if (line[step] - line[step - 1] == 2) {
                    cut = step + 1;
                    break;
                } else {
                    start = step + 1;
                }
            } else if (line[step - 1] - line[step - 2] == 2) {
                cut = step;
                break;
            } else {
                finish = step - 1;
            }
        }
        return cut;
    }
}
