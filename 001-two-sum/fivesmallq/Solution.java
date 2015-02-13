/**
 * 一种方法是两次循环，提交之后超时。
 * 后来想到两次循环对比很浪费，考虑使用差值进行查找。于是使用 hashMap存放值和 index
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //值和索引放到 map 中
        HashMap<Integer, Integer> numberMap = new HashMap<Integer, Integer>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            numberMap.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            //获取差值索引
            Integer index = numberMap.get(diff);
            //找到并且不是当前元素
            if (index != null && index > i) {
                return new int[]{i + 1, index + 1};
            }
        }
        return new int[]{0, 0};
    }
}