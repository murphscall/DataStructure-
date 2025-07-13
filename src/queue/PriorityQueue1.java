package queue;

import java.util.PriorityQueue;


public class PriorityQueue1 {
	public static void main(String[] args) {
		int[] scoville = new int[]{1,2,3,9,10,12};
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int K = 7;

		int result = sco_func(pq,scoville,K);

		System.out.println(result);

	}
	static int sco_func(PriorityQueue<Integer> pq,int[] scoville, int K){
		int count = 0;
		for (int sco : scoville){
			pq.add(sco);
		}

		while(pq.peek() < K){

			if(pq.size() < 2){
				return -1;
			}

			int firstLowSv = pq.poll();
			int secondLowSv = pq.poll();

			int newSv = firstLowSv + (secondLowSv * 2);

			pq.add(newSv);
			count++;

		}
		return count;
	}
}

// 음식의  스코빌 지수를 K 이상으로 만들고 싶다.
// 두개의 음식을 섞어 새로운 음식으로 만들 수 있다. => 새로운 스코빌 지수 ?

// 섞은 음식의 스코빌 지수 =
// 가장 맵지 않은 음식의 스코빌 지수 + (두번쨰로 맵지 않은 음식의 스코빌 지수 * 2)

// 입력 = 음식들의 스코빌 지수를 담은 배열 scoville  , 스코빌 지수 K

// 출력 ? = 스코빌 지수를 K 이상으로 만들기 위한 최소 횟수 반환
// 모든 음식을 K 이상으로 만들수 없다면 -1

// 핵심 반복 작업은 무엇인가?
// 가장 맵지 않은 스코빌과 두번째 맵지않은 스코빌을 꺼내고 계산후  다시 추가
// 반복하다가 가진 모든 음식의 스코빌 지수가 7이상이면 멈추고 몇번했는지 반환

// 가장 맵지않은 두 음식을 어떻게 찾을 것인가 ?
// 단순하게 생각하면 매번 비교
// 좀 더 생각하면 계산후 매번 정렬
// 아니면 작은순 기준 PriorityQueue 사용하기?

// 최적의 자료구조는 ?
// 우선순위 큐


// Tip
// while 문은 우선순위 큐에서 peek 하는 숫자가 K보다 작을때 까지만 반복한다.
// 우선 순위 큐에서는 제일 작은 숫자가 맨 앞에 오기 때문 => 그 뒤에는 전부 K보다 크다는 말과 같음




