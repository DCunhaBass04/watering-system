package ui.menu;

import ui.ConsumirPlanoFertirregaUI;
import ui.CriarPlanoDeRegaUI;
import utils.Utils;
import java.util.*;

public final class Main {

    private Main() {

    }

    public static void main(String[] args) {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Criar Plano de Rega", new CriarPlanoDeRegaUI()));
        options.add(new MenuItem("Ligar à base de dados (Leva às funcionalidades dependentes nesta)", new DatabaseMenu()));
        options.add(new MenuItem("Ler ficheiros relacionados a localidades", new GraphsMenu()));
        //options.add(new MenuItem("Ler sensor e controlar arrays", new SensorAndArrayMenu()));
        int option;
        try {
            do {
                option = Utils.showAndSelectIndex(options, "\n\nMain Menu");

                if ((option >= 0) && (option < options.size())) {
                    options.get(option).run();
                }
            } while (option != -1);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
