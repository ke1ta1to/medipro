package net.keitaito.medipro.sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundModel {
    private Clip clip;
    private final String DEFAULT_FILE_PATH = "src/net/keitaito/medipro/sound/sound_sources/";
    private String filePath;

    public SoundModel(String filePath) {
        try {
            this.filePath = filePath;
            File soundFile = new File(DEFAULT_FILE_PATH + this.filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (Exception e) {
        }
    }

    public void play() {
        if (clip != null) {
            try {
                if (clip.isRunning()) {
                    clip.stop(); // 再生中なら停止してリセット
                }
                setVolume(0.6f); // ボリュームを0にして再生
                clip.setFramePosition(0); // 先頭から再生
                clip.start();
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public void loop() { // ループ再生
        if (clip != null) {
            setVolume(0.6f);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
        }
    }

    public void update(String filePath) {
        if (clip != null) {
            if (clip.isRunning()) {
                clip.stop();
            }
            if (this.filePath.equals(filePath)) {
                clip.setFramePosition(0);
            } else {
                this.filePath = filePath;
                try {
                    File soundFile = new File(DEFAULT_FILE_PATH + this.filePath);
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
                    clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    clip.setFramePosition(0);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void updatePlay(String filePath) {
        update(filePath);
        play();
    }

    public void setVolume(float volume) {
        if (clip != null) {
            FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float min = control.getMinimum(); // 例: -80.0 dB
            float max = control.getMaximum(); // 例: 6.0 dB

            // 人間の聴覚に合うように対数スケールで変換
            float gain;
            if (volume <= 0.0f) {
                gain = min; // 0.0 の場合は最小音量
            } else {
                gain = (float) (min + (max - min) * Math.log10(1 + 9 * volume));
            }
            control.setValue(gain);
        }
    }

    /*
     * public static void main(String[] args) {
     * SEPlayer se = new SEPlayer("se.wav");
     * se.play(); // 効果音を即時再生
     * }
     */
}
