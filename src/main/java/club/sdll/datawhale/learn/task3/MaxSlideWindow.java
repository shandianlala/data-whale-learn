package club.sdll.datawhale.learn.task3;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shandianlala@gmail.com
 * @description Given an array nums, there is a sliding window of size k which is moving from the
 * very left of the array to the very right. You can only see the k numbers in the window. Each time
 * the sliding window moves right by one position. Return the max sliding window.
 * https://leetcode.com/problems/sliding-window-maximum/
 * Input: nums = [1, 3, -1, -3, 5, 3, 6, 7], and k = 3
 * Output: [3, 3, 5, 5, 6, 7]
 * @since 2019-08-11 22:46
 */
public class MaxSlideWindow {

    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || a.length == 0 || k <= 0) {
            return new int[0];
        }
        int length = a.length;
        int[] result = new int[length - k + 1];
        int resultIndex = 0;
        Deque<Integer> indexDeque = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            while (!indexDeque.isEmpty() && indexDeque.peek() < i - k + 1) {
                indexDeque.poll();
            }
            while (!indexDeque.isEmpty() && a[indexDeque.peekLast()] < a[i]) {
                indexDeque.pollLast();
            }
            indexDeque.offer(i);
            if (i >= k - 1) {
                result[resultIndex++] = a[indexDeque.peek()];
            }
        }
        return result;
    }

}
