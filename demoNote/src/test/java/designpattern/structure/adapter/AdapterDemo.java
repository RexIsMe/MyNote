package designpattern.structure.adapter;

/**
 * @author Cytang
 * @title: AdapterDemo
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1016:15
 */
public class AdapterDemo {

    public static void main(String[] args) {
        MediaAdapter ma = new MediaAdapter();
        ma.play("mp3", "123.mp3");
        ma.play("mp4", "123.mp4");
        ma.play("vlc", "123.vlc");

        System.out.println("\r\n");

        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "123.mp3");
        audioPlayer.play("mp4", "123.mp4");
        audioPlayer.play("vlc", "123.vlc");

    }

}
