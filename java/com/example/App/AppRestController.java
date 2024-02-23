package com.example.App;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class AppRestController {
	
    @Autowired
    TrapDAOInterface dao;
    	
    @GetMapping(value = "/rest/trap/all")
     public List<TrapDTO> listTrap() {
        return dao.readTraps();
    }
    
    
	 @GetMapping(value = "rest/trap/{id}")
	    public TrapDTO searchTrap(@RequestBody @PathVariable(value="id") int ID) {
	   	  return dao.searchTrap(ID);
	    }
	 
	 @DeleteMapping(value = "snmptrap/{id}")
	    @ResponseBody
	    public ResponseEntity<Void> deleteTrap(@PathVariable(value="id") int ID) {
	    	ResponseEntity<Void> response;
	    	if (dao.deleteTrap(ID)) {
	    		response = new ResponseEntity<Void>(HttpStatus.OK);
	    		System.out.println("out");
	    	}
	    	else {
	    		response = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	    	}
	    	return response;
	   }
	 @PostMapping(value = "/server/trapinsert")
	    public ResponseEntity<TrapDTO> createTrap(@RequestBody TrapDTO trap) {
		   dao.insertTrap(trap);
		   HttpHeaders headers = new HttpHeaders();
		   try {
			   headers.setLocation(
					   new URI("http://localhost:8080/server/trapinsert"));
		   }catch (URISyntaxException e) {e.printStackTrace();}
		   ResponseEntity<TrapDTO> response = new ResponseEntity<TrapDTO>(trap,headers, HttpStatus.CREATED);
		   return response;
	   }
	 
	
}