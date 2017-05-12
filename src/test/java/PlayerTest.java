import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {
	private Player p;
	
	@BeforeEach
	void setUp() {
		p = new Player();
	}
	
	@Test
	void incrementWins() {
		p.incrementWins();
		assertEquals(1, p.getWins());
	}
	
	@Test
	void setInvalidOption() {
		p.setChoice(10);
		assertThrows(IllegalArgumentException.class, p::playerChoice);
	}
	
	@Test
	void deepCopyChoice() {
		final Player sourcePlayer = new Player();
		sourcePlayer.setChoice(ChoicesEnum.SCISSORS.getValue());
		final Player destPlayer = new Player(sourcePlayer);
		
		assertEquals(sourcePlayer.getChoice(), destPlayer.getChoice());
		sourcePlayer.setChoice(ChoicesEnum.ROCK.getValue());
		assertEquals(ChoicesEnum.SCISSORS.getValue(), destPlayer.getChoice());
	}
	
	@Test
	void deepCopyWins() {
		final Player sourcePlayer = new Player();
		sourcePlayer.incrementWins();
		final Player destPlayer = new Player(sourcePlayer);
		assertEquals(sourcePlayer.getWins(), destPlayer.getWins());
		sourcePlayer.incrementWins();
		assertEquals(1, destPlayer.getWins());
	}
}