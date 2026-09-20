class Solution {
	int maxLength(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<>();
		// put 0,-1 if 0 appears continously from index0 or at index 0
		map.put(0, -1);
		
		int maxlen = 0;
		int preSum = 0;
		int len = 0;
		
		for (int i = 0; i<arr.length; i++) {
			preSum += arr[i];
			
			// we need the compliment of our current sum to cancel it out
			int req = preSum;
			
			if (map.containsKey(req)) {
				len = i - map.get(req);
				maxlen = Math.max(maxlen, len);
			}
			else {
				map.put(preSum, i); // only store the first occurence
			}
		}
		return maxlen;
	}
	
}
