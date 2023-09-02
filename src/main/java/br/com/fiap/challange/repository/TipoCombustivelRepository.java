package br.com.fiap.challange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.challange.entity.TipoCombustivelEntity;

@Repository
public interface TipoCombustivelRepository extends JpaRepository<TipoCombustivelEntity, Long> {

}
