class Solution {
    List<List<Integer>> getAB(int n, int second){
		List<List<Integer>> ablist = new ArrayList<>();
		
		for(int i=second; i<=Math.sqrt(n); i++) {
			if(n%i == 0) {
				List<Integer> ab = new ArrayList<>();
				ab.add(i);
				ab.add(n/i);
				ablist.add(ab);
				
				List<List<Integer>> temp = getAB(n/i, i);
				
				for(List<Integer> li : temp) {
					li.add(i);
					ablist.add(li);
				}
			}
		}
		return ablist;
	}
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> graph = getAB(n, 2);
		
		return graph;
    }
}