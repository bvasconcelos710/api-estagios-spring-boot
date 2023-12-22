/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dacproject.dacproject.repositories;


import com.dacproject.dacproject.entities.AvaliacaoEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoEmpresaRepository extends JpaRepository<AvaliacaoEmpresa, Long> {
    
}
