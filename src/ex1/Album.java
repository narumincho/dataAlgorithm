package ex1;

import java.util.ArrayList;

public class Album {
	private String title;
	private String artist;
	private ArrayList<Music> musicList = new ArrayList<>();

	Album(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public ArrayList<Music> getMusicList() {
		return musicList;
	}

	public void add(Music music) {
		musicList.add(music);
	}

	public int getTotalTime() {
		int sum = 0;
		for (Music music : this.musicList) {
			sum += music.getTime();
		}
		return sum;
	}

	public double getRating() {
		int sum = 0;
		for (Music music : this.musicList) {
			sum += music.getRating();
		}
		return ((double) sum) / this.musicList.size();
	}

	public void play() {
		System.out.printf(
				"アルバム再生 (%d曲, %d秒, 平均%f評価)\n",
				this.musicList.size(),
				this.getTotalTime(),
				this.getRating()
		);
		this.musicList.forEach(music -> {
			music.play();
		});
		System.out.println("再生終了");
	}

	@Override
	public String toString() {
		return String.format(
				"anAlbum(%s,%s,%d,%d,%f)",
				this.title,
				this.artist,
				this.musicList.size(),
				this.getTotalTime(),
				this.getRating());
	}

	public static void main(String[] args) {
		Album album = new Album("素晴らしいアルバム", "素晴らしい人");
		album.add(new Music("明るい曲", "素晴らしい人", 180, 0));
		album.add(new Music("嬉しい曲", "素晴らしい人", 120, 0));
		album.add(new Music("楽しい曲", "素晴らしい人", 130, 0));
		album.add(new Music("うるさい曲", "素晴らしい人", 120, 0));
		album.add(new Music("暗い曲", "素晴らしい人", 190, 0));
		album.add(new Music("やばい曲", "素晴らしい人", 180, 0));
		album.add(new Music("素晴らしい曲", "素晴らしい人", 210, 0));
		System.out.println(album);
		System.out.println("総再生時間:"+album.getTotalTime());
		System.out.println("アルバム評価:"+album.getRating());
		album.play();
	}

}
