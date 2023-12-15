package Modelo;
public class Aeronave {
    private String nome;
    private int assentosDisponiveis;

    public Aeronave(String nome, int assentosDisponiveis) {
        this.nome = nome;
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public String getNome() {
        return nome;
    }

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public int getQuantidadeDeAssentos() {
        return assentosDisponiveis;
    }

    public void setQuantidadeDeAssentos(int assentosDisponiveis) {
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public boolean venderAssento() {
        if (assentosDisponiveis > 0) {
            assentosDisponiveis--;
            return true;
        } else {
            throw new RuntimeException("Não há assentos disponíveis");
        }
    }
}