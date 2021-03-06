package tech.lucidsoft.cache.definitions.managers;

import tech.lucidsoft.cache.ArchiveType;
import tech.lucidsoft.cache.GroupType;
import tech.lucidsoft.cache.definitions.EnumDefinition;
import tech.lucidsoft.cache.definitions.exporters.EnumExporter;
import tech.lucidsoft.cache.definitions.loaders.EnumLoader;
import tech.lucidsoft.cache.filesystem.Cache;
import tech.lucidsoft.cache.filesystem.File;
import tech.lucidsoft.cache.filesystem.Group;

import java.util.HashMap;
import java.util.Map;

public class EnumManager {

    private final Group enumDefGroup;
    private static final Map<Integer, EnumDefinition> definitions = new HashMap<>();
    private static boolean verbose = false;

    public EnumManager(Cache cache) {
        this.enumDefGroup = cache.getArchive(ArchiveType.CONFIGS).findGroupByID(GroupType.ENUM);
    }

    public void load() {
        if (isVerbose()) {
            System.out.println("Loading Enum Definitions...");
        }

        EnumLoader loader = new EnumLoader();
        for (File f : enumDefGroup.getFiles()) {
            EnumDefinition def = loader.load(f.getID(), f.getData());
            definitions.put(f.getID(), def);
        }

        if (isVerbose()) {
            System.out.println("Loaded " + String.format( "%,d", definitions.size()) + " Enum definitions.");
        }
    }

    public void exportToJson(int id, java.io.File directory) {
        if(isVerbose()) {
            System.out.println("Exporting Enum JSON to: " + directory.getPath());
        }
        exportToJson(getEnumDef(id), directory);
    }

    public void exportToJson(EnumDefinition def, java.io.File directory) {
        directory.mkdirs();

        EnumExporter exporter = new EnumExporter(def);
        try {
            exporter.exportToJson(directory, def.getId() + ".json");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportAllToJson(java.io.File directory) {
        if(isVerbose()) {
            System.out.println("Exporting Enum JSONs to: " + directory.getPath());
        }
        for (EnumDefinition def : definitions.values()) {
            exportToJson(def, directory);
        }
    }

    public Map<Integer, EnumDefinition> getDefinitions() {
        return definitions;
    }

    public EnumDefinition getEnumDef(int id) {
        return definitions.get(id);
    }

    public void setVerbose(boolean verbose) {
        EnumManager.verbose = verbose;
    }

    public static boolean isVerbose() {
        return verbose;
    }
}
