
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("111"));
			assertTrue(false);
		}catch(LengthException e){
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("adfe"));
			assertTrue(false);
		}catch(LengthException e){
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Ab4^"));
			assertTrue(false);
		}catch(LengthException e){
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
		
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("aaaaaaaaa"));
			assertTrue(false);
		}catch(NoUpperAlphaException e){
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("a3333349999"));
			assertTrue(false);
		}catch(NoUpperAlphaException e){
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("&&&&%kkkk")); 
			assertTrue(false);
		}catch(NoUpperAlphaException e){
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("111111111A"));
			assertTrue(false);
		}catch(NoLowerAlphaException e){
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("EEEEEEEEEEE"));
			assertTrue(false);
		}catch(NoLowerAlphaException e){
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("RRRRRRRR34%"));
			assertTrue(false);
		}catch(NoLowerAlphaException e){
			assertTrue(true);
		}catch(Exception e){
			assertTrue(false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{ 
			PasswordCheckerUtility.isWeakPassword("593De@");
			assertTrue(false);
		}catch(WeakPasswordException e){
			assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}
		try{ 
			PasswordCheckerUtility.isWeakPassword("A#b2dfe");
			assertTrue(false);
		}catch(WeakPasswordException e){
			assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}
		try{ 
			PasswordCheckerUtility.isWeakPassword("AbC@123");
			assertTrue(false);
		}catch(WeakPasswordException e){
			assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("1@eRFDFDFFFFF"));
		 	assertTrue(false);
		}catch(InvalidSequenceException e){
			assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("FeD#123333"));
		 	assertTrue(false);
		}catch(InvalidSequenceException e){
			assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("Rain#000^"));
		 	assertTrue(false);
		}catch(InvalidSequenceException e){
			assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("aeBe#ff"));
		 	assertTrue(false);
		}catch(NoDigitException e){
			assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("faD#abc"));
		 	assertTrue(false);
		}catch(NoDigitException e){
			assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("FinallyFr&&"));
		 	assertTrue(false);
		}catch(NoDigitException e){
			assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("RainWall#2034"));
		 	assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("Rain%ed24"));
		 	assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("F330od#error"));
		 	assertTrue(true);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		String[] passwordList = {"RainWall#2034", "111","aaaaaaaaa","111111111A","1@eRFDFDFFFFF","aeBe#ff"};
		ArrayList passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(passwordList));
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);
		String curPassword = invalidPasswords.get(0);
		assertTrue(curPassword.contains("111"));
		assertTrue(curPassword.contains("characters"));
		
		curPassword = invalidPasswords.get(1);
		assertTrue(curPassword.contains("aaaaaaaaa"));
		assertTrue(curPassword.contains("uppercase"));
		
		curPassword = invalidPasswords.get(2);
		assertTrue(curPassword.contains("111111111A"));
		assertTrue(curPassword.contains("lowercase"));
		
		curPassword = invalidPasswords.get(3);
		assertTrue(curPassword.contains("1@eRFDFDFFFFF"));
		assertTrue(curPassword.contains("sequence"));
		
		curPassword = invalidPasswords.get(4);
		assertTrue(curPassword.contains("aeBe#ff"));
		assertTrue(curPassword.contains("digit"));
	}
	
}
