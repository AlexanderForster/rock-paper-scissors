import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoundFormatterTest {
	private Player p1;
	private Player p2;
	private RoundFormatter formatter;
	private final String newline = System.lineSeparator();
	private RoundLogic round;
	
	@BeforeEach
	void setUp() {
		p1 = new Player();
		p2 = new Player();
		round = new RoundLogic(p1, p2);
	}

	@Test
	void formatP1Wins() {
		p1.setChoice(ChoicesEnum.ROCK.getValue());
		p2.setChoice(ChoicesEnum.SCISSORS.getValue());
		round.play();
		formatter = new RoundFormatter(round);
		assertEquals("Number of Draws: 0" + newline +
		             newline +
		             "Player 1: ROCK\t Player 1 Total Wins: 1" + newline +
		             "Player 2: SCISSORS\t Player 2 Total Wins: 0" + newline +
		             "Player 1 Wins" + newline + newline, formatter.print());
	}

	@Test
	void formatP2Wins() {
		p1.setChoice(ChoicesEnum.ROCK.getValue());
		p2.setChoice(ChoicesEnum.PAPER.getValue());
		round.play();
		formatter = new RoundFormatter(round);
		assertEquals("Number of Draws: 0" + newline +
		             newline +
		             "Player 1: ROCK\t Player 1 Total Wins: 0" + newline +
		             "Player 2: PAPER\t Player 2 Total Wins: 1" + newline +
		             "Player 2 Wins" + newline + newline, formatter.print());
	}

	@Test
	void formatDraw() {
		p1.setChoice(ChoicesEnum.ROCK.getValue());
		p2.setChoice(ChoicesEnum.ROCK.getValue());
		formatter = new RoundFormatter(round);
		round.play();
		assertEquals("Number of Draws: 1" + newline +
		             newline +
		             "Player 1: ROCK\t Player 1 Total Wins: 0" + newline +
		             "Player 2: ROCK\t Player 2 Total Wins: 0" + newline +
		             newline +
		             "\t\t\t Draw" +
		             newline + newline, formatter.print());
	}

	@Test
	void formatGameWon() {
		p1.setChoice(ChoicesEnum.ROCK.getValue());
		p2.setChoice(ChoicesEnum.PAPER.getValue());
		round.play();
		round.play();
		round.play();
		formatter = new RoundFormatter(round);
		assertEquals("Number of Draws: 0" + newline +
		             newline +
		             "Player 1: ROCK\t Player 1 Total Wins: 0" + newline +
		             "Player 2: PAPER\t Player 2 Total Wins: 3" + newline +
		             "Player 2 Wins" + newline + newline, formatter.print());
	}
}
