import java.util.Arrays;

public class Problem1769 {
    public static void main(String[] args) {
        String boxes = "001011";

        System.out.println(Arrays.toString(minOperations(boxes)));
    }

//    public static int[] minOperations(String boxes) {
//        int[] ans = new int[boxes.length()];
//
//        for (int i = 0; i < boxes.length(); i++) {
//            int count = 0;
//            for (int j = 0; j < boxes.length(); j++) {
//                if (boxes.charAt(j) == '1') {
//                    count += Math.abs(i - j);
//                }
//            }
//            ans[i] = count;
//        }
//        return ans;
//    }

    public static int[] minOperations(String boxes) {
        int n = boxes.length();

        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];

        int count = boxes.charAt(0) - '0';
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + count;
            count += boxes.charAt(i) - '0';
        }

        count = boxes.charAt(n - 1) - '0';
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + count;
            count += boxes.charAt(i) - '0';
        }

        for (int i = 0; i < n; i++) {
            ans[i] = left[i] + right[i];
        }

        return ans;
    }
}

//You have n boxes. You are given a binary string boxes of length n,
// where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
//In one operation, you can move one ball from a box to an adjacent box.
// Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
//Return an array answer of size n, where answer[i] is the minimum number
// of operations needed to move all the balls to the ith box.
//Each answer[i] is calculated considering the initial state of the boxes.

//Input: boxes = "110"
//Output: [1,1,3]
//Explanation: The answer for each box is as follows:
//1) First box: you will have to move one ball from the second box to the first box in one operation.
//2) Second box: you will have to move one ball from the first box to the second box in one operation.
//3) Third box: you will have to move one ball from the first box to the third box in two operations,
//   and move one ball from the second box to the third box in one operation.