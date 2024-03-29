package tech.lucidsoft.sampletools;

import tech.lucidsoft.cache.definitions.ItemDefinition;
import tech.lucidsoft.cache.definitions.NpcDefinition;
import tech.lucidsoft.cache.definitions.ObjectDefinition;
import tech.lucidsoft.cache.definitions.managers.*;
import tech.lucidsoft.cache.filesystem.Cache;

import java.io.File;

/**
 *  This is an example of the cache library's dumping capabilities. This library is intended to be used as
 *  a dependency to create your own dumps instead of being an all-in-one dumping tool. However, this class will serve
 *  as a full dump of the cache.
 */
public class MegaDumper {

    private static String cachePath = "./data/cache202/";

    // Definitions
    private UnderlayManager underlayManager;
    private IdentikitManager identikitManager;
    private OverlayManager overlayManager;
    private InventoryManager inventoryManager;
    private ObjectManager objectManager;
    private EnumManager enumManager;
    private NpcManager npcManager;
    private ItemManager itemManager;
    private ParamManager paramManager;
    private SequenceManager sequenceManager;
    private SpotanimManager spotanimManager;
    private VarbitManager varbitManager;
    private VarclientManager varclientManager;
    private HitmarkManager hitmarkManager;
    private HitbarManager hitbarManager;

    private ModelManager modelManager;
    private SpriteManager spriteManager;

    public static void main(String[] args) {
        if (System.getProperty("cache") != null) {
            cachePath = System.getProperty("cache");
        } else if (args.length > 0) {
            cachePath = args[0];
        }

        new MegaDumper();
    }

    public MegaDumper() {
        long startTime = System.currentTimeMillis();
        Cache cache = Cache.openCache(cachePath);

        long loadDefStart = System.currentTimeMillis();

        System.out.println("Loading definitions...");
        loadUnderlayDefinitions(cache);
        loadIdentikitDefinitions(cache);
        loadOverlayDefinitions(cache);
        loadInventoryDefinitions(cache);
        loadObjectDefinitions(cache);
        loadEnumDefinitions(cache);
        loadNpcDefinitions(cache);
        loadItemDefinitions(cache);
        loadParamDefinitions(cache);
        loadSequenceDefinitions(cache);
        loadSpotanimDefinitions(cache);
        loadVarbitDefinitions(cache);
        loadVarclientDefinitions(cache);
        loadHitmarkDefinitions(cache);
        loadHitbarDefinitions(cache);

        long defTime = System.currentTimeMillis() - loadDefStart;
        System.out.println("Definition loading complete. Took " + String.format("%,.2f", (float) defTime / 1000) + " seconds");

        loadModels(cache);
        loadSprites(cache);
        System.out.println("Model loading complete. Loaded " + modelManager.getModels().length + " models.");

        String jsonPath = cachePath + "/dumps/json/";
        String tomlPath = cachePath + "/dumps/toml/";
        // underlayManager.exportAllToJson(new File(jsonPath + "/underlay/"));
        // .exportAllToJson(new File(jsonPath + "/identikit/"));
        // overlayManager.exportAllToJson(new File(jsonPath + "/overlay/"));
        // inventoryManager.exportAllToJson(new File(jsonPath + "/inv/"));
        // objectManager.exportAllToJson(new File(jsonPath + "/object/"));
        // enumManager.exportAllToJson(new File(jsonPath + "/enum/"));
        npcManager.exportAllToToml(new File(tomlPath + "/npc/"));
        itemManager.exportAllToToml(new File(tomlPath + "/item/"));
        // paramManager.exportAllToJson(new File(jsonPath + "/param/"));
        sequenceManager.exportAllToToml(new File(tomlPath + "/seq/"));
        // spotanimManager.exportAllToJson(new File(jsonPath + "/spotanim/"));
        // varbitManager.exportAllToJson(new File(jsonPath + "/varbit/"));
        // varclientManager.exportAllToJson(new File(jsonPath + "/varclient/"));
        // hitmarkManager.exportAllToJson(new File(jsonPath + "/hitmark/"));
        // hitbarManager.exportAllToJson(new File(jsonPath + "/hitbar/"));

        spriteManager.export(new File(cachePath + "/dumps/sprites/"));

         dumpingExamples();
        // dumpObjectModels();
        // dumpNpcModels();
        // dumpItemModels();

        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        System.out.println("Dumping complete! Took: " + String.format("%,.2f", (float)diff / 1000) + " seconds");
    }

