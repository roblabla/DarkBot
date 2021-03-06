package org.darkstorm.darkbot.minecraftbot.protocol.v5x.play.server;

import java.io.*;

import org.darkstorm.darkbot.minecraftbot.protocol.*;
import org.darkstorm.darkbot.minecraftbot.protocol.ProtocolX.State;

public class PacketS38_PlayerListItem extends AbstractPacketX implements ReadablePacket {
	private String playerName;
	private boolean online;
	private int ping;

	public PacketS38_PlayerListItem() {
		super(0x38, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		playerName = readString(in);
		online = in.readBoolean();
		ping = in.readShort();
	}

	public String getPlayerName() {
		return playerName;
	}

	public boolean isOnline() {
		return online;
	}

	public int getPing() {
		return ping;
	}
}
