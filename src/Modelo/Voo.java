package Modelo;
import java.util.ArrayList;
import java.util.List;

import PadraoObserver.Observer;

public class Voo {
    private String codigo;
    private String status;
    private String origem;
    private String destino;
    private String horaPartida;
    private String horaChegada;
    private Aeronave aeronave;

    public Voo(String codigo, String status, String origem, String destino, String horaPartida,
            String horaChegada, Aeronave aeronave) {
        this.codigo = codigo;
        this.status = status;
        this.origem = origem;
        this.destino = destino;
        this.horaPartida = horaPartida;
        this.horaChegada = horaChegada;
        this.aeronave = aeronave;
    }

    private List<Observer> passageiros = new ArrayList<>();

    public void adicionarPassageiro(Observer passageiro) {
        if (aeronave.venderAssento()) {
            passageiros.add(passageiro);
        }
    }

    //Getters

    public String getCodigo() {
        return codigo;
    }

    public String getHoraPartida() {
        return horaPartida;
    }
    public String getHoraChegada() {
        return horaChegada;
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigem() {
        return origem;
    }

    public String getStatus() {
        return status;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    //Setters

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setHoraPartida(String horaPartida) {
        this.horaPartida = horaPartida;
    }

    public void setHoraChegada(String horaChegada) {
        this.horaChegada = horaChegada;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public void setStatus(String status) {
        this.status = status;
        for (Observer passageiro : passageiros) {
            passageiro.update(status);
        }
    }

    public void removerPassageiro(Observer passageiro) {
        passageiros.remove(passageiro);
    }

}