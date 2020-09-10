package com.example.consultorioedntal.controller;

import com.example.consultorioedntal.model.Talla;
import com.example.consultorioedntal.services.TallaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/tallas")
public class TallaController {
    @Autowired
    TallaService service;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String ver(ModelMap model){
        model.put("registros", service.all());
        return "tallas";
    }

    @ResponseBody
    @RequestMapping(value="/tallaXId", method = RequestMethod.GET)
    public String getBiId(@RequestParam("id") Long id) throws JsonProcessingException {
        Talla c = service.getById(id);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String json = objectMapper.writeValueAsString(c);
        System.out.println(json);
        return json;
    }

    @ResponseBody
    @RequestMapping(value="/nuevo", method = RequestMethod.POST)
    public String nuevo(@RequestParam("registro") String registro) throws JsonProcessingException {
        Talla c = objectMapper.readValue(registro, Talla.class);
        service.insert(c);
        return "OK";
    }

    @ResponseBody
    @RequestMapping(value="/actualizar", method = RequestMethod.POST)
    public String actualizar(@RequestParam("registro") String registro) throws JsonProcessingException {
        Talla c = objectMapper.readValue(registro, Talla.class);
        service.update(c);
        return "OK";
    }

    @ResponseBody
    @RequestMapping(value="/habilitar", method = RequestMethod.POST)
    public String enable(@RequestParam("id") Long id) {
        service.enable(id);
        return "OK";
    }

    @ResponseBody
    @RequestMapping(value="/deshabilitar", method = RequestMethod.POST)
    public String disable(@RequestParam("id") Long id) {
        service.disable(id);
        return "OK";
    }
}
