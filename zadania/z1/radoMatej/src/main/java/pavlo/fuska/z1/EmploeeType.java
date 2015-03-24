package pavlo.fuska.z1;

public enum EmploeeType {
	UCITEL, EXTERNY, PROFESOR, DOCENT, PEDAGOG;

	public static EmploeeType GetType(String type) {
		for(EmploeeType t : EmploeeType.values())
			if(type.equalsIgnoreCase(t.toString()))
				return t;
		return null;
	}
}