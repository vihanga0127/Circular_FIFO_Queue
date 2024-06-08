package CircularFIFOQueue;

public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Enqueue operation
    public void enqueue(int item) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Get the current size of the queue
    public int size() {
        return size;
    }

    // Main method to demonstrate the circular queue
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        queue.enqueue(55);
        queue.enqueue(28);
        queue.enqueue(70);
        System.out.println("Dequeued item: " + queue.dequeue()); 
        queue.enqueue(88);
        queue.enqueue(56);
        queue.enqueue(65); 
        System.out.println("Queue size: " + queue.size());       
        System.out.println("Dequeued item: " + queue.dequeue()); 
    }
}
