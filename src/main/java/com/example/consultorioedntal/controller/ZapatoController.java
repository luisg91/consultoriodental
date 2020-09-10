package com.example.consultorioedntal.controller;

import com.example.consultorioedntal.model.Zapato;
import com.example.consultorioedntal.services.ColorService;
import com.example.consultorioedntal.services.TallaService;
import com.example.consultorioedntal.services.ZapatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/zapatos")
public class ZapatoController {
    @Autowired
    ZapatoService service;

    @Autowired
    TallaService tallaService;

    @Autowired
    ColorService colorService;

    @RequestMapping(method = RequestMethod.GET)
    public String show(ModelMap model){
        model.put("registros", service.all());
        return "zapatos";
    }

    @RequestMapping(value="/nuevo", method = RequestMethod.GET)
    public String showNuevo(ModelMap model){
        model.put("tallas", tallaService.getActivos());
        model.put("colores", colorService.getActivos());
        model.put("zapato", new Zapato());
        model.put("c", "zapatos/nuevo");
        return "edicionZapatos";
    }

    @RequestMapping(value="/nuevo", method = RequestMethod.POST)
    public String registrarNuevo(@ModelAttribute Zapato zapato, ModelMap model){
        //Guardar aqui el pedo
        model.put("tallas", tallaService.getActivos());
        model.put("colores", colorService.getActivos());
        model.put("zapato", new Zapato());
        model.put("c", "zapatos/nuevo");
        return "edicionZapatos";
    }
}
