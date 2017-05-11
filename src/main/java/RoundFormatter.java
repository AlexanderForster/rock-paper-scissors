public class RoundFormatter implements Formatter {
	private final RoundLogic round;
	
	RoundFormatter(final RoundLogic round) {
		this.round = round;
	}
	
	@Override
	public String print() {
		final String newline = System.lineSeparator();
		final StringBuilder output = new StringBuilder()
				                             .append("Number of Draws: ").append(round.getDrawCount()).append(newline)
				                             .append(newline)
				                             .append("Player 1: ").append(round.getPlayer1().playerChoice()).append("\t ").append("Player 1 Total Wins: ").append(round.getPlayer1()
				                                                                                                                                                    .getWins())
				                             .append(newline)
				                             .append("Player 2: ").append(round.getPlayer2().playerChoice()).append("\t ").append("Player 2 Total Wins: ").append(round.getPlayer2()
				                                                                                                                                                    .getWins())
				                             .append(newline);
		if(round.getPlayerWinner() == PlayersEnum.PLAYER1)
			output.append("Player 1 Wins").append(newline).append(newline);
		else if(round.getPlayerWinner() == PlayersEnum.PLAYER2)
			output.append("Player 2 Wins").append(newline).append(newline);
		else if(round.getPlayerWinner() == PlayersEnum.DRAW) {
			output.append(newline)
			      .append("\t\t\t Draw").append(newline)
			      .append(newline);
		}
		return String.valueOf(output);
	}
}
