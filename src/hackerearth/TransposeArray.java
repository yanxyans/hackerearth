package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransposeArray {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			String[] header = reader.readLine().split(" ");
			int n = Integer.parseInt(header[0]);
			int m = Integer.parseInt(header[1]);
			int[][] arr = new int[m][n];
			for (int i = 0; i < n; i++) {
				String[] line = reader.readLine().split(" ");
				for (int j = 0; j < m; j++) {
					arr[j][i] = Integer.parseInt(line[j]);
				}
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (j > 0) {
						System.out.print(" ");
					}
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		} catch (IOException e) {
			
		}
	}

}
