/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dacproject.dacproject.dtos;

import com.dacproject.dacproject.entities.Aluno;
import com.dacproject.dacproject.entities.Empresa;
import com.dacproject.dacproject.entities.Estagio;
import com.dacproject.dacproject.entities.Orientador;
import java.io.Serializable;

public class EstagioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String inicio;
    private String fim;
    private int cargaHoraria;
    private int totalHoras;
    private String status;

    private Aluno aluno;

    private Empresa empresa;

    private Orientador orientador;

    public EstagioDTO() {

    }

    public EstagioDTO(Long id, String inicio, String fim, int cargaHoraria, int totalHoras, String status, Aluno aluno, Empresa empresa, Orientador orientador) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.cargaHoraria = cargaHoraria;
        this.totalHoras = totalHoras;
        this.status = status;
        this.aluno = aluno;
        this.empresa = empresa;
        this.orientador = orientador;
    }

    public EstagioDTO(Estagio entity) {
        this.id = entity.getId();
        this.inicio = entity.getInicio();
        this.fim = entity.getFim();
        this.cargaHoraria = entity.getCargaHoraria();
        this.totalHoras = entity.getTotalHoras();
        this.status = entity.getStatus();
        this.aluno = entity.getAluno();
        this.empresa = entity.getEmpresa();
        this.orientador = entity.getOrientador();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    
    
}
