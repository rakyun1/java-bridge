package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println(" ");
        System.out.println("다리의 길이를 입력해주세요.");
    }
    public void printChooseMove(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Maps maps) {
//        System.out.println(maps.topMap + " ]");
//        System.out.println(maps.downMap + " ]");
        System.out.print("[ ");
        maps.topMap.forEach(System.out::print);
        System.out.println(" ]");
        System.out.print("[ ");
        maps.downMap.forEach(System.out::print);
        System.out.println(" ]");
    }

    public void printRetry(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Maps maps, String result, int count) {
        System.out.println(" ");
        System.out.println("최종 게임 결과");
        printMap(maps);
        System.out.println(" ");
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " +  count);
    }


}
