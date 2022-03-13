package strategicapproachtodp;
/**
 * = What is Dynamic Programming?
 * 
 * - Dynamic Programming (DP) is a programming paradigm that can systematically and efficiently explore all possible solutions to a problem.
 * - As such, it is capable of solving a wide variety of problems that often have the following characteristics:
 * 
 *   - 1. The problem can be broken down into "overlapping subproblems"
 *        - smaller versions of the original problem that re-used multiple times.
 *   - 2. The problem has an "optimal substructure"
 *        - an optimal solution can be formed from optimal solutions to the overlapping subproblems of the original problem.
 *        
 *  - The Fibonacci sequence is a classic example used to explain DP.
 *  - Fibonacci sequence is a sequence of numbers that start with 0, 1, and each subsequent number is obtained by adding the previous two numbers together. 
 *  
 *  - If you wanted to find the n th Fibonacci number F(n),
 *    you can down into smaller subproblems
 *    - find F(n - 1) and F(n - 2) instead.
 *    
 *  - Then, adding the solutions to these subproblems together gives the answer to the original question,
 *    F(n - 1) + F(n - 2) = F(n), which means the problem has optimal substructure,
 *    since a solution F(n) to the original problem can be formed from the solutions to the subproblems.
 *  - This subproblems are also overlapping 
 *    - for example, we would need F(4) to calculate both F(5) and F(6).
 *    
 *  - These attributes may seem familiar to you.
 *  - Greedy problems have optimal substructure, but overlapping subproblems.
 *  
 *  - Divide and conquer algorithms break a problem into subproblems,
 *    but these subproblems are not overlapping
 *    (which is why DP and divide and conquer are commonly mistaken for one another).
 * 
 * - Dynamic programming is a powerful tool because it can break a complex problem into a manageable subproblems,
 *   avoid unnecessary recalculation of overlapping subproblems,
 *   and use the results of those subproblems to solve the initial complex problem.
 *   
 * - DP not only aids us in solving complex problems, but is also greatly improves the time complexity compared to brute force solutions.
 *   - For example, the brute force solution for calculating the Fibonacci sequence has exponential time complexity,
 *     while the dynamic programming solution will have linear time complexity.
 * 
 * implementations:
 * 
 * = Top-down and Bottom-up =
 * 
 * - There are 2 ways to implement a DP algorithm:
 * 
 *   - 1. Bottom-up, also known as tabulation.
 *   - 2. Top-down, also known as memoization.
 *   
 *   
 * = 1. Bottom-up (Tabulation) = 
 * 
 * - Bottom-up implemented with iteration and starts at the base cases.
 * - Let's use the Fibonacci sequence as an example again.
 * 
 * - The base case for the Fibonacci sequence are F(0) = 0 and F(1) = 1.
 * - With bottom-up, we would use these base cases to calculate F(2),
 *   and then use that result to calculate F(3),
 *   and so on all the way up to F(n).
 *   
 *   // Pseudo code example for bottom-up
 *   
 *   F = array of length (n + 1)
 *   F[0] = 0
 *   F[1] = 1
 *   for i from 2 to n:
 *       F[i] = F[i - 1] + F[i - 2]
 *       
 *  
 *       
 * = 2. Top-down (Memoization) =
 * 
 * - Top-down is implemented with recursion and made efficient with memoization.
 * - If we wanted to find the n th Fibonacci number F(n),
 *   we try to computer this by finding F(n - 1) and F(n - 2).
 * - This defines a recursive pattern that will continue on until we reach the base case F(0) = F(1) = 1;
 * 
 * - The problem with just implementing it recursively is that there is a ton of unnecessary repeated computation.
 * - Take a look at the recursion tree if we were to find F(5):
 *   - We have to calculate F(2) three times.
 * 
 * - Notice that we need to calculate F(2) three times.
 * - This might not seem like a big deal, but if were to calculate F(6),
 *   the entire image would be only one child of the root.
 * - Imagine if we wanted to find F(100) - the amount of computation is exponential and will quickly explode.
 * - The solution to this is to memoize results.
 * 
 * - memoizing a result means to store the result of a function call,
 *   usually in a s hashmap or an array,
 *   so that when the same function call is made again,
 *   we can simply return the memoized result instead of recalculating the result.
 *   
 * - After we calculate F(2), let's store it somewhere (typically in a hashmap), 
 *   so that in the future, whenever we need to find F(2), we can just refer to the value we already calculated instead of having to go through the entire tree again.
 * - Below is an example of what the recursion tree for finding F(6) looks like with and without memoization:
 * 
 * 
 *  // Pseudocode example for top-down
 *  
 *  memo = hashmap
 *  Function F(integer i):
 *     if i is 0 or 1:
 *        return i
 *     if i doesn't exist in memo:
 *        memo[i] = F(i - 1) + F(i - 2)
 *     return memo[i]
 * 
 * 
 * 
 * = Which is better? =
 * 
 * - Any DP algorithm can be implemented with either method,
 *   and there are reasons for choosing either over the other.
 * - However, each method has one main advantage that stands out:
 * 
 *   - A bottom-up implementation:(iteration)
 *     - runtime is usually faster, as iteration does not have the overhead that recursion does.
 *     
 *   - A top-down implementation:(recursion)
 *     - is usually much easier to write.
 *     - This is because with recursion, the ordering of subproblem does not matter,
 *       whereas with tabulation, we need to go through a logical ordering of solving subproblems.
 *   
 * 
 * = When to use DP =
 * 
 * - When it comes to solving an algorithm problem, especially in a high-pressure scenario such as interview,
 *   half the battle is figuring out how to even approach the problem.
 * - In the first section, we defined what makes a problem a good candidate for dynamic programming. Recall:
 * 
 *   - 1. The problem can be broken down into "overlapping subproblems"
 *        - smaller versions of the original problem that are re-used multiple times.
 *   - 2. The problem has an "optimal substructure"
 *        - an optimal solution can be formed from optimal solutions to the overlapping subproblems of the original problem.
 *        
 *  - Unfortunately, it is hard to identify when a problem fits into these definitions.
 *  - Instead, let's discuss some common characteristics of DP problems that are easy to identify.
 *         
 *  DP problem characteristics:
 *   
 * - 1. 
 *   - The first characteristic that is common in DP problems is that the problem will ask for the optimum value(maximum or minimum) of something,
 *     or the number of ways there are to do something.
 *     - For example:
 *       - What is the minimum cost of doing...
 *       - What is the maximum profit from...
 *       - How many ways are there to do...
 *       - What is the longest possible...
 *       - Is it possible to reach a certain point...
 *       
 *       
 *       
 *       - When it comes to identifying if a problem should be solved with DP, this first characteristic is not sufficient.
 *       - Sometimes, a problem in this format(asking for the max/min/longest etc.) is mean to be solved with a greedy algorithm.
 *       
 *       - The next characteristic will help us determine whether a problem should be solving using a greedy algorithm or dynamic programming.
 *       
 * - 2.      
 *   - The second characteristic that is common in DP problems is that future "decisions" depend on earlier decisions.
 *   - Deciding to do something at one step may affect the ability to do something in a later step.
 *   
 *   - This characteristic is what makes a greedy algorithm invalid for a DP problem
 *     - we need to factor in results from previous decisions.
 *     
 *   - Admittedly, this characteristics is not as well defined as the first one,
 *     and the best way to identify it is to go through some examples.
 *     
 *   - example:   
 *     - 1. House Robber:
 *     
 *       - problem description:
 *       - You are a robber planning to rob house along a street.
 *       - Each house has a certain amount of money stashed,
 *         the only constraint stopping you from robbing is that adjacent housed have a security systems connected
 *         and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *       
 *       - Given an integer array nums representing the amount of money of each node,
 *         return the maximum amount of money you can rob tonight without alerting the police.
 *         
 *         
 *       - Solution:
 *       - In this problem, each decision will affect what options are available to the robber in the future.
 *         - For example, with the test case nums = [2, 7, 9, 3, 1],
 *         - the optimal solution is to rob the houses with 2, 9 , 1 money.
 *         
 *         - However, if we were to iterate from left to right in a greedy manner,
 *           - our first decision would be whether to rob the first or second house.
 *         - 7 is way more money than 2, so if we were greedy, we would choose to rob house 7.
 *         
 *         - However, this prevents us from robbing the house with 9 money.
 *         
 *         - As you can see, our decision between robbing the first or second house affects which options are available for future decisions.
 *    
 *    - 2. Longest Increasing subsequence
 *      - Another example of a classic DP problem.
 *      - In this problem, we need to determine the length of the longest(first characteristic) subsequence that is strictly increasing.
 *        
 *        - For example, if we had the input nums = [1, 2, 6, 3, 5],
 *        - the answer would be 4, from the subsequence [1, 2, 3, 5].
 *        
 *      - Again, the important decision comes when we arrive at the 6  
 *       - do we take it or not take it?
 *       - If we decide to take it, then we get to increase our current length by 1,
 *         but it affects the future - we can no longer take the 3 or 5.
 *     
 *      - Of course, with such a small example, it's easy to see why we shouldn't take it
 *        - but how are we supposed to design an algorithm that can always make the correct decision with huge inputs?
 *        
 *      - Imagine if nums contained 10,000 numbers instead.
 *  
 * 
 * - When you're solving a problem on your own and trying to decide if the second characteristic is applicable,
 *   assume it isn't, then try to think of a counterexample that proves a greedy algorithm won't work.
 * - If you can think of an example where earlier decisions affect future decisions, then DP is applicable.
 * 
 * 
 * 
 * - To summarize:
 * 
 *   - If a problem is asking for the maximum/minimum/longest/shortest of something,
 *     the number of ways to do something, or if it is possible to reach a certain point,
 *     it is probably greedy or DP.
 *     
 *   - In general, if the problem has constraints that cause decisions to affect other decisions,
 *     such as using one element prevents the usage of other elements, 
 *     then we should consider using dynamic programming to solve the problem.
 *   
 *   - These two characteristics can be used to identify if a problem should be solved with DP.
 *      
 * = Framework for DP problem =
 * 
 *  - Now that we understand the basic of DP and how to spot when DP is applicable to a problem,
 *    we've reached the most important part: actually solving the problem.
 *  - In this section, we're going to talk about a framework for solving DP problems.
 *  - This framework is applicable to nearly every DP problem and provides a clear step-by-step approach to developing DP algorithms.
 *  
 *  - For this article's explanation, we're going to use the problem Climbing Stairs as an example,
 *    with a top-down(recursive) implementation.
 *    
 *  
 * - Before we start, we need to first define a term: state.
 * - In a DP problem, a state is a set of variables that can sufficiently describe a scenario.
 * 
 * - These variables are called state variables, and we only care about relevant ones.
 *   
 *   - For example, to describe every scenario in Climbing Stairs, there is only 1 relevant state variable, the current step we are on.
 *   
 *   - We can denote this with an integer i.
 *   - If i = 6,
 *   - that means that we are describing the state of being on the 6th step.
 *   - Every unique value of i represents a unique state.
 *   
 *   - The color of socks is an irrelevant variable.
 *   - In terms of figuring out how many ways there are to climb the set of stairs,
 *     the only relevant variable is what stair you are currently on.
 *     
 *     
 *   
 * = The Framework =
 * 
 * - To solve a DP problem, we need to combine 3 things:
 * 
 * - 1. A function or data structure that will compute/contain the answer to the problem for every given state.
 * 
 *   - For climbing stairs, let's say we have an function dp where dp(i) returns the number of ways to climb to the i-th step.
 *   - Solving the original problem would be as easy as return dp(n).
 *   
 *   - How did we decide on the design of the function?
 *   - The problem is asking "How many distinct ways can you climb to the top?",
 *     so we decide that the function will represent how many distinct ways you can climb to a certain step
 *     literally the original problem,
 *     but generalized for a given state.
 *     
 *   - Typically, top-down is implemented with a recursive function and hash map,
 *     whereas bottom-up is implemented with nested for loops and an array.
 *   - When designing this function or array,
 *     we also need to decide on state variables to pass as arguments.
 *     
 *   - This problem is very simple, so all we need to describe a state is to know what step we are currently on i.
 * 
 * - 2. A recurrence relation to transition between states
 *   - A recurrence relation is an equation that relates different states with each other.
 *   - Let's say that we needed to find how many ways we can climb to the 30th stair.
 *   - the problem states that we are allowed to take either 1 or 2 steps at a time.
 *   - Logically, that means to climb to the 30th stair, we arrived from either the 28th or 29th stair.
 *   - Therefore, the number of ways we can climb to the 30th stair is equal to 
 *     the number of ways we can climb to the 28th stair plus the number of ways we can climb to the 29th stair.
 *     
 *     
 *   - The problem is, we don't know how many ways there are to climb to the 28th or 29th stair.
 *   - However, we can use the logic from above to define a recurrence relation.
 *   - In the case, dp(i) = dp(i - 1) + dp(i - 2).
 *   - As you can see, information about some state gives us information about other state.
 *   
 *   - Upon careful inspection, we can see that this problem is actually the Fibonacci sequence in disguise.
 *   - This is a very simple recurrence relation 
 *     - typically, finding the recurrence relation is the most difficult part of solving a DP problem.
 *     
 *  - 3. Base cases, so that our recurrence relation does not go on infinitely.
 *    - The equation dp(i) = dp(i - 1) + dp(i - 2) on its own will continue forever to negative infinity.
 *    - We need base cases so that the function will eventually return a actual number.
 *    
 *    - Finding the base case is often the easiest part of solving a DP problem, and just involves a little bit of logical thinking.
 *    - When coming up with the base case(s) ask yourself:
 *      - What state(s) can I find the answer to without using dynamic programming?
 *        - In this example, we can reason that there is only 1 way to climb to the first stair(1 step once),
 *          and there are 2 ways to climb to the second stair(1 step twice and 2 steps once).
 *        - Therefore, our base cases are dp(1) = 1 and dp(2) = 2.
 *        
 *         
 *  - We said above that we don't know how many ways there are to climb to the 28th and 29th stairs.
 *  - However, using these base cases and the recurrence relation from step 2,
 *    we can figure out how many ways there are to climb to the 3rd stair.
 *    
 *  - With that information, we can find out how many ways there are to climb to the 4th stair, and so on.
 *  - Eventually, we will know how many ways there are to climb to the 28th and 29th stairs.
 *  
 *   
 *   
 *   
 *   - Do you notice something missing from the code?
 *   - We haven't memoizationd anything.
 *   - The code above has a time complexity of O(2^n) because every call to dp creates 2 more calls to dp.
 *   - If we wanted to find how many ways there are to climb to the 250th step,
 *     the number of operations we would have to do is approximately equal to the number of atoms in the universe.
 *  
 *     
 *  - In fact, without the memoization, this isn't actually dynamic programming
 *    - it's just basic recursion.
 *  - Only after we optimize our solution by adding memoization to avoid repeated computations can it be called DP.
 *  - memoization means caching results from functions calls and then referring to those results in the future instead of recalculating them.
 *  - This is usually done with a hashmap or an array.
 *  
 *   
 *    
 *       
 *
 */

// 70. Climbing stairs - basic recursion  time O(2^n)
public class ClimbingStairs70_recursion {
	
	// A function that represents the answer to the problem for a given state
	private int dp(int i) {
		
		if(i <= 2) 
			return i; // Base cases
		
		return dp(i - 1) + dp(i - 2); // Recurrence relation
	}
	
	public int climbStairs(int n) {
		return dp(n);
	}

}
