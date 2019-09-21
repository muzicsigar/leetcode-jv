
### Knowledge Prerequisites 
- 取中点： `-*--` or `-*-` or `*-` 其中 `*` 为中点 
- 计算 mid 时需要技巧防止溢出，即 mid=left+(right-left)/2; 而 mid = (left + right)/2会存在溢出；
- padding '#' 倍增索引 #0#1#2#3 和 0#1#2#3
- 割(cut), 中位数(lMid, rMid)
    
    
- 二分查找模板
    * 自己希望用什么区间？`[left, right]` or `[left, right)`
    * 终止条件？是否漏了元素？ `while(left <= right)` or `while(left < right)`
    * return 还是 移动？ `if(target = nums[mid])` return or  move ?
    * 杜绝死循环： 只能 left == mid + 1; right = mid - 1;   
- Ref: https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
- Ref: https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/

- 二维数组 `A(m行，n列)`元素的 一维坐标 `A(i)` 和二维坐标 `A(x, y)`的转化
    * `A[i] = A[i / n][i % n] (0 <= i <= m * n - 1)`    

----------------------------------------------------------------------------------------------------
### II. Quiz Pool

#### 1. To Be Sorted
- [x] [* N0004H_MedianOfTwoSortedArrays_寻找两个有序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/) [array, binary-search, divide-and-conquer]
    * [[solution]](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/4-xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-shu/)      
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0004H_MedianOfTwoSortedArrays.java)
    * padding '#' 倍增索引 #0#1#2#3 和 0#1#2#3
    * 割(cut), 中位数(lMid, rMid)
- [x] [* N0029M_DivideTwoIntegers_两数相除](https://leetcode-cn.com/problems/divide-two-integers/) [math, binary-search]
    * [[solution]](https://leetcode.com/problems/divide-two-integers/discuss/13397/Clean-Java-solution-with-some-comment.)
    * [[solution]](https://leetcode-cn.com/problems/divide-two-integers/solution/xiao-xue-sheng-du-hui-de-lie-shu-shi-suan-chu-fa-b/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0029M_DivideTwoIntegers.java)
- [x] [N0033M_SearchInRotatedSortedArray_搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/) [array, binary-search]
    * [[solution]](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0033M_SearchInRotatedSortedArray.java)    
- [x] [** N0034M_FindFirstAndLastPositionOfElementInSortedArray_在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/) [array, binary-search]
    * [[solution]](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0034M_FindFirstAndLastPositionOfElementInSortedArray.java)
- [x] [N0035E_SearchInsertPosition_搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/) [array, binary-search]
    * [[solution]](https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0035E_SearchInsertPosition.java)
- [x] [* N0050M_Pow](https://leetcode-cn.com/problems/powx-n/) [math, binary-search]
    * [[solution]](https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0050M_Pow.java)
- [x] [N0074M_SearchA2DMatrix_搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/) [array, binary-search]
    * [[solution]](https://leetcode-cn.com/problems/search-a-2d-matrix/solution/ologmn-ologm-logn-by-powcai/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0074M_SearchA2DMatrix.java)
    * 注意一维坐标转成二维坐标的的方式 
