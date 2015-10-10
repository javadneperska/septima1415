package fuska.radovan.p4;

import java.util.ArrayList;

public final class Packer {
	class Node {
		public Node right = null, left = null;
		public Rect rect = null;
		public int id = -1;

		public Node insert(final Nabytok n, final int id) {
			//Children exist
			if(right != null) {
				Node nw = right.insert(n, id);
				if(nw != null)
					return nw;
				return left.insert(n, id);
			}
			//Not empty
			if(this.id != -1)
				return null;
			//No space
			if(!((n.dlzka <= rect.width && n.sirka <= rect.heigth) || (n.dlzka <= rect.heigth && n.sirka <= rect.width)))
				return null;
			//Exact fit
			if((n.dlzka == rect.width && n.sirka == rect.heigth) || (n.dlzka == rect.heigth && n.sirka == rect.width)) {
				this.id = id;
				return this;
			}
			//Split
			right = new Node();
			left = new Node();

			if(rect.width - n.sirka > rect.heigth - n.dlzka) {
				right.rect = new Rect();
				right.rect.left = rect.left;
				right.rect.top = rect.top;
				right.rect.width = n.sirka;
				right.rect.heigth = rect.heigth;

				left.rect = new Rect();
				left.rect.left = rect.left + n.sirka;
				left.rect.top = rect.top;
				left.rect.width = rect.width - n.sirka;
				left.rect.heigth = rect.heigth;
			} else {
				right.rect = new Rect();
				right.rect.left = rect.left;
				right.rect.top = rect.top;
				right.rect.width = rect.width;
				right.rect.heigth = n.dlzka;

				left.rect = new Rect();
				left.rect.left = rect.left;
				left.rect.top = rect.top + n.dlzka;
				left.rect.width = rect.width;
				left.rect.heigth = rect.heigth - n.dlzka;
			}

			return right.insert(n, id);
		}
	}

	class Rect {
		public int top, left;
		public int width, heigth;
	}

	public class Kamion {
		public final Polozka[] nabytok;

		public Kamion(final Polozka[] nabytok) {
			super();
			this.nabytok = nabytok;
		}
	}

	public class Polozka {
		public final int Id, X, Y;

		public Polozka(final int id, final int x, final int y) {
			super();
			Id = id;
			X = x;
			Y = y;
		}
	}

	final Polozka[] GetList(Node n) {
		if(n != null) {

			if(n.id != -1)
				return new Polozka[] { new Polozka(n.id, n.rect.left, n.rect.top) };

			ArrayList<Polozka> al = new ArrayList<Polozka>();
			if(n.right != null)
				for(Polozka p : GetList(n.right))
					al.add(p);
			if(n.left != null)
				for(Polozka p : GetList(n.left))
					al.add(p);
			return al.toArray(new Polozka[0]);
		} else
			return null;
	}

	public Kamion[] pack(final Nabytok[] list, final int width, final int heigth) {
		ArrayList<Kamion> kal = new ArrayList<Kamion>();

		Node n = new Node();
		n.rect = new Rect();
		n.rect.left = 0;
		n.rect.top = 0;
		n.rect.width = width;
		n.rect.heigth = heigth;

		for(int i = 0; i < list.length; i++) {
			if(n.insert(list[i], i) == null) {
				kal.add(new Kamion(GetList(n)));
				n = new Node();
				n.rect = new Rect();
				n.rect.left = 0;
				n.rect.top = 0;
				n.rect.width = width;
				n.rect.heigth = heigth;
				i--;
			}
		}

		kal.add(new Kamion(GetList(n)));

		return kal.toArray(new Kamion[0]);
	}
}
