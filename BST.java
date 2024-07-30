
    class BST {
        // Node class representing a node in the BST
        class Node {
            int key;
            Node left, right;
    
            public Node(int item) {
                key = item;
                left = right = null;
            }
        }
    
        // Root node of the BST
        Node root;
    
        // Constructor to initialize the BST with an empty root
        BST() {
            root = null;
        }
    
        // Method to insert a new key in the BST
        void insert(int key) {
            root = insertRec(root, key);
        }
    
        // Recursive method to insert a new key in the BST
        Node insertRec(Node root, int key) {
            // If the tree is empty, return a new node
            if (root == null) {
                root = new Node(key);
                return root;
            }
    
            // Otherwise, recursively traverse down the tree
            if (key < root.key)
                root.left = insertRec(root.left, key);
            else if (key > root.key)
                root.right = insertRec(root.right, key);
    
            // Return the (unchanged) root node
            return root;
        }
    
        // Method to delete a key from the BST
        void deleteKey(int key) {
            root = deleteRec(root, key);
        }
    
        // Recursive method to delete a key from the BST
        Node deleteRec(Node root, int key) {
            // Base case: if the tree is empty
            if (root == null) return root;
    
            // Recursively traverse down the tree
            if (key < root.key)
                root.left = deleteRec(root.left, key);
            else if (key > root.key)
                root.right = deleteRec(root.right, key);
            else {
                // Node to be deleted found
    
                // Node with only one child or no child
                if (root.left == null)
                    return root.right;
                else if (root.right == null)
                    return root.left;
    
                // Node with two children: get the inorder successor (smallest in the right subtree)
                root.key = minValue(root.right);
    
                // Delete the inorder successor
                root.right = deleteRec(root.right, root.key);
            }
    
            return root;
        }
    
        // Method to find the minimum value node in the BST
        int minValue(Node root) {
            int minValue = root.key;
            while (root.left != null) {
                minValue = root.left.key;
                root = root.left;
            }
            return minValue;
        }
    
        // Method to search for a key in the BST
        boolean search(int key) {
            return searchRec(root, key) != null;
        }
    
        // Recursive method to search for a key in the BST
        Node searchRec(Node root, int key) {
            // Base case: root is null or key is present at root
            if (root == null || root.key == key)
                return root;
    
            // Key is greater than root's key
            if (root.key < key)
                return searchRec(root.right, key);
    
            // Key is smaller than root's key
            return searchRec(root.left, key);
        }
    
        // Method for in-order traversal of the BST
        void inorder() {
            inorderRec(root);
        }
    
        // Recursive method for in-order traversal of the BST
        void inorderRec(Node root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.key + " ");
                inorderRec(root.right);
            }
        }
    
        // Method for pre-order traversal of the BST
        void preorder() {
            preorderRec(root);
        }
    
        // Recursive method for pre-order traversal of the BST
        void preorderRec(Node root) {
            if (root != null) {
                System.out.print(root.key + " ");
                preorderRec(root.left);
                preorderRec(root.right);
            }
        }
    
        // Method for post-order traversal of the BST
        void postorder() {
            postorderRec(root);
        }
    
        // Recursive method for post-order traversal of the BST
        void postorderRec(Node root) {
            if (root != null) {
                postorderRec(root.left);
                postorderRec(root.right);
                System.out.print(root.key + " ");
            }
        }
    
        // Main method to demonstrate the BST operations
        public static void main(String[] args) {
            BST tree = new BST();
    
            // Insert nodes
            tree.insert(50);
            tree.insert(30);
            tree.insert(20);
            tree.insert(40);
            tree.insert(70);
            tree.insert(60);
            tree.insert(80);
    
            // Print in-order traversal
            System.out.println("In-order traversal:");
            tree.inorder();
            System.out.println();
    
            // Print pre-order traversal
            System.out.println("Pre-order traversal:");
            tree.preorder();
            System.out.println();
    
            // Print post-order traversal
            System.out.println("Post-order traversal:");
            tree.postorder();
            System.out.println();
    
            // Search for a node
            System.out.println("Search for 40: " + tree.search(40));
            System.out.println("Search for 90: " + tree.search(90));
    
            // Delete a node
            tree.deleteKey(20);
            System.out.println("In-order traversal after deleting 20:");
            tree.inorder();
            System.out.println();
    
            tree.deleteKey(30);
            System.out.println("In-order traversal after deleting 30:");
            tree.inorder();
            System.out.println();
    
            tree.deleteKey(50);
            System.out.println("In-order traversal after deleting 50:");
            tree.inorder();
            System.out.println();
        }
    }

