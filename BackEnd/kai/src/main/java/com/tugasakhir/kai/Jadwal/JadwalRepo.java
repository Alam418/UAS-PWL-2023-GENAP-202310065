package com.tugasakhir.kai.Jadwal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface JadwalRepo extends CrudRepository<Jadwal, Integer>{
   @Query("SELECT a FROM Jadwal a WHERE a.asal_kereta LIKE %:asal_kereta% ")
  public Iterable<Jadwal> findJadwalByName(@Param("asal_kereta") String asal_kereta);
}
