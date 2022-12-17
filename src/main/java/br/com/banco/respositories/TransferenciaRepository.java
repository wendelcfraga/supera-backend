package br.com.banco.respositories;

import br.com.banco.entities.Transferencia;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;










public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{
    
    List<Transferencia> findByContaId(Long contaId);

    //@Query(value = "SELECT t FROM Transferencia t WHERE t.nomeOperadorTransacao = :nomeOp")
    List<Transferencia> findByNomeOperadorTransacaoContainingIgnoreCase(String nomeOperadorTransacao);


    @Query(value = "SELECT t FROM Transferencia t WHERE (t.dataTransferencia BETWEEN :startDate AND :endDate)")
    List<Transferencia> findByDataBetween(@Param("startDate") LocalDateTime inicio, @Param("endDate") LocalDateTime fim);
}
