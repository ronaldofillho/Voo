package Enum;

public enum TipoStatus {
    AGENDADO(1),
    CHECK_IN(2),
    ATRASADO(3),
    EMBARQUE(4),
    CANCELADO(5),
    DESDEMBARQUE(6);

    private final int numero;

    TipoStatus(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        switch (this) {
            case AGENDADO:
                return "Agendado";
            case CHECK_IN:
                return "Check-in";
            case ATRASADO:
                return "Atrasado";
            case EMBARQUE:
                return "Embarque";
            case CANCELADO:
                return "Cancelado";
            case DESDEMBARQUE:
                return "Desembarque";
            default:
                return "";
        }
    }
}
