/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dacproject.dacproject.dtos;

import com.dacproject.dacproject.entities.Aluno;

import java.io.Serializable;


public class AlunoDTO implements Serializable {

    private Long id;
    private String nome;
    private String matricula;

    public AlunoDTO() {
    }

    public AlunoDTO(Long id, String nome, String matricula) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
    }
    
    public AlunoDTO(Aluno entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
                this.matricula = entity.getMatricula();
	}

    // Getters e Setters

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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
