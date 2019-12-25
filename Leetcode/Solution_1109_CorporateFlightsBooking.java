class Solution_1109_CorporateFlightsBooking {
  public int[] corpFlightBookings(int[][] bookings, int n) {
    int[] res = new int[n];
    for (int[] b : bookings) {
      res[b[0] - 1] += b[2];
      if (b[1] < n)
        res[b[1]] -= b[2];
    }
    for (int i = 1; i < n; ++i)
      res[i] += res[i - 1];
    return res;
  }
}
