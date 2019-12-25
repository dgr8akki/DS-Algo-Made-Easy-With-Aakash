package Leetcode;

class Solution_223_RectangleOverlapArea {
    private int[] findRangeOverlap(int point1, int length1, int point2, int length2) {
        int[] res = new int[2];
        int highestStartPoint = Math.max(point1, point2);
        int lowestEndPoint = Math.min(point1 + length1, point2 + length2);

        if (highestStartPoint < lowestEndPoint) {
            res[1] = lowestEndPoint - highestStartPoint;
            res[0] = highestStartPoint;
        }

        return res;
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int[] rec1 = { A, B, C, D };
        int[] rec2 = { E, F, G, H };
        int[] xOverlap = findRangeOverlap(rec1[0], rec1[2] - rec1[0], rec2[0], rec2[2] - rec2[0]);
        int[] yOverlap = findRangeOverlap(rec1[1], rec1[3] - rec1[1], rec2[1], rec2[3] - rec2[1]);
        return (( C - A ) * ( D - B )) + (( G - E ) * ( H - F )) - xOverlap[1] * yOverlap[1];
    }
}
