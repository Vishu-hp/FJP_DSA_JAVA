// good implementation of binary search

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int ans = 0;
        Arrays.sort(tasks);

        int s = 0, e = Math.min(tasks.length, workers.length);

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int pillReq = 0;
            boolean isPoss = true;

            TreeMap<Integer, Integer> tmp = new TreeMap<>();
            for (int x : workers) {
                tmp.put(x, tmp.getOrDefault(x, 0) + 1);
            }

            for (int idx = mid - 1; idx >= 0; idx--) {
                int task = tasks[idx];

                Integer justGreater = tmp.ceilingKey(task);

                if (justGreater != null) {
                    tmp.put(justGreater, tmp.get(justGreater) - 1);
                    tmp.remove(justGreater, 0);
                } else {
                    Integer maxVal = tmp.ceilingKey(task - strength);

                    if (maxVal != null) {
                        pillReq++;
                        tmp.put(maxVal, tmp.get(maxVal) - 1);
                        tmp.remove(maxVal, 0);
                    } else {
                        isPoss = false;
                        break;
                    }
                }

                if (pillReq > pills) {
                    isPoss = false;
                    break;
                }
            }

            if (isPoss) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }
}
