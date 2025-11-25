package utility;

import com.github.javafaker.Faker;

public class RandomDataUtility {
Faker f=new Faker();// object creation for Faker class
public String randomUserName()
{
	return f.name().username();
			
}
public String randomPassword()
{
	return f.internet().password();
}
public String randomFullName()
{
	return f.name().fullName();
}
public String randomEmailId()
{
	return f.internet().emailAddress();
}
}
