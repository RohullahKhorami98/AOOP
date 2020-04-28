
public class Queue {
	int front;
	int back;
	int queue[];
	int size;

	/**
	 * 
	 * @param size
	 * @Precondition size > 0
	 */
	public Queue(int size) {
		assert size > 0 : "Precodintion, field if the size is negative";
		this.size = size;
		this.front = -1;
		this.back = -1;
		this.queue = new int[size];

	}

	/**
	 * @precondition size !=0
	 * @postcondition queue >= 2
	 */
	public void resize() {
		assert size != 0 : "precondition size == 0 will not be resized";
		int temp[] = new int[queue.length * 2];
		int n = 0;
		for (int i = front; i <= back; i++) {
			if (i == queue.length)
				i = 0;

			temp[n++] = queue[i];
		}
		back = n - 1;
		front = 0;

		assert queue.length >= 2 : "postcondition Resized";
		queue = temp;

	}

	/**
	 * 
	 * @param data
	 * @precondition data != 0
	 * @postcondition queue[back] == data
	 */
	public void enqueue(int data) {
		assert data != 0 : " precondition can not add a data which is zero";
		if ((back + 1) % queue.length == front) {
			resize();
		} else if (front == -1) {
			front++;
		}
		back = (back + 1) % queue.length;
		assert queue[back] == data : "postcondition, field if the data is not added at the end of the queue";
		queue[back] = data;
	}

	/**
	 * 
	 * @return temp if the dequeue operation was successful
	 * @precondition front != -1
	 * 
	 */
	public int dequeue() {

		assert queue[front] == -1 : "precondtion, dequeue operation field , the queue is empty";

		int temp = queue[front];
		if (front == -1) {
			System.out.println("The queue is empty");

		} else {
			if (front == back) {
				front = back = -1;
			}
			queue[front] = 0;
			front = (front + 1) % queue.length;
		}
		return temp;
	}

	public void show() {
		if (front == -1) {
			System.out.println("Empty queue");

		}

		System.out.println("Front of the queue: " + queue[front]);
		System.out.println("------------------------------------");
		for (int i = 0; i < queue.length; i++) {
			if (queue[i] != 0) {
				System.out.println("All elements in queue:  " + queue[i]);
			}
		}
	}

	public static void main(String[] args) {
		Queue q = new Queue(3);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(0);
		q.show();
		System.out.println("Efter dequeue");
		q.dequeue();
		q.show();

	}

}
