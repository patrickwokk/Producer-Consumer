//Patrick Kwok
//010917833

import java.util.concurrent.Semaphore;
import java.util.Random;
import java.util.Scanner;

public class ProducerConsumer {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Buffers b = new Buffers();
		

			//use arguments, 1. time, 2. producer, 3. consumer
			int runTime = Integer.parseInt(args[0]);
			int producerThreads = Integer.parseInt(args[1]);
			int consumerThreads = Integer.parseInt(args[2]);
			
			System.out.println("Using arguments from command line");
			System.out.println("Sleep time = " + runTime );
			System.out.println("Producer threads = " + producerThreads);
			System.out.println("Consumer threads = " + consumerThreads+"\n");
			
			Runnable Producer = new Producer(b);
			Runnable Consumer = new Consumer(b);
			
			Thread producerArry[] = new Thread[producerThreads];
			Thread consumerArry[] = new Thread[consumerThreads];
			
			 for (int i=0; i<producerThreads; i++)
			 {
				 Thread producer = new Thread(new Producer(b));
				 producerArry[i] = producer;
				 producer.start();
			 }
			 
			 for (int i=0; i<consumerThreads; i++)
			 {
				 Thread consumer = new Thread(new Consumer(b));
				 consumerArry[i] = consumer;
				 consumer.start();
			 }
			 
			 try {
			 Thread.sleep(runTime * 1000);
			 }
			 catch (Exception e) {
				 e.printStackTrace();
			 }
			 
			 for (int i=0; i<producerThreads; i++)
		        {
				 producerArry[i].interrupt();
		            try
		            {
		            	producerArry[i].join();
		            }
		            catch (Exception e)
		            {
		            	 e.printStackTrace();
		            }
		        }

		        for (int i=0; i<consumerThreads; i++)
		        {
		        	consumerArry[i].interrupt();
		            try
		            {
		            	consumerArry[i].join();
		            }
		            catch (Exception e)
		            {
		            	e.printStackTrace();
		            }
		        }
		}
		
		
		//loop
			//create producer 
		//loop
			//create consumer
		
		//sleep for the amount of times
		
		//stop the threads
		
		//join producer, function from the semaphore
		
		//join consumer, function from the sempahore 
	}

class Buffers
{
	//semaphore is non negative 
	//mutex.acquire (-1) and mutex.release (+1)
	//full.acquire and full.release
	//empty.acquire and empty.release
	
    static Semaphore mutex = new Semaphore(1);
    static Semaphore empty = new Semaphore(5); //buffer size
    static Semaphore full = new Semaphore(0); 
    
    int[] bufferArray = new int[5];
    int insertIndex= 0;
    int removeIndex = 0;


    
    public void insertItem(int randomInt)
    {
    	try {
    		empty.acquire();
    		mutex.acquire();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	bufferArray[insertIndex++] = randomInt;
    	
    	//buffer size = 5
    	insertIndex = insertIndex %5;
    	
    	//empty = 4
    	//mutex = 0
    	//full = 0
    	
    	try {
    	mutex.release();
    	//mutex = 1
    	full.release();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	//mutex = 1
    	//empty = 4
    	//full = 1
    	
    	//check if the buffer is empty slot
    		//lock the buffer (acquire)
    		//place item into buffer
    	
    	//release the lock, (release)
    }
    
    public int removeItem()
    {
    	
    	try {
    		full.acquire();
    		mutex.acquire();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	int removeItem = bufferArray[removeIndex++];
    	
    	//buffer size = 5
    	removeIndex = removeIndex %5;
    	
    	try {
    		mutex.release();
    		
    		empty.release();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	//similar to insertItem
    	//consumer lock the buffer
    	//and remove item
    	//release the lock
    	
    	
    	return removeItem;
    }

}

