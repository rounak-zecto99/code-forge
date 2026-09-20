class Solution {
	public static ArrayList<Integer> findUnion(int a[], int b[]) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int i = 0;
		int j = 0;
		
		while (i < a.length && j < b.length) {
			
			if (a[i] < b[j]) {
				if (list.isEmpty() || list.get(list.size() - 1) != a[i])
					list.add(a[i]);
				
				i++;
			}
			else if (b[j] < a[i]) {
				if (list.isEmpty() || list.get(list.size() - 1) != b[j])
					list.add(b[j]);
				
				j++;
			}
			else {
				if (list.isEmpty() || list.get(list.size() - 1) != a[i])
					list.add(a[i]);
				
				i++;
				j++;
			}
		}
		
		while (i < a.length) {
			if (list.isEmpty() || list.get(list.size() - 1) != a[i])
				list.add(a[i]);
			
			i++;
		}
		
		while (j < b.length) {
			if (list.isEmpty() || list.get(list.size() - 1) != b[j])
				list.add(b[j]);
			
			j++;
		}
		
		return list;
	}
}
