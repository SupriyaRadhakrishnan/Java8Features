import java.util.*;

/*Call by Method,instead of call by value of reference.
 * 
 */


interface Parser
{
	String parse(String s);
}

class StringParser
{
	public static String convert(String str)
	{
		if(str.length()<=3)
			str = str.toUpperCase();
		else
		str = str.toLowerCase();
		
		return str;
	}
	public String justPrint(String str)
	{
		return str;
	}
}

class MyPrinter
{
	
	public void print(String str,Parser p)
	{
		str = p.parse(str);
		System.out.println(str);
	}
}

public class MethodReferenceDemo {

	public static void main(String[] args) {
               /*********Inbuilt sample of CALL BY METHOD**********/
		List<String> names = Arrays.asList("Supi", "Pjay", "Mahi", "Abhi");

		
		names.forEach(s -> System.out.println(s));
		   //or
		names.forEach(System.out::println);//Call by method println. passing a method as a parameter
		
		 /*********Implementing sample of CALL BY METHOD for interface and method we have**********/
		String str = "Supriya";
		MyPrinter mp = new MyPrinter();
		mp.print(str,new Parser()
				{
			public String parse(String s)
			{
				return StringParser.convert(s);
			}
				});
		//or
		mp.print(str,s->StringParser.convert(s)); //simplified lambda call
		//or
		mp.print(str,(StringParser::convert)); //CALL BY METHOD , this works because the convert method is static
		//for non static methods .We need to create a object and invoke the method.
		StringParser sp = new StringParser();
		mp.print(str,sp::justPrint); 
	}

}
