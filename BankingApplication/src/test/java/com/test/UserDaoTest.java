package com.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import com.model.User;
import com.service.UserDao;

public class UserDaoTest {
	@Test
	public void testGetUserByName()
	{	
		String name="rssindhu";
		User user=UserDao.getUserByName(name);
		assertEquals("rssindhu",user.getPassword());
		assertEquals("rs@perfios.com",user.getEmail());
		assertEquals(13401.0,user.getAmount());
		System.out.println("Test1 successful");
	}
	@Test
	public void testDontGetUserByName()
	{
		String name="rssindhu";
		User user=UserDao.getUserByName(name);
		assertNotEquals("sindhu",user.getPassword());
		assertNotEquals("r@perfios.com",user.getEmail());
		assertNotEquals(1340.0,user.getAmount());
		System.out.println("Test2 successful");
	}
	@Test
	public void testBalance()
	{
		String name="sindhu";
		double amt=UserDao.balance(name);
		assertEquals(5612.0,amt);
		System.out.println("Test3 successful");
	}
	@Test
	public void testBalance1()
	{
		String name="sindhu";
		double amt=UserDao.balance(name);
		assertNotEquals(561.0,amt);
		System.out.println("Test4 successful");
	}
}
