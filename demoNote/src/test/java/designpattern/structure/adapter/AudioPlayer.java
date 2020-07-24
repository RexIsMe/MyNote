package designpattern.structure.adapter;

/**
 * 还是用AndioPlayer，扩展其功能
 *
 * @author Cytang
 * @title: AudioPlayer
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1015:49
 */
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        //播放 mp3 音乐文件的内置支持
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file. Name: "+ fileName);
        } else if ("mp4".equalsIgnoreCase(audioType) || "vlc".equalsIgnoreCase(audioType)){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
/*
    @Override
    public void play(String audioType, String fileName) {
        //播放 mp3 音乐文件的内置支持
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file. Name: "+ fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
*/

}
