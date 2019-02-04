public class Queue {
    private class Node {

        private Object data;
        private Node next;

        public Node(Object data, Node next) {

            this.data = data;
            this.next = next;
        }

        public Node(Object data) {

            this.data = data;
            this.next = null;
        }
    }// End of nested class

    private Node head, tail;
    private int size;

    public Queue() {

        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {return this.size;}

    public void enqueue(Object o) {

        Node nn = new Node(o);
        if(this.size == 0) {

            this.head = nn;
            this.tail = nn;
            this.size++;

        } else {
            this.tail.next = nn;
            this.tail = nn;
            this.size++;

        }
    }

    public Object dequeue(){

        Node cur = this.head;
        this.head = this.head.next;
        this.size--;

        return cur.data;
    }

    public void printAll()
    {
        for(Node cur = this.head; cur != null; cur = cur.next)
        {
            System.out.println(cur.data);
        }
    }
}
