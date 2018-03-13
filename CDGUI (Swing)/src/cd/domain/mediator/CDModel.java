package cd.domain.mediator;

import cd.domain.model.CD;
import cd.domain.model.CDList;

public interface CDModel {

	public CDList getAll();
	public void addCd(CD cd);
	public CD removeCd(String title);
	public CD getCD(int index);
	public int getNumberOfCDs();
	public CDList getCdsByTitle(String title);
	
}
