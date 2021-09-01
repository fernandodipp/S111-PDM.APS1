package com.example.s111_aps1_fernandodipp;

public class Fruta {
    public String nomeFruta;
    public String preco;
    public String mesColheita;

    @Override
    public String toString() {
        return "Nome: " + nomeFruta + " Valor: R$" + preco + " Mês safra: " + mesColheita;
    }

}
