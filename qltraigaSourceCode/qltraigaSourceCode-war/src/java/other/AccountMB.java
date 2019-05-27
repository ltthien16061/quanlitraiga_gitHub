/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import beanpack.NTaiKhoan;
import beanpack.NTaiKhoanFacadeLocal;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Baotiso Laptop
 */
@Named(value = "accountMB")
@SessionScoped
public class AccountMB implements Serializable {

    @EJB
    private NTaiKhoanFacadeLocal nTaiKhoanFacade;

    private int id;
    private String username;
    private String password;

    private NTaiKhoan account;

    /**
     * Creates a new instance of AccountMB
     */
    public AccountMB() {
    }

    public List<NTaiKhoan> showAllAccount() {
        List<NTaiKhoan> listAccount = new ArrayList<NTaiKhoan>();
        listAccount = nTaiKhoanFacade.findAll();
        return listAccount;
    }

    public String login() throws NoSuchAlgorithmException {

        //Create md5 pass
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }

        List<NTaiKhoan> listAccount = nTaiKhoanFacade.findAll().stream().filter((acc) -> {
            return acc.getTentk().equals(username) && acc.getMatkhau().equals(sb.toString());
        }).collect(Collectors.toList());
        
        if (listAccount.isEmpty()) {
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Thông Tin Không Chính Xác!", null);
            FacesContext.getCurrentInstance().addMessage("loginfail", fMsg);
            return "login";
        } else {
            //Tạo session
            account = listAccount.get(0);
            return "index";
        }
    }

    public boolean isLoggedIn() {
        return account != null;
    }

    public String logout() {
        account = null;
        return "/";
    }

    //Add
    public String addAccount() {
        try {
            NTaiKhoan taikhoan = new NTaiKhoan();
            taikhoan.setTentk(username);
            //Create md5 pass
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }

            taikhoan.setMatkhau(sb.toString());
            nTaiKhoanFacade.create(taikhoan);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "account";
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm (Có thể tài khoản đã tồn tại!)", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "account-add";
        }
    }

    //Delete 
    public void getIdForDel(int accID) {
        id = accID;
        System.out.println("Account ID :" + id);
    }

    public String deleteAcc() {
        try {
            NTaiKhoan taikhoan = nTaiKhoanFacade.find(id);
            nTaiKhoanFacade.remove(taikhoan);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Xóa Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        } catch (Exception ex) {
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Xóa", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        }
        return "account";
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
