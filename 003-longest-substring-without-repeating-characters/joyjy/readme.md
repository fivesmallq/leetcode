#### 结果

 * 981 / 981 test cases passed.
 * Status: Accepted
 * Runtime: 278 ms

#### 思路

以题例“abcabcbb”模拟：

寻找方式如下：

```
abcabcbb
01234567

abca // start=0,end=3; length=3；
 bcab // start=1,end=4; length=3;
  cabc // start=2,end=5; length=3;
   abcb // start=3,end=6; length=3;
     cbb // start=5,end=7; length=2;
       b // start=7,end=8; length=1;

```

1. 当寻找到一个不重复字串 S<sub>m,n</sub>(0&lt;=m&lt;n&lt;=l)，其所有的子串 S<sub>k,n</sub>(m&lt;k&lt;n) 为不重复字串且长度小于 S<sub>m,n</sub>：

    **end 永远应该向后搜索不回退；**

2. 当 S<sub>n+1</sub> 与 S<sub>m,n</sub> 中的 S<sub>k</sub>(m&lt;=k&lt;=n) 重复，则只可能 S<sub>k+1,n+1</sub> 再向后搜索才能不重复：

    **start 的位置应当从重复字符位置向后1位**；

#### OJ Fail 测试集

1. 未正确考虑 end 特性时时间复杂度不符合要求；
2. 初始条件设置错误，空字符串返回“1”；
3. 未考虑条件2，start 搜索错误；