
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if(a[0] != b[0])
                    return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            }
        );

        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        int n = servers.length;
        int m = tasks.length;

        for(int i = 0; i < n; i++)
            available.offer(new int[]{servers[i], i});

        int[] ans = new int[m];
        long time = 0;

        for(int i = 0; i < m; i++) {

            time = Math.max(time, i);

            while(!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] server = busy.poll();

                available.offer(
                    new int[]{servers[(int)server[1]], (int)server[1]}
                );
            }

            if(available.isEmpty()) {
                time = busy.peek()[0];

                while(!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] server = busy.poll();

                    available.offer(
                        new int[]{servers[(int)server[1]], (int)server[1]}
                    );
                }
            }

            int[] server = available.poll();

            int index = server[1];
            ans[i] = index;

            busy.offer(new long[]{
                time + tasks[i], index
            });
        }

        return ans;
    }
}
