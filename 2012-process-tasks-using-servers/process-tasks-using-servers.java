class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> available = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        PriorityQueue<int[]> busy = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            return a[2]-b[2];
        });
        
        for(int i=0; i<servers.length; i++){
            available.offer(new int[]{
                servers[i],i
            });
        }
        int[] result = new int[tasks.length];
        for(int i=0; i<tasks.length; i++){
            while(!busy.isEmpty() && busy.peek()[0] <= i){
                int[] server = busy.poll();
                available.offer(new int[]{server[1],server[2]});
            }
            if(!available.isEmpty()){
                int[] server = available.poll();
                result[i] = server[1];
                int finishTime = i + tasks[i];

                busy.offer(new int[]{
                    finishTime, server[0], server[1]
                });
            }else{
                int[] server = busy.poll();
                result[i] = server[2];
                int finishTime = server[0] + tasks[i];
                busy.offer(new int[]{
                    finishTime, server[1], server[2]
                });
            }
        } 
        return result;
    }
}