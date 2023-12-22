/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dacproject.dacproject.dtos;

import com.dacproject.dacproject.entities.Aluno;
import com.dacproject.dacproject.entities.AvaliacaoEmpresa;
import com.dacproject.dacproject.entities.Empresa;
import java.io.Serializable;


public class AvaliacaoEmpresaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
            
    private Long id;

    private Empresa empresa;

    private Aluno aluno;

    private Long rendimento;
    private Long conhecimento;
    private Long cumprimentoTarefas;
    private Long aprendizagem;
    private Long desempenho;

    public AvaliacaoEmpresaDTO() {
    }

    public AvaliacaoEmpresaDTO(Long id, Empresa empresa, Aluno aluno, Long rendimento, Long conhecimento, Long cumprimentoTarefas, Long aprendizagem, Long desempenho) {
        this.id = id;
        this.empresa = empresa;
        this.aluno = aluno;
        this.rendimento = rendimento;
        this.conhecimento = conhecimento;
        this.cumprimentoTarefas = cumprimentoTarefas;
        this.aprendizagem = aprendizagem;
        this.desempenho = desempenho;
    }
    
    public AvaliacaoEmpresaDTO(AvaliacaoEmpresa entity) {
        this.id = entity.getId();
        this.empresa = entity.getEmpresa();
        this.aluno = entity.getAluno();
        this.rendimento = entity.getRendimento();
        this.conhecimento = entity.getConhecimento();
        this.cumprimentoTarefas = entity.getCumprimentoTarefas();
        this.aprendizagem = entity.getAprendizagem();
        this.desempenho = entity.getDesempenho();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Long getRendimento() {
        return rendimento;
    }

    public void setRendimento(Long rendimento) {
        this.rendimento = rendimento;
    }

    public Long getConhecimento() {
        return conhecimento;
    }

    public void setConhecimento(Long conhecimento) {
        this.conhecimento = conhecimento;
    }

    public Long getCumprimentoTarefas() {
        return cumprimentoTarefas;
    }

    public void setCumprimentoTarefas(Long cumprimentoTarefas) {
        this.cumprimentoTarefas = cumprimentoTarefas;
    }

    public Long getAprendizagem() {
        return aprendizagem;
    }

    public void setAprendizagem(Long aprendizagem) {
        this.aprendizagem = aprendizagem;
    }

    public Long getDesempenho() {
        return desempenho;
    }

    public void setDesempenho(Long desempenho) {
        this.desempenho = desempenho;
    }
    
    
}
