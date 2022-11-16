package ControllerHelper;

import Model.ServicesType;
import java.util.List;

public interface InterfaceServicesType {

    public int insertServicesType(ServicesType servicesType);

    public List<ServicesType> getAllServicesType();

    public ServicesType selectServicesType(int id);

    public int deleteServicesType(int id);

    public int updateServicesType(ServicesType servicesType);

    public String getServicesTypeName(int id);

}
