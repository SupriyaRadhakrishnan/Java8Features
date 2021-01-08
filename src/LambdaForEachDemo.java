import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer; // This is imported for Consumer interface.

/*
 * Notes : we can use lambda expression for all the functional interfaces.
 * Consumer interface has the @FunctionalInterface before it is declared.
 * 
 * 
 */

//class ConsImpl implements Consumer<Integer>
//{
//
//	@Override
//	public void accept(Integer i) {
//		System.out.println(i);		
//	}
//	
//}
public class LambdaForEachDemo {
	
	public static void main(String[] args) {
		
 
		List<Integer> values = Arrays.asList(4,5,6,7,8);
			
		//Anonymous Class creation
		/*Consumer<Integer> c = new Consumer<Integer>() {
			public void accept(Integer i) {
				System.out.println(i);		
			}
		};
		values.forEach(c);*/
		// values.forEach(c); we call forEach for each of the value in values and it takes the integer to the accept method in the interface and it prints.
		
		
		/*Consumer<Integer> c = (Integer i) ->System.out.println(i);
		 * or
		 * Consumer<Integer> c = (i) ->System.out.println(i);
		 * or
		 * Consumer<Integer> c = i ->System.out.println(i);
		 * values.forEach(c) - simply we can have c replaced with the RHS value in the above line. 
		 */
		
		
		values.forEach(i -> System.out.print(i)); // lambda here implements the Consumer interface.
		
		
		
		/*indexed and External loop
		for(int i=0;i<values.size();i++)
		{
			System.out.print(values.get(i));
		}
		System.out.println();
		//External loop
		for(int i :values)
		{
			System.out.print(i);
		}
		
		System.out.println();*/
	}

}
