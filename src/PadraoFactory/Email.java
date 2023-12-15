package PadraoFactory;
class Email implements Notificacao {
    
    @Override
    public void enviarNotificacao(String nome, String status) {
        System.out.println("Enviando email para " + nome + " com o status do voo: " + status);
    }
}