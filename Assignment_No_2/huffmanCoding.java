

package Assignment_No_2;

class node {

    char character; 
    int frequency;  
    node left;
    node right; 

    node(char character, int frequency) {

        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;

    }
    
}

public class huffmanCoding {

   
    int[] findTwoSmallest(node[] nodes, int size) {

        int firstMin = 0, secondMin = 1;

        if (nodes[firstMin].frequency > nodes[secondMin].frequency) {

            firstMin = 1;
            secondMin = 0;

        }

        for (int i = 2; i < size; i++) {

            if (nodes[i].frequency < nodes[firstMin].frequency) {

                secondMin = firstMin;
                firstMin = i;

            } else if (nodes[i].frequency < nodes[secondMin].frequency) {

                secondMin = i;

            }
        }
        return new int[]{firstMin, secondMin};
    }

   
     node buildHuffmanTree(char[] characters, int[] frequencies) {

        int size = characters.length;
        node[] nodes = new node[size];

       
        for (int i = 0; i < size; i++) {

            nodes[i] = new node(characters[i], frequencies[i]);

        }

        
        while (size > 1) {
           
            int[] smallest = findTwoSmallest(nodes, size);
            int firstMin = smallest[0];
            int secondMin = smallest[1];

            
            node left = nodes[firstMin];
            node right = nodes[secondMin];
            node parent = new node('-', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;

           
            nodes[firstMin] = parent;
            nodes[secondMin] = nodes[size - 1];
            size--; 
        }

        
        return nodes[0];
    }

    
     void generateAndPrintHuffmanCodes(node root, String code) {
        if (root == null) {
            return;
        }

        
        if (root.left == null && root.right == null) {
            System.out.println("Character : " + root.character + "\tCode : " + code);
        }

       
        generateAndPrintHuffmanCodes(root.left, code + "0");

        
        generateAndPrintHuffmanCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
       
        char[] chars = { 'A','B','C','D','E','F','G','H' };
        int[] freq = { 7,13,16,13,22,40,10,25};

        huffmanCoding h = new huffmanCoding();
        
        node root = h.buildHuffmanTree(chars, freq);

        System.out.println("Huffman Codes : \n");

        h.generateAndPrintHuffmanCodes(root, "");
    }
}
