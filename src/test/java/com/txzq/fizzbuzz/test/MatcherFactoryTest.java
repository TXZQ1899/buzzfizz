package com.txzq.fizzbuzz.test;

import static com.txzq.fizzbuzz.MatcherFactory.MatcherType.ContainsTheNumber;
import static com.txzq.fizzbuzz.MatcherFactory.MatcherType.CouldDivisibleBy;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.txzq.fizzbuzz.MatcherFactory;
import com.txzq.fizzbuzz.MatcherFactory.MatcherType;
import com.txzq.fizzbuzz.condition.Matcher;
import com.txzq.fizzbuzz.condition.impl.ContainsTheNumber;
import com.txzq.fizzbuzz.condition.impl.CouldDivisibleBy;

public class MatcherFactoryTest
{
	
	private MatcherFactory factory;

	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception
	{
		factory = MatcherFactory.getInstance();
	}
	
	@Test
	public void testGetCouldDivisibleMatcher()
	{
		Matcher actual = factory.getMatcher(CouldDivisibleBy, 3, "FIZZ");
		Matcher expected = new CouldDivisibleBy(3, "FIZZ");
		
		assertEquals(expected.getClass(), actual.getClass());
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetContainsTheNumberMatcher()
	{
		Matcher actual = factory.getMatcher(ContainsTheNumber, 5, "BUZZ");
		Matcher expected = new ContainsTheNumber(5, "BUZZ");
		
		assertEquals(expected.getClass(), actual.getClass());
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMatcherReturnsNull()
	{
		Matcher actual = factory.getMatcher(MatcherType.NotImpl, 5, "BUZZ");
		Matcher expected = null;
		
		assertEquals(expected, actual);
	}
	
	

}
