/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author koko
 */
@ManagedBean
@SessionScoped
public class Mahasiswa {


    /**
     * Creates a new instance of Mahasiswa
     */
       
    private String ID_DETAIL;
    private String NAMA;
    private String HARGA;
    private String ID_GENRE;
    private String PUBLISHER;

    public String getID_DETAIL() {
        return ID_DETAIL;
    }

    public void setID_DETAIL(String ID_DETAIL) {
        this.ID_DETAIL = ID_DETAIL;
    }

    public String getNAMA() {
        return NAMA;
    }

    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }

    public String getPUBLISHER() {
        return PUBLISHER;
    }

    public void setPUBLISHER(String PUBLISHER) {
        this.PUBLISHER = PUBLISHER;
    }

    public String getID_GENRE() {
        return ID_GENRE;
    }

    public void setID_GENRE(String ID_GENRE) {
        this.ID_GENRE = ID_GENRE;
    }
   
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 



public String Delete_Mahasiswa(){
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
      String Field_ID_DETAIL = params.get("action");
      try {
         Koneksi obj_koneksi = new Koneksi();
         Connection connection = obj_koneksi.get_connection();
         PreparedStatement ps = connection.prepareStatement("delete from detail where id_detail=?");
         ps.setString(1, Field_ID_DETAIL);
         System.out.println(ps);
         ps.executeUpdate();
        } catch (Exception e) {
         System.out.println(e);
        }
       return "/index.xhtml?faces-redirect=true";   
}

    
public ArrayList getGet_all_mahasiswa() throws Exception{
        ArrayList list_of_mahasiswa=new ArrayList();
             Connection connection=null;
        try {
            Koneksi obj_koneksi = new Koneksi();
            connection = obj_koneksi.get_connection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select * from detail");
            while(rs.next()){
                Mahasiswa obj_Mahasiswa = new Mahasiswa();
                obj_Mahasiswa.setID_DETAIL(rs.getString("id_detail"));
                obj_Mahasiswa.setNAMA(rs.getString("nama"));
                obj_Mahasiswa.setPUBLISHER(rs.getString("publisher"));
                obj_Mahasiswa.setID_GENRE(rs.getString("id_genre"));
                list_of_mahasiswa.add(obj_Mahasiswa);
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            if(connection!=null){
                connection.close();
            }
        }
        return list_of_mahasiswa;
}   

public String Tambah_Mahasiswa(){
        try {
            Connection connection=null;
            Koneksi obj_koneksi = new Koneksi();
            connection = obj_koneksi.get_connection();
            PreparedStatement ps=connection.prepareStatement("insert into detail(id_detail, nama, publisher,id_genre) value('"+ID_DETAIL+"','"+NAMA+"','"+PUBLISHER+"','"+ID_GENRE+"')");
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "/index.xhtml?faces-redirect=true";
    }

    public String Edit_Mahasiswa(){
         FacesContext fc = FacesContext.getCurrentInstance();
         Map<String,String > params = fc.getExternalContext().getRequestParameterMap();
         String Field_ID_DETAIL = params.get("action");
         try {
              Koneksi obj_koneksi = new Koneksi();
              Connection connection = obj_koneksi.get_connection();
              Statement st = connection.createStatement();
              ResultSet rs = st.executeQuery("select * from detail where id_detail="+Field_ID_DETAIL);
              Mahasiswa obj_Mahasiswa = new Mahasiswa();
              rs.next();
              obj_Mahasiswa.setID_DETAIL(rs.getString("id_detail"));
              obj_Mahasiswa.setNAMA(rs.getString("nama"));
              obj_Mahasiswa.setPUBLISHER(rs.getString("publisher"));
              obj_Mahasiswa.setID_GENRE(rs.getString("id_genre"));
              sessionMap.put("EditMahasiswa", obj_Mahasiswa);  
          } catch (Exception e) {
                System.out.println(e);
          }
         return "/Edit.xhtml?faces-redirect=true";   
    }
    
        public String Update_Mahasiswa(){
            FacesContext fc = FacesContext.getCurrentInstance();
            Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
            String Update_ID_DETAIL= params.get("Update_ID_DETAIL");
            try {
                Koneksi obj_koneksi = new Koneksi();
                Connection connection = obj_koneksi.get_connection();
                PreparedStatement ps = connection.prepareStatement("update detail set id_detail=?, nama=?, publisher=?, id_genre=? where id_detail=?");
                ps.setString(1, ID_DETAIL);
                ps.setString(2, NAMA);
                ps.setString(3, PUBLISHER);
                ps.setString(4, ID_GENRE);
                ps.setString(5, Update_ID_DETAIL);
                System.out.println(ps);
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
           return "/index.xhtml?faces-redirect=true";   
    }
    
    public Mahasiswa() {
    }
    
}