// great problem
// dijkstra doesn't work because of constraints of stop, answer can also on path with more price as path with less price can have stops constraints
// dijkstra without visisted check will give tle 
// dfs also gave tle , needs some improvement 
// bfs was accepted, with a check below which avoids over calculations

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
