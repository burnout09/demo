package com.example.demo;

import com.example.demo.domain.Consulta;
import com.example.demo.domain.Paciente;
import com.example.demo.repository.ConsultaRepository;
import com.example.demo.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Paciente paciente1 = Paciente.builder().nombres("Jhon Doe").build();

        Paciente paciente2 = Paciente.builder().nombres("Pedro Ramon").build();

        pacienteRepository.save(paciente1);
        pacienteRepository.save(paciente2);

        Consulta consulta1 = Consulta.builder().numero("123").paciente(paciente1).build();
        Consulta consulta2 = Consulta.builder().numero("134").paciente(paciente2).build();
        Consulta consulta3 = Consulta.builder().numero("145").paciente(paciente1).build();
        Consulta consulta4 = Consulta.builder().numero("156").paciente(paciente2).build();
        Consulta consulta5 = Consulta.builder().numero("167").paciente(paciente2).build();
        Consulta consulta6 = Consulta.builder().numero("178").paciente(paciente2).build();

        consultaRepository.save(consulta1);
        consultaRepository.save(consulta2);
        consultaRepository.save(consulta3);
        consultaRepository.save(consulta4);
        consultaRepository.save(consulta5);
        consultaRepository.save(consulta6);
    }
}
