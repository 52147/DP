package strategicapproachtodp;

import java.util.HashMap;

public class HouseRobber198_dp_topdown {
	
	private HashMap<Integer, Integer> memo = new HashMap<>();
	private int[] nums;
	
	private int dp(int i) {
		
		if(i == 0) {return nums[0];}
		if(i == 1) {return Math.max(nums[0], nums[1]);}
		
		if(!memo.containsKey(i)) {
			memo.put(i, Math.max(dp(i - 1), dp(i - 2) + nums[i]));
		}
		
		return memo.get(i);
		
	}
	
	public int rob(int[] nums) {
		
		this.nums = nums;
		return dp(nums.length - 1);
		
		
		
		
		
	}
	

}
