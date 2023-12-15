import java.util.Scanner;

import Enum.TipoNotificacao;
import Modelo.Aeronave;
import Modelo.Passageiro;
import Modelo.Voo;
import PadraoFactory.Notificacao;
import PadraoFactory.NotificacaoFactory;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Aeronave aeronave = new Aeronave("BOING-777", 162);
        Voo voo = new Voo("LATAM-1710", "Atrasado", "JPA", "BSB", "15:00", "18:00", aeronave);

        // Solicitar informações do passageiro
        System.out.println("Digite o nome do passageiro:");
        String nomePassageiro = scanner.nextLine();

        System.out.println("Status do Voo Atual: " + voo.getStatus());

        System.out.println("Escolha o tipo de notificação (Email, SMS, PushNotification):");
        String tipoNotificacaoStr = scanner.nextLine();

        // Converter a string para um valor do enum
        TipoNotificacao tipoNotificacaoEnum = TipoNotificacao.valueOf(tipoNotificacaoStr);

        // Criar objeto Passageiro usando o padrão Factory
        NotificacaoFactory notificacaoFactory = new NotificacaoFactory();
        Notificacao notificacao = notificacaoFactory.criarNotificacao(tipoNotificacaoEnum.toString());
        Passageiro passageiro = new Passageiro(nomePassageiro, tipoNotificacaoEnum);

        // Simular vender um assento
        try {
            if (aeronave.venderAssento()) {
                System.out.println("Assento vendido com sucesso!");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Contagem regressiva de 10 segundos antes de solicitar novamente as informações
        for (int i = 5; i > 0; i--) {
            System.out.println("Contagem regressiva: " + i + " segundos...");
            try {
                Thread.sleep(1000); // Aguardar 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Digite o novo status do voo: \nSe estiver 'Atrasado', digite 'atrasado':\n");
        String statusVoo = scanner.nextLine();

        // Se houver um atraso, permitir que o usuário atualize as informações de partida e chegada
        if (statusVoo.toLowerCase().equals("atrasado")) {
            System.out.println("Digite a nova hora de partida (HH:mm):");
            String novaPartida = scanner.nextLine();
            voo.setHoraPartida(novaPartida);

            System.out.println("Digite a nova hora de chegada (HH:mm):");
            String novaChegada = scanner.nextLine();
            voo.setHoraChegada(novaChegada);

            // Solicitar novamente informações sobre a notificação e o status do voo
            System.out.println("Escolha a nova forma de notificação (Email, SMS, PushNotification):");
            tipoNotificacaoStr = scanner.nextLine();

            // Converter a string para um valor do enum
            tipoNotificacaoEnum = TipoNotificacao.valueOf(tipoNotificacaoStr);
        }

        // Exibir informações do voo no final
        System.out.println("\nInformações do Voo:");
        
        System.out.println("Código do Voo: " + voo.getCodigo());
        System.out.println("Origem: " + voo.getOrigem());
        System.out.println("Destino: " + voo.getDestino());
        System.out.println("Horário de Partida: " + voo.getHoraPartida());
        System.out.println("Horário de Chegada: " + voo.getHoraChegada());
        
        // Exibir o tipo de notificação
        System.out.println("Tipo de Notificação: " + tipoNotificacaoEnum);
        System.out.println("Status do Voo: " + statusVoo);

        // Fechar o scanner
        scanner.close();
    }
}
