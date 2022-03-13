package strategicapproachtodp;

import java.util.HashMap;

/**
 * 
 * = Approach : DP =
 * 
 * - You may notice that a hashmap is overkill for caching here,
 *   and an array can be used instead.
 * - This is true, but using a hashmap isn't necessarily bad practice as some DP problems will require one,
 *   and they're hassle-free to use as you don't need to worry about sizing an array correctly.
 *   
 * - Furthermore, when using top-down DP, some problems do not require us to solve every single subproblem,
 *   in which case an array may use more memory than a hashmap.  
 * 
 * 
 *
 */

// With memoization, our time complexity drops to O(n) - astronomically better, literally.
public class ClimbingStairs70_DP {
	
	private HashMap<Integer, Integer> memo = new HashMap<>();
	
	private int dp(int i) {
		
		if(i <= 2) {
			return i;
		}
		
		// Instead of just returning dp(i - 1) + dp(i - 2), calculate it once and then store it inside a hashmap to refer to in the future.
		if(!memo.containsKey(i))
			memo.put(i, dp(i - 1) + dp(i - 2));
		
		return memo.get(i);
	}
	
	
	public int climbStairs(int n) {
		return dp(n);
	}
	
	
	

} 
