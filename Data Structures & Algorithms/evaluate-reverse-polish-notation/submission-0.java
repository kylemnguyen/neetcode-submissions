class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        HashSet<String> operators = new HashSet<>();
        operators.add("*");
        operators.add("/");
        operators.add("-");
        operators.add("+");
        
        for(String s : tokens) {
            if(operators.contains(s)){
                String rightOpr = stack.pop();
                String leftOpr = stack.pop();
                int value = 0;
                switch(s) {
                    case "*":
                        value = Integer.parseInt(leftOpr) * Integer.parseInt(rightOpr);
                        break;
                    case "/":
                        value = Integer.parseInt(leftOpr) / Integer.parseInt(rightOpr);
                        break;
                    case "+":
                        value = Integer.parseInt(leftOpr) + Integer.parseInt(rightOpr);
                        break;                    
                    case "-":
                        value = Integer.parseInt(leftOpr) - Integer.parseInt(rightOpr);
                        break;
                    default:
                        break;
                }
                stack.push(Integer.toString(value));

            } else {
                stack.push(s);
            }
        }

        return Integer.parseInt(stack.pop());

    }
}
