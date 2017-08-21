package Stacks_Queues;

import java.util.LinkedList;

// An animal shelter holds only dogs and cats, and operates on a strictly "first in,
//first out" basis. People must adopt either the "oldest" (based on arrival time) of
//all animals at the shelter, or they can select whether they would prefer a dog or a cat.
public class Solution {
	static abstract class Animal {
		private int age;
		private String name;

		public Animal(int age, String name) {
			this.age = age;
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}
	}

	static class Dog extends Animal {
		public Dog(int age, String name) {
			super(age, name);
		}

	}

	static class Cat extends Animal {
		public Cat(int age, String name) {
			super(age, name);
		}
	}

	static class AnimalShelter {
		LinkedList<Animal> animals;

		public AnimalShelter() {
			animals = new LinkedList<Animal>();
		}

		public void enqueue(Animal a) {
			animals.addLast(a);
		}

		public Animal dequeueAny() {
			return animals.removeFirst();
		}

		public Cat dequeueCat() {
			// find first cat
			Cat cat;
			LinkedList<Animal> list = new LinkedList<Animal>();

			// remove animals from shelter while not a cat
			while (animals.getFirst() instanceof Cat == false)
				list.addLast(animals.removeFirst());

			// if there are no remaining animals
			if (animals.isEmpty() == true)
				return null;

			// remove and store the first cat from the shelter
			cat = (Cat) animals.removeFirst();

			// put the animals removed before back into the shelter
			while (list.isEmpty() == false)
				animals.addFirst(list.removeLast());

			return cat;
		}

		public Dog dequeueDog() {
			// find first dog
			Dog dog;
			LinkedList<Animal> list = new LinkedList<Animal>();

			// remove animals from shelter while not a dog
			while (animals.getFirst() instanceof Dog == false)
				list.addLast(animals.removeFirst());

			// if there are no remaining animals
			if (animals.isEmpty() == true)
				return null;

			// remove and store the first dog from the shelter
			dog = (Dog) animals.removeFirst();

			// put the animals removed before back into the shelter
			while (list.isEmpty() == false)
				animals.addFirst(list.removeLast());

			return dog;
		}
	}

	public static void main(String[] args) {
		AnimalShelter shelter = new AnimalShelter();
		shelter.enqueue(new Dog(13, "Sparky"));
		shelter.enqueue(new Dog(10, "Lord"));
		shelter.enqueue(new Cat(11, "Blanka"));
		shelter.enqueue(new Dog(6, "Duffy"));
		shelter.enqueue(new Cat(3, "Cuts"));

		
		Animal a2 = shelter.dequeueCat();
		System.out.println(a2.getName());
		Animal a1 = shelter.dequeueAny();
		System.out.println(a1.getName());
		Cat c1 = shelter.dequeueCat();
		System.out.println(c1.getName());
	}
}
