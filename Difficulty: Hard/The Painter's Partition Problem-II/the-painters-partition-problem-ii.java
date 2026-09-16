class Solution {
	public int minTime(int[] arr, int k) {
		int start = 0; int end = 0;
		
		for (int x:arr) {
			start = Math.max(start, x);
			end += x;
		}
		
		while (start<end) {
			int mid = start + ((end - start)>> 1);
			int ans = 1;
			int sum = mid;
			
			for (int i = 0 ; i<arr.length; i++) {
			
			if(sum - arr[i]<0){
			    ans++;
			    sum = mid;
			}
			sum-=arr[i];
			}
			if (ans>k) {
				start = mid + 1;
			}
			else {
				end = mid;
			}
			
		}
		return end;
		
	}
}
