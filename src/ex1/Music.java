package ex1;

public class Music {
	private String title;
	private String artist;
	private int time;
	private int rating;

	Music(String title, String artist, int time, int rating) {
		this.title = title;
		this.artist = artist;
		this.time = time;
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public int getTime() {
		return time;
	}

	public int getRating() {
		return rating;
	}

	public void play() {
		System.out.printf(
				"再生中 タイトル:%s アーティスト:%s 時間:%d秒 評価:%d\n",
				this.title,
				this.artist,
				this.time,
				this.rating
		);
	}

	@Override
	public String toString() {
		return String.format(
				"aMusic(%s,%s,%d,%d)",
				this.title,
				this.artist,
				this.time,
				this.rating
		);
	}

	public static void main(String[] args) {
		Music music = new Music("なんだこれくしょん", "きゃりーぱみゅぱみゅ", 47, 3);
		System.out.println(music);
		music.play();
	}
}
