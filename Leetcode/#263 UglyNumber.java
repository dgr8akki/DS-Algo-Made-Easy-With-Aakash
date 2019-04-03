class Solution {
    public boolean isUgly(int num) {
        if(num == 0) return false;
        int temp = num;
        while(temp % 2 == 0)
          temp/=2;
        while(temp % 3 == 0)
          temp/=3;
        while(temp % 5 == 0)
          temp/=5;
        return temp == 1;
    }
}