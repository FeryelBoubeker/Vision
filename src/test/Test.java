package test;
import gui.MainPage;

public class Test {

	public static void main(String[] args) {
			MainPage main=new MainPage("Vision");
			Thread mainThread= new Thread(main);
			mainThread.start();
	}

}
