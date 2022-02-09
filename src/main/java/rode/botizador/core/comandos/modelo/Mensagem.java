package rode.botizador.core.comandos.modelo;

import lombok.Data;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.io.File;
import java.util.function.Consumer;

@Data
public abstract class Mensagem {
    private Message mensagem;

    protected abstract void escreve(String str, Consumer<Message> action);
    protected abstract void escreve(EmbedBuilder eb, Consumer<Message> action);
    protected abstract void escreve(MessageEmbed me, Consumer<Message> action);
    protected abstract void escreve(File arq, Consumer<Message> action);

    public abstract void escreveDiretamente(String txt, Consumer<Message> action);
    public abstract void escreveDiretamente(EmbedBuilder eb, Consumer<Message> action);
    public abstract void escreveDiretamente(MessageEmbed me, Consumer<Message> action);
    public abstract void escreveDiretamente(File arq, Consumer<Message> action);

    public void responder(String txt){
        escreve(txt,null);
    }
    public void responder(EmbedBuilder eb){escreve(eb,null);}
    public void responder(MessageEmbed me){escreve(me,null);}
    public void responder(File arq){escreve(arq,null);}
    public void responder(String txt, Consumer<Message> action){
        escreve(txt,action);
    }
    public void responder(EmbedBuilder eb, Consumer<Message> action){escreve(eb,action);}
    public void responder(MessageEmbed me, Consumer<Message> action){escreve(me,action);}
    public void responder(File arq, Consumer<Message> action){escreve(arq,action);}

    public void mensagemDireta(String txt){escreveDiretamente(txt,null);}
    public void mensagemDireta(EmbedBuilder eb){escreveDiretamente(eb,null);}
    public void mensagemDireta(MessageEmbed me){escreveDiretamente(me,null);}
    public void mensagemDireta(File arq){escreveDiretamente(arq,null);}
    public void mensagemDireta(String txt, Consumer<Message> action){escreveDiretamente(txt,action);}
    public void mensagemDireta(EmbedBuilder eb, Consumer<Message> action){escreveDiretamente(eb,action);}
    public void mensagemDireta(MessageEmbed me, Consumer<Message> action){escreveDiretamente(me,action);}
    public void mensagemDireta(File arq, Consumer<Message> action){escreveDiretamente(arq,action);}
}
