 package Trees;

import java.util.Stack;

class node{

    node left;
    node right;  
    int data;

    node(int data){
        this.data=data;
    }
 }

public class binarySearchTrees {

    node root;

    void insert(int data){

        node newNode = new node(data);

        if (root==null) {
            root=newNode;
            return;
        }
        

        node temp = root;
        node parent=temp;

        while (temp!=null) {
            parent=temp;
            temp = newNode.data>temp.data ? temp.right : temp.left;
        }
        if (newNode.data>parent.data) {
            parent.right=newNode;
        }else{
            parent.left=newNode;
        }
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
            System.out.print(temp.data+" --> ");
            temp=temp.right;

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
                System.out.print(temp.data+" --> ");
                flag=false;
            }else{
                temp=s.peek().right;
                flag=true;
            }

        } while (!s.isEmpty());

        System.out.print("END");
       
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
                System.out.print(temp.data+" --> ");
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

    node maxNode(){

        if (root==null) {
            System.out.println("Empty Tree");
            return null;
        }

        node temp = root;

        while (temp.left!=null) {
            temp=temp.left;
        }

        return temp;

    }

    node minNode(){

        if (root==null) {
            System.out.println("Empty Tree");
            return null;
        }

        node temp = root;

        while (temp.right!=null) {
            temp=temp.right;
        }

        return temp;

    }


    public static void main(String[] args) {
        
        binarySearchTrees tree = new binarySearchTrees();

        tree.insert(75);
        tree.insert(13);
        tree.insert(29);
        tree.insert(50);
        tree.insert(95);
        tree.insert(78);
        tree.insert(43);
        tree.insert(10);
        tree.insert(63);
        tree.insert(26);
        tree.insert(85);
        tree.insert(90);
        tree.insert(80);
        tree.insert(87);
  
        tree.preorderTraversal();
        tree.postorderTraversal();
        tree.inorderTraversal();

        System.out.println(tree.minNode().data);
        System.out.println(tree.maxNode().data);

    }
}
    
    
