package medipro.how_to_play;

import java.beans.PropertyChangeSupport;

public class HowToPlayModel {

    public static final String PAGE_NO1 = "page1";
    public static final String PAGE_NO2 = "page2";

    public static final String[] PAGES = { PAGE_NO1, PAGE_NO2 };

    private String currentPage;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public HowToPlayModel() {
        currentPage = PAGE_NO1;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        String old = this.currentPage;
        this.currentPage = currentPage;
        pcs.firePropertyChange("currentPage", old, currentPage);
    }

    public void nextPage() {
        int index = 0;
        for (int i = 0; i < PAGES.length; i++) {
            if (PAGES[i].equals(currentPage)) {
                index = i;
                break;
            }
        }
        if (index < PAGES.length - 1) {
            setCurrentPage(PAGES[index + 1]);
        }
    }

    public void previousPage() {
        int index = 0;
        for (int i = 0; i < PAGES.length; i++) {
            if (PAGES[i].equals(currentPage)) {
                index = i;
                break;
            }
        }
        if (index > 0) {
            setCurrentPage(PAGES[index - 1]);
        }
    }

    public void addPropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(propertyName, listener);
    }

}
