package rode.botizador.core.comandos.dados;

import lombok.*;
import net.dv8tion.jda.api.Permission;
import rode.botizador.core.DicionarioComandos;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosComando {
    protected String[] comando;
    protected Permission permissao;
    protected String ajudaCurta = "";
    protected String ajudaCompleta = "";
    protected DicionarioComandos filhos;
    protected FuncaoComando executar;
    protected CanalFala canal;
}
