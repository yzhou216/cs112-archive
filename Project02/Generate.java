import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.lang.StringBuilder;
public class Generate {
    static final int MAX = 256;
    ArrayList<Node> nodeList = new ArrayList<Node>();
    static ArrayList<Node> nodeListCOPY = new ArrayList<Node>();
    void charCount(String str) {
        int count[] = new int[MAX];
        int len = str.length();
        for (int i = 0; i < len; i++) {
            count[str.charAt(i)]++;
        }
        char ch[] = new char[str.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == ch[j]) {
                    find++;
                }
            }
            if (find == 1) {
                Node node = new Node();
                node.setInput(str.charAt(i));
                node.setCount(count[str.charAt(i)]);
                node.setCompressedSymbol("");
                nodeList.add(node);
            }
        }
    }
    public void assign(Node root, String compressedSymbol) {
        if (root == null)
            return;
        if (root.getLeft() == null && root.getRight() == null) {
            root.setCompressedSymbol(compressedSymbol);
            return;
        }
        assign(root.getLeft(), compressedSymbol + "0");
        assign(root.getRight(), compressedSymbol + "1");
    }

    public void encodeMap(Node root, String compressedSymbol, HashMap<Character, String> map) {
        if (root == null)
            return;
        if (root.getLeft() == null && root.getRight() == null) {
            map.put(root.getInput(), compressedSymbol);
            return;
        }
        encodeMap(root.getLeft(), compressedSymbol + "0", map);
        encodeMap(root.getRight(), compressedSymbol + "1", map);
    }
    public static void main(String[] args) {
        Generate huff = new Generate();
        String fileString = "";
        try {
            File file = new File(args[0]);
            Scanner fileReader = new Scanner(file);
            fileString = fileReader.nextLine();
            while (fileReader.hasNextLine())
                fileString += fileReader.nextLine();
            huff.charCount(fileString);
            fileReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File not found.");
            exception.printStackTrace();
        }
        huff.nodeList.sort(new Node());
        nodeListCOPY.addAll(huff.nodeList);
        while (huff.nodeList.size() > 1) {
            Node first = huff.nodeList.get(0);
            Node second = huff.nodeList.get(1);
            Node parent = new Node();
            parent.setCount(first.getCount() + second.getCount());
            parent.setCompressedSymbol("");
            parent.setLeft(first);
            parent.setRight(second);
            huff.nodeList.remove(second);
            huff.nodeList.remove(first);
            huff.nodeList.add(parent);
            huff.nodeList.sort(new Node());
        }
        Node root = huff.nodeList.get(0);
        root.setCompressedSymbol("");
        huff.assign(root, "");
        for (Node node : nodeListCOPY) {
            System.out.println(node);
        }
        try {
            File write = new File("codebook.txt");
            if (write.createNewFile()) {
                System.out.println("File created: " + write.getName());
            } else {
                System.out.println(write.getName() + ": " + "File already exists.");
            }
        } catch (IOException exception) {
            System.out.println("Error creating file");
            exception.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("codebook.txt");
            for (Node node : nodeListCOPY) {
                myWriter.write((int) node.getInput() + ":" + node.getCompressedSymbol() + "\n");
            }
            myWriter.close();
        } catch (IOException exception) {
            System.out.println("Error writing to file.");
            exception.printStackTrace();
        }
        HashMap<Character, String> map = new HashMap<Character, String>();
        huff.encodeMap(root, "", map);
        System.out.println("Original String: " + fileString);
        StringBuilder huffmanString = new StringBuilder();
        for (char c : fileString.toCharArray()) {
            huffmanString.append(map.get(c));
        }
        System.out.println("Huffman String: " + huffmanString);
    }
}
