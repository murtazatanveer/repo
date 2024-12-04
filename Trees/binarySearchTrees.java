 package Trees;

 class node{

    node left;
    node right;  
    int data;

    node(int data){
        this.data=data;
    }
 }

class binarySearchTrees {

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

    
    
}