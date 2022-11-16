package ControllerHelper;

import Model.Sim;
import java.util.List;

public interface InterfaceSim {

    public int insertSim(Sim sim);

    public List<Sim> getAllSim();

    public Sim selectSim(int id);

    public int deleteSim(int id);

    public int updateSim(Sim sim);

    public int toActive(int id, int status);

    public int toDeactive(int id, int status);

    public List<Sim> getSimByNic(String nic);

    public String getSimNumber(int id);

    public int CountSim();

    public int CountActiveSim();

    public int CountDeactiveSim();

}
