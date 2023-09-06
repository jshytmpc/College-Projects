package midlab1;

public class InfixToPostfix {
    static int precedence(char x) {
        if (x == '^')
            return 3;
        else if (x == '*' || x == '/')
            return 2;
        else if (x == '+' || x == '-')
            return 1;
        return -1;
    }

    static int evaluatePostfix(String exp) {

        StackClass<Integer> stack = new StackClass<>(999);
        System.out.println("Input        Stack");


        for (int i=0; i<exp.length(); i++) {

            if (exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '*' || exp.charAt(i) == '/' || exp.charAt(i) == '^') {
                int op1 = stack.peek();
                stack.pop();
                int op2 = stack.peek();
                stack.pop();

                switch(exp.charAt(i)) {
                    case '+': stack.push(op2 + op1);
                        break;

                    case '-': stack.push(op2 - op1);
                        break;

                    case '*': stack.push(op2 * op1);
                        break;

                    case '/': stack.push(op2 / op1);
                        break;

                    case '^':
                        stack.push((int) Math.pow(op2,op1));
                    //    stack.push(op2 ^ op1);
                        break;
                }
            }

            else {
                int operand = exp.charAt(i) - '0';
                stack.push(operand);
            }

            System.out.print(exp.charAt(i)+"            ");
            System.out.print(" " + stack.printStack());
            System.out.println();
        }

        return stack.peek();
    }

    static void infixToPostfix(String exp) {
        String postfix = "", space = " ";
        StackClass<Character> stack = new StackClass<>(999);

        System.out.println("Input    Stack" + space.repeat(exp.length()/2) + "Postfix");
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                postfix += c + " ";
            }
            
            else if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.peek() + " ";
                    stack.pop();
                }

                stack.pop();
            }

            else if (c == ']') {
                while (!stack.isEmpty() && stack.peek() != '[') {
                    postfix += stack.peek() + " ";
                    stack.pop();
                }

                stack.pop();
            }

            else if (c == '}') {
                while (!stack.isEmpty() && stack.peek() != '{') {
                    postfix += stack.peek() + " ";
                    stack.pop();
                }

                stack.pop();
            }

            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix += stack.peek() + " ";
                    stack.pop();
                }
                stack.push(c);
            }

            System.out.print(c + "         ");
            System.out.print(stack.printStack() + space.repeat(exp.length() - stack.printStack().length()));
            System.out.print(postfix);
            System.out.println();
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                System.out.println("Expression is invalid");
                return;
            }
            postfix += stack.peek() + " ";
            stack.pop();
        }


        System.out.print("          ");
        System.out.print(stack.printStack() + space.repeat(exp.length() - stack.printStack().length()));
        System.out.print(postfix + "\n\n");

        System.out.println("Postfix: " + postfix + "\n\n");
    }
    }
