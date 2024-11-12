package Stack;

public class dynamicStackArray extends stackArray {
    
    dynamicStackArray(int size){
        super(size);
    }

    @Override
    void push(int num) {
        
        if(super.isStackFull()){
            int [] temp=new int[super.arr.length*2];

            for (int i = 0; i < super.arr.length; i++) {
                temp[i]=arr[i];
            }
            super.arr=temp;
            
        }
        super.push(num);
    }

    

}
