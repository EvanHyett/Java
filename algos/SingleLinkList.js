

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
    
    insertAtFront( data ) {
        let newNode = new ListNode( data );
        newNode.next = this.head;
        this.head = newNode;
        return;
    }


    removeFromFront() {
        if( !this.isEmpty){
            this.head = this.head.next;
        }
        return;
    }

    insertAtBack( data ) {
        let newNode = new ListNode( data );
        if ( this.isEmpty() ){
            this.head = newNode;
        } else {
            let runner = this.head;
            while( runner.next ){
                runner = runner.next;
            }
            runner.next = newNode;
        }
        return;
    }

    display(){
        if( this.isEmpty() ){
            console.log("This list is empty!")
        } else {
            let n = 0;
            let runner = this.head;
            console.log('node ' + n + ': '+runner.data);
            while( runner.next ){
                runner = runner.next;
                n++;
                console.log('node ' + n + ': '+runner.data);
            }
        }
        return;
    }

    /**
   * Calls insertAtBack on each item of the given array.
   * - Time: O(n * m) n = list length, m = arr.length.
   * - Space: O(1) constant.
   * @param {Array<any>} vals The data for each new node.
   * @returns {SinglyLinkedList} This list.
   */
    seedFromArr(vals) {
        for(let i = 0; i < vals.length; i++) {
            this.insertAtBack(vals[i]);
        }
        return SinglyLinkedList;
    }

/**
    * Converts this list into an array containing the data of each node.
    * - Time: O(n) linear.
    * - Space: O(n).
    * @returns {Array<any>} An array of each node's data.
    */
    toArr(SinglyLinkedList) {
        let arr = []
        arr.push(SinglyLinkedList.head)
        let ref = SinglyLinkedList.head;
        while (ref.next != null){
            arr.push(ref.next);
            ref = ref.next;
        }
    }

/**
   * Creates a new node with the given data and inserts it at the back of
   * this list.
   * - Time: O(?).
   * - Space: O(?).
   * @param {any} data The data to be added to the new node.
   * @param {?ListNode} runner The current node during the traversal of this list
   *    or null when the end of the list has been reached.
   * @returns {SinglyLinkedList} This list.
   */
    insertAtBackRecursive(data, runner = this.head) {
        if(this.isEmpty()){
            this.head = new ListNode(data);
            return this;
        }
        if (runner.next == null) {
            runner.next = new ListNode(data);
            return this;
        }
        return this.insertAtBackRecursive(data, runner.next)
    }

        /**
     * Removes the last node of this list.
     * - Time: O(?).
     * - Space: O(?).
     * @returns {any} The data from the node that was removed.
     */
    removeBack() {
        if (this.isEmpty())  {
            return [];
        }
        let runner = this.head;
        while (runner.next.next) {
            runner = runner.next;
        }
        let returnNode = runner.next;
        runner.next = null;
        return returnNode;
    }

    /**
     * Determines whether or not the given search value exists in this list.
     * - Time: O(?).
     * - Space: O(?).
     * @param {any} val The data to search for in the nodes of this list.
     * @returns {boolean}
     */
    contains(val) {
        let runner = this.head;
        while (runner.next) {
            if(runner.data == val) {
                return true;
            }
            runner = runner.next;
        }
        return false;
    }

    /**
     * Determines whether or not the given search value exists in this list.
     * - Time: O(?).
     * - Space: O(?).
     * @param {any} val The data to search for in the nodes of this list.
     * @param {?ListNode} current The current node during the traversal of this list
     *    or null when the end of the list has been reached.
     * @returns {boolean}
     */
    containsRecursive(val, current = this.head) {
        if (this.isEmpty()) {
            return false;
        }
        if (current.data == val){
            return true;
        }

        if (current.next == null) {
            return false;
        }
        return this.containsRecursive(val, current.next);
    }
}

/**
   * Calls insertAtBack on each item of the given array.
   * - Time: O(n * m) n = list length, m = arr.length.
   * - Space: O(1) constant.
   * @param {Array<any>} vals The data for each new node.
   * @returns {SinglyLinkedList} This list.
   */
    function seedFromArr(vals) {
        for(let i = 0; vals.length; i++) {
            letinsertAtBack(vals[i]);
        }
        return SinglyLinkedList;
    }


    let list = new SinglyLinkedList();
    console.log(list.containsRecursive(2));
    let array = [1, 2, 3, 4, 5];
    console.log(list.insertAtBackRecursive(3));
    list.seedFromArr(array);
    list.display();
    console.log(list.removeBack());
    list.display();
    console.log(list.contains(2));
    console.log(list.contains(7));
    console.log(list.containsRecursive(3));
    console.log(list.containsRecursive(8));
    list.insertAtBackRecursive(8);
    list.display();



