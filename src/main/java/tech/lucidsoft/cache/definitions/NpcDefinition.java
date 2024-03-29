package tech.lucidsoft.cache.definitions;

import java.util.HashMap;

/**
 * Contains data related to Npc configs(a.k.a definitions/defs)
 */
public class NpcDefinition {

    private int id;
    private String name;
    private int category;
    private String[] options;
    private int varp;
    private int varbit;
    private int[] transmogrifiedIds;
    private int[] models;
    private int[] chatModels;
    private int standAnimation;
    private int walkAnimation;
    private int rotate90Animation;
    private int rotate180Animation;
    private int rotate270Animation;
    private int size;
    private int combatLevel;
    private boolean minimapVisible;
    private boolean visible;
    private boolean clickable;
    private boolean clippedMovement;
    private boolean isFamiliar;
    private int resizeX;
    private int resizeY;
    private int direction;
    private int[] headIconArchiveIds;
    private short[] headIconSpriteIndex;
    private int ambience;
    private int contrast;
    private short[] originalColours;
    private short[] replacementColours;
    private short[] originalTextures;
    private short[] replacementTextures;
    private int field3568;
    private int field3580;
    private int finalTransmogrification;
    private int runAnimation;
    private int runRotate180Animation;
    private int runRotateLeftAnimation;
    private int runRotateRightAnimation;
    private int crawlAnimation;
    private int crawlRotate180Animation;
    private int crawlRotateLeftAnimation;
    private int crawlRotateRightAnimation;
    private HashMap<Integer, Object> parameters;

    public NpcDefinition() {
        setDefaults();
    }

    public NpcDefinition(int id) {
        setDefaults();
        this.setId(id);
    }

    public void setDefaults() {
        setName("null");
        setSize(1);
        setStandAnimation(-1);
        setWalkAnimation(-1);
        setRotate180Animation(-1);
        setRotate90Animation(-1);
        setRotate270Animation(-1);
        setField3568(-1);
        setField3580(-1);
        setOptions(new String[5]);
        setMinimapVisible(true);
        setCombatLevel(-1);
        setResizeX(128);
        setResizeY(128);
        setVisible(false);
        setAmbience(0);
        setContrast(0);
        setDirection(32);
        setVarbit(-1);
        setVarp(-1);
        setClickable(true);
        setClippedMovement(true);
        setFamiliar(false);
    }

    public int[] getHeadIconArchiveIds() {
        return headIconArchiveIds;
    }

    public void setHeadIconArchiveIds(int[] headIconArchiveIds) {
        this.headIconArchiveIds = headIconArchiveIds;
    }

    public short[] getHeadIconSpriteIndex() {
        return headIconSpriteIndex;
    }

