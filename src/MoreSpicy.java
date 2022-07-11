import java.util.PriorityQueue;

public class MoreSpicy {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        solution(scoville, 7);

    }

    static int solution(int[] scoville, int K) {
        int answer = 0;

        //우선순위 큐 정의
        PriorityQueue<Integer> sortQueue = new PriorityQueue<>();

        //우선 순위 큐에 입력 값 추가
        for (int i = 0; i < scoville.length; i++) {
            sortQueue.add(scoville[i]);
        }

        /*for(int i=0;i<scoville.length;i++){
            System.out.println(sortQueue.poll());
        }*/

        if (sortQueue.peek() > K) {
            System.out.println("모든 음식이 최소 스코빌 지수 이상입니다.");
            return answer;
        }


        // 반복문
        while (sortQueue.peek() < K) {
            // 스코필 지수 계산
            int num1 = sortQueue.poll();
            int num2 = sortQueue.poll();

            int result = num1 + num2 * 2;
            sortQueue.add(result);

            answer++;

            if (sortQueue.size() == 1 && sortQueue.peek() < K) {
                answer = -1;
                break;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
