package com.bcopstein.CtrlCorredorV1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.bcopstein.CtrlCorredorV1.repository.CorredorRepository;
import main.java.com.bcopstein.CtrlCorredorV1.repository.EventoRepository;

@RestController
@RequestMapping("/ctrlCorridas")
public class CtrlCorridasController {

    // @Autowired
    private CorredorRepository corredorRepository;
    // @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    public CtrlCorridasController(EventoRepository evento, CorredorRepository corredor) {
        this.corredorRepository = corredor;
        this.eventoRepository = evento;
    }

    @GetMapping("/corredor")
    @CrossOrigin(origins = "*")
    public List<Corredor> consultaCorredor() {
        return corredorRepository.findAll();
    }

    @PostMapping("/corredor")
    @CrossOrigin(origins = "*")
    public boolean cadastraCorredor(@RequestBody final Corredor corredor) {
        return corredorRepository.save(corredor);
    }

    @GetMapping("/eventos")
    @CrossOrigin(origins = "*")
    public List<Evento> consultaEventos() {
        return eventoRepository.findAll();
    }

    @PostMapping("/eventos") // adiciona evento no único corredor
    @CrossOrigin(origins = "*")
    public boolean informaEvento(@RequestBody final Evento evento) {
        return eventoRepository.save(evento);
    }

    @GetMapping("/estatisticas")
    @CrossOrigin(origins = "*")
    public EstatisticasDTO estatisticas(@RequestParam final int distancia){
        List<Evento> listaEventos = eventoRepository.findAll();
        List<double> tempos = new List();
        
        for(Evento e : listaEventos) {
            if(e.getDistancia() == distancia) {
        listaEventos.get(0).getDistancia();
        double minutos = (e.getHoras() * 60) + e.getMinutos() + (e.getSegundos()/ 60);

                tempos.add(e);

            }

            if()

        }
        listaEventos.get(0).getDistancia();

    }

    @GetMapping("/aumentoPerformance")
    @CrossOrigin(origins = "*")
    public PerformanceDTO aumentoPerformance(@RequestParam final int distancia,
    @RequestParam final int ano){
        ...
    }

}
