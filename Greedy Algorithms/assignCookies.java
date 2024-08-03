
import java.util.Arrays;

public class assignCookies{
    static int optimal(int[] g, int[] s){
        int l = 0, m = g.length, r=0;
        Arrays.sort(g);
        Arrays.sort(s);

        while(l<m){
            if(g[l]<=s[r]){
                r++;
            }

            l++;
        }

        return r;
    }

    public static void main(String[] args) {
        int g[] = {1,2};
        int s[] = {1,2,3};

        System.out.println(optimal(g,s));
    }
}