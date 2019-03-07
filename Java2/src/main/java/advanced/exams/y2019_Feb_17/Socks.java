package advanced.exams.y2019_Feb_17;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Socks
{
	private static Deque<Integer> finalPairs = new ArrayDeque<Integer>();
	private static Deque<Integer> firstStack = new ArrayDeque<Integer>();
	private static Deque<Integer> secondStack = new ArrayDeque<Integer>();
	private static Integer largestPair = 0;
	private static Integer firstSock;
	private static Integer secondSock;

	public static void main(String[] args)
	{
		String firstLineString = "10 8 7 13 8 4";
		String secondLineString = "4 7 3 6 4 12";

		fillStack(firstLineString, firstStack);
		fillStack(secondLineString, secondStack);

		while (!firstStack.isEmpty() || !secondStack.isEmpty())
		{
			getSocks(firstStack, secondStack);

			int tempCompare = compareSocks(firstSock, secondSock);
			findSocksPair(tempCompare);
		}

		printResult();
	}

	private static void findSocksPair(int tempCompare)
	{
		switch (tempCompare)
		{
		case 0:
			firstSock++;
			getSecondSock(secondStack);
			findSocksPair(compareSocks(firstSock, secondSock));
			break;
		case 1:
			getFirstSock(firstStack);
			findSocksPair(compareSocks(firstSock, secondSock));
			break;
		case -1:
			Integer tempPair = firstSock + secondSock;
			finalPairs.add(tempPair);
			if (tempPair > largestPair)
			{
				largestPair = tempPair;
			}
			break;
		default:
			break;
		}
	}

	private static void fillStack(String input, Deque<Integer> deque)
	{
		String[] tokensStrings = input.split("\\s+");
		for (int i = 0; i < tokensStrings.length; i++)
		{
			deque.add(Integer.parseInt(tokensStrings[i]));
		}
	}

	private static void printResult()
	{
		System.out.println(largestPair);
		for (Iterator iterator = finalPairs.iterator(); iterator.hasNext();)
		{
			Integer integer = (Integer) iterator.next();
			System.out.print(integer + " ");
		}
	}

	private static int compareSocks(Integer firstSock, Integer secondSock)
	{
		Integer result = secondSock - firstSock;
		if (result == 0)
		{
			return 0;
		} else if (result < 0)
		{
			return 1;
		} else
		{
			return -1;
		}
	}

	private static void getSocks(Deque<Integer> firstStack, Deque<Integer> secondStack)
	{
		try
		{
			firstSock = firstStack.pollLast();
			secondSock = secondStack.pollFirst();
		} catch (NullPointerException e)
		{
			// TODO: handle exception
		}
	}

	private static void getFirstSock(Deque<Integer> firstStack)
	{
		try
		{
			firstSock = firstStack.pollLast();
		} catch (NullPointerException e)
		{
			// TODO: handle exception
		}
	}

	private static void getSecondSock(Deque<Integer> secondStack)
	{
		try
		{
			secondSock = secondStack.pollFirst();
		} catch (NullPointerException e)
		{
			// TODO: handle exception
		}
	}

}
