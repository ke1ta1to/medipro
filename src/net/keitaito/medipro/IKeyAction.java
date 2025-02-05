package net.keitaito.medipro;

import java.util.List;
import java.util.Set;

public interface IKeyAction {

    void addKey(int key);

    void removeKey(int key);

    void clearKeys();

    boolean hasKey(int key);

    Set<Integer> getKeys();

    // availableKeys
    List<Integer> getAvailableKeys();

}
