//Patrick Kwok
//010917833

import java.util.concurrent.Semaphore;


public class Buffer 
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
