package Trees;

import java.util.Stack;

public class expressionTree {
    
    String exp;
    node root;

public expressionTree(String exp){
    this.exp=exp;
    root=null;
}

class node{

    node left;
    node right;  
    String data;

    node(String data){
        this.data=data;
    }
 }

    private String infixToPostfix(){

    if (exp==null) {
        System.out.println("Empty Expression");
        return null;
    }

    String result = "";
    Stack<Character> s = new Stack<>();

    for (int i = 0; i < exp.length(); i++){

        String num="";
        
        boolean flag=false;

        while ((exp.charAt(i)>='0'&&exp.charAt(i)<='9') || ((exp.charAt(i)>='a' && exp.charAt(i)<='z') || (exp.charAt(i)>='A'&&exp.charAt(i)<='Z'))){
            flag=true;
            num+=(exp.charAt(i));
            i++;
            if (i>=exp.length()){break;}
        }

        if(flag){result+=(num+" ");}

        if (i>=exp.length()){break;}
        
        if (exp.charAt(i)=='(' || exp.charAt(i)==')') {
            if (exp.charAt(i)=='(') {
                s.push('(');
            }else{
                while (s.peek()!='(') {
                    result += s.pop(); 
                }
                s.pop();
            }
        }

        else {
            char precedence = precedence(exp.charAt(i));
            
            while (!s.isEmpty() && precedence <= precedence(s.peek()) && s.peek()!='(') {
                result+=s.pop();
            }
            s.push(exp.charAt(i));
        }

    }

    while (!s.isEmpty()) {
        result+=s.pop();
    }

    return result;

}  

private char precedence(char op){

    if (op=='^') {
     return 'c';
    }
    else if(op=='+' || op=='-'){
     return 'a';
    }
     return 'b';   
 }

 public void expressionTreeInsertion(){

     exp = infixToPostfix();

    if (exp==null) {
        System.out.println("Empty Expression");
        return;
    }

    Stack<node> s = new Stack<>();


    for (int i = 0; i < exp.length(); i++){

        if (exp.charAt(i)==' ') {
            continue;
        }

        String num="";
        
        while ((exp.charAt(i)>='0'&&exp.charAt(i)<='9') || ((exp.charAt(i)>='a' && exp.charAt(i)<='z') || (exp.charAt(i)>='A'&&exp.charAt(i)<='Z'))){
 
            num+=(exp.charAt(i));
            i++;
            if (i>=exp.length()){break;}
        }

        if (i>=exp.length()){break;}

        if (!num.isEmpty()){

            node digit = new node(num);
            s.push(digit);
        }else{
            node operator = new node(exp.charAt(i)+"");
            operator.right=s.pop();
            operator.left=s.pop();
            s.push(operator);
        }

    }
    root = s.pop();
    if (s.isEmpty()) {
        System.out.println("Expression Inserted");
    }
 }

 void preorderTraversal(){

    if (root==null) {
        System.out.println("Empty Tree");
        return;
    }

    node temp = this.root;

    Stack<node> s = new Stack<node>();

    boolean flag = true;

    System.out.print("\nPre-Order Traversal : ");

    do {
        while (temp!=null && flag) {
            s.push(temp);
            System.out.print(temp.data+" ");
            temp=temp.left;
        }

        if (s.peek().right==temp) {
            temp=s.pop();
            flag=false;
        }else{
            temp=s.peek().right;
            flag=true;
        }

    } while (!s.isEmpty());

    System.out.print("END");
   
}

void postorderTraversal(){
        
    if (root==null) {
        System.out.println("Empty Tree");
        return;
    }
    node temp = this.root;

    Stack<node> s = new Stack<node>();

    boolean flag = true;

    System.out.print("\nPost-Order Traversal : ");

    do {
        while (temp!=null && flag) {
            s.push(temp);
            temp=temp.left;
        }

        if (s.peek().right==temp) {
            temp=s.pop();
            System.out.print(temp.data+" ");
            flag=false;
        }else{
            temp=s.peek().right;
            flag=true;
        }

    } while (!s.isEmpty());

    System.out.print("END");
   
}

void inorderTraversal(){

    if (root==null) {
        System.out.println("Empty Tree");
        return;
    }

    node temp = root;
    Stack<node> s = new Stack<>();

    System.out.print("\nIn-Order Traversal : ");


    do {
        
        while (temp!=null) {
            s.push(temp);
            temp=temp.left;
        }

        temp=s.pop();
        System.out.print(temp.data+" ");
        temp=temp.right;

    } while (!s.isEmpty());

    System.out.print("END");

}

public static void main(String[] args) {
    expressionTree tree = new expressionTree("a+b*c*d+e");
    tree.expressionTreeInsertion();
    tree.inorderTraversal();
    tree.postorderTraversal();
    tree.preorderTraversal();
}

}
