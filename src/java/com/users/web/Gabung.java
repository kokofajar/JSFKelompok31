/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users.web;


import java.sql.Connection;
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
public class Gabung {

    /**
     * Creates a new instance of View
     */
    private String ID_DETAIL;
    public void setID_DETAIL(String ID_DETAIL) {
        this.ID_DETAIL = ID_DETAIL;
    }
    public String getID_DETAIL() {
        return ID_DETAIL;
    }
    private String NAMA;
    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }
    public String getNAMA() {
        return NAMA;
    }
    private String PUBLISHER;
    public void setPUBLISHER(String PUBLISHER) {
        this.PUBLISHER = PUBLISHER;
    }
    public String getPUBLISHER() {
        return PUBLISHER;
    }
    
    private String KATEGORI;
    public void setKATEGORI(String KATEGORI) {
        this.KATEGORI = KATEGORI;
    }
    public String getKATEGORI() {
        return KATEGORI;
    }
    
    private String KETERANGAN;
    public void setKETERANGAN(String KETERANGAN) {
        this.KETERANGAN = KETERANGAN;
    }
    public String getKETERANGAN() {
        return KETERANGAN;
    }
     
        private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 

    public ArrayList getGet_all_gabung() throws Exception{
        ArrayList list_of_gabung=new ArrayList();
             Connection connection=null;
        try {
            Koneksi obj_koneksi = new Koneksi();
            connection = obj_koneksi.get_connection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select * from gabung");
            while(rs.next()){
                Gabung obj_Mahasiswa = new Gabung();
                obj_Mahasiswa.setID_DETAIL(rs.getString("id_detail"));
                obj_Mahasiswa.setNAMA(rs.getString("nama"));
                obj_Mahasiswa.setPUBLISHER(rs.getString("publisher"));
                obj_Mahasiswa.setKATEGORI(rs.getString("kategori"));
                obj_Mahasiswa.setKETERANGAN(rs.getString("keterangan"));
                list_of_gabung.add(obj_Mahasiswa);
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            if(connection!=null){
                connection.close();
            }
        }
        return list_of_gabung;
}    
    public Gabung() {
    }
    
}
