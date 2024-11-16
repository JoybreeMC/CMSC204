
public class TreeNode<T> {// T must be an imutable type
	protected TreeNode<T> left;
	protected TreeNode<T> right;
	protected T data;
	TreeNode(T data){
		this.data = data;
		left = null;
		right = null;
	}

	TreeNode(TreeNode<T> node){
		data = node.getData();
		left = node.left;
		right = node.right;
	}
	public T getData(){
		return data;
	}
}
