class LRUCache {

    DoublyLinkedList list;
    HashMap<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.list = new DoublyLinkedList();
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Move accessed node to MRU position
        list.remove(node);
        list.addLast(node);

        return node.val;
    }

    public void put(int key, int value) {

        // Case 1: Key already exists
        if (map.containsKey(key)) {
            Node node = map.get(key);

            node.val = value;

            list.remove(node);
            list.addLast(node);

            return;
        }

        // Case 2: Cache is full
        if (list.size() == capacity) {
            Node removed = list.removeFirst();
            map.remove(removed.key);
        }

        // Case 3: Insert new key
        Node node = new Node(key, value);

        list.addLast(node);
        map.put(key, node);
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node previous;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoublyLinkedList {
    int size;
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add an existing node to the end
    public void addLast(Node node) {
        node.previous = tail;
        node.next = null;

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    // Remove and return the first node
    public Node removeFirst() {
        if (head == null) {
            return null;
        }

        Node node = head;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }

        node.next = null;
        node.previous = null;

        size--;
        return node;
    }

    // Remove a specific node
    public void remove(Node node) {

        if (node == head && node == tail) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = node.next;
            head.previous = null;
        } else if (node == tail) {
            tail = node.previous;
            tail.next = null;
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }

        node.next = null;
        node.previous = null;

        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}