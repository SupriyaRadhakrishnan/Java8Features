
/*
 * Interfaces which have just one abstract method.
 * We already had this kind of interface before java 8 .example Runnable has only run() and Comparator has only compare() in its interface.
 * We use @FunctionalInterface annotation
 * Rules : Annotate and must have only one abstract method
 * Usage - > helps the lambda expressions to understand which method to pick.in case we have more than one method,it fails
 * Exception -> if the interface has a method with signature same to the one in Object then it is allowed along with another abstract method
 */

/*
 * Interview Questions: 
 * Can I have more than one abstract method in functional interface - No
 * Can the interface have methods of default and static type - Yes.
 * Comparator has compare and equals?How ? Equals has same signature of that in Object class so it is not considered.
 *  
 */
@FunctionalInterface
interface InterestCalculator
{
	float calculateInterestAmount(float amount,float interestRate);
}

class Account
{
	private InterestCalculator ic;

	public InterestCalculator getIc() {
		return ic;
	}

	public void setIc(InterestCalculator ic) {
		this.ic = ic;
	}

}

public class FunctionalInterfaceDemo {
	
	public static void main(String args[])
	{
		float amount = 20000f;
		float interestRate = 5f;
		Account account = 	new Account();
		/*account.setIc(new InterestCalculator() {
			
			@Override
			public float calculateInterestAmount(float amount, float interestRate) {
				// TODO Auto-generated method stub
				return amount*interestRate;
			}
		});*/
		//or we can do it in single line by aoiding the Anonymous class
		account.setIc((amt,intRate) -> amt*intRate);//calculateInterestAmount method is implemented here.
       
		System.out.println(account.getIc().calculateInterestAmount(amount, interestRate));
	}
}



