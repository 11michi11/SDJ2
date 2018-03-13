package cd.domain.mediator;

import java.io.IOException;

import cd.domain.model.CD;
import cd.domain.model.CDList;
import cd.view.CDGUI;
import cd.view.CDView;

public class CDModelManager implements CDModel {

	private CDList list;
	private CDPersistence storage;

	public CDModelManager() {
		try {
			storage = new CdTextFile("src/cds.txt");
			list = storage.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public CDList getAll() {
		return list;
	}

	@Override
	public void addCd(CD cd) {
		list.addCd(cd);
	}

	@Override
	public CD removeCd(String title) {
		return list.removeFirstCdByTitle(title);
	}

	@Override
	public CD getCD(int index) {
		return list.getCD(index);
	}

	@Override
	public int getNumberOfCDs() {
		return list.getNumberOfCds();
	}

	@Override
	public CDList getCdsByTitle(String title) {
		return list.getCdsByTitle(title);
	}
}
