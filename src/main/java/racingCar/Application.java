package racingCar;

// 경주할 자동차 이름 입력 받는 기능
// 자동차 이름 유효한 지 확인 하는 기능ㅇ
// 자동차 객체 생성 하는 기능 ㅇ
// 경주 횟수 마다 자동차 위치 정보 업데이트하는 기능 ㅇ
// 경주 횟수마다 결과 출력하는 기능 ㅇ
// 우승자 출력 기능 ㅇ

// 자동차 이름 유효 검증 로직 수정
// 경주 횟수 검증 로직 추가
// 출력 로직 수정
// 인터페이스 참조하도록 수정

// indent 1로 줄이기 위해 stream 사용
// getPosition 사용 바꿔보기
// main에서 호출하지 않는 메서드는 static으로 선언하지 않도록 구현해보자.
// 공백 라인 잘 나누기
// 필요 없는 변수 초기화 줄이기

public class Application {
    public static void main(String[] args) {
        // final Scanner scanner = new Scanner(System.in);
        RacingGame game = new RacingGame();

        game.startGame();
    }
}
