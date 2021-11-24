package me.fournetwork.vivace.system;

import java.io.IOException;

public interface System {

    void init();
    void load();
    void save() throws IOException;
    void unload();
    void reload();
    boolean isEnable();
    String getName();
    String getVersion();

}
