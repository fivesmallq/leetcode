public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
		int middleIndex = totalLength >> 1;
		int targetIndexs[] = totalLength % 2 == 0 ? new int[] { middleIndex - 1,  middleIndex} :
													new int[] { middleIndex, middleIndex };
				
		if(nums1.length == 0 && nums2.length == 0){
			return 0;
		}
		
		if(nums1.length == 0) {
			int sum=0;
			for (int index : targetIndexs) {
				sum += indexAt(nums2, index);
			}
			return sum/2.0;
		}
		
		if(nums2.length == 0){
			int sum=0;
			for (int index : targetIndexs) {
				sum += indexAt(nums1, index);
			}
			return sum/2.0;
		}

		if (nums1[0] <= nums2[0]) {
			return find(nums1, nums2, targetIndexs) / 2.0;
		} else {
			return find(nums2, nums1, targetIndexs) / 2.0;
		}
    }

	public static int find(int[] A, int[] B, int[] indexes) {

		if (A[A.length - 1] <= B[0]) { // 没有交集
			int sum = 0;
			for (int index : indexes) {
				sum += indexAt(A, index) + indexAt(B, index - A.length);
			}
			return sum;
		}

		int s1 = 0; int e1 = A.length;
		int s2 = 0; int e2 = B.length;
		int m1 = (s1 + e1) >> 1;
		int m2 = (s2 + e2) >> 1;

		int lastOfFront;
		int firstOfBehind;

		int step = Math.max(m1, m2) >> 1;
		
		do {
		
			int left = m1 + m2;
			int right = A.length - m1 + B.length - m2;

			// 边界处理
			if (m1 == 0 && m2 == 0) {
				throw new RuntimeException();
			} else if (m1 == 0) {
				lastOfFront = B[m2 - 1];
			} else if (m2 == 0) {
				lastOfFront = A[m1 - 1];
			} else {
				lastOfFront = Math.max(A[m1 - 1], B[m2 - 1]);
			}

			if (m1 == A.length && m2 == B.length) {
				throw new RuntimeException();
			} else if (m1 == A.length) {
				firstOfBehind = B[m2];
			} else if (m2 == B.length) {
				firstOfBehind = A[m1];
			} else {
				firstOfBehind = Math.min(A[m1], B[m2]);
			}

			int minus = right - left;
			// 找到中位数
			if (minus <= 1 && lastOfFront <= firstOfBehind) {
				break;
			}
			
			if (minus > 1) { // 由于到达边界造成后部尺寸 > 前部
				if (B[m2] < A[m1]) { // 逆时针
					m2++;
				} else {
					m1++;
				}
			} else {
				boolean clockwise = (m2>0 && lastOfFront == B[m2-1]) || (m1 < A.length && firstOfBehind == A[m1]);
			    
			    int maxStep;
				if(A.length < B.length){
					maxStep = Math.min(A.length-m1, m1);
				}else{
					maxStep = Math.min(B.length-m2, m2);
				}
				step = Math.min(step, maxStep);
				step = Math.max(1, step);
				
				if (clockwise) {// 顺时针
					// m1++; m2--;
					m1 += step;
					m2 -= step;
				} else {
					// m1--; m2++;
					m1 -= step;
					m2 += step;
				}
				
				step = step >> 1;
			}

		} while (true);

		if (indexes[0] != indexes[1]) {
			return lastOfFront + firstOfBehind;
		} else {
			return firstOfBehind << 1;
		}
	}

	public static int indexAt(int[] array, int index) {
		if (index >= 0 && index < array.length) {
			return array[index];
		}
		return 0;
	}
}