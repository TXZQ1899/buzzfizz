package com.txzq.fizzbuzz.condition;

import java.util.function.Predicate;

import com.txzq.fizzbuzz.tools.Assert;

public abstract class Matcher implements Condition
{
	
	public Matcher(){}
	
	public Matcher(Integer factor, String output)
	{
		this.factor = factor;
		this.output = output;
		this.initCondition();
	}
	
	public abstract void initCondition();
	
	private String output;
	
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
	public boolean match(Integer factor)
	{
		Assert.notNull(factor, "Factor should not null");
		return condition.test(factor);
	}
	
	public String getOutput()
	{
		return this.output;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((factor == null) ? 0 : factor.hashCode());
		result = prime * result + ((output == null) ? 0 : output.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matcher other = (Matcher) obj;
		if (factor == null)
		{
			if (other.factor != null)
				return false;
		} else if (!factor.equals(other.factor))
			return false;
		if (output == null)
		{
			if (other.output != null)
				return false;
		} else if (!output.equals(other.output))
			return false;
		return true;
	}
	
	
}
