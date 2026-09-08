package me.aidanskye.submerged.maps;

import dev.doctor4t.wathe.api.MapEffect;
import dev.doctor4t.wathe.game.GameConstants;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static dev.doctor4t.wathe.cca.MapVariablesWorldComponent.PosWithOrientation;

public record SubmergedMap(Settings mapSettings, MapEffect defaultMapEffect, List<Box> freshAirAreas, boolean isRelative) {

    public static class Settings {
        /**
         * The origin point of every map related variable.
         * <p>Before a map is loaded in at runtime, every map variable
         * is a relative location to this point.</p>
         * <p>After a map is loaded in, this value is added to
         * every map variable to make them absolute locations.
         */
        Vec3i mapOrigin;
        /**
         * The origin point of every lobby related variable.
         * <p>Before a map is loaded in at runtime, every lobby variable
         * is a relative location to this point.</p>
         * <p>After a map is loaded in, this value is added to
         * every lobby variable to make them absolute locations.
         */
        Vec3i lobbyOrigin;

        /**
         * The location that players will spawn at after a round ends.
         */
        PosWithOrientation spawnPos;
        /**
         * The location that spectators will spawn at when a round starts.
         */
        PosWithOrientation spectatorSpawnPos;

        /**
         * The area in the lobby that determines which players are playing in the next round.
         * <p>When a game is started, the players in this area
         * are offset by the {@link #playAreaOffset}.
         */
        Box readyArea;
        /**
         * The offset that players are teleported by to get them from the {@link #readyArea} to the {@link #playArea}.
         * <p>Before this value is converted to its absolute value when the
         * map is loaded at runtime, this value is set to an offset from the
         * {@link #mapOrigin} to the minimum corner of the box of the possible
         * locations that players can be teleported to at the start of a game.</p>
         * <p>If you didn't understand that, I don't fully either, I'm just going with it
         */
        Vec3i playAreaOffset;
        /**
         * The area of the map that players play in.
         * <p>Falling below the minimum y-level of this box will cause the player to die due to {@link GameConstants.DeathReasons#FELL_OUT_OF_TRAIN}.
         */
        Box playArea;

        /**
         * The area of the map that is copied to the play area when a game starts.
         * <p>When a game is started, the blocks in this area are copied
         * to the play area by the {@link #resetPasteOffset}.
         */
        Box resetTemplateArea;
        /**
         * The offset from the {@link #resetTemplateArea} to the {@link #playArea}.
         * <p>When a game is started, the blocks in the
         * {@link #resetTemplateArea} are offset by this value
         * to get them to the {@link #playArea}
         */
        Vec3i resetPasteOffset;

        /**
         * The position that the {@link cat.rezelyn.watheextended.item.TeleportToReadyAreaItem} teleports you to.
         */
        PosWithOrientation readyAreaSpawnPos;

        public Settings() {}

        public Settings(@Nullable Vec3i mapOrigin,
                        @Nullable Vec3i lobbyOrigin,
                        PosWithOrientation spawnPos,
                        PosWithOrientation spectatorSpawnPos,
                        Box readyArea,
                        Vec3i playAreaOffset,
                        Box playArea,
                        Box resetTemplateArea,
                        Vec3i resetPasteOffset,
                        @Nullable PosWithOrientation readyAreaSpawnPos
        ) {
            this.mapOrigin = mapOrigin == null ? Vec3i.ZERO : mapOrigin;
            this.lobbyOrigin = lobbyOrigin == null ? Vec3i.ZERO : lobbyOrigin;
            this.spawnPos = spawnPos;
            this.spectatorSpawnPos = spectatorSpawnPos;
            this.readyArea = readyArea;
            this.playAreaOffset = playAreaOffset;
            this.playArea = playArea;
            this.resetTemplateArea = resetTemplateArea;
            this.resetPasteOffset = resetPasteOffset;
            this.readyAreaSpawnPos = readyAreaSpawnPos == null ? spawnPos : readyAreaSpawnPos;
        }

        public Vec3i getMapOrigin() {
            return mapOrigin;
        }

        public void setMapOrigin(Vec3i mapOrigin) {
            this.mapOrigin = mapOrigin;
        }

        public Vec3i getLobbyOrigin() {
            return lobbyOrigin;
        }

