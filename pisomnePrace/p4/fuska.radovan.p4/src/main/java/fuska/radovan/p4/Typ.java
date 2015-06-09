package fuska.radovan.p4;

public enum Typ {
	STOLICKA, SKRINA, POSTEL, REGAL, SUFLIK;

	public static Typ GetType(String input) {
		String lower = input.trim().toLowerCase();
		switch(lower) {
			case "st":
			case "stoli�ka":
				return Typ.STOLICKA;
			case "sk":
			case "skri�a":
				return Typ.SKRINA;
			case "p":
			case "poste�":
				return Typ.POSTEL;
			case "r":
			case "reg�l":
				return Typ.REGAL;
			case "su":
			case "�ufl�k":
				return Typ.SUFLIK;
			default:
				for(Typ t : Typ.values())
					if(lower.equalsIgnoreCase(t.name()))
						return t;
				return null;
		}
	}
}