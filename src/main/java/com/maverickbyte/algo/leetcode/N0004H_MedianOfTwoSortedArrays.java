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

    if (isOdd) {
      mids[0] = mids[1];
    }
    return (mids[0] + mids[1]) / 2.0;
  }


  public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      int[] tmp = nums1;
      nums1 = nums2;
      nums2 = tmp;
    }
    int len1 = nums1.length;
    int len2 = nums2.length;
    int lMid1 = 0, rMid1 = 0, cut1, lMid2 = 0, rMid2 = 0, cut2, high = 2 * len1, low = 0;
    while (low <= high) {
      cut1 = (low + high) / 2;
      cut2 = len1 + len2 - cut1;
      lMid1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[(cut1 - 1) / 2];
      rMid1 = cut1 == 2 * len1 ? Integer.MAX_VALUE : nums1[cut1 / 2];
      lMid2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[(cut2 - 1) / 2];
      rMid2 = cut2 == 2 * len2 ? Integer.MAX_VALUE : nums2[cut2 / 2];
      if (lMid1 > rMid2) {
        high = cut1 - 1;
      } else if (lMid2 > rMid1) {
        low = cut1 + 1;
      } else {
        break;
      }
    }
    return (Math.max(lMid1, lMid2) + Math.min(rMid1, rMid2)) / 2.0;
  }

  //
  public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
    return 0d;
  }


  public static void main(String[] args) {
    int[] nums1 = new int[]{1, 2};
    int[] nums2 = new int[]{3, 4};
    N0004H_MedianOfTwoSortedArrays runner = new N0004H_MedianOfTwoSortedArrays();
    double ans = runner.findMedianSortedArrays2(nums1, nums2);
    System.out.println(ans);
  }
}
