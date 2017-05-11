import java.util.ArrayList;
import java.util.List;

class Game {
	private final Player p1;
	private final Player p2;
	private final List<RoundLogic> states = new ArrayList<>();
	
	Game(final Player p1, final Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	void gameLoop() {
		final String newline = System.lineSeparator();
		do {
			System.out.println("***** Round: " + states.size() + " *********************" + newline);
			final RoundLogic roundState = new RoundLogic(p1, p2);
			roundState.play();
			states.add(roundState);
		} while(!isGameWon());
		System.out.println("GAME WON" + newline + newline);
	}
	
	List<RoundLogic> getStates() {
		return states;
	}
	
	boolean isGameWon() {
		return p1.getWins() == 3 || p2.getWins() == 3;
	}
	
}
