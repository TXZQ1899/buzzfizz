package com.txzq.fizzbuzz.condition.impl;

import java.util.function.Predicate;
import com.txzq.fizzbuzz.condition.Matcher;

public class CouldDivisibleBy extends Matcher 
{
	
	public CouldDivisibleBy() {}
	
	public CouldDivisibleBy(Integer factor, String output)
	{
		super(factor, output);
	}

	@Override
	public void initCondition()
	{
		Predicate<Integer> condition = (number) -> (number % getFactor() == 0);
		super.setCondition(condition);
	}
}
