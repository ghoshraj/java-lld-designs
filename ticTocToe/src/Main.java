import com.tictactoe.model.Player;
import com.tictactoe.service.Game;
import com.tictactoe.strategy.AIMoveStrategy;
import com.tictactoe.strategy.HumanMoveStrategy;

public class Main {
    public static void main(String[] args) {

        Player p1 = new Player("Player 1", 'X', new HumanMoveStrategy());
        Player p2 = new Player("AI", 'O', new AIMoveStrategy());

        Game game = new Game(p1, p2);
        game.startGame();
    }
}