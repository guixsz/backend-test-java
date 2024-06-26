package com.guilhermeSantana.backendtestjava.controller;

import com.guilhermeSantana.backendtestjava.domain.EntryExit;
import com.guilhermeSantana.backendtestjava.repositories.EntryExitRepository;
import com.guilhermeSantana.backendtestjava.service.EntryExitService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("entry-exit")
public class EntryExitController {

    private final EntryExitService entryExitService;

    public EntryExitController(EntryExitService entryExit){
        this.entryExitService = entryExit;
    }

    @PostMapping("/{plate}/{cnpj}")
    public ResponseEntity<EntryExit> registerEntry(@PathVariable("plate") String plate, @PathVariable("cnpj") String cnpj) throws Exception{
        EntryExit entryExit = entryExitService.registerEntry(plate, cnpj);
        return new ResponseEntity<>(entryExit, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntryExit> registerExit(@PathVariable("id") Integer id) throws Exception{
        EntryExit entryExit = entryExitService.registerExit(id);
        return new ResponseEntity<>(entryExit, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EntryExit>> findAll(){
        List<EntryExit> entryExitList = entryExitService.findAll();
        return new ResponseEntity<>(entryExitList,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EntryExit> deleteEntryExit(@PathVariable("id") Integer id){
        entryExitService.deleteEntryExit(id);
        return ResponseEntity.noContent().build();
    }
}
