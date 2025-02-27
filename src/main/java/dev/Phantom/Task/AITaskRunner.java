package dev.Phantom.Task;

import java.util.List;

import dev.Phantom.FakePlayerTaskManager;
import dev.l2j.tesla.commons.concurrent.ThreadPool;

public class AITaskRunner implements Runnable
{	
	@Override
	public void run()
	{		
		FakePlayerTaskManager.INSTANCE.adjustTaskSize();
		List<AITask> aiTasks = FakePlayerTaskManager.INSTANCE.getAITasks();		
		aiTasks.forEach(aiTask -> ThreadPool.execute(aiTask));
	}	
}