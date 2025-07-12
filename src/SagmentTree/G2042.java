package SagmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2042 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] numbers = new long[N];

		for(int i = 0; i < N; i++){
			numbers[i] = Long.parseLong(br.readLine());
		}

		SegmentTree segmentTree = new SegmentTree(numbers);

		for(int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				segmentTree.update(1, 0, numbers.length - 1, b - 1, c);
				numbers[b - 1] = c;
			} else {
				long sum = segmentTree.query(1, 0, numbers.length - 1, b - 1, (int)c - 1);
				System.out.println(sum);
			}
		}
	}
}

class SegmentTree {
	private long[] tree;
	private int n;

	public SegmentTree(long[] arr) {
		this.n = arr.length;
		this.tree = new long[4 * n];
		build(arr, 1, 0, n - 1);
	}

	public void build(long[] arr, int node, int start, int end) {
		if(start == end){
			tree[node] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		build(arr, node * 2, start, mid);
		build(arr, node * 2 + 1, mid + 1, end);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];

		//
	}

	public void update(int node, int start, int end, int idx, long newValue) {
		if(start == end){
			tree[node] = newValue;
		} else {
			int mid = (start + end) / 2;
			if(idx <= mid){
				update(2 * node, start, mid, idx, newValue);
			} else {
				update(2 * node + 1, mid + 1, end, idx, newValue);
			}
			tree[node] = tree[node * 2] + tree[node * 2 + 1];
		}
	}

	public long query(int node, int start, int end, int left, int right) {
		if(right < start || left > end){
			return 0;
		}
		if(left <= start && end <= right){
			return tree[node];
		}

		int mid = (start + end) / 2;
		long leftSum = query(2 * node, start, mid, left, right);
		long rightSum = query(2 * node + 1, mid + 1, end, left, right);
		return leftSum + rightSum;
	}
}
