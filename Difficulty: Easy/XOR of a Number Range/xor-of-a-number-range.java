class Solution {
	
	public int prefixXOR(int n) {
		if (n % 4 == 0)
			return n;
		if (n % 4 == 1)
			return 1;
		if (n % 4 == 2)
			return n + 1;
		
		return 0;
	}
	
	public int findXOR(int l, int r) {
		return prefixXOR(r) ^ prefixXOR(l - 1);
	}
}
