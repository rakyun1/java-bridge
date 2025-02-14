package bridge;

import java.util.List;

public class Controller {
	BridgeMaker maker;
	BridgeGame game;
	BridgeRandomNumberGenerator randomNumber;
	InputView inputView;
	OutputView outputView;
	int bridgeSize;
	List<String> bridge;
	int tryGameCount;

	public Controller(){
		randomNumber = new BridgeRandomNumberGenerator();
		maker = new BridgeMaker(randomNumber);
		game = new BridgeGame();
		inputView = new InputView();
		outputView = new OutputView();

	}
	public void startGame(){
		tryGameCount = 1;
		outputView.printStart();
		setBridgeSize();
	}
	public void setBridgeSize(){
		try{
			bridgeSize = inputView.readBridgeSize();
		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
			bridgeSize = inputView.readBridgeSize();
		}

	}
	public void makeBridge(){
		bridge = maker.makeBridge(bridgeSize);
	}
	public void userMoving(){
		while (true){
			if (game.isEndGame(bridge) == 0){
				outputView.printChooseMove();
				String moved = inputView.readMoving();
				outputView.printMap(game.move(moved, bridge));
			}
			if (game.isEndGame(bridge) == 1){
				outputView.printRetry();
				String retryResult = inputView.readGameCommand();
				if (retryResult.equals("Q")) break;
				game = new BridgeGame();
				tryGameCount++;
			}
			if (game.isEndGame(bridge) == 2){
				outputView.printResult(game.maps, "성공", tryGameCount);
				break;
			}
		}
	}
}
