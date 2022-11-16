package ControllerHelper;

import Model.FAQ;
import java.util.List;

public interface InterfaceFaq {

    public int insertFAQ(FAQ faq);

    public List<FAQ> getAllFAQ();

    public FAQ selectFAQ(int id);

    public int deleteFAQ(int id);

    public int updateFAQ(FAQ faq);
}
