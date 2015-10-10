package fuska.radovan.p4;

public enum Typ {
	STOLICKA, SKRINA, POSTEL, REGAL, SUFLIK;

	public static Typ GetType(String input) {
		String lower = input.trim().toLowerCase();
		switch(lower) {
			case "st":
			case "stolièka":
				return Typ.STOLICKA;
			case "sk":
			case "skriòa":
				return Typ.SKRINA;
			case "p":
			case "poste¾":
				return Typ.POSTEL;
			case "r":
			case "regál":
				return Typ.REGAL;
			case "su":
			case "šuflík":
				return Typ.SUFLIK;
			default:
				for(Typ t : Typ.values())
					if(lower.equalsIgnoreCase(t.name()))
						return t;
				return null;
		}
	}
}