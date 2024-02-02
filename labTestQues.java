import java.util.Vector;

public class labTestQues {

    static Vector<Vector<Integer>> Questions(int n, int m, int k, int[] diff, int[] l, int[] r) {
        Vector<Vector<Integer>> vec = new Vector<>();

        for (int i = 0; i < m; i++) {
            int s = l[i];
            Vector<Integer> row = new Vector<>();
            
            if(l[i]>=n && r[i]>=n){
                vec.add(row);
                continue;
            }
            else if(r[i]>=n){
                r[i] = n-1;
            }

            for (int j = l[i]; j <= r[i]; j++) {
                if (row.isEmpty()) {
                    row.add(j);
                } else {
                    Vector<Integer> tempRow = new Vector<>(row); // Create a temporary copy of the current row
                    boolean a = true;
                    for (Integer ele : tempRow) {
                        if(Math.abs(diff[ele] - diff[j]) >= k){continue;}
                        else{a=false; break;}

                    }
                    if (Math.abs(diff[s] - diff[j]) >= k && a && !row.contains(diff[j])) {
                            row.add(j);
                            s = j;
                    }
                        
                    
                }
            }
            vec.add(row);
        }

        return vec;
    }

    public static void main(String[] args) {

        int[] diff ={20, 10, 14, 15, 15, 18, 16, 9, 8, 12};

        Vector<Vector<Integer>> vec = Questions(10, 5, 2, new int[]{20, 10, 14, 15, 15, 18, 16, 9, 8, 12},
                new int[]{0, 3, 5,11, 0}, new int[]{4, 6, 9,14, 11});

        for (Vector<Integer> row : vec) {
            for (Integer ele : row) {
                System.out.print(diff[ele] + " ");
            }
            System.out.println();
        }
    }
}


