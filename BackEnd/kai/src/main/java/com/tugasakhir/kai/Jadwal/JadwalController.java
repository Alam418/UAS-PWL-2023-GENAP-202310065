package com.tugasakhir.kai.Jadwal;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tugasakhir.kai.dto.ResponseData;
import com.tugasakhir.kai.dto.SearchData;

@RestController
@RequestMapping("/api/jadwal")
public class JadwalController {
    
    @Autowired
    private JadwalServices jadwalServices;

    @PostMapping()
    public ResponseEntity<ResponseData<Jadwal>> postStudents(@Valid @RequestBody Jadwal jadwal, Errors errors) {
        
        ResponseData<Jadwal> responseData = new ResponseData<>();
        
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setResult(false);
            responseData.setData(null);
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setResult(true);
        List<Jadwal>value = new ArrayList<>();
        value.add(jadwalServices.save(jadwal));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public ResponseEntity<ResponseData<Jadwal>> fetchMenu() {
        ResponseData<Jadwal> responseData = new ResponseData<>();
        try {
            Iterable<Jadwal> values = jadwalServices.findAll();
            responseData.setResult(true);
            responseData.setMessage(null);
            responseData.setData(values);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<Jadwal>> fetchMenuById(@PathVariable("id") int id) {
        ResponseData<Jadwal> responseData = new ResponseData<>();
        try {
            Jadwal values = jadwalServices.findOne(id);
            List<Jadwal> result = new ArrayList<>();
            result.add(values);
            responseData.setResult(true);
            responseData.setMessage(null);
            responseData.setData(result);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @PutMapping
    public ResponseEntity<ResponseData<Jadwal>> updateMenu(@Valid @RequestBody Jadwal jadwal, Errors errors) {

        ResponseData<Jadwal> responseData = new ResponseData<>();

        if (jadwal.getId() != 0) {
            if (errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    responseData.getMessage().add(error.getDefaultMessage());
                }
                responseData.setResult(false);
                responseData.setData(null);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }

            responseData.setResult(true);
            List<Jadwal> value = new ArrayList<>();
            value.add(jadwalServices.save(jadwal));
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
        } else {
            responseData.setResult(false);
            responseData.setData(null);
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<Jadwal>> deleteMenuById(@PathVariable("id") int id) {
        ResponseData<Jadwal> responseData = new ResponseData<>();
        if (id != 0) {
            try {
                jadwalServices.removeOne(id);
                List<String> message = new ArrayList<>();
                message.add("Successfully removed");
                responseData.setMessage(message);
                responseData.setData(null);
                responseData.setResult(true);
                return ResponseEntity.ok(responseData);
            } catch (Exception e) {
                List<String> message = new ArrayList<>();
                message.add(e.getMessage());
                responseData.setMessage(message);
                responseData.setData(null);
                responseData.setResult(false);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }
        } else {
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @PostMapping("/search")
  public ResponseEntity<ResponseData<Jadwal>> getJadwalByName(@RequestBody SearchData searchData) {
    ResponseData<Jadwal> responseData = new ResponseData<>();

    try{
      Iterable<Jadwal> values = jadwalServices.findByJadwal(searchData.getSearchKey());
      responseData.setResult(true);
      responseData.setMessage(null);
      responseData.setData(values);
      return ResponseEntity.ok(responseData);

    } catch (Exception e ) {
      List<String> message = new ArrayList<>();
      message.add(e.getMessage());
      responseData.setMessage(message);
      responseData.setData(null);
      responseData.setResult(false);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }
  }
}

