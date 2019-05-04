/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbpack;

import beanpack.NTaiKhoanFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Baotiso Laptop
 */
@Named(value = "accountMB")
@RequestScoped
public class AccountMB {

    @EJB
    private NTaiKhoanFacadeLocal nTaiKhoanFacade;
    
    private String id;
    private String username;
    private String password;

    /**
     * Creates a new instance of AccountMB
     */
    public AccountMB() {
    }
    
    public String login(){
        List<Object[]> listGroups = new ArrayList<Object[]>();
        listGroups = nTaiKhoanFacade.findAccount(username, password);
        if(listGroups.isEmpty()){
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Thông Tin Không Chính Xác!", null);
            FacesContext.getCurrentInstance().addMessage("loginfail", fMsg);
            return "login";
        }else{
            return "index";
        }
    }
    //validate
    public void validateName(FacesContext f, UIComponent c, Object obj){
        String s=(String)obj;
        if(s.length()==0)
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Tên Đăng Nhập Không Được Rỗng!",null));        
    }
    public void validatePass(FacesContext f, UIComponent c, Object obj){
        String s=(String)obj;
        if(s.length()==0)
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mật Khẩu Không Được Rỗng!",null));        
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
