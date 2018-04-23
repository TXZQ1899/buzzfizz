package com.txzq.fizzbuzz;

import com.txzq.fizzbuzz.condition.Matcher;
import com.txzq.fizzbuzz.condition.impl.ContainsTheNumber;
import com.txzq.fizzbuzz.condition.impl.CouldDivisibleBy;

public class MatcherFactory
{
	public static enum MatcherType
	{
		CouldDivisibleBy,ContainsTheNumber,NotImpl
	}
	
	private MatcherFactory()
	{
	}
	
	private static class factory
	{
		private static final MatcherFactory instance = new MatcherFactory();
	}
	
	public static MatcherFactory getInstance(){
        return factory.instance;
    }
	
	public Matcher getMatcher(MatcherType type, Integer factor, String output)
	{
		switch (type)
		{
		case CouldDivisibleBy:
			return new CouldDivisibleBy(factor, output);
		case ContainsTheNumber:
			return new ContainsTheNumber(factor, output);
		default:
			return null;
		}
	}
}
