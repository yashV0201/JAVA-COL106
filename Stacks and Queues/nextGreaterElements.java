import java.util.Stack;

public class nextGreaterElements {

    static int[] optimal(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {3,4,2,7,5,8,10,6};
        int[] queries = {2, 4};

        int[] result = optimal(arr);

        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                result[i] = arr[i + result[i]];
            }
        }

        for (int q : queries) {
            System.out.println("Number of next greater elements to the right of index " + q + ": " + result[q]);
        }
    }
}
