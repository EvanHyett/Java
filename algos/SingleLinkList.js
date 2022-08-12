class ListNode {
    constructor( data ) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    constructor() {
        this.head = null;
    }

    isEmpty() {
        if ( this.head ) {
            return false;
        }
        return true;
    }

    prepend(newVal, targetVal) {
        if( this.isEmpty() ){
            return false;
        }
        let newNode = new ListNode( newVal );
        if( this.head.data == targetVal) {
            newNode.next = this.head;
            this.head = newNode;
            return true
        }
        let runner = this.head;
        while( runner.next ) {
            if( runner.next.data == targetVal ) {
                newNode.next = runner.next;
                runner.next = newNode;
                return true;
            }
            runner = runner.next;
        }
        return false;
    }

    moveMinToFront() {
        if( this.isEmpty() || this.head.next == null){
            return this;
        }
        
        let minNode = this.head;
        let nodeBeforeMinNode = null;
        
        let runner = this.head;
        while( runner.next ){
            if( runner.next.data < minNode.data ) {
                minNode = runner.next;
                nodeBeforeMinNode = runner;
            }
            runner = runner.next;
        }

        if( ! nodeBeforeMinNode ){
            return this;
        }
        
        let nodeAfterMinNode = minNode.next;
        minNode.next = this.head;
        this.head = minNode;
        nodeBeforeMinNode.next = nodeAfterMinNode;
        
        return this;
    }

    /**
 * Concatenates the nodes of a given list onto the back of this list.
 * - Time: O(?).
 * - Space: O(?).
 * @param {SinglyLinkedList} addList An instance of a different list whose
 *    whose nodes will be added to the back of this list.
 * @returns {SinglyLinkedList} This list with the added nodes.
 */
    concat(addList) {}

 /**
 * Splits this list into two lists where the 2nd list starts with the node
 * that has the given value.
 * splitOnVal(5) for the list (1=>3=>5=>2=>4) will change list to (1=>3)
 * and the return value will be a new list containing (5=>2=>4)
 * - Time: O(?).
 * - Space: O(?).
 * @param {any} val The value in the node that the list should be split on.
 * @returns {SinglyLinkedList} The split list containing the nodes that are
 *    no longer in this list.
 */
    splitOnVal(val) {}

/**
 * Recursively finds the maximum integer data of the nodes in this list.
 * - Time: O(?).
 * - Space: O(?).
 * @param {ListNode} runner The start or current node during traversal, or null
 *    when the end of the list is reached.
 * @param {ListNode} maxNode Keeps track of the node that contains the current
 *    max integer as it's data.
 * @returns {?number} The max int or null if none.
 */
    recursiveMax(runner = this.head, maxNode = this.head) {}

    

}


