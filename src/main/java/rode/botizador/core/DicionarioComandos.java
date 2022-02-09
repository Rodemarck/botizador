package rode.botizador.core;

import rode.botizador.core.comandos.dados.DadosComando;

import java.util.HashMap;

public record DicionarioComandos(HashMap<String,Integer> nomesComandos,
                                 HashMap<Integer, DadosComando> comandos) {
}
