package cn.shgx.easy;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimetoBuyandSellStock1 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) {
        	return 0;
        }
        int min = prices[0];//最小的买价
        int profit = 0;//收益
        for(int i = 0;i<prices.length;i++) {
        	profit = Math.max(profit, prices[i]-min);
        	min = Math.min(min, prices[i]);
        }
        return profit;
    }
    public int maxProfit2(int[] prices) {
        if(prices==null||prices.length==0) {
        	return 0;
        }
        int global = 0;//全局最优解
        int local = 0;//局部最优解
        for(int i = 0;i<prices.length-1;i++) {
        	local = Math.max(local+prices[i+1]-prices[i],0);
        	global = Math.max(local, global);
        }
        return global;
    }
}
