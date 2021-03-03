package BinarySearchTree;

public class BinarySearchTree {
    Node root;

    public void add(int data){
        Node nodeToAdd = new Node(data);
        if(root == null){
            root = nodeToAdd;
        }
        traverseAndAdd(root,nodeToAdd);
    }

    private void traverseAndAdd(Node traverseNode, Node nodeToAdd){
        if(nodeToAdd.data < traverseNode.data){

            if(traverseNode.left == null){
                traverseNode.left = nodeToAdd;
            }else {
                traverseAndAdd(traverseNode.left,nodeToAdd);
            }
        }else if(nodeToAdd.data > traverseNode.data){

            if(traverseNode.right == null){
                traverseNode.right = nodeToAdd;
            }else {
                traverseAndAdd(traverseNode.right,nodeToAdd);
            }
        }
    }
    public void traverse(){

        if(root != null) {
            Node nodeToTraverse = root;
            if (nodeToTraverse.left == null && nodeToTraverse.right == null) {
                System.out.println(nodeToTraverse.data);
            }else {
                if (nodeToTraverse.left != null) {
                    inOrderTraverse(nodeToTraverse.left);
                }
                if (nodeToTraverse.right != null) {
                    inOrderTraverse(nodeToTraverse.right);
                }
            }
        }

    }
    private void inOrderTraverse(Node node){

        if(node.left != null){
            inOrderTraverse(node.left);
        }
        System.out.println(node.data);

        if(node.right != null){
            inOrderTraverse(node.right);
        }
    }
}
