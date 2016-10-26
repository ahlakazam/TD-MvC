package fr.unice.iut.info.coo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Box {

	final private String mName;
	final private ArrayList<Message> mMessages;
	
	public Box(String name)
	{	
		mName = name;
		mMessages = new ArrayList<Message>();
	}
	
	public String getName()
	{
		return mName;
	}
	
	/**
	 * add (if not already into the bus) a message into the bus through 
	 * reference or after creating the message through its content
	 */
	
	public void emit(String newMessageContent)
	{
		mMessages.add(new Message(newMessageContent));
	}
	
	/**
	 * return messages into the bus in different ways.
	 * - all the messages
	 * - all too old or too early messages (comparing against a date)
	 */
	
	public Collection<Message> getAllMessages()
	{
		return new ArrayList<Message>(mMessages);
	}
	
	public boolean isEmpty()
	{
		return mMessages.isEmpty();
	}
	
	public String toString()
	{
		String nl = System.lineSeparator();
		
		String res = mName+" Box :"+nl;
		
		if(mMessages.isEmpty())
			res += "empty" + nl;
		else
			for(Message m : mMessages)
				res += m + nl;
		
		return res;
	}
	
	/**
	 * destroy messages into the bus in different ways.
	 * - one message through its reference (if it is present)
	 * - all the messages
	 * - all too old or too early messages (comparing against a date or seconds)
	 * @return true if the message list of the bus have changed after 
	 * realizing services
	 */
	
	public boolean destroyMessage(Message message)
	{
		if(!mMessages.contains(message))
			return false;
		mMessages.remove(message);
		return true;
	}
	
	public boolean destroyMessages(Collection<Message> messages)
	{
		if(!mMessages.containsAll(messages)) 
			return false;
		mMessages.removeAll(messages);
		return true;
	}
	
	public boolean destroyMessagesOlderThan(Date date)
	{
		return destroyMessages(getMessagesOlderThan(date));
	}
	
	public boolean destroyMessagesOlderThan(int seconds)
	{
		return destroyMessages(getMessagesOlderThan(seconds));
	}
	
	public boolean destroyMessagesEarlierThan(Date date)
	{
		return destroyMessages(getMessagesEarlierThan(date));
	}
	
	public boolean destroyMessagesEarlierThan(int seconds)
	{
		return destroyMessages(getMessagesEarlierThan(seconds));
	}
	
	public void destroyAllMessages()
	{
		mMessages.clear();
	}
	
	
	public Collection<Message> getMessagesOlderThan(Date date)
	{
		ArrayList<Message> olders = new ArrayList<Message>();
		for(Message m : mMessages)
		{
			if(m.isOlderThan(date))
				olders.add(m);
		}
		return olders;
	}
	
	public Collection<Message> getMessagesOlderThan(int seconds)
	{
		ArrayList<Message> olders = new ArrayList<Message>();
		for(Message m : mMessages)
		{
			if(m.isOlderThan(seconds))
				olders.add(m);
		}
		return olders;
	}
	
	public Collection<Message> getMessagesEarlierThan(Date date)
	{
		ArrayList<Message> earliers = new ArrayList<Message>();
		for(Message m : mMessages)
		{
			if(m.isOlderThan(date))
				earliers.add(m);
		}
		return earliers;
	}
	
	public Collection<Message> getMessagesEarlierThan(int seconds)
	{
		ArrayList<Message> earliers = new ArrayList<Message>();
		for(Message m : mMessages)
		{
			if(m.isEarlierThan(seconds))
				earliers.add(m);
		}
		return earliers;
	}
}
