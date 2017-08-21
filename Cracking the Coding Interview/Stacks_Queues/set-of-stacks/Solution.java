package Stacks_Queues;

import java.util.ArrayList;

// Implement a data structure SetOfStacks
public class Solution {
	static class SetOfStacks {
		// list of stacks
		private ArrayList<Stack> stacks;
		// maximum capacity for each stack
		private int capacity;
		// list of stacks' sizes
		private ArrayList<Integer> sizes;

		public SetOfStacks(int maxCapacity) {
			stacks = new ArrayList<Stack>();
			sizes = new ArrayList<Integer>();
			this.capacity = maxCapacity;
		}

		// push a value into the last stack
		public void push(int value) {

			if (stacks.isEmpty() == true) {
				stacks.add(new Stack(value));
				sizes.add(1);
				return;
			}

			int currIndex = stacks.size() - 1;
			if (sizes.get(currIndex) < capacity) {
				stacks.get(currIndex).push(value);
				sizes.set(currIndex, sizes.get(currIndex) + 1);
			} else {
				stacks.add(new Stack(value));
				sizes.add(1);
			}
		}

		public int pop() {
			if (stacks.isEmpty() == true)
				return -1;

			int currIndex = stacks.size() - 1;
			if (stacks.get(currIndex).isEmpty() == true)
				return -1;

			int value = stacks.get(currIndex).pop();
			sizes.set(currIndex, sizes.get(currIndex) - 1);
			if (sizes.get(currIndex) == 0) {
				stacks.remove(currIndex);
				sizes.remove(currIndex);
			}

			return value;
		}

		public int popAt(int i) {
			if (i >= stacks.size())
				return -1;

			int value = stacks.get(i).pop();
			sizes.set(i, sizes.get(i) - 1);
			if (sizes.get(i) == 0) {
				stacks.remove(i);
				sizes.remove(i);
			}

			return value;
		}
	}
	
	public static void main(String[] args) {
		SetOfStacks set = new SetOfStacks(5);
		set.push(1);
		set.push(2);
		set.push(3);
		set.push(4);
		set.push(5);
		
		set.push(6);
		
		System.out.println(set.pop());
		System.out.println(set.pop());
		
		System.out.println(set.popAt(1));
	}
}
