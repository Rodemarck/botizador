package rode.botizador;

import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public final class  BotizadorAplication {
    private static final Logger log = LoggerFactory.getLogger(BotizadorAplication.class);
    public static Builder Criar(Class classe){
        return null;
    }
    public static void aa(){
        var stck = Thread.currentThread().getStackTrace();
        var l = stck.length - 1;
        System.out.println(stck[l].getClassName());
    }
    public static void bb(){
        aa();
    }
    public static class Builder{
        private Class classe;
        private String token;
        private Activity atividade;
        private Set<GatewayIntent> intents;

        public Builder token(String token){
            this.token = token;
            return this;
        }
        public Builder activity(Activity activity){
            this.atividade = activity;
            return this;
        }
        public Builder gatewayIntent(Set<GatewayIntent> intents){
            this.intents = intents;
            return this;
        }
    }
}
