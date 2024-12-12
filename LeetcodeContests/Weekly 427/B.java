// could have solved it during vc if stayed calm, focused solely on problem

class Solution {
    public boolean isComValid(int[][] points , int[] a, int[] b, int[] c, int[] d){
        for(int i=0; i < points.length; i++){
            int x = points[i][0], y = points[i][1];
            if(( x==a[0] && y==a[1] ) || (x==b[0] && y==b[1]) || (x==c[0] && y==c[1]) || (x==d[0] && y==d[1])){
                continue;
            }

            if((x >= a[0] && x<=c[0]) && (y>=a[1] && y<=b[1])){
                return false;
            }
        }
        return true;
    }

    public int findArea(int[][] points , int[] a, int[] b, int[] c, int[] d){
        if(a[0] == b[0] && c[0]==d[0]
         && a[1] == c[1] && b[1]==d[1]
         && isComValid(points, a, b, c, d)){
            return (c[0]-a[0]) * (b[1] - a[1]);
        }
        else{
            return -1;
        }
    }

    public int maxRectangleArea(int[][] points) {
        int m = points.length;
        int maxAr = -1, ar=-1;
       Arrays.sort(points, new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            if(a[0] == b[0]){
                return Integer.compare(a[1], b[1]); 
            }
            else {
                return Integer.compare(a[0], b[0]);
            }
        }
    });


        for(int i=0; i< m; i++){
            int[] a = points[i];    
            for(int j=i+1; j< m; j++){
                int[]  b = points[j];
                for(int k=j+1; k< m; k++){
                    int[]  c = points[k];
                    for(int l=k+1; l< m; l++){
                        int[]  d = points[l];
                        ar = -1;

                        ar = findArea(points , a, b, c, d);
                        maxAr = Math.max(maxAr, ar);
                    }
                }
        }
    }

        return maxAr;
    }
}
