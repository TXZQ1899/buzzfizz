package com.txzq.fizzbuzz.condition.impl;

import java.util.function.Predicate;
import com.txzq.fizzbuzz.condition.Matcher;

public class ContainsTheNumber extends Matcher
{
	
	public ContainsTheNumber() {}
	
	public ContainsTheNumber(Integer factor)
	{
		super(factor);
	}

	@Override
	public void initCondition()
	{
		Predicate<Integer> condition = (number) -> (number.toString().contains(getFactor().toString()));
		super.setCondition(condition);
	}
}
