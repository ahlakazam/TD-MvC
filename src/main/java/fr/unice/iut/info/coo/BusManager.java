package fr.unice.iut.info.coo;

import java.util.*;

public class BusManager {
	
	private HashMap<String, Bus> mBusMap;
	
	public BusManager(){
		mBusMap = new HashMap<String, Bus>();
	}
	
	public boolean hasExistingBus(String name)
	{
		return mBusMap.containsKey(name);	
	}
	
	public boolean createBus(String busName)
	{
		if(hasExistingBus(busName))
			return false;
		mBusMap.put(busName, new Bus(busName));
		return true;
	}
	
	public void listBusNames()
	{
		System.out.println("Bus names :");
		for(Bus b : mBusMap.values())
		{
			System.out.println(b.getName());
		}
	}
	
	public Collection<Bus> getAllBus()
	{
		return new ArrayList<Bus>(mBusMap.values());
	}
	
	public boolean createBox(String busName, String newBoxName)
	{
		if(!mBusMap.containsKey(busName))
			return false;
		return mBusMap.get(busName).createBox(newBoxName);
	}
	
	public void emitIntoBox(String busName, String boxName, String newMessageContent)
	{
		if(!mBusMap.containsKey(busName))
			return;
		mBusMap.get(busName).emitIntoBox(boxName, newMessageContent);
	}
	
	public void emit(String busName, String newMessageContent)
	{
		if(!mBusMap.containsKey(busName))
			return;
		mBusMap.get(busName).emit(newMessageContent);
	}
	
	public Collection<Message> getAllMessages(String busName, String boxName)
	{
		if(mBusMap.containsKey(busName))
			return mBusMap.get(busName).getAllMessages(boxName);
		return null;
	}
	
	public Collection<Message> getAllMessages(String busName)
	{
		if(mBusMap.containsKey(busName))
			return mBusMap.get(busName).getAllMessages();
		return null;
	}
	
	public Collection<Message> getAllMessages()
	{
		ArrayList<Message> res = new ArrayList<Message>();
		for(Bus b : mBusMap.values())
			res.addAll(b.getAllMessages());
		return res;
	}

	public void destroyAllMessages()
	{
		for(Bus b : mBusMap.values())
			b.destroyAllMessages();
	}
	
	public void destroyMessagesOlderThan(Date date)
	{
		for(Bus b : mBusMap.values())
			b.destroyMessagesOlderThan(date);
	}
	
	public void destroyMessagesOlderThan(int seconds)
	{
		for(Bus b : mBusMap.values())
			b.destroyMessagesOlderThan(seconds);
	}
	
	public void destroyMessagesEarlierThan(Date date)
	{
		for(Bus b : mBusMap.values())
			b.destroyMessagesEarlierThan(date);
	}
	
	public void destroyMessagesEarlierThan(int seconds)
	{
		for(Bus b : mBusMap.values())
			b.destroyMessagesEarlierThan(seconds);
	}
	
	public void destroyAllMessages(String busName)
	{
		if(mBusMap.containsKey(busName))
			mBusMap.get(busName).destroyAllMessages();
	}
	
	public void destroyMessagesOlderThan(String busName, Date date)
	{
		for(Bus b : mBusMap.values())
			b.destroyMessagesOlderThan(date);
	}
	
	public void destroyMessagesOlderThan(String busName, int seconds)
	{
		for(Bus b : mBusMap.values())
			b.destroyMessagesOlderThan(seconds);
	}
	
	public void destroyMessagesEarlierThan(String busName, Date date)
	{
		for(Bus b : mBusMap.values())
			b.destroyMessagesEarlierThan(date);
	}
	
	public void destroyMessagesEarlierThan(String busName, int seconds)
	{
		for(Bus b : mBusMap.values())
			b.destroyMessagesEarlierThan(seconds);
	}
	
	public void destroyAllMessages(String busName, String boxName)
	{
		if(mBusMap.containsKey(busName))
			mBusMap.get(busName).destroyAllMessages(boxName);
	}
	
	public void destroyMessagesOlderThan(String busName, String boxName, Date date)
	{
		for(Bus b : mBusMap.values())
			b.destroyMessagesOlderThan(date);
	}
	
	public void destroyMessagesOlderThan(String busName, String boxName, int seconds)
	{
		for(Bus b : mBusMap.values())
			b.destroyMessagesOlderThan(seconds);
	}
	
	public void destroyMessagesEarlierThan(String busName, String boxName, Date date)
	{
		for(Bus b : mBusMap.values())
			b.destroyMessagesEarlierThan(date);
	}
	
	public void destroyMessagesEarlierThan(String busName, String boxName, int seconds)
	{
		for(Bus b : mBusMap.values())
			b.destroyMessagesEarlierThan(seconds);
	}
	
	public String toString()
	{
		String nl = System.lineSeparator();
		
		String res = "Bus systems : " + nl;
		
		if(mBusMap.isEmpty())
			res += "empty" + nl;
		else
			for(Bus b : mBusMap.values())
				res += "---> "+ b + nl;
		
		return res + "*************";
	}

	public Set<String> getAllBusNames () {
		return mBusMap.keySet();
	}

	public Bus getBus(String busName) {

	    return mBusMap.get(busName);

    }
	
}
