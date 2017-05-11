public class GameFormatter implements Formatter {
	private final Game game;
	
	GameFormatter(final Game game) {
		this.game = game;
	}
	
	@Override
	public String print() {
		final String newline = System.lineSeparator();
		final StringBuilder output = new StringBuilder();
		for(int roundNo = 0; roundNo < game.getStates().size(); roundNo++) {
			output.append("***** Round: ").append(roundNo).append(" *********************").append(newline);
			final RoundFormatter formatter = new RoundFormatter(game.getStates().get(roundNo));
			output.append(formatter.print());
		}
		if(game.isGameWon())
			output.append("GAME WON").append(newline)
			      .append(newline);
		return String.valueOf(output);
	}
}
