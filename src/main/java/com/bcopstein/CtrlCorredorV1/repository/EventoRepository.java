package main.java.com.bcopstein.CtrlCorredorV1.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

import com.bcopstein.CtrlCorredorV1.model.Corredor;
import com.bcopstein.CtrlCorredorV1.model.Evento;

@Component
public class EventoRepository {
  private JdbcTemplate jdbcTemplate;

  @Autowired
  public EventoRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;

    this.jdbcTemplate.execute("DROP TABLE eventos IF EXISTS");
    this.jdbcTemplate.execute("CREATE TABLE eventos("
        + "id int, nome VARCHAR(255), dia int, mes int, ano int, distancia int, horas int, minutos int, segundos int,PRIMARY KEY(id))");

    this.jdbcTemplate.batchUpdate("INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES"
        + " ('1','Poa Day Run',22,5,2019,5,0,35,32)");
  }

  public List<Evento> findAll() {
    List<Evento> resp = this.jdbcTemplate.query("SELECT * from eventos",
        (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
            rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"), rs.getInt("segundos")));
    return resp;
  }

  public boolean save(Evento evento) {
    this.jdbcTemplate.update(
        "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES (?,?,?,?,?,?,?,?,?)",
        evento.getId(), evento.getNome(), evento.getDia(), evento.getMes(), evento.getAno(), evento.getDistancia(),
        evento.getHoras(), evento.getMinutos(), evento.getSegundos());
    return true;
  }
}
