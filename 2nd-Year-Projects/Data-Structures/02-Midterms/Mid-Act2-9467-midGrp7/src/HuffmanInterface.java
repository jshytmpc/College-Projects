
import java.util.Map;

public interface HuffmanInterface {
    public boolean printCode(HuffmanNode root, String s);
    public void HuffmanCode();
    public void encodeData(HuffmanNode root, String str, Map<Object, String> huffmanCode);
    public int decodeData(HuffmanNode root, int index, StringBuilder sb);
    public boolean isLeaf(HuffmanNode root);
    public void txtToHuffman(String text2);
    public void HuffmanToTxt(String text);
}
