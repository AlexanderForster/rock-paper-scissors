import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
	@Test
	void gameFinishedAfterThreeWins() {
		final Player p1 = new Player();
		p1.setChoice(ChoicesEnum.ROCK.getValue());
		final Player p2 = new Player();
		p2.setChoice(ChoicesEnum.SCISSORS.getValue());
		final Game game = new Game(p1, p2);
		game.gameLoop();
		assertEquals(3, game.getStates().size());
	}
}
