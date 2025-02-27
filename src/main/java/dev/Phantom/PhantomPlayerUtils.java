package dev.Phantom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

import dev.l2j.tesla.commons.random.Rnd;
import dev.l2j.tesla.gameserver.model.actor.Creature;
import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.network.clientpackets.Say2;
import dev.l2j.tesla.gameserver.network.serverpackets.CreatureSay;
import dev.l2j.tesla.gameserver.network.serverpackets.L2GameServerPacket;

public class PhantomPlayerUtils
{
	private static ArrayList<String> _fakesTellPhrases = new ArrayList<>();
	private static ArrayList<String> _fakesPeacePhrases = new ArrayList<>();
	private static ArrayList<String> _fakesTradePhrases = new ArrayList<>();

	public static void load()
	{
		_fakesTellPhrases.clear();
		_fakesPeacePhrases.clear();
		_fakesTradePhrases.clear();

		parseFile("tell", _fakesTellPhrases);
		parseFile("peace", _fakesPeacePhrases);
		parseFile("trade", _fakesTradePhrases);

	}
	
	private static void parseFile(String file_name, ArrayList<String> phrases)
	{
		LineNumberReader lnr = null;
		BufferedReader br = null;
		FileReader fr = null;
		try
		{
			File Data = new File("./config/aCis/Phantom/chat/" + file_name + ".talk");
			if (!Data.exists())
			{
				return;
			}
			
			fr = new FileReader(Data);
			br = new BufferedReader(fr);
			lnr = new LineNumberReader(br);
			String line;
			while ((line = lnr.readLine()) != null)
			{
				if (line.trim().length() == 0 || line.startsWith("#"))
					continue;
				
				phrases.add(line);
			}
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (fr != null)
				{
					fr.close();
				}
				if (br != null)
				{
					br.close();
				}
				if (lnr != null)
				{
					lnr.close();
				}
			}
			catch (Exception e1)
			{
				
			}
		}
	}
	
	public static void maybeAnnounce(Player fake)
	{
		//parece q so aceita uma condi��o esse codigo testa agora pra ve uma coisa
		toSelfAndKnownPlayers(fake, new CreatureSay(fake.getObjectId(), Rnd.chance(80) ? Say2.SHOUT : Say2.ALL, fake.getName(), getRandomPeacePhrase()));
		toSelfAndKnownPlayers(fake, new CreatureSay(fake.getObjectId(), Rnd.chance(80) ? Say2.SHOUT : Say2.TRADE, fake.getName(), getRandomPeacePhrase()));
		 //Say2.TRADE
	}
	//
	public static void toSelfAndKnownPlayers(Creature character, L2GameServerPacket mov)
	{
		if (character instanceof Player)
			character.sendPacket(mov);
		
		toKnownPlayers(character, mov);
	}
	
	public static void toKnownPlayers(Creature character, L2GameServerPacket mov)
	{
		for (Player player : character.getKnownType(Player.class))
			player.sendPacket(mov);
	}
	

	public static String getRandomPeacePhrase()
	{
		return _fakesPeacePhrases.get(Rnd.get(_fakesPeacePhrases.size()));
	}
	public static String getRandomTradePhrase()//parece q ja tem
	{
		return _fakesTradePhrases.get(Rnd.get(_fakesTradePhrases.size()));
	}

	public static String getRandomTellPhrase()
	{
		return _fakesTellPhrases.get(Rnd.get(_fakesTellPhrases.size()));
	}

	public static long LastPMUsedTime = 0;
	
	public static void answerPlayers(Player sender, FakePlayer fakePlayer, String text)
	{
		long currentTime = System.currentTimeMillis();
		long elapsedTime = currentTime - LastPMUsedTime;
		long resurrectionSkillReuseTime = 1000 * 1;
		
		if (elapsedTime >= resurrectionSkillReuseTime)
		{
			sender.sendPacket(new CreatureSay(fakePlayer.getObjectId(), Say2.TELL, fakePlayer.getName(), getRandomTellPhrase()));

			LastPMUsedTime = currentTime;
		}
	}

	public static void answerPlayersTrade(Player player, FakePlayer fakePlayer) {


		long currentTime = System.currentTimeMillis();
		long elapsedTime = currentTime - LastPMUsedTime;
		long resurrectionSkillReuseTime = 1000 * 1;
		
		if (elapsedTime >= resurrectionSkillReuseTime)
		{
			player.sendPacket(new CreatureSay(fakePlayer.getObjectId(), Say2.ALL, fakePlayer.getName(), getRandomTradePhrase()));

			LastPMUsedTime = currentTime;
		}
		
	}


}