package rode.botizador.core.comandos.modelo;

import lombok.*;
import rode.botizador.core.comandos.dados.CanalFala;

@Data
@AllArgsConstructor
@Builder(access = AccessLevel.MODULE)
public abstract class Comando {
    private final String nome;
    private final String[] chaves;
    private final CanalFala canal;
    private String ajuda = "";
    private String ajudaCompleta = "";

    public abstract void executa(String[] args, Mensagem msg);
}
