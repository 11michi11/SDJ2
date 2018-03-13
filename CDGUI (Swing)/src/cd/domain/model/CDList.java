package cd.domain.model;

import java.util.ArrayList;

public class CDList {
	private ArrayList<CD> cds;

	public CDList() {
		this.cds = new ArrayList<CD>();
	}

	public CD getCD(int index) {
		return cds.get(index);
	}

	public CDList getCdsByTitle(String title) {
		CDList list = new CDList();
		for (int i = 0; i < cds.size(); i++) {
			if (cds.get(i).getTitle().equalsIgnoreCase(title)) {
				list.addCd(cds.get(i));
			}
		}
		return list;
	}

	public int getNumberOfCds() {
		return cds.size();
	}

	public void addCd(CD cd) {
		if (!cds.contains(cd))
			cds.add(cd);
	}

	public void removeCdByIndex(int index) {
		cds.remove(index);
	}

	public CD removeFirstCdByTitle(String title) {
		CD cd = null;
		for (int i = 0; i < cds.size(); i++) {
			if (cds.get(i).getTitle().equalsIgnoreCase(title)) {
				cd = cds.get(i);
				removeCdByIndex(i);
				break;
			}
		}
		return cd;
	}

	public String toString() {
		String all = "";
		for (int i = 0; i < cds.size(); i++) {
			all += "\nCD #" + (i + 1) + "\n" + cds.get(i);
			if (i < cds.size() - 1)
				all += "\n";
		}
		return all;
	}

}
