package strategicapproachtodp;
/**
 * = bottom-up =
 * 
 * - We just talked a whole lot about top-down, but what about bottom-up?
 * - Everything is pretty much the same,
 *   except we will start from our base cases and iterate up to our final answer.
 * - As stated before, bottom-up implementations usually use an array,
 *   so we will use an array dp where dp[i] represents the number of ways to climb to the i the step. 
 *
 * - Notice that the implementation still follows the framework exactly - 
 *   the framework holds for both top-down and bottom-up implementations.
 *   
 * To summarize:
 * 
 * - With DP problems, we can use logical thinking to find the answer to the original problem for certain inputs,
 *   in this case we reason that there is 1 way to climb to the first stair and 2 way to climb to the second stair.
 *   
 * - We can then use a recurrence relation to find the answer to the original problem for any state,
 *   in this case for any stair number.
 * - Finding the recurrence relation involves thinking about how moving from one state to another changes the answer to the problem.
 * 
 * - This is the essence of dynamic programming.
 *
 */
public class ClimbingStairs70_bottomup {
	
	public int climbStairs(int n) {
	
	if(n == 1)
		return 1;
	
	// An array that represents the answer to the problem for a given state
	int[] dp = new int[n + 1];
	dp[1] = 1; // base cases
	dp[2] = 2; // base cases
	
	for(int i = 3; i <= n; i++) {
		dp[i] = dp[i - 1] + dp[i - 2]; // Recurrence relation
	}
	
	
	return dp[n];
	
	
	
	}

}
