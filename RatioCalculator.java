import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatioCalculator {
    public static double calculateRatio(int[] nums, List<Integer> usedNumbers) {
        // Initialize the four largest and four smallest numbers
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        // Iterate through the array to find the four largest and four smallest numbers
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        // Calculate the sum of the largest two numbers and the sum of the smallest two numbers
        double sumOfLargest = max1 + max2;
        double sumOfSmallest = min1 + min2;
        
        // Add the numbers used for calculation to the list
        usedNumbers.clear();
        usedNumbers.addAll(Arrays.asList(max1, max2, min1, min2));

        // Return the ratio of the sum of the largest two numbers divided by the sum of the smallest two numbers
        return sumOfLargest / sumOfSmallest;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 12, 450, 1, 1, 5, 6, 23, 6, 8, 9, 321, 2, 3};
        List<Integer> usedNumbers = new ArrayList<>();
        double ratio = calculateRatio(a, usedNumbers);
        System.out.println("The ratio is: " + ratio + ". Numbers used for calculation: " + usedNumbers);
    }
}
