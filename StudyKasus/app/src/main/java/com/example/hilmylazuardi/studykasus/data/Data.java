package com.example.hilmylazuardi.studykasus.data;

/**
 * Created by Hilmy Lazuardi on 5/27/2018.
 */

public class Data {
    private String id_users, nama, alamat, status;

    public Data(){}
    public Data(String id_users, String nama, String alamat, String status){
        this.id_users=id_users;
        this.nama=nama;
        this.alamat=alamat;
        this.status=status;
    }
    public String getId_users(){
        return id_users;
    }
    public void setId_users(String id_users){
        this.id_users = id_users;
    }
    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getAlamat(){
        return alamat;
    }
    public void setAlamat(String alamat){ this.alamat = alamat; }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}
