package ex1;

import java.util.ArrayList;
import java.util.Collections;

public class MusicPlayer {
	private String name;
	private ArrayList<Album> albumList = new ArrayList<>();

	MusicPlayer(String name) {
		this.name = name;
	}

	public void add(Album album) {
		albumList.add(album);
	}

	public void play() {
		System.out.println(this.name + "で全曲再生");
		albumList.forEach(album -> {
			album.play();
		});
	}

	public void shufflePlay() {
		ArrayList<Music> allMusicList = new ArrayList<>();
		for(Album album:this.albumList) {
			for(Music music:album.getMusicList()) {
				allMusicList.add(music);
			}
		}
		Collections.shuffle(allMusicList);
		System.out.println(this.name + "でランダム再生");
		allMusicList.forEach(music -> {
			music.play();
		});
	}

	public static void main(String[] args) {
		Album albumA = new Album("素晴らしいアルバム", "素晴らしい人");
		albumA.add(new Music("明るい曲", "素晴らしい人", 180, 0));
		albumA.add(new Music("嬉しい曲", "素晴らしい人", 120, 0));
		albumA.add(new Music("楽しい曲", "素晴らしい人", 130, 0));
		albumA.add(new Music("うるさい曲", "素晴らしい人", 120, 0));
		albumA.add(new Music("暗い曲", "素晴らしい人", 190, 0));
		albumA.add(new Music("やばい曲", "素晴らしい人", 180, 0));
		albumA.add(new Music("素晴らしい曲", "素晴らしい人", 210, 0));

		Album albumB = new Album("良いアルバム", "良い人");
		albumB.add(new Music("風の曲", "良い人", 180, 3));
		albumB.add(new Music("海の曲", "良い人", 120, 4));
		albumB.add(new Music("山の曲", "良い人", 130, 2));

		MusicPlayer musicPlayer = new MusicPlayer("いかついミュージックプレイヤー");
		musicPlayer.add(albumA);
		musicPlayer.add(albumB);

		musicPlayer.play();
		musicPlayer.shufflePlay();
	}

}
