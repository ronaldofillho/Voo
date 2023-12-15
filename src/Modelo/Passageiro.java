package Modelo;

import Enum.TipoNotificacao;
import PadraoFactory.Notificacao;
import PadraoFactory.NotificacaoFactory;
import PadraoObserver.Observer;

public class Passageiro implements Observer {
    private String nome;
    private Notificacao notificacao;
    private NotificacaoFactory notificacaoFactory = new NotificacaoFactory();

    public Passageiro(String nome, TipoNotificacao tipoNotificacao) {
        this.nome = nome;
        this.notificacao = notificacaoFactory.criarNotificacao(tipoNotificacao.toString());
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public void setTipoNotificacao(TipoNotificacao tipoNotificacao) {
        this.notificacao = notificacaoFactory.criarNotificacao(tipoNotificacao.toString());
    }



    @Override
    public void update(String status) {
        notificacao.enviarNotificacao(nome, status);
    }
}