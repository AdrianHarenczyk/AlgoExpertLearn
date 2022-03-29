package base;

import java.util.Arrays;
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

    public static int[] twoNumberSum2(int[] array, int targetSum) {
        Arrays.sort(array);
        int i = 0;
        int j = array.length - 1;

        while (j != i) {
            int sum = array[i] + array[j];
            if (sum > targetSum) {
                j--;
            } else if (sum < targetSum) {
                i++;
            }
            if (sum == targetSum) {
                return new int[]{array[i], array[j]};
            }
        }
        return new int[]{};
    }

}
