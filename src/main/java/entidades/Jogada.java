package entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.util.Date;

@Entity
public class Jogada {
// definindo explicitamente a chave primaria
	// generation type é uma estrategia de auto increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//  Definindo explicitamente as colunas com colum
    @Column(name = "jogador1")
    private String jogador1;

    @Column(name = "jogador2")
    private String jogador2;

    @Column(name = "jogada1")
    private String jogada1;

    @Column(name = "jogada2")
    private String jogada2;

    @Column(name = "resultado")
    private String resultado;

    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    public Jogada() {
    }

    public Jogada(String jogador1, String jogador2, String jogada1, String jogada2, String resultado, Date data) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.jogada1 = jogada1;
        this.jogada2 = jogada2;
        this.resultado = resultado;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJogador1() {
        return jogador1;
    }

    public void setJogador1(String jogador1) {
        this.jogador1 = jogador1;
    }

    public String getJogador2() {
        return jogador2;
    }

    public void setJogador2(String jogador2) {
        this.jogador2 = jogador2;
    }

    public String getJogada1() {
        return jogada1;
    }

    public void setJogada1(String jogada1) {
        this.jogada1 = jogada1;
    }

    public String getJogada2() {
        return jogada2;
    }

    public void setJogada2(String jogada2) {
        this.jogada2 = jogada2;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    // debugar
    @Override
    public String toString() {
        return "Jogada{" +
                "id=" + id +
                ", jogador1='" + jogador1 + '\'' +
                ", jogador2='" + jogador2 + '\'' +
                ", jogada1='" + jogada1 + '\'' +
                ", jogada2='" + jogada2 + '\'' +
                ", resultado='" + resultado + '\'' +
                ", data=" + data +
                '}';
    }
}