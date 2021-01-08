
/*
 * Note while compilation a class file is created for each class and the interfaces.
 * In the below case we get three classes created during the compilation(one for interface A, one for LambdaDemo class and one for the inner class.
 * To prevent it from creating a class file during compilation for the inner class we can use the lambda expression. 
 */
interface A
{
	 void show(); //if it has a parameter...void show(int i)	
}
//This class is just used to implement the methods in the interface.
//class Xyz implements A
//{
//
//	@Override
//	public void show() {  in case it has a parameter -- public void show(int i)
//		System.out.println("Hello");   in case it has a parameter -- System.out.println("Hello" + i);
//	}
//	
//}
/*
 * This can be achieved 3 ways, 1)with a class implementing the interface.
 * 2)remove the class and directly define the method in the interface here.
 * 3) remove the method name and just give the implementation using the ->(lambda expression). 
 */
public class LambdaDemo {
	
	public static void main(String args[])
	{
		A Obj;
		/*Step :1
		Obj = new Xyz();Obj.show();*/
	   /* Step :2
		Obj = new A() // This is an anonymous inner class
				{
			public void show() in case it has a parameter -- public void show(int i)
			{
				System.out.println("Hello");  in case it has a parameter -- System.out.println("Hello" + i);
			}
				};*/
		//Step :3
		Obj = () ->   //in case it has a parameter -- show(int i)
			{
				System.out.println("Hello");  //in case it has a parameter -- System.out.println("Hello" + i);
			}	;
			//or since it has only one line
		Obj = () ->	System.out.println("Hello"); // we can also have it as (i) without the datatype
		//incase of only one parameter we can put it as Obj = i ->	System.out.println("Hello"); 
		
		Obj.show();  //in case it has a parameter -- Obj.show(6),
	}
}
