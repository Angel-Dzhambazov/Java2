/*
 * P02_ExcelFunctions.java
 *
 * created at 2019-03-08 by a.dzhambazov <YOURMAILADDRESS>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package advanced.exams.y2019_Feb_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.function.LongSupplier;

public class P02_ExcelFunctions
{
	private static List<String[]> input = new ArrayList<>();
	private static String[] header;
	private static String[] command;

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int inputLines = Integer.parseInt(bf.readLine());

		fillInput(inputLines, bf);

		switch (command[0])
		{
		case "hide":
			hideColumnAndPrint();
			break;
		case "sort":
			sortStudentsAndPrint();
			break;
		case "filter":
			filterColumnAndPrint();
			break;
		default:
			break;
		}

	}

	private static void sortStudentsAndPrint()
	{
		printLine(header);
		for (int i = 0; i < header.length; i++)
		{
			if (command[1].equals(header[i]))
			{

				TreeMap<String, String[]> sortedStudentsMap = new TreeMap<>();
				for (String[] student : input)
				{
					sortedStudentsMap.put(student[i], student);
				}
				sortedStudentsMap.forEach((key, value) ->
				{
					printLine(value);
				});
			}
		}
	}

	private static void hideColumnAndPrint()
	{
		for (int i = 0; i < header.length; i++)
		{
			if (header[i].equals(command[1]))
			{
				printLine(header, i);
				for (String[] student : input)
				{
					printLine(student, i);
				}
			}
		}
	}

	private static void filterColumnAndPrint()
	{
		printLine(header);
		for (int i = 0; i < header.length; i++)
		{
			if (command[1].equals(header[i]))
			{
				for (String[] student : input)
				{
					if (student[i].equals(command[2]))
					{
						printLine(student);
					}
				}
			}
		}
	}

	private static void fillInput(int inputLines, BufferedReader bf) throws IOException
	{
		header = bf.readLine().split(", ");
		for (int i = 1; i < inputLines; i++)
		{
			input.add(bf.readLine().split(", "));
		}
		command = bf.readLine().split("\\s+");
	}

	private static void printLine(String[] line)
	{
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < line.length - 1; i++)
		{
			sBuilder.append(line[i] + " | ");
		}
		sBuilder.append(line[line.length - 1]);
		System.out.println(sBuilder.toString());
	}

	private static void printLine(String[] line, int hiddenColumn)
	{
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < line.length - 1; i++)
		{
			if (i != hiddenColumn)
			{
				sBuilder.append(line[i] + " | ");
			}
		}
		sBuilder.append(line[line.length - 1]);
		if (sBuilder.toString().endsWith(" | "))
		{
			sBuilder.toString().substring(0, sBuilder.toString().length() - 2);
		}
		System.out.println(sBuilder.toString());
	}
}
