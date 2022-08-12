
/**
 * Class to represent a Node in a Binary Search Tree (BST).
 */
    class BSTNode {
    /**
     * Constructs a new instance of a BST node.
     * @param {number} data The integer to store in the node.
     */
    constructor(data) {
        this.data = data;
      /**
       * These properties are how this node is connected to other nodes to form
       * the tree. Similar to .next in a SinglyLinkedList except a BST node can
       * be connected to two other nodes. To start, new nodes will not be
       * connected to any other nodes, these properties will be set after
       * the new node is instantiated.
       *
       * @type {BSTNode|null}
       */
      this.left = null;
      /** @type {BSTNode|null} */
      this.right = null;
    }
  }
  
  /**
   * Represents an ordered tree of nodes where the data of left nodes are <= to
   * their parent and the data of nodes to the right are > their parent's data.
   */
  class BinarySearchTree {
    constructor() {
      /**
       * Just like the head of a linked list, this is the start of our tree which
       * branches downward from here.
       *
       * @type {BSTNode|null}
       */
      this.root = null;
    }


/**
 * Determines if this tree is empty.
 * - Time: O(?).
 * - Space: O(?).
 * @returns {boolean} Indicates if this tree is empty.
 */
isEmpty() {
    if (this.root == null) {
        return true;
    }
    else return false;
}

/**
 * Inserts a new node with the given newVal in the right place to preserver
 * the order of this tree.
 * - Time: O(?).
 * - Space: O(?).
 * @param {number} newVal The data to be added to a new node.
 * @returns {BinarySearchTree} This tree.
 */
    insert(newVal) {
        let newNode = new BSTNode(newVal)
        if (this.isEmpty()) {
            this.root = newNode;
            return this;
        }
        let runner = this.root;
        let prevNode = null;
        while (runner) {
            if (newVal > runner.data) {
                prevNode = runner;
                runner = runner.right;
            } else {
                prevNode = runner;
                runner = runner.left;
            }
        }
        if (newVal > prevNode.data) {
            prevNode.right = newNode;
        } else {
            prevNode.left = newNode;
        }
        return this
    }

 /**
 * Retrieves the smallest integer data from this tree.
 * - Time: O(?).
 * - Space: O(?).
 * @param {Node} current The node that is currently accessed from the tree as
 *    the tree is being traversed.
 * @returns {number} The smallest integer from this tree.
 */
    min( current = this.root ){
    if( this.isEmpty() ){
        return null;
    }
    while( current.left ){
        current = current.left
    }
    return current.data;
}

    /**
   * Retrieves the smallest integer data from this tree.
   * - Time: O(?).
   * - Space: O(?).
   * @param {Node} current The node that is currently accessed from the tree as
   *    the tree is being traversed.
   * @returns {number} The smallest integer from this tree.
   */
    minRecursive(current = this.root) {
        if (this.isEmpty()) {
            return null;
        } 
        while( current.left ){
            current = current.left
        }
        return this.minRecursive();
    }

 /**
 * Determines if this tree contains the given searchVal.
 * - Time: O(?).
 * - Space: O(?).
 * @param {number} searchVal The number to search for in the node's data.
 * @returns {boolean} Indicates if the searchVal was found.
 */
contains(searchVal) {}

/**
 * Determines if this tree contains the given searchVal.
 * - Time: O(?).
 * - Space: O(?).
 * @param {number} searchVal The number to search for in the node's data.
 * @returns {boolean} Indicates if the searchVal was found.
 */
containsRecursive(searchVal, current = this.root) {}



}

let searchTreeOne = new BinarySearchTree();

searchTreeOne.insert(5);
searchTreeOne.insert(8);
searchTreeOne.insert(3);
searchTreeOne.insert(2);
searchTreeOne.insert(5);
searchTreeOne.insert(9);
console.log(searchTreeOne.minRecursive());
console.log(searchTreeOne.min());
console.log(searchTreeOne.isEmpty());
console.log(searchTreeOne);
