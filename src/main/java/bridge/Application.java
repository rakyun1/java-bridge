package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller();
        controller.startGame();
        controller.makeBridge();
        controller.userMoving();
    }
}
