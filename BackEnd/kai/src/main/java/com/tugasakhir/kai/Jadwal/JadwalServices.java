package com.tugasakhir.kai.Jadwal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class JadwalServices {
    
    @Autowired
    private JadwalRepo jadwalRepo;

    public Jadwal save(Jadwal jadwal){
        return jadwalRepo.save(jadwal); //insert & update Query
    }

    public Iterable<Jadwal> findAll(){
        return jadwalRepo.findAll(); //select * from jadwal
    }

    public Jadwal findOne(int id){
        return jadwalRepo.findById(id).get();
        //select * from jadwal where id =1
    }

    public void removeOne(int id){
        jadwalRepo.deleteById(id);
    }
    
    public Iterable<Jadwal> findByJadwal(String asal_kereta){
    return jadwalRepo.findJadwalByName(asal_kereta);
  }
}



