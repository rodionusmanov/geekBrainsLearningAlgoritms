package homeworkAlgs03_1;

public class Main {
    public static final int lineLength = 50;
    public static void main(String[] args) {
        int[] line = LineFiller.fillLine(lineLength);
        System.out.println(BinarySearch.findCutElement(line));
    }
}
