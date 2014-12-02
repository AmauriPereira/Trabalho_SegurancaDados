package br.edu.ifnmg.alvespereira.segurancadados.apresentacao.utilitarios;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.LoggerFactory;

public class logSegurancaDados {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(logSegurancaDados.class);

    public logSegurancaDados(String Tipo, String mensagem) {

        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

        try {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(context);

            // Chamada context.reset () para limpar qualquer configuração anterior
            context.reset();
            configurator.doConfigure("lib/logback.xml");
        } catch (JoranException je) {
            // StatusPrinter will handle this
        }

        if (Tipo.equals("INFO")) {
            logger.info(mensagem);
        } else {
            logger.trace(mensagem);
        }

    }

    public logSegurancaDados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
