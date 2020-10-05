class BinomialCoefficient { 
  static long binomialCoeff(int n, int k) { 
    long res = 1; 
    
    if (k > n - k) 
      k = n - k; 
    
    for (int i = 0; i < k; ++i) { 
      res *= (n - i); 
      res /= (i + 1); 
    } 
    
    return res; 
  }
    
  static long catalan(int n) { 
    long c = binomialCoeff(2 * n, n); 
    return c / (n + 1); 
  }
    
  public static void main(String[] args) { 
    for (int i = 0; i < 10; i++)
      System.out.print(catalan(i) + " ");
  } 
} 
    