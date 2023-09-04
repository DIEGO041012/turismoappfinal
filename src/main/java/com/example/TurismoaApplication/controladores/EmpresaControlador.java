package com.example.TurismoaApplication.controladores;

import com.example.TurismoaApplication.modelos.Empresa;
import com.example.TurismoaApplication.servicios.EmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
public class EmpresaControlador {

    @Autowired
    EmpresaServicio empresaServicio;

    @PostMapping
    public ResponseEntity<?> registrarEmpresa(@RequestBody Empresa datosEmpresa){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(empresaServicio.registrarEmpresa(datosEmpresa));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarEmpresa(@RequestBody Empresa datosNuevosEmpresa, @PathVariable Integer id){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(empresaServicio.modificarEmpresa(id,datosNuevosEmpresa));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUnaEmpresa(@PathVariable Integer id){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(empresaServicio.buscarEmpresaPorId(id));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodasEmpresas(){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(empresaServicio.buscarTodasEmpresas());

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEmpresa(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(empresaServicio.eliminarEmpresa(id));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }




}
