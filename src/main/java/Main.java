public class Main {
	public static void main(final String... args) {
		final Player p1 = new PlayerRandomChoice();
		final Player p2 = new PlayerRandomChoice();
		final Game game = new Game(p1, p2);
		game.gameLoop();
		final Formatter formatter = new GameFormatter(game);
		System.out.println(formatter.print());
	}
}
