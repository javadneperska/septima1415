package pitko.molnar.z1;

public class Utilities {
	public final static Type getType(final String input) {
		String temp = input.trim().toLowerCase();
		switch (temp) {
		case "profesor":
			return Type.PROFESOR;
		case "docent":
			return Type.DOCENT;
		case "teacher":
			return Type.TEACHER;
		case "external":
			return Type.EXTERNAL;
		case "peadagogue":
			return Type.PEDAGOGUE;

		default:
			for (Type k : Type.values())
				if (temp.equalsIgnoreCase(k.name()))
					return k;
			return null;
		}
	}

}
