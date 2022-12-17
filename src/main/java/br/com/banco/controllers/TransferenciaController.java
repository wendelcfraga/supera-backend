package br.com.banco.controllers;

import br.com.banco.entities.Transferencia;
import br.com.banco.respositories.TransferenciaRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;






@RestController
@RequestMapping(value = "/transferencias")
public class TransferenciaController {

    @Autowired
    private TransferenciaRepository _transRepository;
    
    @GetMapping("/conta/{contaId}")
    public List<Transferencia> findTransByConta(@PathVariable long contaId)
    {
        return _transRepository.findByContaId(contaId);
    }


    @GetMapping
    public List<Transferencia> findAll() 
    {
        List<Transferencia> trans = _transRepository.findAll();
        return trans;
    }


    @GetMapping("/periodo")
    public List<Transferencia> findByTransTimeInterval(@RequestParam("dataIni")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ssX") LocalDateTime dataIni,
    @RequestParam("dataFim") 
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ssX") LocalDateTime dataFim) 
    {
        return _transRepository.findByDataBetween(dataIni, dataFim);
    }

    @GetMapping("/operador/{nomeOperador}")
    public List<Transferencia> findByOperador(@PathVariable String nomeOperador)
    {
        
        return _transRepository.findByNomeOperadorTransacaoContainingIgnoreCase(nomeOperador);
    }
}
