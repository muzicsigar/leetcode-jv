
# Knowledge Prerequisites 
用来论述总结解题技巧，预备知识。

回溯法：把问题的解空间转化成了图或者树的结构表示，然后使用深度优先搜索策略进行遍历，遍历的过程中记录和寻找所有可行解或者
最优解。等同于树的后续遍历或图的深度优先搜索。因此，回溯法一般结合递归来实现。

注意：回溯法求解问题时，实际是遍历树或图的过程。


## 解题技巧

### 通用的解题步骤
- step 1: 确定每次分支能够分出多少个branch，脑子里要形成一个树`T`，实在不行用笔画下来。
- step 2: 对建模好的`T`进行DFS遍历, 明确终止递归的状态
- step 3: 尽量剪枝
    * 特殊剪枝：结果去重的判断条件， 确定原数组是否需要先排序

### 技巧


----------------------------------------------------------------------------------------------------
# II. Quiz Pool


## 1. To Be Sorted
- [x] [N0017M_LetterCombinationsOfAPhoneNumber_电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/) [string, backtrack]
    * [[solution]](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/leetcode-17-letter-combinations-of-a-phone-number-/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0017M_LetterCombinationsOfAPhoneNumber.java)
- [x] [* N0022M_GenerateParentheses_括号生成](https://leetcode-cn.com/problems/generate-parentheses/) [string, backtrack]
    * [[solution]](https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0022M_GenerateParentheses.java)      
- [x] [* N0037H_SudokuSolver_解数独](https://leetcode-cn.com/problems/sudoku-solver/) [hash, backtrack]
    * [[solution]](https://leetcode-cn.com/problems/sudoku-solver/solution/jie-shu-du-by-leetcode/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0037H_SudokuSolver.java)
- [x] [N0039M_CombinationSum_组合总和](https://leetcode-cn.com/problems/combination-sum/) [array, backtrack]
    * [[solution]](https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0039M_CombinationSum.java)    
- [x] [N0040M_CombinationSumII_组合总和II](https://leetcode-cn.com/problems/combination-sum-ii/) [array, backtrack]
    * [[solution]](https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0040M_CombinationSumII.java)
- [x] [N0046M_Permutations_全排列](https://leetcode-cn.com/problems/permutations/) [backtrack]
    * [[solution]](https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0046M_Permutations.java)
- [x] [N0047M_Permutations_II_全排列II](https://leetcode-cn.com/problems/permutations-ii/) [backtrack]
    * [[solution]](https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0047M_PermutationsII.java)
    * 重点：重复排列剪枝
- [x] [* N0051H_NQueens_N皇后](https://leetcode-cn.com/problems/n-queens/) [backtrack]
    * [[solution]](https://leetcode-cn.com/problems/n-queens/solution/nhuang-hou-by-leetcode/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0051H_NQueens.java)
    * 重点：如何记忆状态，col，主对角线，副对角线
- [x] [N0052H_NQueensII_N皇后II](https://leetcode-cn.com/problems/n-queens-ii/) [backtrack]
    * [[solution]](https://leetcode-cn.com/problems/n-queens-ii/solution/nhuang-hou-ii-by-leetcode/)
    * [[solution]](https://leetcode-cn.com/problems/n-queens-ii/solution/dfs-wei-yun-suan-jian-zhi-by-makeex/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0052H_NQueensII.java)
- [x] [* N0060M_X_PermutationSequence_第K个排列](https://leetcode-cn.com/problems/permutation-sequence/) [math, backtrack]
    * [[solution]](https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/)
    * [[github_code]](../src/main/java/com/maverickbyte/algo/leetcode/N0060M_PermutationSequence.java)
    * 找规律的数学解法：康托展开
          
    
## 2. Classical
组合，排列，子集,  单词搜索， N皇后

- [N0784E_LetterCasePermutation_字母大小写全排列.md](N0784E_LetterCasePermutation_字母大小写全排列.md)
    * [Solution 1](https://leetcode-cn.com/problems/letter-case-permutation/solution/shen-du-you-xian-bian-li-hui-su-suan-fa-python-dai/)
    * [Code](../src/main/java/com/maverickbyte/algo/leetcode/N0784E_LetterCasePermutation.java)
- [N0046M_Permutations_全排列.md](N0046M_Permutations_全排列.md)
    * [Solution 1]()
- [N0047M_Permutations_II_全排列II.md](N0047M_Permutations_II_全排列II.md)
- [N0060M_X_PermutationSequence_第K个排列.md](N0060M_X_PermutationSequence_第K个排列.md)

- [N0077M_Combinations_组合.md]()
- [N0039M_CombinationSum_组合总和.md]()
- [N0040M_CombinationSumII_组合总和II.md]()
- [N0216M_CombinationSumIII_组合总和III.md]()

- [N0078M_Subsets_子集.md]()
- [N0090M_SubsetsII_子集II.md]()

- [N0401E_BinaryWatch_二进制手表.md]()
- [N0093M_RestoreIPAddresses_复原IP地址.md](N0093M_RestoreIPAddresses_复原IP地址.md)
- [N0022M_GenerateParentheses_括号生成.md]()
- [N0051H_NQueens_N皇后.md]()
- [N0052H_NQueensII_N皇后II.md]()
- [N0079M_WordSearch_单词搜索.md]()
- [N0212H_WordSearchII_单词搜索II.md]()    




