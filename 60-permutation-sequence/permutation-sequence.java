class Solution {
    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> res){
        if(current.size() == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i])continue;
            current.add(nums[i]);
            used[i] = true;
            backtrack(nums,current,used,res);
            current.remove(current.size()-1);
            used[i] = false;
        }
    }

    public String getPermutation(int n, int k) {
        int[] array = new int[n];
        for(int i=n; i>0; i--){
            array[i-1] = i;
        }
        n = array.length;
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[n];

        backtrack(array,current,used,res);
        List<Integer> kthList = res.get(k-1);
        StringBuilder result = new StringBuilder();
        for(int i : kthList){
            result.append(i);
        }
        return result.toString();
    }
}