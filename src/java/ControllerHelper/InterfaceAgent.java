package ControllerHelper;

import Model.Agent;
import Model.UserCredentials;
import java.util.List;

public interface InterfaceAgent {

    public int validateAgent(UserCredentials agent);

    public int insertAgent(Agent agent);

    public List<Agent> getAllAgent();

    public Agent selectAgent(int id);

    public Agent getNameAndImageAgent(int id);

    public int deleteAgent(int id);

    public int updateAgent(Agent agent);

    public int updateProfileImageAndData(Agent agent);

    public int updateProfileData(Agent agent);

    public int CountAgent();

    public int selectChangePasswordAgent(int id, String curuntPassword);

    public int changePasswordAgent(int id, String newPassword);
}
