class Player implements RandomChoice {
	private int wins;
	private int choice;
	
	public Player() {
		wins = 0;
		choice = 0;
	}
	
	public Player(final Player sourcePlayer) {
		this.choice = sourcePlayer.choice;
		this.wins = sourcePlayer.wins;
	}
	
	ChoicesEnum playerChoice() {
		choice = getChoice();
		if(choice == ChoicesEnum.ROCK.getValue()) return ChoicesEnum.ROCK;
		else if(choice == ChoicesEnum.PAPER.getValue()) return ChoicesEnum.PAPER;
		else if(choice == ChoicesEnum.SCISSORS.getValue()) return ChoicesEnum.SCISSORS;
		throw new IllegalArgumentException();
	}
	
	void incrementWins() {
		wins++;
	}
	
	int getWins() {
		return wins;
	}
	
	@Override
	public int getChoice() {
		return choice;
	}
	
	@Override
	public void setChoice(final int choice) {
		this.choice = choice;
	}
}
