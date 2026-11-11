class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long costA = (long) need1*cost1 + (long) need2*cost2;
        long costB = (long) Math.max(need1,need2) * costBoth;

        int mn = Math.min(need1,need2);
        long costC = (long)mn*costBoth + (long)(need1-mn)*cost1 + (long)(need2-mn)*cost2;
        return Math.min(costA,Math.min(costB,costC));
    }
}