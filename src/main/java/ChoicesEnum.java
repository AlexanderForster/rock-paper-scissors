public enum ChoicesEnum {
	ROCK(0),
	PAPER(1),
	SCISSORS(2);
	private final int value;
	
	ChoicesEnum(final int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
