import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoundTest {
	private final PlayersEnum player1 = PlayersEnum.PLAYER1;
	private final PlayersEnum player2 = PlayersEnum.PLAYER2;
	private Player p1;
	private Player p2;
	
	@BeforeEach
	void setUp() {
		p1 = new Player();
		p2 = new Player();
	}
	
	@Test
	@DisplayName("player1 with scissors beats player2 with paper")
	void scissorsBeatsPaper() {
		playRound(player1, ChoicesEnum.SCISSORS, ChoicesEnum.PAPER);
	}
	
	@Test
	@DisplayName("player1 with rock beats player2 with scissors")
	void rockBeatsScissors() {
		playRound(player1, ChoicesEnum.ROCK, ChoicesEnum.SCISSORS);
	}
	
	@Test
	@DisplayName("player1 with paper beats player2 with rock")
	void paperBeatsRock() {
		playRound(player1, ChoicesEnum.PAPER, ChoicesEnum.ROCK);
	}
	
	@Test
	@DisplayName("player1 with rock loses to player2 with paper")
	void rockLosesToPaper() {
		playRound(player2, ChoicesEnum.ROCK, ChoicesEnum.PAPER);
	}
	
	@Test
	@DisplayName("player1 with scissors loses to player2 with rock")
	void scissorsLosesToRock() {
		playRound(player2, ChoicesEnum.SCISSORS, ChoicesEnum.ROCK);
	}
	
	@Test
	@DisplayName("player1 with paper loses to player2 with scissors")
	void paperLosesToScissors() {
		playRound(player2, ChoicesEnum.PAPER, ChoicesEnum.SCISSORS);
	}
	
	@Test
	@DisplayName("player1 and player2 choose rock")
	void rock() {
		playRound(PlayersEnum.DRAW, ChoicesEnum.ROCK, ChoicesEnum.ROCK);
	}
	
	@Test
	@DisplayName("player1 and player2 choose paper")
	void paper() {
		playRound(PlayersEnum.DRAW, ChoicesEnum.PAPER, ChoicesEnum.PAPER);
	}
	
	@Test
	@DisplayName("player1 and player2 choose scissors")
	void scissors() {
		playRound(PlayersEnum.DRAW, ChoicesEnum.SCISSORS, ChoicesEnum.SCISSORS);
	}
	
	@Test
	@DisplayName("draw + player1 with rock beats player2 with scissors")
	void drawFirstRoundP1WinsSecondRound() {
		playRound(PlayersEnum.DRAW, ChoicesEnum.ROCK, ChoicesEnum.ROCK);
		playRound(player1, ChoicesEnum.ROCK, ChoicesEnum.SCISSORS);
	}
	
	@Test
	@DisplayName("player1 with rock beats player2 with scissors; player1 with scissors loses to player2 with rock")
	void p1WinsFirstRoundP2WinsSecondRound() {
		playRound(player1, ChoicesEnum.ROCK, ChoicesEnum.SCISSORS);
		playRound(player2, ChoicesEnum.SCISSORS, ChoicesEnum.ROCK);
	}
	
	@Test
	void twoDraws() {
		p1.setChoice(ChoicesEnum.ROCK.getValue());
		p2.setChoice(ChoicesEnum.ROCK.getValue());
		final RoundLogic round1 = new RoundLogic(p1, p2);
		round1.play();
		assertEquals(1, round1.getDrawCount());
		round1.play();
		assertEquals(2, round1.getDrawCount());
	}
	
	private void playRound(final PlayersEnum expectedPlayer, final ChoicesEnum player1Choice, final ChoicesEnum player2Choice) {
		p1.setChoice(player1Choice.getValue());
		p2.setChoice(player2Choice.getValue());
		final RoundLogic round1 = new RoundLogic(p1, p2);
		round1.play();
		assertEquals(expectedPlayer, round1.getPlayerWinner());
	}
}