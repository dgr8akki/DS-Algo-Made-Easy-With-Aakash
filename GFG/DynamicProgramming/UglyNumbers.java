/**
 * UglyNumbers
 */
public class UglyNumbers {
    static int maxDivide(int a, int b) {
        while (a % b == 0)
            a = a / b;
        return a;
    }

    static boolean isUgly(int number) {
        return maxDivide(maxDivide(maxDivide(number, 2), 3), 5) == 1;
    }

    static int getNthUglyNumber(int n) {
        int i = 1;

        int count = 1;

        while (n > count) {
            i++;
            if (isUgly(i))
                count++;
        }
        return i;
    }

    static int getNthUglyNo(int n) {
        int ugly[] = new int[n];
        int twoStepCounter = 0, threeStepCounter = 0, fiveStepCounter = 0, nextMultipleOfTwo = 2;
        int nextMultipleOfThree = 3;
        int nextMultipleOfFive = 5;
        int nextUglyNo = 1;

        ugly[0] = 1;

        for (int index = 1; index < n; index++) {
            nextUglyNo = Math.min(nextMultipleOfTwo, Math.min(nextMultipleOfThree, nextMultipleOfFive));

            ugly[index] = nextUglyNo;

            if (nextUglyNo == nextMultipleOfTwo)
                nextMultipleOfTwo = ugly[++twoStepCounter] * 2;

            if (nextUglyNo == nextMultipleOfThree)
                nextMultipleOfThree = ugly[++threeStepCounter] * 3;

            if (nextUglyNo == nextMultipleOfFive)
                nextMultipleOfFive = ugly[++fiveStepCounter] * 5;

        }
        return nextUglyNo;
    }

    public static void main(String args[]) {
        System.out.println("1500th ugly " + "no. is " + getNthUglyNo(1500));
    }

}
