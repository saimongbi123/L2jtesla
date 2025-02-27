package dev.l2j.tesla.gameserver.handler.admincommandhandlers;

import dev.l2j.tesla.gameserver.handler.IAdminCommandHandler;
import dev.l2j.tesla.gameserver.model.actor.Player;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetLoc implements IAdminCommandHandler {

    private static final String[] ADMIN_COMMANDS = { "admin_loc" };

    @Override
    public boolean useAdminCommand(String command, Player activeChar) {
        if (command.startsWith("admin_loc")) {
            int x = activeChar.getX();
            int y = activeChar.getY();
            int z = activeChar.getZ();

            activeChar.sendMessage("Suas coordenadas atuais são: X = " + x + ", Y = " + y + ", Z = " + z);
            saveToFile(x, y, z);
        }
        return true;
    }

    @Override
    public String[] getAdminCommandList() {
        return ADMIN_COMMANDS;
    }

    private void saveToFile(int x, int y, int z) {
        String filePath = "coordenadas.txt";
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(timeStamp + " - X = " + x + ", Y = " + y + ", Z = " + z + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}