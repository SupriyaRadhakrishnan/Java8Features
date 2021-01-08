import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Methods Intermediate - anymatch,distinct,skip,sorted,findfirst,filter,flatmap and map  - when executed without a terminate method does not do anything
 *         Terminate - forEach -applies some function to each element
 *                     collect - saves elements into a collection
 *                     others reduce the stream to a single summary element.Eg : count,max,min,reduce and summary statistics
 *  Stream pipeline consists of source,zero or more intermediate operation,one terminal operation   
 *   Source - Collections,arrays,lines of file.
 * 
 */
public class StreamFunctionsDemo {

	public static void main(String[] args) throws IOException {
		// Integer Stream 
		         IntStream.range(1,10).forEach(System.out::print);
		         System.out.println();//123456789
		
		//Integer Stream with skip
		         IntStream.range(1,10).skip(5).forEach(x->System.out.print(x));
		         System.out.println();//6789
		
		//Integer Stream with sum
		         System.out.println(IntStream.range(1,5).sum());//10
		
		//Stream.of,sorted and findfirst
		         Stream.of("Ava","Aneri","Alberto").sorted().findFirst().ifPresent(System.out::println);//Alberto
		
		//Stream from an array ,sort,filter and print
		         String names[] = {"Al","Kushal","Brent","Sarika","amanda","Shivika","Hans","Sarah"};
		         Arrays.stream(names). //or Stream.of(names)
           		 filter(x->x.startsWith("S")).
		         sorted().
		         forEach(System.out::println);//Sarah,Sarika,Shivika
		
		//Average of squares of int array
		         Arrays.stream(new int[] {2,4,6,8,10}).map(x->x*x).average().ifPresent(System.out::println); //44.0
		
		//Stream from a List,filter and print 
		         List<String> people = Arrays.asList("Al","Kushal","Brent","Sarika","amanda","Shivika","Hans","Sarah");
		         people.stream().map(String::toLowerCase).filter(x->x.startsWith("a")).forEach(System.out::println);//amanda
		
		//Stream rows from text file sort ,filter and print
		         Stream<String> bands = Files.lines(Paths.get("src/bands.txt"));
		         bands.sorted().filter(x->x.length()>13).forEach(System.out::println);//BackStreet Boys
		         bands.close();
		
		//Stream rows from text file and save to list
				List<String> bands2 = Files.lines(Paths.get("src/bands.txt")).sorted().filter(x->x.contains("e")).collect(Collectors.toList());
				bands2.forEach(System.out::println);//Adele,BackStreet Boys
				
		//Stream rows from csv files and count
				Stream<String> rows1 = Files.lines(Paths.get("src/data.txt"));
				int rowcount = (int)rows1.map(x->x.split(",")).filter(x->x.length == 3).count();
				System.out.println("row count: " + rowcount);// return 5 excluding E.
				rows1.close();
				
	   //Stream rows from csv files and parse data from the rows
				Stream<String> rows2 = Files.lines(Paths.get("src/data.txt"));
				rows2.map(x->x.split(",")).filter(x->x.length == 3).
				filter(x->Integer.parseInt(x[1]) > 15)
				.forEach(x->System.out.println(x[0]+" "+x[1]+" "+x[2]));
				/*B 17 2.8
				  D 23 2.7
				  F 18 3.4*/
				rows1.close();
				
		//Stream rows from csv files and store fields in map
				Stream<String> rows3 = Files.lines(Paths.get("src/data.txt"));
				Map<String,Integer> map = new HashMap<String,Integer>();
				map = rows3
						    .map(x->x.split(","))
					       .filter(x->x.length == 3)
				           .filter(x->Integer.parseInt(x[1]) > 15)
				           .collect(Collectors.toMap(x->x[0],x->Integer.parseInt(x[1])));
				rows3.close();
				for(String key :map.keySet())
				{
					System.out.println(key +" " +map.get(key));
					/*Only key and value in map
					  B 17 
					  D 23 
					  F 18 */
				}
				
		//Reduction - sum. existing sum() works only for integers.for double we use reduce
				double total = Stream.of(7.3,1.5,4.8).reduce(0.0,(Double a ,Double b)->(a+b));
				//0.0 is the start and Double a saves the running total and Double b is the current number
						System.out.println(total);//13.600000000000001

        //Reduction - summary statistics - works only for int
			    IntSummaryStatistics summary = IntStream.of(7,2,19,88,73,4,10).summaryStatistics();
			    System.out.println(summary);//IntSummaryStatistics{count=7, sum=203, min=2, average=29.000000, max=88}
							
		
	}

}
