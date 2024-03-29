package tech.lucidsoft.cache.definitions.loaders;

import tech.lucidsoft.cache.definitions.SequenceDefinition;
import tech.lucidsoft.cache.io.ByteBuffer;

import java.util.HashMap;
import java.util.Map;

public class SequenceLoader {

    public SequenceDefinition load(int id, ByteBuffer buffer) {
        SequenceDefinition def = new SequenceDefinition(id);
        while (true) {
            int opcode = buffer.readUnsignedByte();
            if (opcode == 0) {
                break;
            }
            decode(def, buffer, opcode);
        }
        return def;
    }

    public void decode(SequenceDefinition def, final ByteBuffer buffer, final int opcode) {
        switch (opcode) {
            case 1:
                int frameLengthsSize = buffer.readUnsignedShort();
                def.setFrameLengths(new int[frameLengthsSize]);

                for (int i = 0; i < frameLengthsSize; i++) {
                    def.getFrameLengths()[i] = buffer.readUnsignedShort();
                }

                def.setFrameIds(new int[frameLengthsSize]);

                for (int i = 0; i < frameLengthsSize; i++) {
                    def.getFrameIds()[i] = buffer.readUnsignedShort();
                }

                for (int i = 0; i < frameLengthsSize; i++) {
                    def.getFrameIds()[i] += buffer.readUnsignedShort() << 16;
                }
                return;
            case 2:
                def.setFrameStep(buffer.readUnsignedShort());
                return;
            case 3:
                int interleaveSize = buffer.readUnsignedByte();
                def.setInterleaves(new int[1 + interleaveSize]);

                for (int i = 0; i < interleaveSize; i++) {
                    def.getInterleaves()[i] = buffer.readUnsignedByte();
                }

                def.getInterleaves()[interleaveSize] = 9999999;
                return;
            case 4:
                def.setStretches(true);
                return;
            case 5:
                def.setForcedPriority(buffer.readUnsignedByte());
                return;
            case 6:
                def.setLeftHandItem(buffer.readUnsignedShort());
                if (def.getLeftHandItem() > 0) {
                    def.setLeftHandItem(def.getLeftHandItem() - 512);
                }
                return;
            case 7:
                def.setRightHandItem(buffer.readUnsignedShort());
                if (def.getRightHandItem() > 0) {
                    def.setRightHandItem(def.getRightHandItem() - 512);
                }
                return;
            case 8:
                def.setMaxLoops(buffer.readUnsignedByte());
                return;
            case 9:
                def.setPrecedenceAnimating(buffer.readUnsignedByte());
                return;
            case 10:
                def.setPriority(buffer.readUnsignedByte());
                return;
            case 11:
                def.setReplyMode(buffer.readUnsignedByte());
                return;
            case 12:
                int chatFramesSize = buffer.readUnsignedByte();
                def.setChatFrameIds(new int[chatFramesSize]);

                for (int i = 0; i < chatFramesSize; i++) {
                    def.getChatFrameIds()[i] = buffer.readUnsignedShort();
                }

                for (int i = 0; i < chatFramesSize; i++) {
                    def.getChatFrameIds()[i] += buffer.readUnsignedShort() << 16;
                }
                return;
            case 13:
                int frameSoundsSize = buffer.readUnsignedByte();
                def.setFrameSounds(new int[frameSoundsSize]);

                for(int i = 0; i < frameSoundsSize; i++) {
                    def.getFrameSounds()[i] = buffer.readMedium();
                }
                return;
            // TODO: figure out what each new variable means
            case 14:
                int something = buffer.readInt();
                break;
            case 15:
                int size = buffer.readUnsignedShort();
                Map something2 = new HashMap();
                for (int i = 0; i < size; i++) {
                    int something3 = buffer.readUnsignedShort();
                    int something4 = buffer.readMedium();
                    something2.put(Integer.valueOf(something3), Integer.valueOf(something4));
                }
                break;
            case 16:
                int something5 = buffer.readUnsignedShort();
                int something6 = buffer.readUnsignedShort();
                break;
            case 17:
                boolean[] something7 = new boolean[256];

                int something8 = buffer.readUnsignedByte();

                for (int j = 0; j < something8; j++) {
                    something7[buffer.readUnsignedByte()] = true;
                }
                break;
        }
    }
}
