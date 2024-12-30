// great problem
// learnings : 1) creating graph from custom data, 
//             2) good understanding of dfs

class Solution {
    public Map<String, Map<String, Double>> createGraph(List<List<String>> equations, double[] values){
        Map<String, Map<String, Double>> g = new HashMap<>();
        int idx=0;
        for(List<String> x: equations){
            g.putIfAbsent(x.get(0), new HashMap<>());
            g.get(x.get(0)).put(x.get(1), values[idx]);

            g.putIfAbsent(x.get(1), new HashMap<>());
            g.get(x.get(1)).put(x.get(0), 1/values[idx++]);
        }
        return g;
    }

    public void solveQuery(String s, String e, Map<String, Map<String, Double>> g
    , HashSet<String> vis, double ans, double[] arr, int idx){
        if(vis.contains(s)){
            return;
        }

        if(s.equals(e)){
            arr[idx] = ans;
            return;
        }
        

        vis.add(s);
        for(Map.Entry<String, Double> x: g.get(s).entrySet()){
            String nbr = x.getKey();
            double val = x.getValue();

            solveQuery(nbr, e, g, vis, ans*val, arr, idx);
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> g = createGraph(equations, values);
        double[] arr = new double[queries.size()];

        for(int i=0; i< queries.size(); i++){
            String s1 = queries.get(i).get(0);
            String s2 = queries.get(i).get(1);

            if(!g.containsKey(s1) || !g.containsKey(s2)){
                arr[i] = -1.0;
                continue;
            }

            HashSet<String> vis = new HashSet<>();
            double ans = 1.0;
            arr[i] = -1.0;
            solveQuery(queries.get(i).get(0), queries.get(i).get(1), g, vis, ans, arr, i);
        }

        return arr;
    }
}
