package com.example.demo.controller;

import com.example.demo.domain.Consulta;
import com.example.demo.domain.Paciente;
import com.example.demo.repository.ConsultaRepository;
import com.example.demo.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/view")
public class ConsultaController {

    private final PacienteRepository pacienteRepository;
    private final ConsultaRepository consultaRepository;

    @GetMapping("/pacientes/ver/{id}")
    public String getConsultas(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);

        if (paciente == null) {
            return "redirect:/view/pacientes";
        }

        if (!paciente.getConsultas().isEmpty()) {
            model.addAttribute("consultas", paciente.getConsultas());
            model.addAttribute("titulo", "Lista de Consultas del Paciente: ".concat(paciente.getNombres()));
        }

        return "consulta";
    }

    @GetMapping("/consulta/ver/{id}")
    public String getConsultaById(@PathVariable Long id, Model model) {
        Consulta consulta = consultaRepository.findById(id).orElse(null);

        if (consulta == null) {
            return "redirect:/view/pacientes";
        }

        model.addAttribute("consulta", consulta);
        model.addAttribute("titulo", "Detalle de Consulta");


        return "detalle";
    }
}
