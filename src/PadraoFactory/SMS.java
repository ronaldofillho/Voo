package PadraoFactory;
class SMS implements Notificacao {
    
    @Override
    public void enviarNotificacao(String nome, String status) {
        System.out.println("Enviando SMS para " + nome + " com o status do voo: " + status);
    }
}