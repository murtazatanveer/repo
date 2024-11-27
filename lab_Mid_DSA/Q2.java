/* 2.	Write a Program that accepts a postfix expression and evaluate postfix expression.*/

class postfix{

    int []arr;
    int size;
    String str;

    postfix(String str){
        arr=new int[str.length()];
        size=-1;
        this.str=str;
    }

    void push(int num){
        arr[++size]=num;
    }

    int pop(){
        int temp=arr[size];
        arr[size--]=0;
        return temp;
    }

    int postfixResult(){

        for(int i=0;i<str.length();i++){

            int first=0;
            int second=0;

          switch (str.charAt(i)) {

            case 43:
             first=pop();
             second=pop();
                push(second+first);
                break;

                case 45:
                 first=pop();
                second=pop();
                push(second-first);
                break;

                case 47:
                first=pop();
                second=pop();
                push(second/first);
                break;


                case 42:
                first=pop();
                second=pop();
                push(second*first);
                break;


                case 94:
                first=pop();
                second=pop();
                push((int)Math.pow(second, first));
                break;

          
            default:
            char ch = str.charAt(i);
            push((int)(ch-'0'));
            break;
          }

        }

        return pop();

    }

}

public class Q2{
    public static void main(String[] args) {
        postfix ob = new postfix(" 623+-382/+*2^3+");
        System.out.println(ob.postfixResult());
    }
}