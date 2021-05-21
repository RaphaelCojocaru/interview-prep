import java.util.*;

// https://www.hackerrank.com/challenges/java-dequeue/problem
public class test {
    public static int maximumUniqueSubarray(int[] array, int length) {
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        int maxLength = 0, firstElem;

        // Perform initial iteration to setup the content of Deque and Set
        for (int i = 0; i < length; i++) {
            deque.add(array[i]);
            set.add(array[i]);
            maxLength = set.size();
        }

        for (int i = length; i < array.length; i++) {
            firstElem = deque.removeFirst();

            if (!deque.contains(firstElem)) {
                set.remove(firstElem);
            }

            deque.addLast(array[i]);
            set.add(array[i]);

            if (set.size() > maxLength) {
                maxLength = set.size();
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int noOfElements = scan.nextInt();
        int[] array = new int[noOfElements];
        int length = scan.nextInt();

        for (int i = 0; i < noOfElements; i++) {
            array[i] = scan.nextInt();
        }

        System.out.println(maximumUniqueSubarray(array, length));
    }
}
