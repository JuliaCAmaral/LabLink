package br.lablink.utils;

public class CpfCnpjUtil {

    private static final int TRES = 3;
    private static final int CINCO = 5;
    private static final int SEIS = 6;
    private static final int OITO = 8;
    private static final int NOVE = 9;
    private static final int ONZE = 11;
    private static final int DOZE = 12;
    private static final int QUATORZE = 14;

    public static String formatar(String valor) {
        if (valor == null || valor.isBlank()) {
            return null;
        }

        if (valor.length() == ONZE) {
            return valor.substring(0, TRES)
                    + "."
                    + valor.substring(TRES, SEIS)
                    + "."
                    + valor.substring(SEIS, NOVE)
                    + "-"
                    + valor.substring(NOVE, ONZE);
        }

        if (valor.contains(".")) {
            return valor.replace(".", "").replace("/", "");
        } else if (valor.length() == OITO) {
            return valor;
        }

        return valor.substring(0, 2)
                + "."
                + valor.substring(2, CINCO)
                + "."
                + valor.substring(CINCO, OITO)
                + "/"
                + valor.substring(OITO, DOZE)
                + "-"
                + valor.substring(DOZE, QUATORZE);
    }

    public static String removeFormatacao(String documentoFormatado) {
        return documentoFormatado.replaceAll("[^0-9]","");
    }
}