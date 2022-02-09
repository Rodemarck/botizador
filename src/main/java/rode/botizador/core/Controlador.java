package rode.botizador.core;


import lombok.Data;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveAllEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;
import rode.botizador.core.comandos.dados.DadosComando;

import java.util.Arrays;
import java.util.HashMap;

@Data
public class Controlador implements EventListener {
    private DicionarioComandos comandosTexto;
    private DicionarioComandos comandosReacoes;
    private HashMap<Class, DadosComando> comandosEspeciais;
    private DadosComando inicio;
    private DadosComando erro;

    @Override
    public void onEvent(@NotNull GenericEvent event) {
        if(event instanceof GuildMessageReceivedEvent e) recebeMensagemGuild(e);
        else if(event instanceof GuildMessageReactionAddEvent e) reageMensagemGuild(e);
        else if(event instanceof GuildMessageReactionRemoveEvent e) removeReacaoMensagemGuild(e);
        else if(event instanceof GuildMessageReactionRemoveAllEvent e) limpaReacoesMensagemGuild(e);
        else if(event instanceof ReadyEvent e) pronto(e);
    }

    public void recebeMensagemGuild(GuildMessageReceivedEvent e){
        var args = separaPalavras(e.getMessage().getContentDisplay());
        var comando = procuraComando(args,comandosTexto);
        comando.getExecutar().executaComando(args);
    }
    public void reageMensagemGuild(GuildMessageReactionAddEvent e){

    }
    public void removeReacaoMensagemGuild(GuildMessageReactionRemoveEvent e){

    }
    public void limpaReacoesMensagemGuild(GuildMessageReactionRemoveAllEvent e){}
    public void pronto(ReadyEvent e){}

    private String[] separaPalavras(String textoCru){
        return Arrays.stream(textoCru.split("(\\s|\\n)+"))
                .filter(s-> s.length() > 0)
                .toArray(i ->new String[i]);
    }
    private DadosComando procuraComando(String[] args, DicionarioComandos dicionarioComandos){
        var pos = 0;
        var len = args.length;
        DadosComando comando = null;
        if(dicionarioComandos.nomesComandos().containsKey(args[0]))
            comando = dicionarioComandos.comandos().get(args[0]);

        if(comando == null) return null;

        for(var i = 1; i < len; i++){
            if(!comando.getFilhos().nomesComandos().containsKey(args[i]))
                break;
            pos = comando.getFilhos().nomesComandos().get(args[i]);
            comando = comando.getFilhos().comandos().get(pos);
        }
        return comando;
    }
}
