package com.tugasakhir.kai.Tiket;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class TiketServices {
    
    @Autowired
    private TiketRepo tiketRepo;

    public Tiket save(Tiket tiket){
        return tiketRepo.save(tiket); //insert & update Query
    }

    public Iterable<Tiket> findAll(){
        return tiketRepo.findAll(); //select * from tiket
    }

    public Tiket findOne(int id){
        return tiketRepo.findById(id).get();
        //select * from tiket where id =1
    }

    public void removeOne(int id){
        tiketRepo.deleteById(id);
    }
    
    public Iterable<Tiket> findByName(String nik){
    return tiketRepo.findTiketByName(nik);
  }
}