        public void setLobbyOrigin(Vec3i lobbyOrigin) {
            this.lobbyOrigin = lobbyOrigin;
        }

        public PosWithOrientation getSpawnPos() {
            return spawnPos;
        }

        public void setSpawnPos(PosWithOrientation spawnPos) {
            this.spawnPos = spawnPos;
        }

        public PosWithOrientation getSpectatorSpawnPos() {
            return spectatorSpawnPos;
        }

        public void setSpectatorSpawnPos(PosWithOrientation spectatorSpawnPos) {
            this.spectatorSpawnPos = spectatorSpawnPos;
        }

        public Box getReadyArea() {
            return readyArea;
        }

        public void setReadyArea(Box readyArea) {
            this.readyArea = readyArea;
        }

        public Vec3i getPlayAreaOffset() {
            return playAreaOffset;
        }

        public void setPlayAreaOffset(Vec3i playAreaOffset) {
            this.playAreaOffset = playAreaOffset;
        }

        public Box getPlayArea() {
            return playArea;
        }

        public void setPlayArea(Box playArea) {
            this.playArea = playArea;
        }

        public Box getResetTemplateArea() {
            return resetTemplateArea;
        }

        public void setResetTemplateArea(Box resetTemplateArea) {
            this.resetTemplateArea = resetTemplateArea;
        }

        public Vec3i getResetPasteOffset() {
            return resetPasteOffset;
        }

        public void setResetPasteOffset(Vec3i resetPasteOffset) {
            this.resetPasteOffset = resetPasteOffset;
        }

        public PosWithOrientation getReadyAreaSpawnPos() {
            return readyAreaSpawnPos;
        }

        public void setReadyAreaSpawnPos(PosWithOrientation readyAreaSpawnPos) {
            this.readyAreaSpawnPos = readyAreaSpawnPos;
        }

        public boolean isValid() {
//            Submerged.LOGGER.info("mapOrigin: {}, lobbyOrigin: {}, spawnPos: {}, specSpawnPos: {}, readyArea: {}, playAreaOffset: {}, playArea: {}, resetTemplateArea: {}, resetPasteOffset: {}",
//                    getMapOrigin(),
//                    getLobbyOrigin(),
//                    getSpawnPos(),
//                    getSpectatorSpawnPos(),
//                    getReadyArea(),
//                    getPlayAreaOffset(),
//                    getPlayArea(),
//                    getResetTemplateArea(),
//                    getResetPasteOffset());
            return !(getMapOrigin() == null ||
                    getLobbyOrigin() == null ||
                    getSpawnPos() == null ||
                    getSpectatorSpawnPos() == null ||
                    getReadyArea() == null ||
                    getPlayAreaOffset() == null ||
                    getPlayArea() == null ||
                    getResetTemplateArea() == null ||
                    getResetPasteOffset() == null
            );
        }

        public Settings offsetValues() {
            setSpawnPos(offsetPosWithOrientation(getSpawnPos(), getLobbyOrigin()));
            setSpectatorSpawnPos(offsetPosWithOrientation(getSpectatorSpawnPos(), getMapOrigin()));

            setReadyArea(offsetBox(getReadyArea(), getLobbyOrigin()));
            //I really hope this works first try, cause this would be hell to debug
            //really just going off of a whim cause I didn't want to have to add more complexity to adding maps using the system
            setPlayAreaOffset((getMapOrigin().add(getPlayAreaOffset())).subtract(new Vec3i((int) getReadyArea().minX, (int) getReadyArea().minY, (int) getReadyArea().minZ)));
            setPlayArea(offsetBox(getPlayArea(), getMapOrigin()));

            setResetTemplateArea(offsetBox(getResetTemplateArea(), getMapOrigin()));

            setReadyAreaSpawnPos(offsetPosWithOrientation(getReadyAreaSpawnPos(), getLobbyOrigin()));
            return this;
        }

        public static PosWithOrientation offsetPosWithOrientation(PosWithOrientation pos, Vec3i offset) {
            Vec3d posVec = pos.pos;
            return new PosWithOrientation(posVec.add(Vec3d.of(offset)), pos.yaw, pos.pitch);
        }

        public static Box offsetBox(Box box, Vec3i offset) {
            return box.offset(Vec3d.of(offset));
        }
    }
}
