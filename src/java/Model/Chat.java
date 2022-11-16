/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Rudy
 */
public class Chat {

    private int id;
    private int customer_id;
    private int agent_id;
    private String message;
    private String sent_time;
    private int send_by;

    public Chat() {
    }

    public Chat(int id, int customer_id, int agent_id, String message, int send_by, String sent_time) {
        this.id = id;
        this.customer_id = customer_id;
        this.agent_id = agent_id;
        this.message = message;
        this.send_by = send_by;
        this.sent_time = sent_time;
    }

    public Chat(int customer_id, int agent_id, String message, int send_by) {
        this.id = id;
        this.customer_id = customer_id;
        this.agent_id = agent_id;
        this.message = message;
        this.send_by = send_by;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSend_by(int send_by) {
        this.send_by = send_by;
    }

    public String getSent_time() {
        return sent_time;
    }

    public int getId() {
        return id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public String getMessage() {
        return message;
    }

    public int getSend_by() {
        return send_by;
    }

}
