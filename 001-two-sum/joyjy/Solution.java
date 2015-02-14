public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;

        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<Integer, Integer>(length);

        for(int i=0; i<length;i++){
            map.put(numbers[i], i);
        }

        for(int i=0; i<length;i++){
            int another = target - numbers[i];
            Integer anotherPos = map.get(another);
            if(anotherPos != null && anotherPos > i) {
                return new int[]{i+1, anotherPos+1};
            }
        }
        return null;
    }
}