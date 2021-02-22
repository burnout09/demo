package com.example.demo.controller;

import com.example.demo.domain.Consulta;
import com.example.demo.domain.Paciente;
import com.example.demo.repository.ConsultaRepository;
import com.example.demo.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DemoController {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;

    @GetMapping("/pacientes")
    public ResponseEntity<List<Paciente>> getPacientes() {
        return ResponseEntity.ok((List<Paciente>) pacienteRepository.findAll());
    }

    @GetMapping("/consultas")
    public ResponseEntity<List<Consulta>> getConsultas() {
        return ResponseEntity.ok((List<Consulta>) consultaRepository.findAll());
    }
}
