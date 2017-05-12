class PlayerRandomChoice extends Player {
	@Override
	public int getChoice() {
		return (int) (Math.random() * 3);
	}
}
