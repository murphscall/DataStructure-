import java.io.*;

public class G2447 {
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		int N = 27; // 예: 27입력 (3^3)
		arr = new char[N][N];

		fillStars(0, 0, N, false);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

	public static void fillStars(int x, int y, int size, boolean blank) {
		if (blank) {
			for (int i = x; i < x + size; i++) {
				for (int j = y; j < y + size; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}

		if (size == 1) {
			arr[x][y] = '*';
			return;
		}

		int newSize = size / 3;
		int count = 0;
		for (int i = x; i < x + size; i += newSize) {
			for (int j = y; j < y + size; j += newSize) {
				count++;
				if (count == 5) {
					fillStars(i, j, newSize, true); // 가운데만 공백
				} else {
					fillStars(i, j, newSize, false);
				}
			}
		}
	}
}
