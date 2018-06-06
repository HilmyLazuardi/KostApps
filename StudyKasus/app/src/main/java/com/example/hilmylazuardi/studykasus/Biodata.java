package com.example.hilmylazuardi.studykasus;

/**
 * Created by Hilmy Lazuardi on 6/1/2018.
 */

public class Biodata extends Koneksi {
    private String URL = "http://192.168.43.47/kostapps/simple_api/connect.php";
    String url = "";
    String response = "";

    public String tampilBiodata() {
        try {
            url = URL + "?operasi=view";
            System.out.println("URL Tampil Biodata: " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }

    public String getBiodataById(int id_users) {
        try {
            url = URL + "?operasi=get_biodata_by_id&id=" + id_users;
            System.out.println("URL Insert Biodata : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }

    public String updateBiodata(String id_users, String nama, String alamat, String status) {
        try {
            url = URL + "?operasi=update&id_users=" + id_users + "&nama=" + nama + "&alamat=" + alamat + "&status" + status;
            System.out.println("URL Insert Biodata : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }
}
