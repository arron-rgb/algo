```text

/Users/arronshentu/Project/21fall/algo/src/edu/neu/algo

$!velocityTool.camelCaseName(${question.title})

package edu.neu.algo.leetcode.editor.en.$!velocityTool.date("_yyyyMMdd");

public class $!velocityTool.camelCaseName(${question.title}){
${question.content}
    
${question.code}
}
```

# Notes

## UniqueBinarySearchTrees

> Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

```text

```

## SingleNumberII

> Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

```text
0 = 1
1 = 1
2 = 1 * dp[1] + 1 * dp[1] (1.right = dp[1], 2.left = dp[1]) = 2
3 = 1 * dp[2] + 1 * dp[3] + dp[1] * dp[1] (1.right = dp[2], 3.left = dp[2], 2.left=dp[1], 2.right = dp[1]) = 2 + 2 + 1 = 5
```
 
