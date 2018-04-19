package com.txzq.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

import com.txzq.fizzbuzz.condition.Matcher;
import com.txzq.fizzbuzz.condition.impl.ContainsTheNumber;
import com.txzq.fizzbuzz.condition.impl.CouldDivisibleBy;

public class FizzBuzzApp
{
	
	private static final Matcher couldDevisibleBy3 = new CouldDivisibleBy(3, "FIZZ");
	private static final Matcher couldDevisibleBy5 = new CouldDivisibleBy(5, "BUZZ");
	private static final Matcher containsTheNumber3 = new ContainsTheNumber(3, "FIZZ");
	private static final Matcher containsTheNumber5 = new ContainsTheNumber(5, "BUZZ");
	
	private List<Matcher> matchers = new ArrayList<>();
	
	private FizzBuzzApp()
	{
		initMatchers();
	}
	
	private void initMatchers()
	{
		matchers.add(couldDevisibleBy3);
		matchers.add(couldDevisibleBy5);
		matchers.add(containsTheNumber3);
		matchers.add(containsTheNumber5);
	}
	
	public List<Matcher> getMatchers()
	{
		return this.getMatchers();
	}
	
	private static class MyApp
	{
		private static final FizzBuzzApp instance = new FizzBuzzApp();
	}
	
	public static FizzBuzzApp getInstance(){
        return MyApp.instance;
    }

	
	
	public String getOutput(Integer i)
	{
		String output = "";
		for(Matcher m : this.matchers)
		{
			if (m.match(i) && !output.contains(m.getOutput()))
			{
				output += m.getOutput();
			}
		}
		
		if (output.isEmpty()) output = i.toString();
		
		return output;
	}

}
