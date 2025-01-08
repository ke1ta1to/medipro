package medipro;

public class App {

    public void start() {
        System.out.println("Application started");
        AppFrame appFrame = new AppFrame();
        appFrame.setVisible(true);

    }

    public static void main(String[] args) {
        new App().start();
    }

}
