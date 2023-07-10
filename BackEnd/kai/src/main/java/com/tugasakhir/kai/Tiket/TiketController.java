package com.tugasakhir.kai.Tiket;

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
@RequestMapping("/api/tiket")
public class TiketController {
    
    @Autowired
    private TiketServices tiketServices;

    @PostMapping()
    public ResponseEntity<ResponseData<Tiket>> postStudents(@Valid @RequestBody Tiket tiket, Errors errors) {
        
        ResponseData<Tiket> responseData = new ResponseData<>();
        
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setResult(false);
            responseData.setData(null);
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setResult(true);
        List<Tiket>value = new ArrayList<>();
        value.add(tiketServices.save(tiket));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public ResponseEntity<ResponseData<Tiket>> fetchTiket() {
        ResponseData<Tiket> responseData = new ResponseData<>();
        try {
            Iterable<Tiket> values = tiketServices.findAll();
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
    public ResponseEntity<ResponseData<Tiket>> fetchTiketById(@PathVariable("id") int id) {
        ResponseData<Tiket> responseData = new ResponseData<>();
        try {
            Tiket values = tiketServices.findOne(id);
            List<Tiket> result = new ArrayList<>();
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
    public ResponseEntity<ResponseData<Tiket>> updateTiket(@Valid @RequestBody Tiket tiket, Errors errors) {

        ResponseData<Tiket> responseData = new ResponseData<>();

        if (tiket.getId_tiket() != 0) {
            if (errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    responseData.getMessage().add(error.getDefaultMessage());
                }
                responseData.setResult(false);
                responseData.setData(null);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }

            responseData.setResult(true);
            List<Tiket> value = new ArrayList<>();
            value.add(tiketServices.save(tiket));
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
    public ResponseEntity<ResponseData<Tiket>> deleteTiketById(@PathVariable("id") int id) {
        ResponseData<Tiket> responseData = new ResponseData<>();
        if (id != 0) {
            try {
                tiketServices.removeOne(id);
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
  public ResponseEntity<ResponseData<Tiket>> getTiketByName(@RequestBody SearchData searchData) {
    ResponseData<Tiket> responseData = new ResponseData<>();

    try{
      Iterable<Tiket> values = tiketServices.findByName(searchData.getSearchKey());
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

