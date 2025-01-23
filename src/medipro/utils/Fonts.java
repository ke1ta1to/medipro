package medipro.utils;

import java.awt.Font;

public class Fonts {

    public static final Font STICK_FONT;
    public static final Font MPLUS1CODE_FONT;

    static {
        try {
            STICK_FONT = Font.createFont(Font.TRUETYPE_FONT,
                    Fonts.class.getClassLoader().getResourceAsStream("medipro/fonts/Stick-Regular.ttf"));
            MPLUS1CODE_FONT = Font.createFont(Font.TRUETYPE_FONT,
                    Fonts.class.getClassLoader().getResourceAsStream("medipro/fonts/MPLUS1Code-Medium.ttf"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
