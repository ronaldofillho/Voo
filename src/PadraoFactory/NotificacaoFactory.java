package PadraoFactory;

public class NotificacaoFactory {

    public Notificacao criarNotificacao(String tipo) {
        if (tipo.equals("Email")) {
            return new Email();
        } else if (tipo.equals("SMS")) {
            return new SMS();
        } else if (tipo.equals("PushNotification")) {
            return new PushNotification();
        } else {
            throw new IllegalArgumentException("Tipo de notificação desconhecido: " + tipo);
        }
    }
}