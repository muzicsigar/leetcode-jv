package com.maverickbyte.algo.leetcode;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0004H_MedianOfTwoSortedArrays {

  // nums1, nums2不同时为空
  public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
    // npe check, bound check

    int totalSize = nums1.length + nums2.length;
    int mid = totalSize / 2;
    boolean isOdd = totalSize % 2 == 1;

    int[] mids = new int[]{0, 0};

    int i = 0;
    int j = 0;
    while (i < nums1.length && j < nums2.length && i + j <= mid) {
      if (nums1[i] > nums2[j]) {
        mids[0] = mids[1];
        mids[1] = nums2[j];
        j++;
      } else {
        mids[0] = mids[1];
        mids[1] = nums1[i];
        i++;
      }
    }
    while (i >= nums1.length && i + j <= mid) {
      mids[0] = mids[1];
      mids[1] = nums2[j];
      j++;
    }
    while (j >= nums2.length && i + j <= mid) {
      mids[0] = mids[1];
      mids[1] = nums1[i];
      i++;
    }

    if(isOdd) {
      mids[0] = mids[1];
    }
    return (mids[0] + mids[1]) / 2.0;
  }


  // 牺牲空间：int[] nums = new int[nums1.length + nums2.length];
  public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
    return 0d;
  }

  //
  public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
    return 0d;
  }


  public static void main(String[] args) {
    int[] nums1 = new int[]{1, 2};
    int[] nums2 = new int[]{3, 4};
  }
}
