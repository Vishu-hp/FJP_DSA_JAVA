// good problem, creating graph, implementing dijkstra

class Solution {

    public Map<Integer, Map<Integer, Integer>> createGraph(int[][] times) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for (int[] x : times) {
            int src = x[0], nbr = x[1], tm = x[2];

            graph.putIfAbsent(src, new HashMap<>());
            graph.get(src).put(nbr, tm);
        }

        return graph;
    }

    public int dijkstra(Map<Integer, Map<Integer, Integer>> graph, int node, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { node, 0 });
        HashSet<Integer> vis = new HashSet<>();
        int ans = -1, cnt = 0;

        while (pq.size() > 0) {
            int[] rem = pq.remove();

            if (vis.contains(rem[0])) {
                continue;
            }

            vis.add(rem[0]);
            cnt++;

            if (cnt == n) {
                ans = rem[1];
            }

            Map<Integer, Integer> inMap = graph.get(rem[0]);
            if (inMap != null) {
                for (Map.Entry<Integer, Integer> x : graph.get(rem[0]).entrySet()) {
                    int nbr = x.getKey(), tm = x.getValue();

                    pq.add(new int[] { nbr, tm + rem[1] });
                }
            }

        }
        return ans;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = createGraph(times);

        int ans;
        ans = dijkstra(graph, k, n);

        return ans;
    }
}
