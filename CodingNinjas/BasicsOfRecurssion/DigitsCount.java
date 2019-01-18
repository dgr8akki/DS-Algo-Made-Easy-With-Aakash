class Solution {
	public static int count(int n){
		if(n >= 0 && n < 10) return 1;
		return 1 + count(n / 10);
	}
}
