import java.util.ArrayList;


public class subsequencesPattern {
    static void printAll(int[] arr, int index, ArrayList<Integer> list){
        if(index>= arr.length){
            System.out.print(list.toString()+" ");
            return;
        }

        //pick case
        list.add(arr[index]);
        printAll(arr, index+1, list);

        //not pick case
        list.remove(list.size()-1);
        printAll(arr, index+1, list);
    }

    static void printWithSum(int[] arr, int index,int k, int sum, ArrayList<Integer> list){
        if(index == arr.length){
            if(sum == k){
                System.out.print(list.toString()+" ");
            }
            return;
        }
        //pick- case
        list.add(arr[index]);
        sum+= arr[index];
        printWithSum(arr, index+1, k, sum, list);

        // not-pick case
        sum -= arr[index];
        list.remove(list.size()-1);
        printWithSum(arr, index+1, k, sum, list);
    }

    static boolean printOneWithSum(int[] arr, int index,int k, int sum, ArrayList<Integer> list){
        if(index == arr.length){
            // if condn is statisfied return a true
            if(sum == k){
                System.out.print(list.toString()+" ");
                return true;
            }
            // else return a false
            return false;
        }
        //pick- case
        list.add(arr[index]);
        sum+= arr[index];
        if(printOneWithSum(arr, index+1, k, sum, list) == true) return true;
        // if above return true, no need to move further as task is already done

        // if not then move forward
        // not-pick case
        sum -= arr[index];
        list.remove(list.size()-1);
        if(printOneWithSum(arr, index+1, k, sum, list)) return true;
        // do not move forward if returnde true

        // else return false if both do not return true
        return false;
    }

    static int countWithSum(int[] arr, int k, int index, int sum, ArrayList<Integer>list){
        //base case
        if(index == arr.length){
            // condition satisfied
            if(sum == k){
                return 1;
            }

            //condition not satisfied
            return 0;
        }

        // case pick
        list.add(arr[index]);
        sum += arr[index];
        int l = countWithSum(arr, k, index+1, sum, list);

        // case - not pick
        list.remove(list.size()-1);
        sum -= arr[index];
        int r = countWithSum(arr, k, index+1, sum, list);

        return l+r;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,1};
        ArrayList<Integer> list = new ArrayList<>();

        //printAll(arr, 0, list);
        System.out.println(countWithSum(arr, 2, 0, 0, list));
    }
}
