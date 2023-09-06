import java.util.*;
public class Huffman implements HuffmanInterface {
    static Map<Object, String> huffmanCodeChar = new HashMap<>();
    static PriorityQueue<HuffmanNode> q;
    int[] charFreq;

    List<Character> aL = new ArrayList<>();
    List<Integer> aL2 = new ArrayList<>();

    int bitCountA, bitCountB;
    public void intro() {
        System.out.println();
        System.out.println("|----------------------------------------|");
        System.out.println("|------------HUFFMAN CONVERTER-----------|");
        System.out.println("|  BY: ARNOBIT, GORIO, MAYANGAO, TIMPAC  |");
        System.out.println("|........................................|");
        System.out.println();
    }

    public void menu() {
        System.out.println();
        System.out.println("MENU");
        System.out.println("------------------");
        System.out.println("1. Huffman code");
        System.out.println("2. Text to Huffman");
        System.out.println("3. Huffman to Text");
        System.out.println("4. Exit program");
        System.out.println("------------------");
        System.out.println();
    }

    public boolean printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null) {
            Formatter fmt = new Formatter();
            fmt.format("%8s %14s %17s",root.c, s, s.length());
            System.out.println(fmt);
            return false;
        }

        assert root.left != null;
        printCode(root.left, s + "0");
        bitCountB++;
        printCode(root.right, s + "1");
        bitCountB++;
        bitCountB += s.length();
        return false;
    }

    public void HuffmanCode() {
        System.out.println("Input text to Convert: ");
        Scanner s = new Scanner(System.in);
        String txt = s.nextLine();
        int n = txt.length();
        char[] chars = txt.toCharArray();

        System.out.println();
        System.out.println("Huffman Table: ");
        System.out.println();

        System.out.println("--------------------------------------------------");
        Formatter fmt = new Formatter();
        fmt.format("%12s %15s %18s", "Character", "Huffman Code", "Number of Bits");
        System.out.println(fmt);
        System.out.println("--------------------------------------------------");


        int indx, count;

        for (char c : chars) {
            if (!aL.contains(c)) {
                aL.add(c);
                aL2.add(1);
            } else {
                indx = aL.indexOf(c);
                count = aL2.get(indx) + 1;
                aL2.set(indx, count);
            }
            bitCountA++; // counts the frequency
        }


        Object[] charArray = new Object[aL.size()];
        charFreq = new int[aL2.size()];
        for (int i = 0; i < aL2.size(); i++) {
            char el = aL.get(i);
            Integer el2 = aL2.get(i);

            charArray[i] = el;
            charFreq[i] = Integer.parseInt(String.valueOf(el2));
        }


        // min priority queue
        q = new PriorityQueue<HuffmanNode>(n, new Compare());

        for (int i = 0; i < aL2.size(); i++) {

            // creating a Huffman node object
            // and add it to the priority queue.
            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.data = charFreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        // create a root node
        HuffmanNode root = null;

        do {
            // first min extract.
            HuffmanNode min1 = q.peek();
            q.poll();

            // second min extract.
            HuffmanNode min2 = q.peek();
            q.poll();

            // new node = sum of min1 and min2
            HuffmanNode equal = new HuffmanNode();

            // to the sum of the frequency of the two nodes
            // assigning values to the equal node.
            equal.data = min1.data + min2.data;
            equal.c = '-';

            // first extracted node as left child.
            equal.left = min1;

            // second extracted node as the right child.
            equal.right = min2;

            // marking the f node as the root node.
            root = equal;

            // add this node to the priority-queue.
            q.add(equal);
        } while (q.size() > 1);


        // print the codes by traversing the tree
        if (root != null) {
            printCode(root, "");
        }



        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("chars: " + Arrays.toString(charArray));
        System.out.println("freq: " + Arrays.toString(charFreq));

        System.out.println();
        encodeData(root, "", huffmanCodeChar);

    }



    public void encodeData(HuffmanNode root, String str, Map<Object, String> huffmanCode) {
        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            huffmanCode.put(root.c, str.length() > 0 ? str : "1");
        }
        encodeData(root.left, str + '0', huffmanCode);
        encodeData(root.right, str + '1', huffmanCode);
    }

    public int decodeData(HuffmanNode root, int index, StringBuilder sb) {
        if (root == null) {
            return index;
        }
        if (isLeaf(root)) {
            System.out.print(root.c);
            return index;
        }
        index++;
        root = (sb.charAt(index) == '0') ? root.left : root.right;
        index = decodeData(root, index, sb);
        return index;
    }

    public boolean isLeaf(HuffmanNode root) {

        return root.left == null && root.right == null;
    }

    public void txtToHuffman(String text2) {
        StringBuilder sb = new StringBuilder();

        for (char c : text2.toCharArray()) {
            sb.append(huffmanCodeChar.get(c));
        }
        if(filter(String.valueOf(sb))) {
            System.out.println("Error: Only enter characters from the table");
            System.out.println();
            return;
        }
        System.out.println("The encoded string is: " + sb);
    }

    public void HuffmanToTxt(String text) {
        HuffmanNode  root = q.peek();
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        System.out.println();
        System.out.println("The decoded string is: ");
        assert root != null;
        if (isLeaf(root))
        {
            while (root.data-- > 0)
            {
                System.out.print(root.c);
            }
        }
        else
        {

            int index = -1;
            while (index < sb.length() - 1)
            {
                index = decodeData(root, index, sb);
            }
        }
        System.out.println();
    }

    public void percentageStorage() {
        bitCountA = bitCountA*7; // ASCII
        System.out.println();
        System.out.println(bitCountA + " bits is needed when using the ASCII table");
        System.out.println(bitCountB + " bits Huffman coding");
    }

    public static boolean filter(String text) {
        for (int i = 0; i <text.length();i ++){
            String c = String.valueOf(text.charAt(i));
            if (c.matches("[null]+")){
                return true;
            }
        }
        return false;
    }

}



class HuffmanNode {
    int data;
    Object c;

    HuffmanNode left;
    HuffmanNode right;
}
class Compare implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}