    public void setHeadIconSpriteIndex(short[] headIconSpriteIndex) {
        this.headIconSpriteIndex = headIconSpriteIndex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getVarp() {
        return varp;
    }

    public void setVarp(int varp) {
        this.varp = varp;
    }

    public int getVarbit() {
        return varbit;
    }

    public void setVarbit(int varbit) {
        this.varbit = varbit;
    }

    public int[] getTransmogrifiedIds() {
        return transmogrifiedIds;
    }

    public void setTransmogrifiedIds(int[] transmogrifiedIds) {
        this.transmogrifiedIds = transmogrifiedIds;
    }

    public int[] getModels() {
        return models;
    }

    public void setModels(int[] models) {
        this.models = models;
    }

    public int[] getChatModels() {
        return chatModels;
    }

    public void setChatModels(int[] chatModels) {
        this.chatModels = chatModels;
    }

    public int getStandAnimation() {
        return standAnimation;
    }

    public void setStandAnimation(int standAnimation) {
        this.standAnimation = standAnimation;
    }

    public int getWalkAnimation() {
        return walkAnimation;
    }

    public void setWalkAnimation(int walkAnimation) {
        this.walkAnimation = walkAnimation;
    }

    public int getRotate90Animation() {
        return rotate90Animation;
    }

    public void setRotate90Animation(int rotate90Animation) {
        this.rotate90Animation = rotate90Animation;
    }

    public int getRotate180Animation() {
        return rotate180Animation;
    }

    public void setRotate180Animation(int rotate180Animation) {
        this.rotate180Animation = rotate180Animation;
    }

    public int getRotate270Animation() {
        return rotate270Animation;
    }

    public void setRotate270Animation(int rotate270Animation) {
        this.rotate270Animation = rotate270Animation;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    public void setCombatLevel(int combatLevel) {
        this.combatLevel = combatLevel;
    }

    public boolean isMinimapVisible() {
        return minimapVisible;
    }

    public void setMinimapVisible(boolean minimapVisible) {
        this.minimapVisible = minimapVisible;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public boolean isClippedMovement() {
        return clippedMovement;
    }

    public void setClippedMovement(boolean clippedMovement) {
        this.clippedMovement = clippedMovement;
    }

    public boolean isFamiliar() {
        return isFamiliar;
    }

    public void setFamiliar(boolean familiar) {
        isFamiliar = familiar;
    }

    public int getResizeX() {
        return resizeX;
    }

    public void setResizeX(int resizeX) {
        this.resizeX = resizeX;
    }

    public int getResizeY() {
        return resizeY;
    }

    public void setResizeY(int resizeY) {
        this.resizeY = resizeY;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }


    public int getAmbience() {
        return ambience;
    }

    public void setAmbience(int ambience) {
        this.ambience = ambience;
    }

    public int getContrast() {
        return contrast;
    }

    public void setContrast(int contrast) {
        this.contrast = contrast;
    }

    public short[] getOriginalColours() {
        return originalColours;
    }

    public void setOriginalColours(short[] originalColours) {
        this.originalColours = originalColours;
    }

    public short[] getReplacementColours() {
        return replacementColours;
    }

    public void setReplacementColours(short[] replacementColours) {
        this.replacementColours = replacementColours;
    }

    public short[] getOriginalTextures() {
        return originalTextures;
    }

    public void setOriginalTextures(short[] originalTextures) {
        this.originalTextures = originalTextures;
    }

    public short[] getReplacementTextures() {
        return replacementTextures;
    }

    public void setReplacementTextures(short[] replacementTextures) {
        this.replacementTextures = replacementTextures;
    }

    public int getField3568() {
        return field3568;
    }

    public void setField3568(int field3568) {
        this.field3568 = field3568;
    }

    public int getField3580() {
        return field3580;
    }

    public void setField3580(int field3580) {
        this.field3580 = field3580;
    }

    public int getFinalTransmogrification() {
        return finalTransmogrification;
    }

    public void setFinalTransmogrification(int finalTransmogrification) {
        this.finalTransmogrification = finalTransmogrification;
    }

    public HashMap<Integer, Object> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<Integer, Object> parameters) {
        this.parameters = parameters;
    }

    public int getRunAnimation() {
        return runAnimation;
    }

    public void setRunAnimation(int runAnimation) {
        this.runAnimation = runAnimation;
    }

    public int getRunRotate180Animation() {
        return runRotate180Animation;
    }

    public void setRunRotate180Animation(int runRotate180Animation) {
        this.runRotate180Animation = runRotate180Animation;
    }

    public int getRunRotateLeftAnimation() {
        return runRotateLeftAnimation;
    }

    public void setRunRotateLeftAnimation(int runRotateLeftAnimation) {
        this.runRotateLeftAnimation = runRotateLeftAnimation;
    }

    public int getRunRotateRightAnimation() {
        return runRotateRightAnimation;
    }

    public void setRunRotateRightAnimation(int runRotateRightAnimation) {
        this.runRotateRightAnimation = runRotateRightAnimation;
    }

    public int getCrawlAnimation() {
        return crawlAnimation;
    }

    public void setCrawlAnimation(int crawlAnimation) {
        this.crawlAnimation = crawlAnimation;
    }

    public int getCrawlRotate180Animation() {
        return crawlRotate180Animation;
    }

    public void setCrawlRotate180Animation(int crawlRotate180Animation) {
        this.crawlRotate180Animation = crawlRotate180Animation;
    }

    public int getCrawlRotateLeftAnimation() {
        return crawlRotateLeftAnimation;
    }

    public void setCrawlRotateLeftAnimation(int crawlRotateLeftAnimation) {
        this.crawlRotateLeftAnimation = crawlRotateLeftAnimation;
    }

    public int getCrawlRotateRightAnimation() {
        return crawlRotateRightAnimation;
    }

    public void setCrawlRotateRightAnimation(int crawlRotateRightAnimation) {
        this.crawlRotateRightAnimation = crawlRotateRightAnimation;
    }
}
