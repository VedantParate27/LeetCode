class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long common = Math.min(need1, need2);
        long common_Cost = common * Math.min(cost1+cost2, costBoth);

        long rem1 = need1 - common;
        long rem2 = need2 - common;

        long rem1_cost = rem1 * Math.min(cost1, costBoth);
        long rem2_cost = rem2 * Math.min(cost2, costBoth);

        return common_Cost + rem1_cost + rem2_cost; 
    }
}