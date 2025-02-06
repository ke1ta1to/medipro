package net.keitaito.medipro.share;

import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.keitaito.mediproserver.Inputs;

public class ShareModel {

    public static final String ENDPOINT = "https://api.medipro.keitaito.net/v1/inputs";

    private Gson gson = new Gson();

    private boolean open = false;

    private List<Inputs> inputs = new ArrayList<>();

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public ShareModel() {
        loadInputs();
    }

    public List<Inputs> getInputs() {
        return inputs;
    }

    public void setInputs(List<Inputs> inputs) {
        this.inputs = inputs;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        boolean oldOpen = this.open;
        this.open = open;
        pcs.firePropertyChange("open", oldOpen, open);
    }

    public void addPropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(propertyName, listener);
    }

    public void loadInputs() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(ENDPOINT)).GET().build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            List<Inputs> inputs = gson.fromJson(response.body(), new TypeToken<Collection<Inputs>>() {
            }.getType());
            setInputs(inputs);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
