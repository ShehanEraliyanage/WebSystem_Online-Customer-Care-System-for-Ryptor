package ControllerHelper;

import Model.Services;
import java.util.List;

public interface InterfaceServices {

    public int insertServices(Services services);

    public List<Services> getAllServices();

    public Services selectServices(int id);

    public int deleteServices(int id);

    public int updateServices(Services services);

}
