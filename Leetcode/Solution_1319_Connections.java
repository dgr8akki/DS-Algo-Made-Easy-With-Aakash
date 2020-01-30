class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[] root = new int[n];
        int cnt = 0, extra = 0;
        for(int i = 0; i < n; i++)
            root[i] = i;
        
        for(int[] c : connections) {
            int r1 = find(root, c[0]);
            int r2 = find(root, c[1]);
            if(r1 == r2) extra++;
            root[r2] = r1;
        }
        for(int i = 0; i < n; i++) {
            if(root[i] == i) cnt++;
        }
        return cnt - 1 <= extra ? cnt - 1 : -1;
    }
    private int find(int[] root, int id) {
        while(id != root[id])
            id = root[id];
        return id;
    }
}