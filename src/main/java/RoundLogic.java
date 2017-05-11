import java.util.Objects;

class RoundLogic {
	private final Player p1;
	private final Player p2;
	private int draw;
	private PlayersEnum playerWinner;
	
	RoundLogic(final Player p1, final Player p2) {
		this.p1 = p1;
		this.p2 = p2;
		this.draw = 0;
		this.playerWinner = PlayersEnum.NONE;
	}
	
	void play() {
		final String newline = System.lineSeparator();
		final StringBuilder output = new StringBuilder()
				                             .append("Number of Draws: ").append(getDrawCount()).append(newline)
				                             .append(newline)
				                             .append("Player 1: ").append(p1.playerChoice()).append("\t ").append("Player 1 Total Wins: ").append(p1.getWins())
				                             .append(newline)
				                             .append("Player 2: ").append(p2.playerChoice()).append("\t ").append("Player 2 Total Wins: ").append(p2.getWins())
				                             .append(newline);
		if(p1.playerChoice() == ChoicesEnum.ROCK && p2.playerChoice() == ChoicesEnum.PAPER) {
			p2.incrementWins();
			playerWinner = PlayersEnum.PLAYER2;
		} else if(p1.playerChoice() == ChoicesEnum.PAPER && p2.playerChoice() == ChoicesEnum.ROCK) {
			p1.incrementWins();
			playerWinner = PlayersEnum.PLAYER1;
		} else if(p1.playerChoice() == ChoicesEnum.ROCK && p2.playerChoice() == ChoicesEnum.SCISSORS) {
			p1.incrementWins();
			playerWinner = PlayersEnum.PLAYER1;
		} else if(p1.playerChoice() == ChoicesEnum.SCISSORS && p2.playerChoice() == ChoicesEnum.ROCK) {
			p2.incrementWins();
			playerWinner = PlayersEnum.PLAYER2;
		} else if(p1.playerChoice() == ChoicesEnum.SCISSORS && p2.playerChoice() == ChoicesEnum.PAPER) {
			p1.incrementWins();
			playerWinner = PlayersEnum.PLAYER1;
		} else if(p1.playerChoice() == ChoicesEnum.PAPER && p2.playerChoice() == ChoicesEnum.SCISSORS) {
			p2.incrementWins();
			playerWinner = PlayersEnum.PLAYER2;
		} else if(Objects.equals(p1.playerChoice(), p2.playerChoice())) {
			draw++;
			playerWinner = PlayersEnum.DRAW;
		}
		if(getPlayerWinner() == PlayersEnum.PLAYER1)
			output.append("Player 1 Wins").append(newline).append(newline);
		else if(getPlayerWinner() == PlayersEnum.PLAYER2)
			output.append("Player 2 Wins").append(newline).append(newline);
		else if(getPlayerWinner() == PlayersEnum.DRAW) {
			output.append(newline)
			      .append("\t\t\t Draw").append(newline)
			      .append(newline);
		}
		System.out.println(output.toString());
	}
	
	int getDrawCount() {
		return draw;
	}
	
	PlayersEnum getPlayerWinner() {
		return playerWinner;
	}
	
	Player getPlayer1() {
		return p1;
	}
	
	Player getPlayer2() {
		return p2;
	}
}
