package com.tugasakhir.kai.Jadwal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Jadwal")
public class Jadwal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    @NotEmpty(message = "Asal Kereta is required")
    private String asal_kereta;

    @Column
    @NotEmpty(message = "Tujuan Kereta is required")
    private String tujuan_kereta;

    @Column
    @NotEmpty(message = "Jam Berangkat is required")
    private String jam_berangkat;

    public Jadwal() {
    }

    public Jadwal(int id, String jenis_kereta, String asal_kereta, String tujuan_kereta, String jam_berangkat) {
        this.id = id;
        this.asal_kereta = asal_kereta;
        this.tujuan_kereta = tujuan_kereta;
        this.jam_berangkat = jam_berangkat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsal_kereta() {
        return asal_kereta;
    }

    public void setAsal_kereta(String asal_kereta) {
        this.asal_kereta = asal_kereta;
    }

    public String getTujuan_kereta() {
        return tujuan_kereta;
    }

    public void setTujuan_kereta(String tujuan_kereta) {
        this.tujuan_kereta = tujuan_kereta;
    }

    public String getJam_berangkat() {
        return jam_berangkat;
    }

    public void setJam_berangkat(String jam_berangkat) {
        this.jam_berangkat = jam_berangkat;
    }

    
}



