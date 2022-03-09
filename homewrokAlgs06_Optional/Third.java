package homewrokAlgs06_Optional;

import java.io.*;

public class Third {
    static String[] numbers = new String[3];

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/library/chisla.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);


            int count = 0;
            String line = reader.readLine();
            while (line != null) {
                numbers[count++] = line;
                line = reader.readLine();
            }
            fr.close();
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        char[] firstLine = numbers[0].toCharArray();
        char[] secondLine = numbers[1].toCharArray();
        byte sumFormat = checkSignFormat(firstLine[0], secondLine[0]);
        int maxLength = calculateLength(numbers);

        if (sumFormat == 0) {
            int[] thirdLine = calculateAnswer0(firstLine, secondLine, maxLength);
            numbers[2] = answerToString(thirdLine);
            try (FileWriter fw = new FileWriter("src/main/resources/library/chisla.txt", true)) {
                fw.append("\n");
                fw.write(numbers[2]);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (sumFormat == 1) {
            int[] thirdLine = calculateAnswer1(firstLine, secondLine, maxLength);
            numbers[2] = answerToString1(thirdLine);
            try (FileWriter fw = new FileWriter("src/main/resources/library/chisla.txt", true)) {
                fw.append("\n");
                fw.write(numbers[2]);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (sumFormat == 2) {
            int[] thirdLine = calculateAnswer1(secondLine, firstLine, maxLength);
            numbers[2] = answerToString1(thirdLine);
            try (FileWriter fw = new FileWriter("src/main/resources/library/chisla.txt", true)) {
                fw.append("\n");
                fw.write(numbers[2]);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (sumFormat == 3) {
            int[] thirdLine = calculateAnswer3(firstLine, secondLine, maxLength);
            numbers[2] = answerToString(thirdLine);
            try (FileWriter fw = new FileWriter("src/main/resources/library/chisla.txt", true)) {
                fw.append("\n");
                fw.append('-');
                fw.write(numbers[2]);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /*int[] thirdLine = calculateAnswer(firstLine, secondLine, maxLength, sumFormat);
        numbers[2] = answerToString(thirdLine);*/
        /*try (FileWriter fw = new FileWriter("src/main/resources/library/chisla.txt", true)) {
            fw.append("\n");
            fw.write(numbers[2]);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }



    private static int[] calculateAnswer0(char[] firstLine, char[] secondLine, int maxLength) {
        int[] thirdLine = new int[maxLength];
        int temp = 0;
        int fLine;
        int sLine;
        for (int i = 0; i < maxLength; i++) {
            if (firstLine.length - 1 - i >= 0) {
                fLine = Character.getNumericValue(firstLine[firstLine.length - 1 - i]);
            } else {
                fLine = 0;
            }
            if (secondLine.length - 1 - i >= 0) {
                sLine = Character.getNumericValue(secondLine[secondLine.length - 1 - i]);
            } else {
                sLine = 0;
            }
            thirdLine[thirdLine.length - 1 - i] += temp;
            thirdLine[thirdLine.length - 1 - i] += fLine + sLine;
            temp = thirdLine[thirdLine.length - 1 - i] / 10;
            thirdLine[thirdLine.length - 1 - i] %= 10;
        }
        return thirdLine;
    }

    private static int[] calculateAnswer1(char[] firstLine, char[] secondLine, int maxLength) {
        int[] thirdLine = new int[maxLength];
        int temp = 0;
        int fLine;
        int sLine;

        if (firstLine.length - 1 > secondLine.length) {
            for (int i = 0; i < maxLength; i++) {
                if (firstLine.length - 1 - i > 0) {
                    fLine = Character.getNumericValue(firstLine[firstLine.length - 1 - i]);
                } else {
                    fLine = 0;
                }
                if (secondLine.length - 1 - i >= 0) {
                    sLine = Character.getNumericValue(secondLine[secondLine.length - 1 - i]);
                } else {
                    sLine = 0;
                }
                fLine += temp;
                if (sLine > fLine) {
                    thirdLine[thirdLine.length - 1 - i] = (fLine + 10 - sLine);
                    temp = -1;
                } else {
                    thirdLine[thirdLine.length - 1 - i] = (fLine - sLine);
                    temp = 0;
                }
            }
            thirdLine[0] = -1;
            return thirdLine;
        }
        else if (firstLine.length - 1 < secondLine.length){
            for (int i = 0; i < maxLength; i++) {
                if (firstLine.length - 1 - i > 0) {
                    fLine = Character.getNumericValue(firstLine[firstLine.length - 1 - i]);
                } else {
                    fLine = 0;
                }
                if (secondLine.length - 1 - i >= 0) {
                    sLine = Character.getNumericValue(secondLine[secondLine.length - 1 - i]);
                } else {
                    sLine = 0;
                }
                sLine += temp;
                if (fLine > sLine) {
                    thirdLine[thirdLine.length - 1 - i] = (sLine + 10 - fLine);
                    temp = -1;
                } else {
                    thirdLine[thirdLine.length - 1 - i] = (sLine - fLine);
                    temp = 0;
                }
            }
            return thirdLine;
        } else {
            int count = 0;
            boolean even = true;
            while (even){
                if(Character.getNumericValue(firstLine[count + 1]) == Character.getNumericValue(secondLine[count])){
                    count++;
                } else if (Character.getNumericValue(firstLine[count + 1]) > Character.getNumericValue(secondLine[count])) {
                    for (int i = 0; i < maxLength; i++) {
                        if (firstLine.length - 1 - i > 0) {
                            fLine = Character.getNumericValue(firstLine[firstLine.length - 1 - i]);
                        } else {
                            fLine = 0;
                        }
                        if (secondLine.length - 1 - i >= 0) {
                            sLine = Character.getNumericValue(secondLine[secondLine.length - 1 - i]);
                        } else {
                            sLine = 0;
                        }
                        fLine += temp;
                        if (sLine > fLine) {
                            thirdLine[thirdLine.length - 1 - i] = (fLine + 10 - sLine);
                            temp = -1;
                        } else {
                            thirdLine[thirdLine.length - 1 - i] = (fLine - sLine);
                            temp = 0;
                        }
                    }
                    thirdLine[0] = -1;
                    return thirdLine;
                } else {
                    for (int i = 0; i < maxLength; i++) {
                        if (firstLine.length - 1 - i > 0) {
                            fLine = Character.getNumericValue(firstLine[firstLine.length - 1 - i]);
                        } else {
                            fLine = 0;
                        }
                        if (secondLine.length - 1 - i >= 0) {
                            sLine = Character.getNumericValue(secondLine[secondLine.length - 1 - i]);
                        } else {
                            sLine = 0;
                        }
                        sLine += temp;
                        if (fLine > sLine) {
                            thirdLine[thirdLine.length - 1 - i] = (sLine + 10 - fLine);
                            temp = -1;
                        } else {
                            thirdLine[thirdLine.length - 1 - i] = (sLine - fLine);
                            temp = 0;
                        }
                    }
                    return thirdLine;
                }
            }
        }
        return thirdLine;
    }

    private static int[] calculateAnswer3(char[] firstLine, char[] secondLine, int maxLength) {
        int[] thirdLine = new int[maxLength];
        int temp = 0;
        int fLine;
        int sLine;
        for (int i = 0; i < maxLength - 1; i++) {
            if (firstLine.length - 1 - i > 0) {
                fLine = Character.getNumericValue(firstLine[firstLine.length - 1 - i]);
            } else {
                fLine = 0;
            }
            if (secondLine.length - 1 - i > 0) {
                sLine = Character.getNumericValue(secondLine[secondLine.length - 1 - i]);
            } else {
                sLine = 0;
            }
            thirdLine[thirdLine.length - 1 - i] += temp;
            thirdLine[thirdLine.length - 1 - i] += fLine + sLine;
            temp = thirdLine[thirdLine.length - 1 - i] / 10;
            thirdLine[thirdLine.length - 1 - i] %= 10;
        }
        return thirdLine;
    }

    private static byte checkSignFormat(char c, char c1) {
        if (Character.compare(c, '-') != 0 && Character.compare(c1, '-') != 0) {
            return 0;
        } else if (Character.compare(c, '-') == 0 && Character.compare(c1, '-') != 0) {
            return 1;
        } else if (Character.compare(c, '-') != 0 && Character.compare(c1, '-') == 0) {
            return 2;
        } else {
            return 3;
        }
    }

    private static String answerToString(int[] thirdLine) {
        String numbers = "";
        if (thirdLine[0] == 1) {
            numbers += thirdLine[0];
        }
        for (int i = 1; i < thirdLine.length; i++) {
            numbers += thirdLine[i];
        }
        return numbers;
    }

    private static String answerToString1(int[] thirdLine) {
        String numbers = "";
        int count = 0;
        if (thirdLine[count] == -1) {
            numbers += '-';
            count++;
        }
        boolean notStarted = true;
        while(notStarted){
            if (thirdLine[count] == 0){
                count++;
            } else {
                notStarted = false;
            }
        }
        for (int i = count; i < thirdLine.length; i++) {
            numbers += thirdLine[i];
        }
        return numbers;
    }

    public static int calculateLength(String[] numbers) {
        if (numbers[0].length() > numbers[1].length()) {
            return numbers[0].length() + 1;
        } else {
            return numbers[1].length() + 1;
        }
    }
}
