package PadraoFactory;
class PushNotification implements Notificacao {
    
    @Override
    public void enviarNotificacao(String nome, String status) {
        System.out.println("Enviando push notification para " + nome + " com o status do voo: " + status);
    }
}