package ControllerHelper;

import Model.Admin;
import Model.UserCredentials;
import java.util.List;

public interface InterfaceAdmin  {
    
    public int validateAdmin(UserCredentials admin);

    public int insertAdmin(Admin admin);

    public List<Admin> getAllAdmin();

    public Admin selectAdmin(int id);

    public Admin getNameAndImageAdmin(int id);

    public int deleteAdmin(int id);

    public int updateAdmin(Admin admin);

    public int updateProfileImageAndData(Admin admin);

    public int updateProfileData(Admin admin);

    public int CountAdmin();

    public int selectChangePasswordAdmin(int id, String curuntPassword);

    public int changePasswordAdmin(int id, String newPassword);

}
