package rode.botizador.core.comandos.dados;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;
import java.util.regex.Pattern;

@Data
@SuperBuilder
public class DadosComandoContinuo extends DadosComando {
    private HashMap<Pattern, FuncaoComando> comportamentos;
}
