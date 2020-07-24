package designpattern.structure.adapter;

/**
 * 【适配器模式】
 *      让原本只能播放mp3的MediaPlayer可以播放vlc、mp4
 *
 * @author Cytang
 * @title: MediaPlayer
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1015:49
 */
public interface MediaPlayer {
    void play(String audioType, String fileName);
}
