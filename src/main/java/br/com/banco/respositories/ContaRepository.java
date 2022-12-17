package br.com.banco.respositories;

import br.com.banco.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContaRepository extends JpaRepository<Conta, Long>{

    
}
