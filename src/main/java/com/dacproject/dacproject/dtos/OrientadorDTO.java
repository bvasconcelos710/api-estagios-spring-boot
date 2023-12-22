/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dacproject.dacproject.dtos;

import com.dacproject.dacproject.entities.Orientador;
import java.io.Serializable;


public class OrientadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    
    private Long id;
    private String nome;
    private String disciplina;

    public OrientadorDTO() {
    }
    
    public OrientadorDTO(Long id, String nome, String disciplina ) {
        this.id = id;
        this.nome = nome;
        this.disciplina = disciplina;
    }
    
    public OrientadorDTO(Orientador entity) {
        this.id = entity.getId();
	this.nome = entity.getNome();
        this.disciplina = entity.getDisciplina();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    
}
