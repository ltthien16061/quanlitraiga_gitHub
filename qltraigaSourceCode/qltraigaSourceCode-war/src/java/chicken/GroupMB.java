/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chicken;

import beanpack.GDotNhapGaGiong;
import beanpack.GDotNhapGaGiongFacadeLocal;
import beanpack.GNhomGa;
import beanpack.GNhomGaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Baotiso Laptop
 */
@Named(value = "groupMB")
@SessionScoped
public class GroupMB extends CustomValidator implements Serializable {
    
    @EJB
    private GNhomGaFacadeLocal gNhomGaFacade;

    @EJB
    private GDotNhapGaGiongFacadeLocal gDotNhapGaGiongFacade;
    
    //Parameter for table GNhomGa
    private String groupID;
    private int importID;
    private int num1;
    private int num2;
    private boolean status;
    private Date divideDate;
    private Date update;
    private boolean xoa;

    /**
     * Creates a new instance of GroupMB
     */
    public GroupMB() {
    }
    
    //show all group
    public List<Object[]> showAllGroup() {
        List<Object[]> listGroup = new ArrayList<Object[]>();
        listGroup = gNhomGaFacade.showAllGroup();
        return listGroup;
    }
    //show chicken import for add group
     public List<Object[]> showAllImportForAdd() {
        List<Object[]> listImport = new ArrayList<Object[]>();
        listImport = gDotNhapGaGiongFacade.showChickenImportByDel();
        return listImport;
    }
    //Add group 
     public String addGroup(String codeSP, int remainingNum, int importID){
         //get input value into temp parameter
         int soluongconlai = remainingNum;
         int soluongnhap = num1; 
         //Check input number
         if(soluongnhap < 10 || soluongnhap > 200){
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Số gà trong nhóm không được thấp hơn 10 và cao hơn 200 con!", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "chicken-addgroup";
         }else if(soluongnhap > soluongconlai){
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Số gà trong nhóm không được cao hơn số gà còn lại trong đợt nhập đã chọn!", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "chicken-addgroup";
         }else{
            //String Processing
                //get supplier code
            String code = codeSP;
                //get time
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = new Date();
                //get group ID number
            int groupCount = gNhomGaFacade.countGroupID();
                //set string group ID
            String ID = code + "-" + dateFormat.format(date) + "G" + (groupCount+1);
            System.out.println("groupID: "+ID);   
            //Add Group
            try{
                GNhomGa nhomga = new GNhomGa();
                GDotNhapGaGiong dotnhap = gDotNhapGaGiongFacade.find(importID);                
                nhomga.setManhom(ID);
                nhomga.setMadotnhap(dotnhap);
                nhomga.setSoluongbandau(soluongnhap);
                nhomga.setSoluonghientai(soluongnhap);
                nhomga.setTinhtrang(false);                
                nhomga.setThoigianchianhom(date);
                nhomga.setXoa(false);
                gNhomGaFacade.create(nhomga);
                //Update remaining chicken Number
                dotnhap.setSoluongconlai(dotnhap.getSoluongconlai()-soluongnhap);
                gDotNhapGaGiongFacade.edit(dotnhap);
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
                return "chicken-group";
                }catch(Exception ex){
                ex.printStackTrace();
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm !", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
                return "chicken-addgroup";
            }
        }          
     }
     
    //Delete Group
        //get id for delete
        public void getIdForDel(String id, int ipID){
            groupID = id;
            importID = ipID;
        }
        public String deleteGroup() {
            try{
                num1 = gNhomGaFacade.find(groupID).getSoluongbandau();
                num2 = gNhomGaFacade.find(groupID).getSoluonghientai();
                status = gNhomGaFacade.find(groupID).getTinhtrang();
                divideDate = gNhomGaFacade.find(groupID).getThoigianchianhom();
                xoa = true;
                //Set forgein key
                GDotNhapGaGiong dotnhap = gDotNhapGaGiongFacade.find(importID);
                GNhomGa nhomga = gNhomGaFacade.find(groupID);
                nhomga.setMadotnhap(dotnhap);
                nhomga.setSoluongbandau(num1);
                nhomga.setSoluonghientai(num2);
                nhomga.setTinhtrang(status);
                nhomga.setThoigianchianhom(divideDate);
                nhomga.setXoa(xoa);
                gNhomGaFacade.edit(nhomga);
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Xóa Thành Công", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }catch(Exception ex){
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Xóa", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }        
            return "chicken-group";
        }
    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public int getImportID() {
        return importID;
    }

    public void setImportID(int importID) {
        this.importID = importID;
    }
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDivideDate() {
        return divideDate;
    }

    public void setDivideDate(Date divideDate) {
        this.divideDate = divideDate;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public boolean isXoa() {
        return xoa;
    }

    public void setXoa(boolean xoa) {
        this.xoa = xoa;
    }

}
