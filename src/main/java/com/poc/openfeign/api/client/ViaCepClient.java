package com.poc.openfeign.api.client;

import com.poc.openfeign.api.response.EnderecoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep-client"  )
public interface ViaCepClient {
    @GetMapping("/{cep}/json")
    EnderecoResponse buscarEnderecoPorCep(@PathVariable String cep);
}
