package com.maverickbyte.algo.leetcode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0042H_TrappingRainWater {
  // 1. brutal-force
  public int trap(int[] height) {
    if (height == null) {
      throw new NullPointerException();
    }
    if (height.length < 3) {
      return 0;
    }

    int ans = 0;
    for (int i = 1; i < height.length - 1; i++) {
      int maxLeft = 0;
      int maxRight = 0;
      for (int left = i - 1; left >= 0; left--) {
        if (height[left] > maxLeft) {
          maxLeft = height[left];
        }
      }
      for (int right = i + 1; right < height.length; right++) {
        if (height[right] > maxRight) {
          maxRight = height[right];
        }
      }
      int water = Math.min(maxLeft, maxRight) - height[i];
      water = water < 0 ? 0 : water;
      ans += water;
    }
    return ans;
  }

  // 2. dynamic programming
  public int trap1(int[] height) {
    if (height == null) {
      throw new NullPointerException();
    }
    if (height.length < 3) {
      return 0;
    }
    int size = height.length;
    int ans = 0;
    int[] maxLeft = new int[size];
    int[] maxRight = new int[size];
    for (int i = 1; i < size; i++) {
      maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
    }
    for (int i = size - 2; i > 0; i--) {
      maxRight[i] = Math.max(height[i], maxRight[i + 1]);
    }
    for (int i = 1; i < size - 1; i++) {
      ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
    }
    return ans;
  }


  // 3. using stack
  public int trap2(int[] height) {
    int ans = 0;
    int current = 0;
    LinkedList<Integer> st = new LinkedList<>();
    while (current < height.length) {
      while (!st.isEmpty() && height[current] > height[st.getFirst()]) {
        int top = st.pollFirst();
        if (st.isEmpty()) {
          break;
        }
        int distance = current - st.getFirst() - 1;
        int boundedHeight = Math.min(height[current], height[st.getFirst()]) - height[top];
        ans += distance * boundedHeight;
      }
      st.addFirst(current++);
    }
    return ans;
  }


  // 4. using double pointers
  public int trap3(int[] height) {
    int left = 0, right = height.length - 1;
    int ans = 0;
    int leftMax = 0, rightMax = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= leftMax) {
          leftMax = height[left];
        } else {
          ans += leftMax - height[left];
        }
        left++;
      } else {
        if (height[right] >= rightMax) {
          rightMax = height[right];
        } else {
          ans += rightMax - height[right];
        }
        right++;
      }
    }
    return ans;
  }
}
