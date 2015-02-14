结果

 * 16 / 16 test cases passed.
 * Status: Accepted
 * Runtime: 241 ms

思路

1. 首先选用 for(i,j) if(v(i)+v(j)==target) 的形式，运行时间超时
2. 思考题目旁边的 Tag 为何是 HashTable
3. 经提示“一次循环”，想起 Hash 的查找是 O(1) 的

OJ Fail 测试集

1. 大集合检测运行时间
2. 无序集合检测正确性
3. 使用自身为目标 /2 的集合元素，查看是否注意边界值