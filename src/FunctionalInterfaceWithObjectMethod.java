interface MyRunnable extends Runnable { //Since Runnable is a Functional Interface MyRuunable also becomes Functional Interface
	int priority = 0;
}

public class FunctionalInterfaceWithObjectMethod {

	public static void main(String[] args) {
		MyRunnable myr = new MyRunnable() {

			@Override
			public void run() {
				System.out.println("Hello My Runnable");
			}

		};
		
		MyRunnable myr1 = () -> System.out.println("Hello My Runnable1");
		Thread myThread = new Thread(myr1);
		myThread.start();
	}

}
