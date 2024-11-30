package ui.menu;

import database.DatabaseConnection;
import ui.*;
import utils.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public final class DatabaseMenu implements Runnable {

    @Override
    public void run() {
        try{
            loadProperties();

            String ipAddress = System.getProperty("database.inet");
            InetAddress inet = InetAddress.getByName(ipAddress);
            databaseMenu();
            DatabaseConnection.getInstance().closeConnection();
        } catch (UnknownHostException e) {
            System.out.println("\nDatabase Server not reachable!");
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("App properties not loaded!");
        }
    }
    private static void loadProperties() throws IOException {
        Properties properties = new Properties(System.getProperties());

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("application.properties");
        properties.load(inputStream);
        inputStream.close();

        System.setProperties(properties);
    }

    private void databaseMenu(){
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Registar fertirregas a partir de plano", new ConsumirPlanoFertirregaUI()));
        options.add(new MenuItem("Registar uma Operação de Colheita", new RegistarColheitaUI()));
        options.add(new MenuItem("Registar uma Operação de Poda", new RegistarPodaUI()));
        options.add(new MenuItem("Registar uma Aplicação de Fator de Produção", new RegistarAplicacaoFatorUI()));
        options.add(new MenuItem("Registar uma Operação de Monda", new RegistarMondaUI()));
        options.add(new MenuItem("Registar uma Operação de Semeadura", new RegistarSemeaduraUI()));
        options.add(new MenuItem("Registar uma Operação de fertirrega", new RegistarFertirregaUI()));
        options.add(new MenuItem("Sair", new ExitUI()));
        int option;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nMenu da Base de Dados");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
