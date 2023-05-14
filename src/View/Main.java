package View;

import Controller.GaragemApartamentoController;
import Model.Morador;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int opc= 0;
        GaragemApartamentoController tabela= new GaragemApartamentoController();
        Morador morador= new Morador();
        while (opc != 9){
            opc= Integer.parseInt(JOptionPane.showInputDialog("MENU \n 1 - Cadastrar Morador \n 2 - Consultar Morador \n 3 - Remover Morador \n 9 - Sair"));
            switch (opc){
                case 1: morador= new Morador();
                    String cadastro= JOptionPane.showInputDialog("Digite dessa forma: 101;Luan;Uno;azul;263jk");
                    String[] vet= cadastro.split(";");
                    morador.setNumApartamento(Integer.parseInt(vet[0]));
                    morador.setNome(vet[1]);
                    morador.setModelo(vet[2]);
                    morador.setCor(vet[3]);
                    morador.setPlaca(vet[4]);
                    tabela.cadastrar(morador);
                    break;
                case 2:
                    try {
                        morador.setNumApartamento(Integer.parseInt(JOptionPane.showInputDialog("Digite o número do Apartamento")));
                        morador= tabela.consulta(morador);
                        System.out.println(morador);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3: morador.setNumApartamento(Integer.parseInt(JOptionPane.showInputDialog("Digite o número do Apartamento")));
                    try {
                        tabela.remover(morador);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                case 9: break;
            }
        }
    }
}
