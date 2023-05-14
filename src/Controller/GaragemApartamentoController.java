package Controller;

import Biblioteca.ListaObject.Lista;
import Model.Morador;

public class GaragemApartamentoController {

    Lista[] vetApartamento;

    public GaragemApartamentoController(){
        vetApartamento= new Lista[10];
        for (int i=0; i<10; i++){
            vetApartamento[i]= new Lista();
        }
    }

    public int hashcode(int numApartamento){
        for (int i=0; i<3; i++){
            numApartamento/= 10;
        }
        int posicao= numApartamento;
        return posicao;
    }

    public void cadastrar(Morador carro){
        int hash= carro.getNumApartamento();
        hash= hashcode(hash);
        Lista lista= vetApartamento[hash];
        if (lista.isEmpty()){
            lista.addFirst(carro);
        }
        else {
            try {
                lista.addLast(carro);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Morador consulta(Morador carro) throws Exception{
        int hash= carro.getNumApartamento();
        hash= hashcode(hash);
        Lista lista= vetApartamento[hash];
        int tamanho= lista.size();
        for (int i=0; i<tamanho; i++){
            Morador m= (Morador) lista.get(i);
            if (m.getNumApartamento() == carro.getNumApartamento()){
                return m;
            }
        }
        return null;
    }

    public void remover(Morador carro) throws Exception{
        int hash= carro.getNumApartamento();
        hash= hashcode(hash);
        Lista lista= vetApartamento[hash];
        int tamanho= lista.size();
        for (int i=0; i<tamanho; i++){
            Morador m= (Morador) lista.get(i);
            if (m.getNumApartamento() == carro.getNumApartamento()){
                lista.remove(i);
                break;
            }
        }
    }


}
