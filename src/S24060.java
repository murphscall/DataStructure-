import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S24060 {
	static  int count = 0;
	static int K;
	static int result;
	static int kValue = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] A  = new int[N];
		for (int i =0; i < N; i++){
			A[i] = Integer.parseInt(st.nextToken());
		}

		merge_sort(A , 0 , N -1);

		if (count < K) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
	// p = 0  , r = 4
	public static void merge_sort(int[] arr, int p , int r){
		if(p < r){
			// q = 2
			int q = (p+r)/ 2;
			merge_sort(arr , p , q);
			merge_sort(arr , q+1 , r);

			// arr , 0 , 2 , 4
			merge(arr , p,q,r);
		}

	}

	public static void merge(int[] arr , int p , int q , int r){
		// i = 0 , j = 3 , t = 0;
		int i = p , j = q + 1 , t = 0;
		int[] tmp = new int[r-p + 1];


		// [4,5] , [1,2,3]
		// i= 0 <= 2 / j = 3 <= 4
		while(i <= q && j <= r){
			if(arr[i] <= arr[j]){
				tmp[t++] = arr[i++];
			}else{
				tmp[t++] = arr[j++];
			}
			count++;
			if(count == K){
				result = tmp[t - 1];
			}
		}

		while(i <= q) {
			tmp[t++] = arr[i++];
			count++;
			if(count == K) {
				result = tmp[t - 1];
			}
		}

		while(j <= r) {
			tmp[t++] = arr[j++];
			count++;
			if(count == K) {
				result = tmp[t - 1];
			}
		}

		for(int idx = 0; idx < t; idx++) {
			arr[p + idx] = tmp[idx];
		}

	}
}
