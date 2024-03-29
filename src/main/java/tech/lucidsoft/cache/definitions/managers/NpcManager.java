package tech.lucidsoft.cache.definitions.managers;

import tech.lucidsoft.cache.ArchiveType;
import tech.lucidsoft.cache.GroupType;
import tech.lucidsoft.cache.filesystem.Cache;
import tech.lucidsoft.cache.filesystem.File;
import tech.lucidsoft.cache.filesystem.Group;
import tech.lucidsoft.cache.definitions.NpcDefinition;
import tech.lucidsoft.cache.definitions.exporters.NpcExporter;
import tech.lucidsoft.cache.definitions.loaders.NpcLoader;
import tech.lucidsoft.cache.util.DefUtil;

import java.util.HashMap;
import java.util.Map;

public class NpcManager {

    private final Group npcDefGroup;
    private final Map<Integer, NpcDefinition> definitions = new HashMap<>();
    private static boolean verbose = false;

    public NpcManager(Cache cache) {
        this.npcDefGroup = cache.getArchive(ArchiveType.CONFIGS).findGroupByID(GroupType.NPC);
    }

    public void load() {
        if (isVerbose()) {
            System.out.println("Loading NPC Definitions...");
        }
        NpcLoader loader = new NpcLoader(npcDefGroup.getVersion() >= 1493);
        for (File f : npcDefGroup.getFiles()) {
            NpcDefinition def = loader.load(f.getID(), f.getData());
            definitions.put(f.getID(), def);
        }

        if (isVerbose()) {
            System.out.println("Loaded " + String.format( "%,d", definitions.size()) + " NPC definitions.");
        }
    }

    public void exportToToml(int id, java.io.File directory) {
        if(isVerbose()) {
            System.out.println("Exporting NPC TOML to: " + directory.getPath());
        }
        exportToToml(getNpcDef(id), directory);
    }

    public void exportToToml(NpcDefinition def, java.io.File directory) {
        directory.mkdirs();

        NpcExporter exporter = new NpcExporter(def);
        String cleansedName = DefUtil.cleanseName(def.getName());
        try {
            exporter.exportToToml(directory, + def.getId() + "_" + cleansedName + ".toml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportAllToToml(java.io.File directory) {
        if(isVerbose()) {
            System.out.println("Exporting NPC TOMLs to: " + directory.getPath());
        }
        for (NpcDefinition def : definitions.values()) {
            exportToToml(def, directory);
        }
    }

    public void exportToJson(int id, java.io.File directory) {
        if(isVerbose()) {
            System.out.println("Exporting NPC JSON to: " + directory.getPath());
        }
        exportToJson(getNpcDef(id), directory);
    }

    public void exportToJson(NpcDefinition def, java.io.File directory) {
        directory.mkdirs();

        NpcExporter exporter = new NpcExporter(def);
        String cleansedName = DefUtil.cleanseName(def.getName());
        try {
            exporter.exportToJson(directory, def.getId() + "_" + cleansedName + ".json");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportAllToJson(java.io.File directory) {
        if(isVerbose()) {
            System.out.println("Exporting NPC JSONs to: " + directory.getPath());
        }
        for (NpcDefinition def : definitions.values()) {
            exportToJson(def, directory);
        }
    }

    public Map<Integer, NpcDefinition> getDefinitions() {
        return definitions;
    }

    public NpcDefinition getNpcDef(int id) {
        return definitions.get(id);
    }

    public void setVerbose(boolean verbose) {
        NpcManager.verbose = verbose;
    }

    public static boolean isVerbose() {
        return verbose;
    }
}
