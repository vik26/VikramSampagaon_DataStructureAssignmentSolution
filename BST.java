package greadedProject3Q2;

public class BST {
	public static Node node;
    static Node prevNode = null;
    static Node headNode = null;
   
   
    static void flattenBTToSkewed(Node root,
                                  int order)
    {
       
        
        if(root == null)
        {
            return;
        }
       
        
        if(order > 0)
        {
            flattenBTToSkewed(root.right, order);
        }
        else
        {
            flattenBTToSkewed(root.left, order);
        }
        Node rightNode = root.right;
        Node leftNode = root.left;
       
        
        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
       
        
        if (order > 0)
        {
            flattenBTToSkewed(leftNode, order);
        }
        else
        {
            flattenBTToSkewed(rightNode, order);
        }
    }
   
    
    static void traverseRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.val + " ");
        traverseRightSkewed(root.right);       
    }
	
	  public static void main(String[] args) {
	  
	  BST tree = new BST(); 
	  tree.node = new Node(50);
	  tree.node.left = new Node(30); 
	  tree.node.right = new Node(60); 
	  tree.node.left.left = new Node(10);
	  tree.node.right.left = new Node(55);
	  
	  
	  int order = 0; flattenBTToSkewed(node, order);
	  traverseRightSkewed(headNode);
	  }
	 

}
