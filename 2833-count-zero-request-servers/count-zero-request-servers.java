class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs,(a,b)->Integer.compare(a[1],b[1]));
        int[][] sortedqueries = new int[queries.length][2];
        for(int i=0; i<queries.length; i++){
            sortedqueries[i][0] = queries[i];
            sortedqueries[i][1]= i;
        }
        Arrays.sort(sortedqueries,(a,b)->Integer.compare(a[0],b[0]));
        int[] freq = new int[n+1];
        int[] result = new int[queries.length];
        int left = 0;
        int right = 0;
        int activeServers = 0;

        for(int i=0; i<sortedqueries.length; i++){
            int q = sortedqueries[i][0];
            int orgIndex = sortedqueries[i][1];

            while(right<logs.length && logs[right][1]<=q){
                int server = logs[right][0];
                if(freq[server] == 0){
                    activeServers++;
                }
                freq[server]++;
                right++;
            }
            while(left<logs.length && logs[left][1]<q-x){
                int server = logs[left][0];
                freq[server]--;

                if(freq[server]==0){
                    activeServers--;
                }
                left++;
            }
            result[orgIndex] = n-activeServers;
        }
        return result;
    }
}