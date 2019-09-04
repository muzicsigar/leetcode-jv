
### Knowledge Prerequisites 
DP其实就是一种表格法
大多数递归都可以用动态规划的思想重写

#### 1. Terms
- 记忆化回溯
- 

#### 2. 解决DP问题的一般步骤
- **step 1** 分解子问题
- **step 2** 确定状态，和根据状态求出的值
- **step 3** 确定边界条件（也就是找出一些初始状态的状态值）
- **step 4** 构建出状态转移方程
- **step 5** 将递归DP进行空间优化，尽可能转变为递推(a.k.a 迭代)



- 自顶向下的DP(**top-down DP**)
- 自底向上的DP(**bottom-up DP**)
- example: start为grid[0][0], end为grid[m][n]
  * `dp(0, 0) = relation{dp(0, 1), dp(1, 0)}`为 top-down DP
  * `dp(m, n) = relation{dp(m, n - 1), dp(m - 1, n)}` 为 bottom-up DP

----------------------------------------------------------------------------------------------------
### II. Quiz Pool

https://leetcode-cn.com/problemset/all/?topicSlugs=dynamic-programming

#### 1. To Be Sorted
- [x] [** N0032H_LongestValidParentheses_最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/) [string, stack, dp]
    * [[solution]](https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0032H_LongestValidParentheses.java)
    * 多种解法: brutal-force, dp, stack, left&right
    * 暴力解法包含括号验证的子问题
- [ ] [* N0053E_MaximumSubarray_最大子序和](https://leetcode-cn.com/problems/maximum-subarray/) [array, divide-and-conquer, dp]
    * [[solution]](https://leetcode-cn.com/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0053E_MaxSubArray.java)
- [ ] [* N0055M_JumpGame_跳跃游戏](https://leetcode-cn.com/problems/jump-game/) [array, greedy-method, dp]
    * [[solution]](https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0055M_JumpGame.java)
- [x] [N0062M_UniquePaths_不同路径](https://leetcode-cn.com/problems/unique-paths/) [array, dp]
    * [[solution]](https://leetcode-cn.com/problems/unique-paths/solution/dong-tai-gui-hua-by-powcai-2/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0062M_UniquePaths.java)
- [x] [N0063M_UniquePathsII_不同路径II](https://leetcode-cn.com/problems/unique-paths-ii/) [array, dp]
    * [[solution]](https://leetcode-cn.com/problems/unique-paths-ii/solution/bu-tong-lu-jing-ii-by-leetcode/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0063M_UniquePathsII.java)
- [x] [N0064M_MinimumPathSum_最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/) [array, dp]
    * [[solution]](https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-by-leetcode/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0064M_MinimumPathSum.java)
- [x] [N0070E_ClimbingStairs_爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/) [dp]
    * [[solution]](https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0070E_ClimbingStairs.java)
- [x] [* N0072H_EditDistance_编辑距离](https://leetcode-cn.com/problems/edit-distance/) [string, dp]
    * [[solution]](https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0072H_EditDistance.java)
    
* [ ] [N1025E_DivisorGame_除数博弈](https://leetcode-cn.com/problems/divisor-game/)
      [[solution]]()
- [ ] [N0121E_BestTimeToBuyAndSellStock_买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/)
      [[solution]]()
- [ ] [买卖股票的最佳时机 II]()
      [[solution]]()
- [ ] [买卖股票的最佳时机 III]()
      [[solution]]()
- [ ] [买卖股票的最佳时机 IV]()
      [[solution]]()
- [ ] [最佳买卖股票时机含冷冻期]()
      [[solution]]()
- [ ] [买卖股票的最佳时机含手续费]()      
      [[solution]]()
- [ ] [* 300. 最长上升子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/description/)      
      [[solution]]()
- [ ] [10. Regular Expression Matching 正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching/solution/ji-yu-guan-fang-ti-jie-gen-xiang-xi-de-jiang-jie-b/)      
      [[solution_fr_labuladong]](https://leetcode-cn.com/problems/regular-expression-matching/solution/ji-yu-guan-fang-ti-jie-gen-xiang-xi-de-jiang-jie-b/)
- [ ] [354. Russian Doll Envelopes 俄罗斯套娃信封问题](https://leetcode-cn.com/problems/russian-doll-envelopes/)      
      [[solution]]()      
- [x] [N0091M_DecodeWays_解码方法](https://leetcode-cn.com/problems/decode-ways/)
      [[solution]](https://leetcode-cn.com/problems/decode-ways/solution/fei-bo-na-qi-si-lu-by-dingmin1860/)
- [x] [N0096M_UniqueBinarySearchTrees_不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees/solution/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b/)
      [[solution]](https://leetcode-cn.com/problems/unique-binary-search-trees/solution/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b/)
- [ ] []()      
      [[solution]]()
       
#### 2. Difficulty Top 5
    * [ ] [N1025E_DivisorGame_除数博弈](https://leetcode-cn.com/problems/divisor-game/)
          [[solution]]()
    
#### 3. Classical

##### 股票问题
通用题解：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/
- [ ] [N0121E_BestTimeToBuyAndSellStock_买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/)
      [[solution]]()
- [ ] [N0122E_BestTimeToBuyAndSellStock_II_买卖股票的最佳时机II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)
      [[solution]]()
- [ ] [N0123H_BestTimeToBuyAndSellStock_III_买卖股票的最佳时机III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)
      [[solution]]()
- [ ] [N0188H_BestTimeToBuyAndSellStock_IV_买卖股票的最佳时机IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/)
      [[solution]]()
- [ ] [N0309H_BestTimeToBuyAndSellStockWithCoolDown_最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)
      [[solution]]()
- [ ] [N0714H_BestTimeToBuyAndSellStockWithTransactionFee_买卖股票的最佳时机含手续费](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)
      [[solution]]()

##### 编辑路径
- [ ] [N0072H_EditDistance_编辑距离](https://leetcode-cn.com/problems/edit-distance/)
      [[solution]]()
- [ ] []()
      [[solution]]()

##### 路径问题          
- [ ] [N0064M_MinimumPathSum_最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)
      [[solution_fr_powcai]](https://leetcode-cn.com/problems/minimum-path-sum/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai/)
      [[solution_fr_official]](https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-by-leetcode/)
- [ ] [N0062_UniquePaths_不同路径](https://leetcode-cn.com/problems/unique-paths/)
      [[solution_fr_powcai]](https://leetcode-cn.com/problems/unique-paths/solution/dong-tai-gui-hua-by-powcai-2/)
- [ ] [N0063_UniquePaths_II_不同路径II](https://leetcode-cn.com/problems/unique-paths-ii/)
      [[solution_fr_powcai]](https://leetcode-cn.com/problems/unique-paths-ii/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-2/)
- [ ] [N0980_UniquePaths_III_不同路径III](https://leetcode-cn.com/problems/unique-paths-iii/)
      [[solution]]()
- [ ] [N0174H_DungeonGame_地下城游戏](https://leetcode-cn.com/problems/dungeon-game/)
      [[solution]]()
- [ ] []()
      [[solution]]()
#### 4. Frequency Top 10 && Before 300 
