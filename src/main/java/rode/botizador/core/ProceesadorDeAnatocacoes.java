package rode.botizador.core;

import net.dv8tion.jda.api.entities.TextChannel;
import rode.botizador.BotizadorAplication;
import rode.botizador.core.comandos.modelo.Mensagem;

public class ProceesadorDeAnatocacoes {
    public static void varreProcurandoComandos(Class classe){
        BotizadorAplication.aa();
        BotizadorAplication.bb();
        /*System.out.println(classe.getPackageName());
        var reflections = new Reflections(classe.getPackageName());

        reflections.getTypesAnnotatedWith(EComando.class).forEach(System.out::println);*/
    }

    public static void main(String[] args) {
        varreProcurandoComandos(BotizadorAplication.class);
    }
}
