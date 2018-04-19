package com.txzq.fizzbuzz.condition;

import java.util.function.Predicate;

public abstract class Matcher implements Condition
{
	
	public Matcher(){}
	
	public Matcher(Integer factor)
	{
		this.factor = factor;
	}
	
	public abstract void initCondition();
	
	private Predicate<Integer> condition;
	
	private Integer factor;

	public Integer getFactor()
	{
		return factor;
	}

	public void setFactor(Integer factor)
	{
		this.factor = factor;
	}

	public void setCondition(Predicate<Integer> condition)
	{
		this.condition = condition;
	}
	
	@Override
	public boolean match(Integer number)
	{
		return condition.test(number);
	}
}
