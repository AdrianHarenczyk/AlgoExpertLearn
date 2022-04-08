package base;

import java.util.*;
import java.util.stream.IntStream;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {
        int[] ints = sortedSquaredArray2(new int[]{-10, -5, 0, 5, 10});
        System.out.println(Arrays.toString(ints));
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

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int iterator = 0;
        for (Integer integer : array) {
            int number = sequence.get(iterator);
            if (number == integer) {
                iterator++;
            }
            if (iterator == sequence.size()) {
                return true;
            }
        }
        return false;
    }

    public int[] sortedSquaredArray(int[] array) {
        return IntStream.of(array).map(i -> i * i).sorted().toArray();
    }

    public static int[] sortedSquaredArray2(int[] array) {
        int[] resultArray = new int[array.length];
        int max = resultArray.length - 1;
        int min = 0;
        for (int i = max; i >= 0; i--) {
            if (abs(array[max]) < abs(array[min])) {
                resultArray[i] = array[min] * array[min];
                min++;
            } else {
                resultArray[i] = array[max] * array[max];
                max--;
            }
        }
        resultArray[0] = array[min] * array[min];
        return resultArray;
    }

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> teamToWins = new HashMap<>();
        for (int i = 0; i < competitions.size(); i++) {
            var competition = competitions.get(i);
            var homeTeam = competition.get(0);
            var awayTeam = competition.get(1);
            var result = results.get(i);
            if (result == 0) {
                addPoints(teamToWins, awayTeam);
            } else {
                addPoints(teamToWins, homeTeam);
            }
        }
        Optional<Map.Entry<String, Integer>> winningTeam = teamToWins.entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue));
        return winningTeam.isPresent() ? winningTeam.get().getKey() : "Empty";
    }

    private void addPoints(Map<String, Integer> teamToWins, String team) {
        var points = teamToWins.get(team);
        if (points == null) {
            teamToWins.put(team, 1);
        } else {
            points++;
            teamToWins.put(team, points);
        }
    }

    public int nonConstructibleChange(int[] coins) {
        if (coins == null) {
            return 1;
        }
        Arrays.sort(coins);
        int changeValue = 0;
        for (int coin : coins) {
            if (coin > changeValue + 1) {
                return changeValue + 1;
            }
            changeValue += coin;
        }
        return changeValue + 1;
    }

    public static int findClosestValueInBst(BST tree, int target) {
        if (tree == null) {
            return 0;
        }
        BST currentTree = tree;

        int valueWithLowestDelta = tree.value;
        int currentlyLowestDelta = getDelta(tree.value, target);

        while (currentTree != null) {
            int value = currentTree.value;
            int currentDelta = getDelta(value, target);
            if (currentlyLowestDelta > currentDelta) {
                currentlyLowestDelta = currentDelta;
                valueWithLowestDelta = value;
            }
            if (value > target) {
                currentTree = currentTree.left;
            } else if (value == target) {
                return value;
            } else {
                currentTree = currentTree.right;
            }
        }
        return valueWithLowestDelta;
    }

    private static int getDelta(int value, int target) {
        return Math.abs(value - target);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;


        // Stock Presentation Service
        public BST(int value) {
            this.value = value;
        }
    }

}
