#### 结果

 * 2078 / 2078 test cases passed.
 * Status: Accepted
 * Runtime: 620 ms

#### 思路

对于有序数组 `A[m]，B[n]`，存在 `0 < i < m，0 < j < n`，使得 `i+j == m-i + n-j (-1)`，并且 `Math.max(A[i-1], B[j-1]) <= Math.min(A[i], B[j])`；

1. 处理各种边界值
2. 使用二分查找 i、j

#### OJ 结果

太慢……