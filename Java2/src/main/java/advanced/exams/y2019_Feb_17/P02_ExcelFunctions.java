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

			break;
		case "sort":

			break;
		case "filter":

			break;
		default:
			break;
		}

	}

	private static void fillInput(int inputLines, BufferedReader bf) throws IOException
	{
		header = bf.readLine().split(", ");
		for (int i = 1; i < inputLines - 1; i++)
		{
			input.add(bf.readLine().split(", "));
		}
		command = bf.readLine().split("\\s+");
	}
}