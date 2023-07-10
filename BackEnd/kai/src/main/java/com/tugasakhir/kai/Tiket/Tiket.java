package com.tugasakhir.kai.Tiket;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Tiket")
public class Tiket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tiket;

    @Column(length = 20)
    @NotEmpty(message = "Name is required")
    private String name;
    
    @Column
    @NotEmpty(message = "NIK is required")
    private String nik;

    @Column(length = 20)
    @NotEmpty(message = "No.Hp is required")
    private String no_hp;

    @Column
    @NotEmpty(message = "Alamat is required")
    private String alamat;

    @Column
    @NotEmpty(message = "Email is required")
    private String email;

    @Column
    @NotEmpty(message = "Penumpang Dewasa is required")
    private String pd;

    @Column
    @NotEmpty(message = "Penumpang Bayi is required")
    private String pb;

    @Column
    private Date tgl_pemesanan;

    @Column
    @NotEmpty(message = "Jenis_Kereta is required")
    private String Jenis_Kereta;
    
    @Column
    @NotEmpty(message = "Harga is required")
    private String Harga;

    @Column
    @NotEmpty(message = "Kereta is required")
    private String kereta;

    @Column
    @NotEmpty(message = "Jadwal is required")
    private String jadwal;


    public Tiket() {
    }

    public Tiket(int id_tiket, String name, String nik, String no_hp, String alamat, String email, String pd, String pb, Date tgl_pemesanan, String Jenis_Kereta, String Harga, String kereta, String jadwal) {
        this.id_tiket = id_tiket;
        this.name = name;
        this.nik = nik;
        this.no_hp = no_hp;
        this.alamat = alamat;
        this.email = email;
        this.pd = pd;
        this.pb = pb;
        this.tgl_pemesanan = tgl_pemesanan;
        this.Jenis_Kereta = Jenis_Kereta;
        this.Harga = Harga;
        this.kereta = kereta;
        this.jadwal = jadwal;
    }

    public int getId_tiket() {
        return id_tiket;
    }

    public void setId_tiket(int id_tiket) {
        this.id_tiket = id_tiket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPd() {
        return pd;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }

    public String getPb() {
        return pb;
    }

    public void setPb(String pb) {
        this.pb = pb;
    }

    public Date getTgl_pemesanan() {
        return tgl_pemesanan;
    }

    public void setTgl_pemesanan(Date tgl_pemesanan) {
        this.tgl_pemesanan = tgl_pemesanan;
    }

    public String getJenis_Kereta() {
        return Jenis_Kereta;
    }

    public void setJenis_Kereta(String jenis_Kereta) {
        Jenis_Kereta = jenis_Kereta;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getKereta() {
        return kereta;
    }

    public void setKereta(String kereta) {
        this.kereta = kereta;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }
    
}



