package ControllerHelper;

import Model.Packages;
import java.util.List;

public interface InterfacePackage {

    public int insertPackage(Packages packages);

    public List<Packages> getAllPackage();

    public Packages selectPackage(int id);

    public int deletePackage(int id);

    public int updatePackage(Packages packages);

    public List<Packages> getAllSimPackage(int simID);

    public int simPackageActive(int simID, int packageID);

    public int simPackageDeactive(int simID, int packageID);

    public int CountPackage();
    
    public int updateRentalPackage(int simID,int packageID);
    
    List<Packages> getAllPackageByType(int type);
}
