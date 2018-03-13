package cd.domain.mediator;
import java.io.IOException;

import cd.domain.model.CD;
import cd.domain.model.CDList;

public interface CDPersistence
{
   public CDList load() throws IOException;
   public void save(CDList cdList) throws IOException;
   public void save(CD cd) throws IOException;
   public void remove(CD cd) throws IOException;
   public void clear() throws IOException;
}
