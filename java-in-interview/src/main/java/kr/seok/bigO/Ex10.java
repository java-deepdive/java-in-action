package kr.seok.bigO;

import static java.lang.Math.sqrt;

public class Ex10 {
    /*
        O(n)
     */
    boolean isPrime(int n) {
        for(int x = 2 ; x * x <= n ; x++) {
            if(n % x == 0) {
                return false;
            }
        }
        return true;
    }

    /*
        O (sqrt(n))
     */
    boolean isPrime2(int n) {
        for(int x = 2 ; x <= sqrt(n) ; x++) {
            if(n % x == 0) {
                return false;
            }
        }
        return true;
    }
}
