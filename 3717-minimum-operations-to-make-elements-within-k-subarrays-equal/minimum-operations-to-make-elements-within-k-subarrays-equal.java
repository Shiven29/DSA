class Solution {
    class DualHeap{
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> delayedMap = new HashMap<>();

        int minSize = 0; int maxSize = 0; long minSum = 0; long maxSum = 0;
        void prune(PriorityQueue<Integer> heap){
            while(!heap.isEmpty()){
                int num = heap.peek();

                if(delayedMap.getOrDefault(num,0)==0)
                    break;

                heap.poll();
                int count = delayedMap.get(num);
                if(count == 1){
                    delayedMap.remove(num);
                }else{
                    delayedMap.put(num,count-1);
                }
            }
        }
            void add(int num){
                prune(minHeap);
                if(minHeap.isEmpty() || num<=minHeap.peek()){
                    minHeap.offer(num);
                    minSize++;
                    minSum += num;
                }else{
                    maxHeap.offer(num);
                    maxSize++;
                    maxSum += num;
                }
                balance();
            }
            void remove(int num){
                prune(minHeap);
                prune(maxHeap);

                delayedMap.put(num, delayedMap.getOrDefault(num,0)+1);
                if(num<=minHeap.peek()){
                    minSize--;
                    minSum -= num;

                    if(num == minHeap.peek()){
                        prune(minHeap);
                    }
                }else{
                    maxSize--;
                    maxSum -= num;

                    if(!maxHeap.isEmpty() && num == maxHeap.peek()){
                        prune(maxHeap);
                    }
                }
                balance();
            }
            void balance(){
                prune(minHeap);
                prune(maxHeap);

                if(minSize>maxSize+1){
                    int num = minHeap.poll();
                    minSize--;
                    minSum -= num;

                    maxHeap.offer(num);
                    maxSize++;
                    maxSum += num;

                    prune(minHeap);
                }else if(minSize < maxSize){
                    int num = maxHeap.poll();

                    maxSize--;
                    maxSum -= num;

                    minHeap.offer(num);
                    minSize++;
                    minSum += num;

                    prune(maxHeap);
                }
            }

            long getCost(){
                prune(minHeap);
                prune(maxHeap);

                long median = minHeap.peek();
                return median*minSize - minSum + maxSum-median * maxSize;
            }
        }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        int window= n-x+1;

        long[] cost = new long[window];

        DualHeap dh = new DualHeap();

        for(int i=0; i<x; i++){
            dh.add(nums[i]);
        }

        for(int i=0; i<window; i++){
            cost[i] = dh.getCost();
            if(i+x<n){
                dh.remove(nums[i]);
                dh.add(nums[i+x]);
            }
        }

        long INF = Long.MAX_VALUE/4;

        long[][] dp = new long[n+1][k+1];

        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], INF);
        }
        for(int i=0;i<=n; i++){
            dp[i][0] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j= 1; j<=k; j++){
                dp[i][j] = dp[i-1][j];
                if(i>=x && dp[i-x][j-1] != INF){
                    dp[i][j] = Math.min(dp[i][j],dp[i-x][j-1]+cost[i-x]);
                }
            }
        }
        return dp[n][k];
    }
}