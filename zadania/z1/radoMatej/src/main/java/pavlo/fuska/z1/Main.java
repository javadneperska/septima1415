package pavlo.fuska.z1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		ArrayList<Emploee> emploees;
		File f = new File("text.txt");

		try {
			emploees = FileUtils.ParseFile(f);
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		if(emploees.size() == 0)
			System.out.println("Empty file");
		else {
			HashMap<EmploeeType, HashMap<Subject, Integer>> subjects = new HashMap<>();

			HashMap<Subject, Integer> values;
			int count;
			for(Emploee em : emploees) {
				//System.out.println(em.toString());
				if(subjects.containsKey(em.getType()))
					values = subjects.get(em.getType());
				else
					values = new HashMap<Subject, Integer>();
				for(Subject sb : em.getExtraInfo().getSubjects()) {
					if(values.containsKey(sb))
						count = values.get(sb);
					else
						count = 0;
					values.put(sb, count + 1);
				}
				subjects.put(em.getType(), values);
			}

			for(EmploeeType et : subjects.keySet()) {
				ArrayList<Subject> subjs = new ArrayList<Subject>();
				Subject sub;
				int p;
				for(int n = 0; n < 3; n++) {
					sub = null;
					p = 0;
					for(Subject subj : subjects.get(et).keySet()) {
						if(!subjs.contains(subj) && subjects.get(et).get(subj) > p) {
							sub = subj;
							p = subjects.get(et).get(subj);
						}
					}
					if(sub != null)
						subjs.add(sub);
				}

				System.out.format("%s: %s\n", et.toString(), subjs.toString());
			}
		}
	}
}