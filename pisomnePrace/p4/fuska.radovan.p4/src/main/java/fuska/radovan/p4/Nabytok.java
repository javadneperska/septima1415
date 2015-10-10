package fuska.radovan.p4;

import java.awt.Color;

public class Nabytok {
	public final Color farba;
	public final Typ typ;
	public final Material material;
	public final int vyska, sirka, dlzka;
	public final int cena;

	public Nabytok(Typ typ, Color farba, Material material, int vyska, int sirka, int dlzka, int cena) {
		super();
		this.farba = farba;
		this.typ = typ;
		this.material = material;
		this.vyska = vyska;
		this.sirka = sirka;
		this.dlzka = dlzka;
		this.cena = cena;
	}

	@Override
	public String toString() {
		return "Nabytok [typ=" + typ + ", material=" + material + ", farba=" + farba + ", vyska=" + vyska + ", sirka=" + sirka + ", dlzka=" + dlzka + ", cena=" + cena + "]";
	}
}