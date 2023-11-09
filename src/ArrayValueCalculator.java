import Size.ArrayDataException;
import Size.ArraySizeException;

import java.util.Arrays;

public class ArrayValueCalculator{
        public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
    if (array.length != 4 || Arrays.stream(array).anyMatch(row -> row.length != 4)) {
        throw new ArraySizeException("Масив повинен бути розміром 4x4");
    }

    int sum = 0;
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            try {
                sum += Integer.parseInt(array[i][j]);
            } catch (NumberFormatException e) {
                throw new ArrayDataException("Невірні дані у комірці [" + i + "][" + j + "]", e);
            }
        }
    }

    return sum;
}

        public static void main(String[] args) {
            String[][] validArray = {
                    {"1", "2", "3", "4"},
                    {"5", "6", "7", "8"},
                    {"9", "10", "11", "12"},
                    {"13", "14", "15", "16"}
            };

            try {
                int result = doCalc(validArray);
                System.out.println("Результат розрахунку: " + result);
            } catch (ArraySizeException e) {
                System.out.println("Помилка розміру масиву: " + e.getMessage());
            } catch (ArrayDataException e) {
                System.out.println("Помилка даних у масиві: " + e.getMessage());
                e.printStackTrace();
            }
        }
}