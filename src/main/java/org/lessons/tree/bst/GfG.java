//package org.lessons.tree.bst;
//
//class Node {
//    int key;
//    Node left, right;
//
//    public Node(int item)
//    {
//        key = item;
//        left = right = null;
//    }
//}
//class GfG {
//
//    // function to search a key in a BST
//    static Node search(Node root, int key)
//    {
//        // Base Cases: root is null or key is present at
//        // root
//        if (root == null || root.key == key)
//            return root;
//
//        // Key is greater than root's key
//        if (root.key < key)
//            return search(root.right, key);
//
//        // Key is smaller than root's key
//        return search(root.left, key);
//    }
//
//    public static void main(String[] args)
//    {
//
//        // Creating a hard coded tree for keeping
//        // the length of the code small. We need
//        // to make sure that BST properties are
//        // maintained if we try some other cases.
//        Node root = new Node(50);
//        root.left = new Node(30);
//        root.right = new Node(70);
//        root.left.left = new Node(20);
//        root.left.right = new Node(40);
//        root.right.left = new Node(60);
//        root.right.right = new Node(80);
//
//        // Searching for keys in the BST
//        System.out.println(search(root, 19) != null
//                ? "Found"
//                : "Not Found");
//        System.out.println(search(root, 80) != null
//                ? "Found"
//                : "Not Found");
//    }
//}
