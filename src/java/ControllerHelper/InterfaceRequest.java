package ControllerHelper;

import Model.Request;
import java.util.List;

public interface InterfaceRequest {

    public int insertRequest(Request request);

    public List<Request> getAllRequestByEmployeeType(int id, String type);

    public List<Request> getAllRequestByCustomer(int customer_id);

    public int toConfirmRequest(int id);

    public int toRejectRequest(int id);

    public int fowardRequest(int id, int userID, String type);

}
