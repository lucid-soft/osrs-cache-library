package tech.lucidsoft.cache.definitions.managers;

import tech.lucidsoft.cache.ArchiveType;
import tech.lucidsoft.cache.GroupType;
import tech.lucidsoft.cache.definitions.UnderlayDefinition;
import tech.lucidsoft.cache.definitions.exporters.UnderlayExporter;
import tech.lucidsoft.cache.definitions.loaders.UnderlayLoader;
import tech.lucidsoft.cache.filesystem.Cache;
import tech.lucidsoft.cache.filesystem.File;
import tech.lucidsoft.cache.filesystem.Group;

import java.util.HashMap;
import java.util.Map;

public class UnderlayManager {

    private final Group underlayDefGroup;
    private static final Map<Integer, UnderlayDefinition> definitions = new HashMap<>();
    private static boolean verbose = false;

    public UnderlayManager(Cache cache) {
        this.underlayDefGroup = cache.getArchive(ArchiveType.CONFIGS).findGroupByID(GroupType.UNDERLAY);
    }

    public void load() {
        if (isVerbose()) {
            System.out.println("Loading Underlay Definitions...");
        }

        UnderlayLoader loader = new UnderlayLoader();
        for (File f : underlayDefGroup.getFiles()) {
            UnderlayDefinition def = loader.load(f.getID(), f.getData());
            definitions.put(f.getID(), def);
        }

        if (isVerbose()) {
            System.out.println("Loaded " + String.format( "%,d", definitions.size()) + " Underlay definitions.");
        }
    }

    public void exportToJson(int id, java.io.File directory) {
        if(isVerbose()) {
            System.out.println("Exporting Underlay JSON to: " + directory.getPath());
        }
        exportToJson(getUnderlayDef(id), directory);
    }

    public void exportToJson(UnderlayDefinition def, java.io.File directory) {
        directory.mkdirs();

        UnderlayExporter exporter = new UnderlayExporter(def);
        try {
            exporter.exportToJson(directory, def.getId() + ".json");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportAllToJson(java.io.File directory) {
        if(isVerbose()) {
            System.out.println("Exporting Underlay JSONs to: " + directory.getPath());
        }
        for (UnderlayDefinition def : definitions.values()) {
            exportToJson(def, directory);
        }
    }

    public Map<Integer, UnderlayDefinition> getDefinitions() {
        return definitions;
    }

    public UnderlayDefinition getUnderlayDef(int id) {
        return definitions.get(id);
    }

    public void setVerbose(boolean verbose) {
        UnderlayManager.verbose = verbose;
    }

    public static boolean isVerbose() {
        return verbose;
    }
}
