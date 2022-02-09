package rode.botizador.core.comandos.modelo;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GenericGuildMessageEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.io.File;
import java.util.function.Consumer;

@Data
@SuperBuilder
public class MensagemGuild extends Mensagem{
    private TextChannel canal;
    private GenericGuildMessageEvent event;

    @Override
    protected void escreve(String str, Consumer<Message> action) {
        if(action != null)
            canal.sendMessage(str).queue(action);
        else
            canal.sendMessage(str).queue();
    }

    @Override
    protected void escreve(EmbedBuilder eb, Consumer<Message> action) {
        if(action != null)
            canal.sendMessageEmbeds(eb.build()).queue(action);
        else
            canal.sendMessageEmbeds(eb.build()).queue();
    }

    @Override
    protected void escreve(MessageEmbed me, Consumer<Message> action) {
        if(action != null)
            canal.sendMessageEmbeds(me).queue(action);
        else
            canal.sendMessageEmbeds(me).queue();
    }

    @Override
    protected void escreve(File arq, Consumer<Message> action) {
        if(action != null)
            canal.sendFile(arq)
                    .queue(q->
                        action
                                .andThen(q2->arq.delete())
                                .accept(q)
                    );
        else
            canal.sendFile(arq)
                    .queue(q2->arq.delete());
    }

    @Override
    public void escreveDiretamente(String txt, Consumer<Message> action) {
        chatPrivado(pv->{
            if(action != null)
                pv.sendMessage(txt).queue(action);
            else
                pv.sendMessage(txt).queue();
        });
    }

    @Override
    public void escreveDiretamente(EmbedBuilder eb, Consumer<Message> action) {
        chatPrivado(pv->{
            if(action != null)
                pv.sendMessageEmbeds(eb.build()).queue(action);
            else
                pv.sendMessageEmbeds(eb.build()).queue();
        });
    }

    @Override
    public void escreveDiretamente(MessageEmbed me, Consumer<Message> action) {
        chatPrivado(pv->{
            if(action != null)
                pv.sendMessageEmbeds(me).queue(action);
            else
                pv.sendMessageEmbeds(me).queue();
        });
    }

    @Override
    public void escreveDiretamente(File arq, Consumer<Message> action) {
        chatPrivado(pv->{
            if(action != null)
                pv.sendFile(arq)
                        .queue(q->
                                action
                                        .andThen(q2->arq.delete())
                                        .accept(q)
                        );
            else
                pv.sendFile(arq)
                        .queue(q2->arq.delete());
        });
    }

    public void chatPrivado(Consumer<PrivateChannel> pv){
        canal.retrieveMessageById(event.getMessageIdLong())
                .queue(q->{
                    q.getMember()
                            .getUser()
                            .openPrivateChannel()
                            .queue(pv);
                });
    }

}
