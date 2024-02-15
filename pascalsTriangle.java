public class pascalsTriangle {
    static int nCr(int n, int r){
        if(r==0) return 1;
        int ans = 1;
        for(int i = 1; i<=(n-r);i++){
            ans = ans*(n+1-i);
            ans = ans/i;
        }

        return ans;
    }

    static int element(int n, int r){
        return nCr(n-1, r-1);
    }

    static void row(int n){      //optimal solution  TC: O(N)
        int ans = 1;
        System.out.print(ans+" ");
        for(int i=1; i<n; i++){
            ans = ans*(n-i);
            ans = ans/i;
            System.out.print(ans+" ");

        }

    }

    static void triangle(int n){      // optimal soln   TC: O(N*N);
        for(int i=0; i<=n; i++){
            row(i);
            System.out.println();
        }
    }



    public static void main(String[] args) {

        int ncr = nCr(8,6);
        System.out.println();

        int ele = element(5, 3);
        System.out.println(ele);

        row(6);

        triangle(6);
        
    }
    
}
