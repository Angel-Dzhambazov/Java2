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
				String sortBy = header[i];
			}
		}
	}

	private static void hideColumnAndPrint()
	{
		printLine(header);
		for (String[] student : input)
		{
			if (!student[0].equals(command[1]))
			{
				printLine(student);
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
}
