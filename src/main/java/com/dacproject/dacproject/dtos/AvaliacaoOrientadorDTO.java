/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dacproject.dacproject.dtos;

import com.dacproject.dacproject.entities.Aluno;
import com.dacproject.dacproject.entities.AvaliacaoOrientador;
import com.dacproject.dacproject.entities.Orientador;
import java.io.Serializable;


public class AvaliacaoOrientadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private Orientador orientador;
    private Aluno aluno;

    private Long assiduidade;
    private Long disciplina;
    private Long sociabilidade;
    private Long responsabilidade;
    private Long iniciativa;

    public AvaliacaoOrientadorDTO() {
    }

    public AvaliacaoOrientadorDTO(Long id, Orientador orientador, Aluno aluno, Long assiduidade, Long disciplina, Long sociabilidade, Long responsabilidade, Long iniciativa) {
        this.id = id;
        this.orientador = orientador;
        this.aluno = aluno;
        this.assiduidade = assiduidade;
        this.disciplina = disciplina;
        this.sociabilidade = sociabilidade;
        this.responsabilidade = responsabilidade;
        this.iniciativa = iniciativa;
    }
    
    public AvaliacaoOrientadorDTO(AvaliacaoOrientador entity){
         this.id = entity.getId();
        this.orientador = entity.getOrientador();
        this.aluno = entity.getAluno();
        this.assiduidade = entity.getAssiduidade();
        this.disciplina = entity.getDisciplina();
        this.sociabilidade = entity.getSociabilidade();
        this.responsabilidade = entity.getResponsabilidade();
        this.iniciativa = entity.getIniciativa();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Long getAssiduidade() {
        return assiduidade;
    }

    public void setAssiduidade(Long assiduidade) {
        this.assiduidade = assiduidade;
    }

    public Long getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Long disciplina) {
        this.disciplina = disciplina;
    }

    public Long getSociabilidade() {
        return sociabilidade;
    }

    public void setSociabilidade(Long sociabilidade) {
        this.sociabilidade = sociabilidade;
    }

    public Long getResponsabilidade() {
        return responsabilidade;
    }

    public void setResponsabilidade(Long responsabilidade) {
        this.responsabilidade = responsabilidade;
    }

    public Long getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(Long iniciativa) {
        this.iniciativa = iniciativa;
    }
    
    
}
