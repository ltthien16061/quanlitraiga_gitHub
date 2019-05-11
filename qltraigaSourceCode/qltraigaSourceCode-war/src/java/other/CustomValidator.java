package other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Baotiso Laptop
 */
public class CustomValidator {
    
    public void validateString(FacesContext f, UIComponent c, Object obj){
        String s=(String)obj;
        if(s.length()==0)
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Nọi dung không được bỏ trống.",null));        
    } 
    public void validateNum(FacesContext f, UIComponent c, Object obj){
        int s=(int)obj;
        if(s<=0)
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Số lượng gà không hợp lệ",null));        
    }
    public void validateDate(FacesContext f, UIComponent c, Object obj) throws ParseException{
        if(obj==null){
            return;
        }
        Date s=(Date)obj;   
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date olddate = sdf.parse("30/12/1990");
        Date curdate = new Date();
        if(s.before(olddate) || s.after(curdate))
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Ngày Nhập không hợp lệ",null));        
    }
}
