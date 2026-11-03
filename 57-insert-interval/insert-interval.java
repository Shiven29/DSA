class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        boolean inserted = false;
        for(int i = 0; i<intervals.length; i++){
            if(intervals[i][1]<newInterval[0]){
                result.add(new int[]{intervals[i][0],intervals[i][1]});
            }else if(intervals[i][0]<=newInterval[1]){
                newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            }else{
                if(!inserted){
                    result.add(new int[]{newInterval[0],newInterval[1]});
                    inserted = true;
                }
                result.add(new int[]{
                    intervals[i][0],intervals[i][1]
                });
            }
            
        }
        if(!inserted){
            result.add(new int[]{newInterval[0],newInterval[1]});
        }
        return result.toArray(new int[result.size()][]);
    }
}