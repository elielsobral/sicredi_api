package br.com.sicredi.adapter.controller.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cep-service", url = "https://user-info.herokuapp.com/users")
public interface ValidarCpf {

    @RequestMapping("/{cpf}")
    ResponseEntity<Object> execute(@PathVariable("cpf") String cpf);
}
