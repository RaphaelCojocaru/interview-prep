package Stacks_Queues;

// Implement a MyQueue class which implements a queue using two stacks.
public class Solution {
	static class MyQueue {
		private Stack s1, s2;

		public MyQueue() {
			// create two empty stacks
			s1 = new Stack(1);
			s1.pop();
			s2 = new Stack(2);
			s2.pop();
		}

		public void enqueue(int value) {
			s1.push(value);
		}

		public int dequeue() {
			int value = -1;

			if (s1.isEmpty() == true)
				return value;

			// move all the elements from s1 to s2
			while (s1.isEmpty() == false) {
				int tmp = s1.pop();
				s2.push(tmp);
			}

			// get the top element of the s2
			value = s2.pop();

			// move all the elements back to s1
			while (s2.isEmpty() == false) {
				int tmp = s2.pop();
				s1.push(tmp);
			}

			return value;
		}
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

	}
}
