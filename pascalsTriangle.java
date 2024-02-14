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
    public static void main(String[] args) {

        int ncr = nCr(8,6);
        System.out.println(ncr);
        
    }
    
}
