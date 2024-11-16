import java.util.ArrayList;

public class MorseCodeTree  implements LinkedConverterTreeInterface<String>{
	private TreeNode<String> root;
	
	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
	}
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = new TreeNode<String>(newNode);
	}

	@Override
	public void insert(String code, String result) {
		this.addNode(root, code, result);
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() == 0) {
			root.data = letter;
		}else {
			String newCode = code.substring(1);
			if(code.charAt(0)== '.') {
				if(root.left == null) {
					root.left = new TreeNode<String>("");
				}
				addNode(root.left, newCode, letter);
			}else if(code.charAt(0) == '-') {
				if(root.right == null) {
					root.right = new TreeNode<String>("");
				}
				addNode(root.right, newCode, letter);
			}
		}
	}

	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if(code.length() == 0) {
			return root.getData();
		}else {
			String newCode = code.substring(1);
			if(code.charAt(0)== '.') {
				return fetchNode(root.left, newCode);
			}else {
				return fetchNode(root.right, newCode);
			}
		}
	}

	@Override
	public LinkedConverterTreeInterface delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void buildTree() {
		addNode(root, "", "");
		addNode(root, ".-", "a");
		addNode(root, "-...", "b");
		addNode(root, "-.-.", "c");
		addNode(root, "-..", "d");
		addNode(root, ".", "e");
		addNode(root, "..-.", "f");
		addNode(root, "--.", "g");
		addNode(root, "....", "h");
		addNode(root, "..", "i");
		addNode(root, ".---", "j");
		addNode(root, "-.-", "k");
		addNode(root, ".-..", "l");
		addNode(root, "--", "m");
		addNode(root, "-.", "n");
		addNode(root, "---", "o");
		addNode(root, ".--.", "p");
		addNode(root, "--.-", "q");
		addNode(root, ".-.", "r");
		addNode(root, "...", "s");
		addNode(root, "-", "t");
		addNode(root, "..-", "u");
		addNode(root, "...-", "v");
		addNode(root, ".--", "w");
		addNode(root, "-..-", "x");
		addNode(root, "-.--", "y");
		addNode(root, "--..", "z");
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(root, list);
		return list;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root.left == null) {
			list.add(root.data);
		}else {
			LNRoutputTraversal(root.left, list);
			list.add(root.data);
		}
		if(root.right != null) {
			LNRoutputTraversal(root.right, list);
		}
		
	}

}
