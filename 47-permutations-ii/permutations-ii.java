class Solution {
    private void backtrack(int[] nums, boolean[] used , List<Integer> current, List<List<Integer>> result){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;

            if(i>0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            current.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, current, result);
            current.remove(current.size()-1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];

        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums,used,current,result);
        return result;

    }
}