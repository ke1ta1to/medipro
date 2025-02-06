package net.keitaito.medipro.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundModel {
    private Clip clip;
    private final String DEFAULT_FILE_PATH = "src/net/keitaito/medipro/sound/sound_sources/";

    public SoundModel(String filePath) {
        try {
            File soundFile = new File(DEFAULT_FILE_PATH + filePath);
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

    public void loop() { // ループ再生
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }

    public void update(String filePath) {
        if (clip.isRunning()) {
            clip.stop();
        }
        try {
            File soundFile = new File(DEFAULT_FILE_PATH + filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /*
     * public static void main(String[] args) {
     * SEPlayer se = new SEPlayer("se.wav");
     * se.play(); // 効果音を即時再生
     * }
     */
}
