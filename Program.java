import java.util.Scanner;

public class Program {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(
				"This utility calculates the least common multiple of an infinite (theoretically)\namount of positive numbers (values up to 2^31-1)");
		// prompt for the amount of numbers
		int population = populationPrompt();
		// making an array according to the amount of numbers
		int[] numbers = new int[population];
		for (int i = 0; i < population; i++) {
			numbers[i] = scanNumber(i);
		}
		// conducting comparison
		int lcm = leastCommonMultiple(numbers, population);
		// output least common multiple
		System.out.print("------\nThe least common multiple is: " + lcm);

	}

	public static int populationPrompt() {
		int population = 0;
		while (population <= 0) {
			System.out.print("How many numbers are you\ngoing to find the LCM for? : ");
			population = scan.nextInt();
		}
		return population;
	}

	public static int scanNumber(int i) {
		int x;
		do {
			System.out.print("Give me number " + (i + 1) + " : ");
			x = scan.nextInt();
		} while (x <= 0);
		return x;
	}

	public static int leastCommonMultiple(int[] arr, int population) {
		for (int i = 1; i < population; i++)
			arr[i] = pairMultiple(arr[i - 1], arr[i]);
		return arr[population - 1];
	}

	public static int pairMultiple(int x, int y) {
		int count = 1;
		while (count <= 2147483647) {
			if (count % x == 0 && count % y == 0)
				break;
			count++;
		}
		return count;
	}

}