    private void dumpingExamples() {
        // Dumps just one model
        // modelManager.dumpModel(1, new File("dumps/models/"), "1");

        // Dumps all models
        System.out.println("Dumping all models to: " + cachePath + "dumps/model/all/");
        for (int i = 0; i < modelManager.getModels().length; i++) {
            modelManager.dumpModel(i, new File(cachePath + "/dumps/model/all/"), i + "");
        }

        // Dumps one object model
        // modelManager.dumpObjectModels(objectManager.getObjectDef(1), "dumps/objects/object1/");
    }

    public void loadUnderlayDefinitions(Cache cache) {
        underlayManager = new UnderlayManager(cache);
        underlayManager.setVerbose(true);
        underlayManager.load();
    }

    public void loadIdentikitDefinitions(Cache cache) {
        identikitManager = new IdentikitManager(cache);
        identikitManager.setVerbose(true);
        identikitManager.load();
    }

    public void loadOverlayDefinitions(Cache cache) {
        overlayManager = new OverlayManager(cache);
        overlayManager.setVerbose(true);
        overlayManager.load();
    }

    public void loadInventoryDefinitions(Cache cache) {
        inventoryManager = new InventoryManager(cache);
        inventoryManager.setVerbose(true);
        inventoryManager.load();
    }

    public void loadObjectDefinitions(Cache cache) {
        objectManager = new ObjectManager(cache);
        objectManager.setVerbose(true);
        objectManager.load();
    }

    public void loadEnumDefinitions(Cache cache) {
        enumManager = new EnumManager(cache);
        enumManager.setVerbose(true);
        enumManager.load();
    }

    public void loadNpcDefinitions(Cache cache) {
        npcManager = new NpcManager(cache);
        npcManager.setVerbose(true);
        npcManager.load();
    }

    public void loadItemDefinitions(Cache cache) {
        itemManager = new ItemManager(cache);
        itemManager.setVerbose(true);
        itemManager.load();
    }

    public void loadParamDefinitions(Cache cache) {
        paramManager = new ParamManager(cache);
        paramManager.setVerbose(true);
        paramManager.load();
    }

    public void loadSequenceDefinitions(Cache cache) {
        sequenceManager = new SequenceManager(cache);
        sequenceManager.setVerbose(true);
        sequenceManager.load();
    }

    public void loadSpotanimDefinitions(Cache cache) {
        spotanimManager = new SpotanimManager(cache);
        spotanimManager.setVerbose(true);
        spotanimManager.load();
    }

    public void loadVarbitDefinitions(Cache cache) {
        varbitManager = new VarbitManager(cache);
        varbitManager.setVerbose(true);
        varbitManager.load();
    }

    public void loadVarclientDefinitions(Cache cache) {
        varclientManager = new VarclientManager(cache);
        varclientManager.setVerbose(true);
        varclientManager.load();
    }

    public void loadHitmarkDefinitions(Cache cache) {
        hitmarkManager = new HitmarkManager(cache);
        hitmarkManager.setVerbose(true);
        hitmarkManager.load();
    }

    public void loadHitbarDefinitions(Cache cache) {
        hitbarManager = new HitbarManager(cache);
        hitbarManager.setVerbose(true);
        hitbarManager.load();
    }

    public void loadModels(Cache cache) {
        modelManager = new ModelManager(cache);
        modelManager.setVerbose(true);
        modelManager.load();
    }

    public void loadSprites(Cache cache) {
        spriteManager = new SpriteManager(cache);
        spriteManager.setVerbose(true);
        spriteManager.load();
    }

    public void dumpObjectModels() {
        // Dumps all object models
        System.out.println("Dumping Object Models...");
        for (ObjectDefinition def : objectManager.getDefinitions().values()) {
            modelManager.dumpObjectModels(def, "/dumps/model/object/");
        }
    }

    public void dumpNpcModels() {
        // Dumps all npc models
        System.out.println("Dumping NPC Models...");
        for (NpcDefinition def : npcManager.getDefinitions().values()) {
            modelManager.dumpNpcModels(def, "/dumps/model/npc/");
        }
    }

    public void dumpItemModels() {
        // Dumps all item models
        System.out.println("Dumping Item Models...");
        for (ItemDefinition def : itemManager.getDefinitions().values()) {
            modelManager.dumpItemModels(itemManager, def, "/dumps/model/item/");
        }
    }
}
