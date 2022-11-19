package Problem3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Pond implements Runnable{
	static int fishCount;
	private List<Fish> fishPond=Collections.synchronizedList(new ArrayList<>());
	public Pond()
	{
		for(int i=0;i<10;i++)
			fishPond.add(new Fish("female",i));
		for(int i=10;i<20;i++)
			fishPond.add(new Fish("male", i));
		fishCount=20;
	}
	public void run()
	{
		while(fishCount>1)
		{
			int a=genRandom(fishCount);
			int b=genRandom(fishCount);
			while(a==b)
				b=genRandom(fishCount);
			Fish f1=fishPond.get(a);
			Fish f2=fishPond.get(b);
			meet(f1,f2);
		}
	}
	public synchronized void decrement()
	{
		fishCount-=1;
	}
	public synchronized void increment()
	{
		fishCount+=1;
	}
	public void meet(Fish fish1, Fish fish2)
	{
		if(fish1.getGender()=="male"&&fish2.getGender()=="male")
		{
			fishPond.remove(fish1);
			fishPond.remove(fish2);
			decrement();
			decrement();
		}
		else if(fish1.getGender()=="female"&&fish2.getGender()=="female")
		{
			if(genRandom(2)==0)
				fishPond.remove(fish1);
			else
				fishPond.remove(fish2);
			decrement();
		}
		else
		{
			addFish();
			addFish();
		}
		System.out.println("Thread ID: "+Thread.currentThread().getId()+" "+fish1+" "+fish2+"remaining fishes: "+fishCount);
		//System.out.println("Count of remaining fishes: "+fishCount+"By Thread ID: "+ Thread.currentThread().getId());
		//System.out.println("Current Thread ID: "+ Thread.currentThread().getId()+fishPond);
		//System.out.println("PondSize : "+fishPond.size()+"Current Thread ID: "+ Thread.currentThread().getId());
		System.out.println("\n");
	}
	public void addFish()
	{
		if(genRandom(2)==0)
			fishPond.add(new Fish("female", fishCount+1));
		else
			fishPond.add(new Fish("male", fishCount+1));
		increment();
	}
	public int genRandom(int n)
	{
		Random ran=new Random();
		return ran.nextInt(n);
	}
}
