package medipro;

import java.util.List;
import java.util.Set;

public interface IKeyAction {

    void addKey(String key);

    void removeKey(String key);

    void clearKeys();

    boolean hasKey(String key);

    Set<String> getKeys();

    // availableKeys
    List<String> getAvailableKeys();

}
