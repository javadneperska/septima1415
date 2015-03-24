package pavlo.fuska.z1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;

public final class FileUtils {

	public static ArrayList<Emploee> ParseFile(File f) throws IOException {
		ArrayList<Emploee> list = new ArrayList<Emploee>();
		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));

		String line;
		while((line = r.readLine()) != null) {
			try {
				list.add(FileUtils.deserialize(line));
			} catch(ParseException e) {
				System.out.println("Error: Invalid line in database file, skipping");
			}
		}

		r.close();
		return list;
	}

	private static Emploee deserialize(String line) throws ParseException {
		String[] arr = line.split(";");
		if(arr.length < 13)
			throw new ParseException("Not enough parameters", line.length() - 1);

		Address address = new Address(Integer.parseInt(arr[5]), arr[4], arr[6], arr[7]);
		ExtraInfo extraInfo = new ExtraInfo(ParseSubjects(arr[11]), Integer.parseInt(arr[9]), Integer.parseInt(arr[10]), Integer.parseInt(arr[12]));
		return new Emploee(arr[0], arr[1], arr[2], !arr[3].toLowerCase().startsWith("m"), address, EmploeeType.GetType(arr[8]), extraInfo);
	}

	private static Subject[] ParseSubjects(String input) {
		String[] arr = input.split(",");
		ArrayList<Subject> list = new ArrayList<Subject>();
		Subject sb;
		for(String s : arr) {
			sb = Subject.Get(s);
			if(!list.contains(sb))
				list.add(sb);
		}
		return (Subject[])list.toArray(new Subject[0]);
	}
}