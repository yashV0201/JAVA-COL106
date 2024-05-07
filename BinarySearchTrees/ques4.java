public class ques4 {
    static int soln(int[] a, int[] target){
        int[] hash1 = new int[10];
        for(int i=0; i<target.length;i++){
            hash1[target[i]] +=1;
        }

        int[] hash2 = new int[10];
        for(int i=0; i<target.length;i++){
            hash2[a[i]] +=1;
        }
        int count = -1;
        boolean similar = false;
        for(int i =0; i<a.length;i++){
            if(hash1[a[i]] != hash2[a[i]]){
                similar =false;
                break;
            } 
            else similar = true;
            
        }
        if(similar) return 0;


        for(int i=0;i<a.length;i++){
            if(a[i]+2>9) continue;
            for(int j=0;j<a.length;j++){
                if(i==j) continue;
                if(a[j]-2<0) continue;
                if(hash1[a[i]] != hash2[a[i]] && hash1[a[j]] != hash2[a[j]] ){
                    if(hash1[a[i]+2] == hash2[a[i]] && hash1[a[j]-2] == hash2[a[j]]){
                        count++;
                        hash2[a[i]]--;
                        hash2[a[j]]--;
                        a[i] = a[i]+2;
                        a[j] = a[j]-2;
                        hash2[a[i]]++;
                        hash2[a[j]]++;

                    }
                }
            }
        }
        if(count>=0) return count+1;
        return count;
    }

    public static void main(String[] args) {
        int[] a= {1,2,5};
        int[] target ={4,1,3}; 
        System.out.println(soln(a,target));
    }
}
