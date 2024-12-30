 package Queue;

class priorityQueue {

    private int top;
    private int arr[];

    priorityQueue(int initialSize){
        arr=new int[initialSize];
        top=0;
    }

    void insert(int num){
        
        if(arr[1]==0){
            arr[1]=num;
            top++;
            return;
        }

        if (top==arr.length-1) {
            increaseSize();
        }

        arr[++top]=num;

        heapify(this.top);

    }

    int poll(){

        if (top==0) {
            System.out.println("Empty Priority Queue");
            return Integer.MIN_VALUE;
        }

        int elementToPoll = arr[1];

        arr[1]=arr[top];
        arr[top]=0;
        top--;

        int temp=1;

        while (true) {

            if ((temp*2)<=top){
                if (((temp*2)+1)<=top) {
                    if (arr[temp*2]>arr[(temp*2)+1]) {
                        if (arr[temp]>arr[(temp*2)+1]) {
                            int t = arr[temp];
                            arr[temp]=arr[(temp*2)+1];
                            arr[(temp*2)+1]=t;
                            temp=(temp*2)+1;
                            
                        }else{
                            break;
                        }
                    }else{
                        if (arr[temp]>arr[(temp*2)]) {
                            int t = arr[temp];
                            arr[temp]=arr[(temp*2)];
                            arr[(temp*2)]=t;
                            temp=(temp*2);
                            
                        }
                        else{
                            break;
                        }
                    }
                }
                else{
                    if (arr[temp]>arr[temp*2]) {
                        int t = arr[temp];
                        arr[temp]=arr[(temp*2)];
                        arr[(temp*2)]=t;
                        temp=temp*2;
                    }
                    else{
                        break;
                    }
                }
            }
            else{
                break;
            }
        }
        return elementToPoll;
        }


        int peek(){
            if (top==0) {
                System.out.println("Empty Priority Queue");
                return Integer.MIN_VALUE;
            }
            return arr[1];
        }

        void display(){

            if (top==0) {
                System.out.println("Empty Priority Queue");
                return;
            }
            System.out.print("P Queue : ");
            for (int i = 1; i <= top; i++) {
                System.out.print(arr[i]+" --> ");
            }
            System.out.println("\n");
        }

        int size(){
            return top;
        }


    private void heapify(int top){

        while (arr[top/2]>arr[top] && top>1) {
            int temp=arr[top/2];
            arr[top/2]=arr[top];
            arr[top]=temp;
            top/=2;
        }

    }
    
    private void increaseSize(){

        int temp[]=new int[arr.length*2];

        for (int i = 0; i < arr.length; i++) {
            temp[i]=arr[i];
        }
        arr=temp;
    }


}