package com.txzq.fizzbuzz.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.txzq.fizzbuzz.MatcherFactory;
import com.txzq.fizzbuzz.MatcherFactory.MatcherType;
import com.txzq.fizzbuzz.condition.Matcher;

public class MatchTest
{
	
	private Matcher CouldDivisibleBy;
	private Matcher ContainsTheNumber;

	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception
	{
		CouldDivisibleBy = MatcherFactory.getInstance().getMatcher(MatcherType.CouldDivisibleBy, 3, "FIZZ");
		ContainsTheNumber = MatcherFactory.getInstance().getMatcher(MatcherType.ContainsTheNumber, 5, "BUZZ");
	}
	
	@Test
	public void testMatchNullValue() throws IllegalArgumentException
	{
		thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Factor should not null");
        CouldDivisibleBy.match(null);
	}
	
	@Test
	public void testCouldDivisibleBy()
	{
		assertEquals(true, CouldDivisibleBy.match(3));
	}
	
	@Test
	public void testCouldNotDivisibleBy()
	{
		assertEquals(false, CouldDivisibleBy.match(1));
	}
	
	@Test
	public void testContiansTheNumber()
	{
		assertEquals(true, ContainsTheNumber.match(5));
	}
	
	@Test
	public void testNotContiansTheNumber()
	{
		assertEquals(false, ContainsTheNumber.match(1));
	}
	
	
	
	

}
