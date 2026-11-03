class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        for(int num : nums){
            max = Math.max(num,max);
        }
        int minmoves = 0;
        for(int num : nums){
            minmoves += Math.abs(max-num);
        }
        return minmoves;
    }
}