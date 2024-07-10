import java.util.*;
import java.io.*;
public class Main {
    static Node tree = new Node('A', null, null); // 트리는 A부터 시작
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			insert(tree, root, left, right);
		}
		
		pre_order(tree);
		System.out.println();
		in_order(tree);
		System.out.println();
		post_order(tree);
		System.out.println();
	}
	static class Node {
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
	public static void insert(Node temp, char root, char left, char right) {
		if(temp.value == root) {
			temp.left = (left == '.' ? null : new Node(left, null, null));
			temp.right = (right == '.' ? null : new Node(right, null, null));
		} else {
			if(temp.left != null){
				insert(temp.left,root,left,right);
			}
			if(temp.right != null) {
				insert(temp.right, root, left, right);
			}
		}
	}
	public static void pre_order(Node node){
		if(node == null) return;
		System.out.print(node.value);
		pre_order(node.left);
		pre_order(node.right);
	}
	
	public static void in_order(Node node) {
		if(node == null) return;
		in_order(node.left);
		System.out.print(node.value);
		in_order(node.right);
	}
	
	public static void post_order(Node node) {
		if(node == null) return;
		post_order(node.left);
		post_order(node.right);
		System.out.print(node.value);
	}
}