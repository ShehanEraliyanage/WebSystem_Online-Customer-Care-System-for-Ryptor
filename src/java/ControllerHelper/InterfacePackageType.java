package ControllerHelper;

import Model.PackageType;
import java.util.List;

public interface InterfacePackageType {

    public int insertPackageType(PackageType packageType);

    public List<PackageType> getAllPackageType();

    public PackageType selectPackageType(int id);

    public int deletePackageType(int id);

    public int updatePackageType(PackageType packageType);

    public String getPackageTypeName(int id);
}
