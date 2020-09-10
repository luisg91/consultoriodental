package com.example.consultorioedntal.controller;

import com.example.consultorioedntal.model.Color;
import com.example.consultorioedntal.services.ColorService;
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
public class ColorController {
    @Autowired
    ColorService service;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value="/colores", method = RequestMethod.GET)
    public String show(ModelMap model){
        model.put("registros", service.all());
        return "colores";
    }

    @ResponseBody
    @RequestMapping(value="/colores/colorXId", method = RequestMethod.GET)
    public String getBiId(@RequestParam("id") Long id) throws JsonProcessingException {
        Color c = service.getById(id);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String json = objectMapper.writeValueAsString(c);
        System.out.println(json);
        return json;
    }

    @ResponseBody
    @RequestMapping(value="/colores/nuevo", method = RequestMethod.POST)
    public String nuevo(@RequestParam("registro") String registro) throws JsonProcessingException {
        Color c = objectMapper.readValue(registro, Color.class);
        service.insert(c);
        return "OK";
    }

    @ResponseBody
    @RequestMapping(value="/colores/actualizar", method = RequestMethod.POST)
    public String actualizar(@RequestParam("registro") String registro) throws JsonProcessingException {
        Color c = objectMapper.readValue(registro, Color.class);
        service.update(c);
        return "OK";
    }

    @ResponseBody
    @RequestMapping(value="/colores/habilitar", method = RequestMethod.POST)
    public String enable(@RequestParam("id") Long id) {
        service.enable(id);
        return "OK";
    }

    @ResponseBody
    @RequestMapping(value="/colores/deshabilitar", method = RequestMethod.POST)
    public String disable(@RequestParam("id") Long id) {
        service.disable(id);
        return "OK";
    }
}
