import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> result = new ArrayList<>();
        List<String> stack = new ArrayList<>();
        while (true) {
            result.clear();
            stack.clear();
            String string = scanner.nextLine();
            if (string.equals("exit")) {
                break;
            }
            String[] strs = string.split(" ");
            if (strs.length < 2) {
                throw new IllegalArgumentException(string + " isn`t expression");
            }
            for (String str : strs
            ) {
                if (str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-") || str.equals("(") || str.equals(")")) {
                    if (stack.isEmpty()) {
                        stack.add(str);
                    } else if ((!stack.get(stack.toArray().length - 1).equals("*") && !stack.get(stack.toArray().length - 1).equals("/")) & !str.equals(")")) {
                        stack.add(str);
                    } else {
                        if (str.equals("*") || str.equals("/")) {
                            for (int i = stack.size() - 1; i >= 0; i--) {
                                String el = stack.get(i);
                                if (el.equals("*") || el.equals("/")) {
                                    result.add(el);
                                    stack.remove(el);
                                } else
                                    break;
                            }
                            stack.add(str);
                        } else if (str.equals("+") || str.equals("-")) {
                            for (int i = stack.size() - 1; i >= 0; i--) {
                                String el = stack.get(i);
                                if (el.equals("*") || el.equals("/") || el.equals("+") || el.equals("-")) {
                                    result.add(el);
                                    stack.remove(el);
                                } else
                                    break;
                            }
                            stack.add(str);
                        } else if (str.equals("(")) {
                            stack.add(str);
                        } else if (str.equals(")")) {
                            for (int i = stack.size() - 1; i >= 0; i--) {
                                String el = stack.get(i);
                                if (!el.equals("(")) {
                                    result.add(el);
                                    stack.remove(i);
                                } else {
                                    stack.remove("(");
                                    stack.remove(")");
                                    break;
                                }
                            }
                        }

                    }
                } else {
                    try {
                        Double.parseDouble(str);
                    } catch (NumberFormatException nfe) {
                        throw new IllegalArgumentException(str + " isn`t a number");
                    }
                    result.add(str);
                }
            }

            if (!stack.isEmpty()) {
                for (int i = stack.size() - 1; i >= 0; i--) {
                    result.add(stack.get(i));
                }
            }

            stack.clear();
            Double res = 0.0;
            for (String item : result
            ) {
                if (!item.equals("*") && !item.equals("/") && !item.equals("+") && !item.equals("-")) {
                    stack.add(item);
                } else if (item.equals("*") || item.equals("/") || item.equals("+") || item.equals("-")) {
                    int index1 = stack.size() - 1;
                    int index2 = stack.size() - 2;
                    double value2 = Double.parseDouble(stack.get(index1));
                    double value1 = Double.parseDouble(stack.get(index2));

                    stack.remove(index1);
                    stack.remove(index2);

                    res = 0.0;
                    if (item.equals("*")) {
                        res = value1 * value2;
                    } else if (item.equals("/")) {
                        if (value2 == 0) {
                            throw new IllegalArgumentException("Division by zero");
                        }
                        res = value1 / value2;
                    } else if (item.equals("+")) {
                        res = value1 + value2;
                    } else if (item.equals("-")) {
                        res = value1 - value2;
                    }
                    stack.add(String.valueOf(res));
                }
            }
            System.out.println(res);
        }
    }
}
