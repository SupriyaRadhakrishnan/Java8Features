
/*Note if 2 interface defines same method and if it is implemented by a class, then we need to define the method in the class
 * Multiple inheritance is not allowed in Java 
 */

interface Phone
{
	void call();//This method is by default abstract and public
	default void message() //using the default keyword we can define a method inside interface
	{
		System.out.println("Sent");
	}
}
interface PhoneX
{
	void call();//This method is by default abstract and public
	default void message() //using the default keyword we can define a method inside interface
	{
		System.out.println("Sent");
	}
}

class Parent
{
	public void message() //using the default keyword we can define a method inside interface
	{
		System.out.println("Sent from Parent");
	}
}
//This method implements only the abstract methods in the interface
class AndroidPhone extends Parent implements Phone ,PhoneX
{

	@Override
	public void call() {
		System.out.println("Call");
	}	
}
public class MethodsInInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AndroidPhone ap = new AndroidPhone();
		ap.call(); //Prints Call
		ap.message();
		//Prints Sent if it only implements the interface.else prints Sent from parent.Basedn on the Third rules in java(Class is prioritized before interface)
	}

}
