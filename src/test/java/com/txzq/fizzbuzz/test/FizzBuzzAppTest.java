package com.txzq.fizzbuzz.test;

import static com.txzq.fizzbuzz.MatcherFactory.MatcherType.CouldDivisibleBy;
import static com.txzq.fizzbuzz.MatcherFactory.MatcherType.ContainsTheNumber;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.txzq.fizzbuzz.FizzBuzzApp;
import com.txzq.fizzbuzz.MatcherFactory;
import com.txzq.fizzbuzz.condition.Matcher;

public class FizzBuzzAppTest
{
	
	private FizzBuzzApp fizzBuzz;
	
	private final static String FIZZ = "FIZZ";
	
	private final static String BUZZ = "BUZZ";
	
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception
	{
		fizzBuzz = FizzBuzzApp.getInstance();
	}
	
	@Test
	public void testCouldDivisibleBy3()
	{
		List<Matcher> matchers = initCouldDivisibleByMatcher();
		assertEquals(FIZZ, fizzBuzz.getOutput(matchers, 6));
	}
	
	@Test
	public void testCouldDivisibleBy5()
	{
		List<Matcher> matchers = initCouldDivisibleByMatcher();
		assertEquals(BUZZ, fizzBuzz.getOutput(matchers, 10));
	}
	
	@Test
	public void testCouldNotDivisibleBy3OR5()
	{
		List<Matcher> matchers = initCouldDivisibleByMatcher();
		assertEquals("1", fizzBuzz.getOutput(matchers, 1));
	}
	
	@Test
	public void testCouldDivisibleByBoth3And5()
	{
		List<Matcher> matchers = initCouldDivisibleByMatcher();
		assertEquals(FIZZ+BUZZ, fizzBuzz.getOutput(matchers, 15));
	}
	
	@Test
	public void testContainsBoth3And5()
	{
		List<Matcher> matchers = initContainsNumberMatcher();
		assertEquals(FIZZ+BUZZ, fizzBuzz.getOutput(matchers, 35));
	}
	
	@Test
	public void testNotContainsBoth3And5()
	{
		List<Matcher> matchers = initContainsNumberMatcher();
		assertEquals("1", fizzBuzz.getOutput(matchers, 1));
	}
	
	@Test
	public void testContainsTheNumber3()
	{
		List<Matcher> matchers = initContainsNumberMatcher();
		assertEquals(FIZZ, fizzBuzz.getOutput(matchers, 13));
	}
	
	@Test
	public void testContainsTheNumber5()
	{
		List<Matcher> matchers = initContainsNumberMatcher();
		assertEquals(BUZZ, fizzBuzz.getOutput(matchers, 55));
	}
	
	private List<Matcher> initCouldDivisibleByMatcher()
	{
		List<Matcher> matchers = new ArrayList<>();
		
		matchers.add(MatcherFactory.getInstance().getMatcher(CouldDivisibleBy, 3, "FIZZ"));
		matchers.add(MatcherFactory.getInstance().getMatcher(CouldDivisibleBy, 5, "BUZZ"));
		return matchers;
	}
	
	private List<Matcher> initContainsNumberMatcher()
	{
		List<Matcher> matchers = new ArrayList<>();
		
		matchers.add(MatcherFactory.getInstance().getMatcher(ContainsTheNumber, 3, "FIZZ"));
		matchers.add(MatcherFactory.getInstance().getMatcher(ContainsTheNumber, 5, "BUZZ"));
		return matchers;
	}

}
