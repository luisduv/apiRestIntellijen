package com.vimenca.demo.controller;

import com.vimenca.demo.bean.Persona;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
//@RequestMapping("/")



public class DemoController {



    List<Persona> Listapersona = new ArrayList<Persona>();



   // @GetMapping
    @RequestMapping(value="/person",method = RequestMethod.GET)
    public  Persona obtenerPersona(HttpServletRequest request){
        Persona person = new Persona();
        person.setNombre("luis");
        person.setApellido("paulino");
        person.setDocumento(01234);

        return person;
    }




    /*@RequestMapping(value="/postGuardar",method = RequestMethod.POST)
    public  Persona guardarPersona(HttpServletRequest request){
        Persona person = new Persona();


        System.out.println("la person " + person.getNombre()+" " + person.getApellido() + "tiene"+ person.getDocumento());

        return person;
    }*/


    @RequestMapping(value="/postPer",method = RequestMethod.POST)
    public  List<Persona> postpersonaa(@RequestBody Persona persona){

        Listapersona.add(persona);

        return Listapersona;
    }

    @PostMapping("/postPersonList")
    public  List<Persona> postpersonas(@RequestBody List<Persona> personas){

        personas.stream().
            forEach(persona ->{Listapersona.add(persona);
            });

        return Listapersona;
    }




    @GetMapping("/getPersonaEdad/{edad}")
    public List<Persona> getPersonaById(@PathVariable("edad") int edad){

        return Listapersona.stream().
                filter(x -> x.getDocumento() == edad)
                .collect(Collectors.toList());

    }

    @GetMapping("/getPersonaEdad")
    public List<Persona> getPersonaEdad(@PathParam("edad") int edad){

        return Listapersona.stream().
                filter(x -> x.getDocumento() == edad)
                .collect(Collectors.toList());

    }




    





}

