package com.poc.openfeign.api.controller;

import com.poc.openfeign.api.client.ViaCepClient;
import com.poc.openfeign.api.response.EnderecoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/endereco")
public class ViaCepController {

    @Autowired
    private ViaCepClient viaCepClient;

    @GetMapping("/cep/{cep}")
    public ResponseEntity<EnderecoResponse> buscarEnderecoPorCep(@PathVariable("cep") String cep) {
        return ResponseEntity.ok().body(viaCepClient.buscarEnderecoPorCep(cep));
    }
}
