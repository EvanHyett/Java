class ListNode {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    constructor() {
    this.head = null;
    }
    isEmpty() {
        if(this.head){ return false }
        
        return true;
    }

    insertAtBack(data) {
        item = new ListNode(data);
        if(this.isEmpty()){ this.head = item }
        else{
            let nextItem = this.head;
            while(nextItem.next != null){ nextItem = nextItem.next }
            nextItem.next = item;
        }
    }
}