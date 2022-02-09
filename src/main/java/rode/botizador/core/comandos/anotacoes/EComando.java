package rode.botizador.core.comandos.anotacoes;

public @interface EComando {
    public String grupo() default "geral";
    public String[] chaves();
}
