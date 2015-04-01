public enum Types {

	PERSONAL, TRUCK;
	
	public static Types fromString(String s) {
		for (Types t : Types.values())
			if (s.compareToIgnoreCase(t.name()) == 0)
				return t;
		return null;
	}

}
