package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.Country;
import com.exotourier.exotourier.exception.CountryAlreadyExistException;
import com.exotourier.exotourier.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    
    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/")
    public List<Country> getAll(){
        return countryService.getAll();
    }

    @PostMapping("/")
    public Country create(@RequestBody @Valid Country country) throws CountryAlreadyExistException {
        return countryService.create(country);
    }

    @GetMapping("/{idCountry}")
    public Country getById(@PathVariable Integer idCountry){
        return countryService.getById(idCountry).get();
    }
}
