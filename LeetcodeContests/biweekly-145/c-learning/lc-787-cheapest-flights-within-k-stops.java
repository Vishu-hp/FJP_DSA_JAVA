// great problem
// dijkstra doesn't work because of constraints of stop, answer can also on path with more price as path with less price can have stops constraints
// dijkstra without visisted check will give tle and using excessive looping check was accepted
// dfs also gave tle , needs some improvement 
// bfs was accepted, with a check below which avoids over calculations

// bfs with excessive looping check
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int[] f : flights) {
            map.computeIfAbsent(f[0], m -> new HashMap<>()).put(f[1], f[2]);
        }

        k++;

        int min = Integer.MAX_VALUE;
        int[] count = new int[n];

        count[src]++;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { src, 0 });

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (k-- == 0) break;

            while (size-- > 0) {
                int[] cur = queue.poll();
                Map<Integer, Integer> next = map.getOrDefault(cur[0], null);

                if (next == null) continue;

                for (Map.Entry<Integer, Integer> entry : next.entrySet()) {
                    if (cur[1] + entry.getValue() >= min)
                        continue;
                    if (entry.getKey() == dst) {
                        min = Math.min(min, cur[1] + entry.getValue());
                        continue;
                    }

                    // it removes excessive looping
                    if (count[entry.getKey()]++ <= n) {
                        queue.add(new int[] { entry.getKey(), cur[1] + entry.getValue() });
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;

    }
}

// dijkstra with excessive looping check
class Solution {
    public Map<Integer, Map<Integer, Integer>> createGraph(int[][] flights) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for (int[] flight : flights) {
            int src = flight[0], des = flight[1], prc = flight[2];
            graph.putIfAbsent(src, new HashMap<>());
            graph.get(src).put(des, prc);
        }

        return graph;
    }

    public int dijkstra(Map<Integer, Map<Integer, Integer>> graph, int src, int dst, int k
    , int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { src, 0, 0 });
        int[] vis = new int[n];
        Arrays.fill(vis, 0);
        vis[src]++;
        int ans = Integer.MAX_VALUE;

        while (pq.size() > 0) {
            int[] rem = pq.remove();

            // removes excessive looping
            if (vis[rem[0]] > n) {
                continue;
            }

            vis[rem[0]]++;
            if (rem[0] == dst) {
                ans = Math.min(ans, rem[1]);
            }

            Map<Integer, Integer> inMap = graph.get(rem[0]);
            if (inMap != null) {
                for (Map.Entry<Integer, Integer> x : graph.get(rem[0]).entrySet()) {
                    int nbr = x.getKey(), prc = x.getValue();

                    if (rem[2]+1 < k+1 || (rem[2] + 1 == k + 1 && nbr == dst)) {
                        pq.add(new int[] { nbr, prc + rem[1], rem[2] + 1 });
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> graph = createGraph(flights);
        int ans;
        ans = dijkstra(graph, src, dst, k, n);
        return ans;
    }
}
