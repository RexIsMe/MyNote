package designpattern.structure.adapter;

/**
 * @author Cytang
 * @title: Mp4Player
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1015:51
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
