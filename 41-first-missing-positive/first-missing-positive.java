class Solution {
    private void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length; 

        for(int i = 0; i<=n-1; i++){
            while(nums[i]>=1 && nums[i]<=n){
                int correctIndex = nums[i]-1;

                if(nums[i]!=nums[correctIndex]){
                    swap(nums,i,correctIndex);
                }else{
                    break;
                }
            }
        }
        for(int i =0; i<n; i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
}