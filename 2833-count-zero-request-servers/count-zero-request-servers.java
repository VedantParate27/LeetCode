class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a,b)-> Integer.compare(a[1], b[1]));
        int[][] q = new int[queries.length][2];

        for(int i=0; i<queries.length; i++){
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));

        int res[] = new int[queries.length];
        int left = 0;
        int right = 0;
        int activeServer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<queries.length; i++){
            int end = q[i][0];
            int start = end - x;

            while(right < logs.length && logs[right][1] <= end){
                int server = logs[right][0];
                map.put(server, map.getOrDefault(server, 0)+1);
                if(map.get(server) == 1)
                    activeServer++;

                right++;
            }

            while(left<right && logs[left][1] < start){
                int server = logs[left][0];
                map.put(server, map.get(server)-1);
                if(map.get(server) == 0){   
                    map.remove(server);
                    activeServer--;
                }

                left++;
            }
        res[q[i][1]] = n - activeServer;
        }
        return res;
    }
}