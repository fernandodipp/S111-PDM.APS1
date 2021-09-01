package com.example.s111_aps1_fernandodipp;

public class FrutaValidator {
    private final String nomeIvalido = "";
    private final float precoInvalido = 0;
    FrutasBD adicionandoFruta = new FrutasBD();

    public boolean validadorFruta(Fruta fruta) {
        if (fruta.nomeFruta.equals(nomeIvalido) || fruta.preco.equals(precoInvalido)) {
            return false;
        }
        if (fruta == null) {
            return false;
        } else {
            adicionandoFruta.adicionaFruta(fruta);
            return true;
        }

    }


}
