class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        TreeSet<Integer> available = new TreeSet<>();
        int[] freq = new int[k];

        for(int i = 0; i<k; i++){
            available.add(i);
        }

        for(int i =0; i<arrival.length; i++){
            int preferred = i%k;

            while(!pq.isEmpty() && pq.peek()[1] <= arrival[i]){
                int[] completed = pq.poll();
                available.add(completed[0]);
            }
            if(available.isEmpty()){
                continue;
            }

            Integer server = available.ceiling(preferred);
            if(server == null){
                server = available.first();
            }
            available.remove(server);
            freq[server]++;

            int completion = arrival[i] + load[i];
            pq.add(new int[]{server,completion});
        }
        int max = 0;

        for(int i=0; i<k; i++){
            max = Math.max(max,freq[i]);
        }
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<k; i++){
            if(freq[i] == max){
                result.add(i);
            }
        }
        return result;
    }
}