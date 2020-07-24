package designpattern.structure.adapter;

/**
 *
 *
 * @author Cytang
 * @title: MediaAdapter
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1015:54
 */
public class MediaAdapter implements MediaPlayer{

    AdvancedMediaPlayer advancedMediaPlayer;
    MediaPlayer mediaPlayer;

    public MediaAdapter() {
    }

    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc") ){
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new Mp4Player();
        }
    }

    public AdvancedMediaPlayer getAdvancedMediaPlayer(String audioType){
        AdvancedMediaPlayer advancedMediaPlayer;
        if("vlc".equalsIgnoreCase(audioType)){
            advancedMediaPlayer = new VlcPlayer();
        } else {
            advancedMediaPlayer = new Mp4Player();
        }
        return advancedMediaPlayer;
    }

    @Override
    public void play(String audioType, String fileName) {
        if("vlc".equalsIgnoreCase(audioType)){
            advancedMediaPlayer = getAdvancedMediaPlayer(audioType);
            advancedMediaPlayer.playVlc(fileName);
        } else if("mp4".equalsIgnoreCase(audioType)){
            advancedMediaPlayer = getAdvancedMediaPlayer(audioType);
            advancedMediaPlayer.playMp4(fileName);
        } else {
            mediaPlayer = new AudioPlayer();
            mediaPlayer.play(audioType, fileName);
        }
    }
}
