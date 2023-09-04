package com.example.TurismoaApplication.servicios;

import com.example.TurismoaApplication.modelos.Empresa;
import com.example.TurismoaApplication.repositorios.EmpresaRepositorio;
import com.example.TurismoaApplication.validaciones.EmpresaValidacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServicio {

    @Autowired
    EmpresaRepositorio empresaRepositorio;

    @Autowired
    EmpresaValidacion empresaValidacion;

    public Empresa registrarEmpresa(Empresa datosARegistrar) throws Exception{
        try{
            //validaciones
            if(!this.empresaValidacion.validarNombre(datosARegistrar.getNombre())){
                throw new Exception("error en el servicio");
            }

            //falta validar el nit

            //SI PASO TODOS LOS IF ESTOY LISTO PARA LLAMAR AL REPO
            return(this.empresaRepositorio.save(datosARegistrar));

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Empresa modificarEmpresa(Integer id, Empresa datosAModificar)throws Exception{
        try{

            //validamos la informacion
            if(!this.empresaValidacion.validarNombre(datosAModificar.getNombre())){
                throw new Exception("error en el dato entregado");
            }

            //buscar que la empresa que tiene el id que envia el usuario exista en BD
            Optional<Empresa>empresaEncontrada=this.empresaRepositorio.findById(id);
            //pregunto si lo que busque esta vacio (QUE NO ESTA)
            if(empresaEncontrada.isEmpty()){
                throw new Exception("Empresa no encontrada");
            }
            //Rutina POR SI SI LA ENCONTRE
            //1.Convierto el opcional en la entidad respectiva
            Empresa empresaQueExiste=empresaEncontrada.get();

            //2. A la empresa que existe le cambio la informacion que el usuario necesita
            empresaQueExiste.setNombre(datosAModificar.getNombre());

            //3. Guardar la informacion que se acaba de editar (SET)
            return (this.empresaRepositorio.save(empresaQueExiste));


        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Empresa buscarEmpresaPorId(Integer id) throws Exception{
        try{
            Optional<Empresa> empresaOpcional= this.empresaRepositorio.findById(id);
            if(empresaOpcional.isEmpty()){
                throw new Exception("Empresa no encontrada");
            }
            return empresaOpcional.get();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Empresa> buscarTodasEmpresas() throws Exception{
        try{
            List<Empresa>listaEmpresa= this.empresaRepositorio.findAll();
            return listaEmpresa;

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarEmpresa(Integer id) throws  Exception{
        try{

            Optional<Empresa> empresaOpcional=this.empresaRepositorio.findById(id);

            if(empresaOpcional.isPresent()){
                this.empresaRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("empresa no encontrada");
            }


        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }




}
