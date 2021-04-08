//Patrick Kwok
//010917833

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Producer implements Runnable
{
	private Buffers b;
	long sleepTime;
    int randomInteger;
	
	public Producer(Buffers b)
	{
		this.b = b;
	}
	
	public void run()
	{
		try
		{
			//loop for 100 times
			for(int i = 0; i<100; i++)
			{
				//random from 0 - 0.5
				Random r = new Random();
				double randomValue = (0.0 + (0.5-0.0)) * r.nextDouble();
				this.sleepTime = (long)randomValue;
				
				//threads.sleep
				Thread.sleep(sleepTime);
				
				
		        Random randomInteger = new Random();
		        int randomInt = randomInteger.nextInt(); 
		        
				
		        //insert random number
				b.insertItem(randomInt);
			

				System.out.println("Producer produced = " + randomInt);

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
