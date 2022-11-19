package Problem3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Pond fishPond=new Pond();
		Thread th1=new Thread(fishPond);
		th1.start();
		Thread th2=new Thread(fishPond);
		th2.start();
		Thread th3=new Thread(fishPond);
		th3.start();
		Thread th4=new Thread(fishPond);
		th4.start();
		Thread th5=new Thread(fishPond);
		th5.start();
	}
}
