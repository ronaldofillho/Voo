import java.util.Scanner;

import Enum.TipoNotificacao;
import Enum.TipoStatus;
import Modelo.Aeronave;
import Modelo.Passageiro;
import Modelo.Voo;
import PadraoFactory.Notificacao;
import PadraoFactory.NotificacaoFactory;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Aeronave aeronave = new Aeronave("BOING-777", 162);
        Voo voo = new Voo("LATAM-1710", "Embarque", "JPA", "BSB", "15:00", "18:00", aeronave);


        System.out.println("Digite o nome do passageiro:");
        String nomePassageiro = scanner.nextLine();

        System.out.println("Status do Voo Atual: " + voo.getStatus());

        System.out.println("Escolha o tipo de notificação (Email, SMS, PushNotification):");
        String tipoNotificacaoStr = scanner.nextLine();

        TipoNotificacao tipoNotificacaoEnum = TipoNotificacao.valueOf(tipoNotificacaoStr);

        NotificacaoFactory notificacaoFactory = new NotificacaoFactory();
        Notificacao notificacao = notificacaoFactory.criarNotificacao(tipoNotificacaoEnum.toString());
        Passageiro passageiro = new Passageiro(nomePassageiro, tipoNotificacaoEnum);


        try {
            if (aeronave.venderAssento()) {
                System.out.println("Assento vendido com sucesso!");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Digite o status do Voo que voce está vendo agora:");
        String statusVoo = scanner.nextLine();
        passageiro.update(statusVoo);

        for (int i = 5; i > 0; i--) {
            System.out.println("Contagem regressiva: " + i + " segundos...");
            try {
                Thread.sleep(1000); // Aguardar 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("Escolha o tipo de status:");
        for (TipoStatus tipo : TipoStatus.values()) {
            System.out.printf("%d - %s\n", tipo.getNumero(), tipo.name());
        }


        System.out.print("Digite o número correspondente ao tipo de status desejado: ");
        int escolhaTipoStatus = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner


        if (escolhaTipoStatus == TipoStatus.ATRASADO.getNumero()) {

            System.out.println("Digite a nova hora de partida (HH:mm):");
            String novaPartida = scanner.nextLine();
            voo.setHoraPartida(novaPartida);

            System.out.println("Digite a nova hora de chegada (HH:mm):");
            String novaChegada = scanner.nextLine();
            voo.setHoraChegada(novaChegada);

            System.out.println("Escolha a nova forma de notificação (Email, SMS, PushNotification):");
            tipoNotificacaoStr = scanner.nextLine();
            tipoNotificacaoEnum = TipoNotificacao.valueOf(tipoNotificacaoStr);
            passageiro.update(tipoNotificacaoEnum.toString());
        }


        System.out.println("\nInformações do Voo:");

        System.out.println("Código do Voo: " + voo.getCodigo());
        System.out.println("Origem: " + voo.getOrigem());
        System.out.println("Destino: " + voo.getDestino());
        System.out.println("Horário de Partida: " + voo.getHoraPartida());
        System.out.println("Horário de Chegada: " + voo.getHoraChegada());


        System.out.println("Tipo de Notificação: " + tipoNotificacaoEnum);
        System.out.println("Status do Voo: " + TipoStatus.values()[escolhaTipoStatus - 1].toString());


        scanner.close();
    }
}
