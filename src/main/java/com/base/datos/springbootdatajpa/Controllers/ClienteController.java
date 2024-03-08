package com.base.datos.springbootdatajpa.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.base.datos.springbootdatajpa.Models.DAO.IClienteDao;
import com.base.datos.springbootdatajpa.Models.Entity.Cliente;

@Controller
@SessionAttributes("cliente")
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private IClienteDao clienteDao;

    private Map<Integer, String> generos = new HashMap<>();

    @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clienteDao.findall());//los datos los trae por medio de una consulta
    
        return "clientes/listar";
    }

    @GetMapping("/form")
    public String create(Model model)
    {
        generos.put(1, "hombre");
        generos.put(2, "mujer");
        String cedula = null;
        
        model.addAttribute("titlePage", "register User");
        model.addAttribute("cedula",cedula);
        Cliente cliente = new Cliente();
        model.addAttribute("generos", generos);
        model.addAttribute("titulo", "formulario de clientes");
        model.addAttribute("cliente", cliente);
        model.addAttribute("button", "registrar cliente");

        return "clientes/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Cliente cliente, BindingResult result, SessionStatus status, Model model,@RequestParam("cedula") String cedula)
    {
        if(result.hasErrors() || (cedula == null || cedula.isEmpty() && clienteDao.findOne(cliente.getId()) != null))
        {
            generos.put(1, "hombre");
            generos.put(2, "mujer");
            model.addAttribute("generos", generos);

            model.addAttribute("button", "guardar");
            model.addAttribute("cedula",cedula);
            model.addAttribute("titlePage", "Cliente");
            model.addAttribute("titulo", "formulario de clientes");
            return "clientes/form";
        }
        clienteDao.save(cliente);

        
        status.setComplete();
        return "redirect:/clientes/listar";
    }

    @GetMapping("/form/{id}")
    public String editar(Model model, @PathVariable(value = "id") String id)
    {
        model.addAttribute("titlePage", "Editar");
        String cedula = null;
        Cliente cliente = null;

        if (id.length() > 0) {
            cliente = clienteDao.findOne(id);
        } else {
            return "redirect:/clientes/listar";
        }
        
        cedula = cliente.getId();
        model.addAttribute("cedula",cedula);

        generos.put(1, "hombre");
        generos.put(2, "mujer");
        model.addAttribute("generos", generos);

        model.addAttribute("titulo", "Editar Cliente");
        model.addAttribute("cliente", cliente);
        model.addAttribute("button", "guardar cambios");

        return "clientes/form";
    }

    @GetMapping("/eliminar/{Id}")
    public String eliminar(@PathVariable(value = "Id") String id)
    {
        if (id.length()>0)
        {
            clienteDao.delete(id);
        }
        return "redirect:/clientes/listar";
    }

    

}
