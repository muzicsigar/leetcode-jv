
### Knowledge Prerequisites 

- 做链表排序的题， 需要看清楚题目中 是否允许交换值，还是说必须进行指针操作；
- STEP 1 5min ~ 10min 注意画图理解，确定要用几个指针，尽量少额外开辟指针
- STEP 2 Coding： 在写代码的过程中，可能会出现没有设置pre指针的错漏，这是自己在STEP 1 考虑不成熟造成的。
- STEP 3 检查死循环： 特别注意 node之间的死循环， 需要清除每个node的next指针指向。

操作链表的技巧:
- 哑结点的使用 dummy
- 双指针：固定两个指针间的距离
- 快慢指针：可以不知道length就能取中点x
- 题目未限制更改node的值，就可以交换节点之间的值
- 递归的使用，优先队列的使用


#### 1. Terms



----------------------------------------------------------------------------------------------------
### II. Quiz Pool

https://leetcode-cn.com/problemset/all/?topicSlugs=dynamic-programming

#### 1. To Be Sorted
- [x] [N0002M_AddTwoNumbers_两数相加](https://leetcode-cn.com/problems/add-two-numbers/) [linkedlist, math]
      [[solution]](https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/)
      [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0002M_AddTwoNumbers.java)
- [x] [* N0019M_RemoveNthNodeFromEndOfList_删除链表的倒数第N个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/) [linkedlist, double-pointer]
    * [[solution]](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-by-l/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0019M_RemoveNthNodeFromEndOfList.java)
    * 重点看第二种解法：双指针的妙用
    * 本题技巧：dummy-node， two-pointers    
- [x] [* N0021E_MergeTwoSortedLists_合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/) [linkedlist]
    * [[solution]](https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0021E_MergeTwoSortedLists.java)    
    * 可以用递归
- [x] [* N0023H_MergeKSortedLists_合并K个排序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/) [heap, linkedlist, divide-and-conquer] 
    * [[solution]](https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/leetcode-23-he-bing-kge-pai-xu-lian-biao-by-powcai/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0023H_MergeKSortedLists.java)
    * 是N0021E合并2个有序链表的升级版
    * 这个题的多种解法不错：优先队列优化，分治归并    
- [x] [* N0024M_SwapNodesInPairs_两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/) [linkedlist]
    * [[solution]](https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/hua-jie-suan-fa-24-liang-liang-jiao-huan-lian-biao/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0024M_SwapNodesInPairs.java)
    * 迭代和递归两种方法都练习下。
    
    
    
- [ ] [* N0025H_ReverseNodesInKGroup_K个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)
      [[solution]](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/kge-yi-zu-fan-zhuan-lian-biao-by-powcai/)
    * TODO: 还没做完，需要接着做；  
    * need practice
- [x] [N0061M_RotateList_旋转链表](https://leetcode-cn.com/problems/rotate-list/)
      [[solution]](https://leetcode-cn.com/problems/rotate-list/solution/xuan-zhuan-lian-biao-by-leetcode/)
- [ ] [N0083E_RemoveDuplicatesFromSortedList_删除排序链表中的重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/)
      [[solution]](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/solution/shan-chu-pai-xu-lian-biao-zhong-de-zhong-fu-yuan-s/)
      [[solution]](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/solution/di-gui-yu-fei-di-gui-by-powcai/)
    * TODO recursive version：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/solution/di-gui-yu-fei-di-gui-by-powcai/
- [ ] [N0082M_RemoveDuplicatesFromSortedListII_删除排序链表中的重复元素II](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/)
      [[solution]]()
    * TODO recursive version: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/kuai-man-zhi-zhen-by-powcai-2/
- [ ] [N0086M_PartitionList_分隔链表](https://leetcode-cn.com/problems/partition-list/)
      [[solution]]()
- [ ] [N0092M_ReverseLinkedListII_反转链表II](https://leetcode-cn.com/problems/reverse-linked-list-ii/)
      [[solution]](https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/liang-chong-fang-fa-by-powcai/)
- [x] [N0206E_ReverseLinkedList_反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)
      [[solution]](https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/)      
- [ ] [N0109M_ConvertSortedListToBinarySearchTree_有序链表转换二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/)
      [[solution]]()
- [x] [N0138M_CopyListWithRandomPointer_复制带随机指针的链表](https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-by-leetcod/)
      [[solution]](https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-by-leetcod/)
      [[related]](https://leetcode-cn.com/problems/clone-graph/)
- [x] [N0141E_LinkedListCycle_环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)
      [[solution]](https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode/)
    * 技巧： 双指针中的快慢指针
- [ ] [N0142M_LinkedListCycleII_环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)
      [[solution]](https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/)
    * TODO 主要是有一个Floyd算法的数学证明
- [x] [N0143M_ReorderList_重排链表](https://leetcode-cn.com/problems/reorder-list/)
      [[solution]](https://leetcode-cn.com/problems/reorder-list/solution/zhong-pai-lian-biao-by-a380922457/)
    * 找链表中点其实可以用快慢指针！！  
- [ ] [* N0147M_InsertionSortList_对链表进行插入排序](https://leetcode-cn.com/problems/insertion-sort-list/)
      [[solution]](https://leetcode-cn.com/problems/insertion-sort-list/solution/lian-biao-de-cha-ru-pai-xu-by-a380922457/)
- [ ] [* N0148M_SortList_排序链表](https://leetcode-cn.com/problems/sort-list/)
      [[solution]](https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/)
      [[solution]](https://leetcode-cn.com/problems/sort-list/solution/gui-bing-pai-xu-he-kuai-su-pai-xu-by-a380922457/)
    * TODO 需要总结： 链表的插入排序，归并排序，快速排序
- [x] [N0160E_IntersectionOfTwoLinkedLists_相交链表](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)
      [[solution]](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/intersection-of-two-linked-lists-shuang-zhi-zhen-l/)
    * solution的解法牛逼；
- [x] [N0203E_RemoveLinkedListElements_移除链表元素](https://leetcode-cn.com/problems/remove-linked-list-elements/)
      [[solution]](https://leetcode-cn.com/problems/remove-linked-list-elements/solution/203yi-chu-lian-biao-yuan-su-by-lewis-dxstabdzew/)
    * 可以看看递归解法
- [x] [N0237E_DeleteNodeInALinkedList_删除链表中的节点](https://leetcode-cn.com/problems/delete-node-in-a-linked-list/)
      [[solution]](https://leetcode-cn.com/problems/delete-node-in-a-linked-list/solution/delete-node-in-a-linked-list-zhi-jie-xiu-gai-by-jy/)
    * 删除节点的另一种方法：通过改变节点值， 一般是通过更改pre指针
- [x] [N0234E_PalindromeLinkedList_回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)
      [[solution]](https://leetcode-cn.com/problems/palindrome-linked-list/solution/javashi-xian-kuai-man-zhi-zhen-fan-zhuan-qian-ban-/)
- [ ] []()
      [[solution]]()
- [ ] []()
      [[solution]]()
- [ ] []()
      [[solution]]()
- [ ] []()
      [[solution]]()
- [ ] []()
      [[solution]]()
- [ ] []()
      [[solution]]()
- [ ] []()
      [[solution]]()
- [ ] []()
      [[solution]]()
          
#### 2. Difficulty Top 5
    
#### 3. Classical

#####  反转链表
- [x] [*N0024M_SwapNodesInPairs_两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)
      [[solution]](https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/hua-jie-suan-fa-24-liang-liang-jiao-huan-lian-biao/)
    * 迭代和递归两种方法都练习下。 
- [ ] [N0025H_ReverseNodesInKGroup_K个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)
      [[solution]]()
- [ ] [N0206E_ReverseLinkedList_反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)
      [[solution]]()
- [ ] [N0092M_ReverseLinkedListII_反转链表II](https://leetcode-cn.com/problems/reverse-linked-list-ii/)
      [[solution]]()
      
##### 合并链表
- [x] [N0021E_MergeTwoSortedLists_合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)
      [[solution]](https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode/)
    * 可以用递归
- [x] [* N0023H_MergeKSortedLists_合并K个排序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)
      [[solution]]()
      
##### 环形链表
- [x] [N0141E_LinkedListCycle_环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)
      [[solution]](https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode/)
    * 技巧： 双指针中的快慢指针
- [ ] [N0142M_LinkedListCycleII_环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)
      [[solution]](https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/)
    * TODO 主要是有一个Floyd算法的数学证明

##### 链表排序
链表的插入排序，快速排序，归并排序
- [ ] [* N0147M_InsertionSortList_对链表进行插入排序](https://leetcode-cn.com/problems/insertion-sort-list/)
      [[solution]](https://leetcode-cn.com/problems/insertion-sort-list/solution/lian-biao-de-cha-ru-pai-xu-by-a380922457/)
- [ ] [* N0148M_SortList_排序链表](https://leetcode-cn.com/problems/sort-list/)
      [[solution]](https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/)
      [[solution]](https://leetcode-cn.com/problems/sort-list/solution/gui-bing-pai-xu-he-kuai-su-pai-xu-by-a380922457/)
    * TODO 需要总结： 链表的插入排序，归并排序，快速排序


#### 4. Frequency Top 10 && Before 300 