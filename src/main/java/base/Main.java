package base;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i : array) {
            int number = targetSum - i;
            if (map.get(number) != null && map.get(number)) {
                return new int[]{number, i};
            }
            map.put(i, Boolean.TRUE);
        }
        return new int[0];
    }

}
