package rode.botizador.core.comandos.dados;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;

@Data
@SuperBuilder
public class DadosComandosReacao extends DadosComando{
    private HashMap<String, FuncaoComando> comportamentos;
}
