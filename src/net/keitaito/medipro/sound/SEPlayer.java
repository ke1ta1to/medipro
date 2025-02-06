package net.keitaito.medipro.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SEPlayer {
    private Clip clip;

    public SEPlayer(String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip.isRunning()) {
            clip.stop(); // 再生中なら停止してリセット
        }
        clip.setFramePosition(0); // 先頭から再生
        clip.start();
    }

    public static void main(String[] args) {
        SEPlayer se = new SEPlayer("se.wav");
        se.play(); // 効果音を即時再生
    }
}
