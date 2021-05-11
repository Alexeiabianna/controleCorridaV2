import main.java.com.bcopstein.CtrlCorredorV1.repository.EventoRepository;

public class EstatisticasDTO {
  private int media;
  private int mediana;
  private int desvioPadrao;

  public EstatisticasDTO(int media, int mediana, int desvioPadrao) {
    this.media = media;
    this.mediana = mediana;
    this.desvioPadrao = desvioPadrao;
  }

  public int getMedia() {
    return media;
  }

  public void setMedia(int media) {
    this.media = media;
  }

  public int getMediana() {
    return mediana;
  }

  public void setMediana(int mediana) {
    this.mediana = mediana;
  }

  public int getDesvioPadrao() {
    return desvioPadrao;
  }

  public void setDesvioPadrao(int desvioPadrao) {
    this.desvioPadrao = desvioPadrao;
  }

}
