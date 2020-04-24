package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintArrayReverse {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(reader.readLine());
			int[] arr = new int[n];
			for (int i = n - 1; i >= 0; i--) {
				arr[i] = Integer.parseInt(reader.readLine());
			}
			for (int num : arr) {
				System.out.println(num);
			}
		} catch (IOException e) {
			
		}
	}

}
