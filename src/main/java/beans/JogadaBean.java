package beans;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import daos.JogadaDao;
import entidades.Jogada;
import services.JogoService; 

// explicitando apelido para bean
@ManagedBean(name = "jogadaBean")
public class JogadaBean {
	private Jogada jogada = new Jogada();
	private List<Jogada> lista;
	private Integer idParaEncontrar;

	public Jogada getJogada() {
		return jogada;
	}

	public void setJogada(Jogada Jogada) {
		this.jogada = Jogada;
	}
	
	public List<Jogada> getLista() {
		lista = JogadaDao.listarTodas();
		return lista;
	}

	public void setLista(List<Jogada> lista) {
		this.lista = lista;
	}

	public Integer getIdParaEncontrar() {
        return idParaEncontrar;
    }

    public void setIdParaEncontrar(Integer idParaEncontrar) {
        this.idParaEncontrar = idParaEncontrar;
    }
	
	public void salvar() {
		jogada.setData(new Date());
		jogada = JogoService.atribuirJogadas(jogada);
		jogada = JogoService.definirVencedor(jogada);
		JogadaDao.salvar(jogada);
		// exibir mensagem
		FacesMessage msg = new FacesMessage("Sucesso", "Jogada cadastrado com sucesso.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void prepararEdicao(Jogada jogadaSelecionada) {
        this.jogada = jogadaSelecionada; // vai pegar a jogada escolhida para atualizar	
    }
	
	public void atualizar() {
        JogadaDao.atualizar(jogada);
		FacesMessage msg = new FacesMessage("Atualizar", "Jogada atualizada com sucesso.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
        jogada = new Jogada(); 
        getLista(); 
    }

    // busscando pelo id
    public void encontrar() {
        Jogada encontrada = JogadaDao.encontrar(idParaEncontrar);
        jogada = encontrada;
    }
    
    public void deletar(Jogada jogadaSelecionada)
    {
    	JogadaDao.deletar(jogadaSelecionada);
		FacesMessage msg = new FacesMessage("Deletar", "Jogada deletada com sucesso.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		getLista();
    }
    
}

