package baseball.util;

public class Integers {

    public static int[] toIntArray(String str) throws NumberFormatException {
        int[] arr = new int[str.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        return arr;
    }

}
