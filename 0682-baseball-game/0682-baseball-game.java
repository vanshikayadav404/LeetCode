class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {

            if (op.equals("+")) {
                int n = stack.size();
                stack.push(stack.get(n - 1) + stack.get(n - 2));
            } 
            else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } 
            else if (op.equals("C")) {
                stack.pop();
            } 
            else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;

        for (int score : stack) {
            sum += score;
        }

        return sum;
    }
}