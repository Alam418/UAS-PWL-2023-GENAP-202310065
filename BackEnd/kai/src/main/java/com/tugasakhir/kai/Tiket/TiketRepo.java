package com.tugasakhir.kai.Tiket;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TiketRepo extends CrudRepository<Tiket, Integer>{
    @Query("SELECT a FROM Tiket a WHERE a.nik LIKE %:nik% ")
  public Iterable<Tiket> findTiketByName(@Param("nik") String nik);
}
