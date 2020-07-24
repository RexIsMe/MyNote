package designpattern.structure.adapter;

/**
 * @author Cytang
 * @title: VlcPlayer
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/1015:51
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
