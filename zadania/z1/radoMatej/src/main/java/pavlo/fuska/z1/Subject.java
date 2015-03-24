package pavlo.fuska.z1;

public enum Subject {
	MATH, PHYSICS, BIOLOGY, CHEMISTRY, GEOGRAPHY;

	public static Subject Get(String s) {
		switch(s) {
			case "MAT":
				return Subject.MATH;
			case "FYZ":
				return Subject.PHYSICS;
			case "BIO":
				return Subject.BIOLOGY;
			case "CHE":
				return Subject.CHEMISTRY;
			case "GEO":
				return Subject.GEOGRAPHY;
			default:
				for(Subject t : Subject.values())
					if(s.equalsIgnoreCase(t.toString()))
						return t;
				break;
		}
		return null;
	}
}