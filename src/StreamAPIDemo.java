import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
/*
 * Methods Intermediate - filter,Sort and map  - when executed without a terminate method does not do anything
 *         Terminate - findfirst and forEach 
 *         Advantages :
 *                 1) more effiecient programming
 *                 2)heavy use of lambda
 *                 3)ParallelStream make it easy for multi-thread operations
 *                 Stream pipeline consists of source,zero or more intermediate operation,one terminal operation      
 */
public class StreamAPIDemo {

	public static void main(String[] args) {
		
		List<Integer> values = Arrays.asList(4,5,6,7,8);		
		values.forEach(i -> System.out.print(i)); 
		values.stream().forEach(System.out::print); // Stream
		values.parallelStream().forEach(System.out::print); //we want it to use different threads
		System.out.println();
		
		//We can use the Stream only once on a values
		Stream<Integer> s = values.stream();
		s.forEach(System.out::print);
		//s.forEach(System.out::print); 
		/*Executing this line gives in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
		at java.util.stream.AbstractPipeline.sourceStageSpliterator(Unknown Source)
		at java.util.stream.ReferencePipeline$Head.forEach(Unknown Source)
		at StreamAPIDemo.main(StreamAPIDemo.java:21)*/
		
		//filter()
		values.stream().filter(i-> {
				System.out.println(i);
		return true;	
		}).findFirst(); // prints 4 as it the first method
		
		values.stream().filter(i-> {
			System.out.println(i);
	return true;	
	}).findFirst().orElse(0); // incase the list has no numbers then it prints 0. 
		
		
		
		//map()
		//findfirst()
		//forEach()
	}

}
