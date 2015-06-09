package fuska.radovan.p4;

public enum Material {
	DREVO, DREVOTRIESKA, INE;

	public static Material GetType(String input) {
		String lower = input.trim().toLowerCase();
		switch (lower) {
		case "iné":
			return Material.INE;
		default:
			for (Material t : Material.values())
				if (lower.equalsIgnoreCase(t.name()))
					return t;
			return null;
		}
	}
}