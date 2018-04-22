package com.txzq.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

import com.txzq.fizzbuzz.condition.Matcher;
import static com.txzq.fizzbuzz.MatcherFactory.MatcherType.CouldDivisibleBy;
import static com.txzq.fizzbuzz.MatcherFactory.MatcherType.ContainsTheNumber;

public class FizzBuzzApp
{
	private FizzBuzzApp()
	{
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

	public String getOutput(List<Matcher> matchers , Integer i)
	{
		
		String output = "";
		for(Matcher m : matchers)
		{
			if (null == m) continue;
			
			if (m.match(i) && !output.contains(m.getOutput()))
			{
				output += m.getOutput();
			}
		}
		
		if (output.isEmpty()) output = i.toString();
		
		return output;
	}
	
	public static void main(String[] args)
	{
		FizzBuzzApp myApp = FizzBuzzApp.getInstance();
		List<Matcher> matchers = new ArrayList<>();
		
		
		matchers.add(null);
		matchers.add(MatcherFactory.getInstance().getMatcher(CouldDivisibleBy, 3, "FIZZ"));
		matchers.add(MatcherFactory.getInstance().getMatcher(CouldDivisibleBy, 5, "BUZZ"));
		matchers.add(MatcherFactory.getInstance().getMatcher(ContainsTheNumber, 3, "FIZZ"));
		matchers.add(MatcherFactory.getInstance().getMatcher(ContainsTheNumber, 5, "BUZZ"));
		
		for(int i = 1 ; i<=100 ; i++)
		{
			System.out.println(myApp.getOutput(matchers, i));
		}
	}

}
