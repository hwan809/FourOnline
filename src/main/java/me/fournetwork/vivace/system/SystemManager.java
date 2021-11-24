package me.fournetwork.vivace.system;

import me.fournetwork.vivace.util.DebugLogger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SystemManager {

    private final List<System> systems = new ArrayList<>();

    public void setup(System system) {
        systems.add(system);
        system.init();
    }

    public <T extends System> T getSystem(Class<T> classType) throws IllegalStateException {
        for (System s : systems) {
            if (s.getClass().equals(classType)) return classType.cast(s);
        }
        throw new IllegalStateException("cannot get system : class " + classType.getName() + " does not exists");
    }

    public void save(System system) {
        DebugLogger.info("start saving system '" + system.getName() + "' v" + system.getVersion() + "...");
        try {
            system.save();
            DebugLogger.info("...save complete!");
        } catch (IOException e) {
            DebugLogger.error("...critical error occurred while saving system " + system.getName() + " v" + system.getVersion() + ". saving failed");
            e.printStackTrace();
        }
    }

    public void saveAll() {
        DebugLogger.info("");
        systems.forEach(this::save);
    }
}
