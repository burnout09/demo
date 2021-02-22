package com.example.demo.controller;

import com.example.demo.domain.Paciente;
import com.example.demo.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/view")
public class PacienteController {

    private final PacienteRepository pacienteRepository;

    @GetMapping("/pacientes")
    public String getPacientes(Model model) {
        List<Paciente> pacientes = new ArrayList<>();
        pacienteRepository.findAll().forEach(pacientes::add);

        model.addAttribute("titulo", "Lista de Pacientes");
        model.addAttribute("pacientes", pacientes);

        return "paciente";
    }
}
