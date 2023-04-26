class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> result = new ArrayList<>();
		
		// slot1 정렬, slot2 정렬
		Arrays.sort(slots1, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		Arrays.sort(slots2, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int p1 = 0;
		int p2 = 0;
		
		while(p1 < slots1.length && p2 < slots2.length) {
			int[] s1 = slots1[p1];
			int[] s2 = slots2[p2];
			
			if((Math.max(s1[0], s2[0]) <= Math.min(s1[1], s2[1])) && (Math.min(s1[1], s2[1]) - Math.max(s1[0], s2[0]) >= duration) ) {
				int start = Math.max(s1[0], s2[0]);
				int end = start + duration;
				result.add(start);
				result.add(end);
				return result;
			}else {
                if(s1[1] < s2[1]) {
                    p1 ++;
                }else {
                    p2 ++;
                }
			}
		}
		
		return result;
    }
}