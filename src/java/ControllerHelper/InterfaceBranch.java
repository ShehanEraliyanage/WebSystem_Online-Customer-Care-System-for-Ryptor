package ControllerHelper;

import Model.Branch;
import java.util.List;

public interface InterfaceBranch {

    public int insertBranch(Branch branch);

    public List<Branch> getAllBranch();

    public Branch selectBranch(int id);

    public int deleteBranch(int id);

    public int updateBranch(Branch branch);

    public String getBranchName(int id);

    public int CountBranch();

}
