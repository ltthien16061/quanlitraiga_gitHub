/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbpack;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Baotiso Laptop
 */
@Named(value = "sessionMB")
@SessionScoped
public class SessionMB implements Serializable {

    /**
     * Creates a new instance of SessionMB
     */
    public SessionMB() {
    }
    
}
