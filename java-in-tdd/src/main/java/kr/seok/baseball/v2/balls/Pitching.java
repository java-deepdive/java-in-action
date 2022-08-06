package kr.seok.baseball.v2.balls;

public class Pitching {
	private final Balls com;
	private final Balls player;
	
	public Pitching(Balls com, Balls player) {
		checkArgument(com != null, "com is Not Null");
		checkArgument(player != null, "com is Not Null");
		this.com = com;
		this.player = player;
	}
	
	private void checkArgument(boolean flag, String messages) {
		if(!flag) {
			throw new RuntimeException(messages);
		}
	}
	
	public void report() {
	
	}
}