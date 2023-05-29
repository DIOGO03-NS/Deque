import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Atividade {

    public static ArrayList<Pessoa> gerarPessoas(){
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

        Random random = new Random();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                String id = "Pessoa" + (i * 10 + j + 1);
                String sexo = random.nextBoolean() ? "Masculino" : "Feminino";
                int idade = random.nextInt(100);
                boolean gestante = false;
                boolean lactante = false;
                boolean necessidadeEspecial = false;

                if (j == 0) {
                    necessidadeEspecial = true;
                } else if (j == 1) {
                    gestante = true;
                } else if (j == 2) {
                    lactante = true;
                } else if (j >= 3 && j <= 5) {
                    idade = 60 + random.nextInt(40);  // acima de 60 anos
                }

                Pessoa pessoa = new Pessoa(id, sexo, idade, gestante, lactante, necessidadeEspecial);
                pessoas.add(pessoa);
            }
        } 
        return pessoas;   
    }
    public static void main(String[] args) {
        Deque<Pessoa> filaAtendimentos = new Deque<Pessoa>();
        Queue<Pessoa> naoAtendidos = new LinkedList<Pessoa>();
        Queue<Pessoa> atendidos = new LinkedList<Pessoa>();
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

        int atendimentos = 0;
        while(atendimentos <= 100){
            pessoas = gerarPessoas();
            for(int c = 0; c < atendimentos + 1; c++){
                Pessoa p = pessoas.get(c);
                if(p.gestante || p.lactante){
                    filaAtendimentos.adicionaNoInicio(p);
                }else if(p.capacitista){
                    filaAtendimentos.adicionaNoInicio(p);
                }else if(p.idade > 60){
                    filaAtendimentos.adicionaNoInicio(p);
                }else{
                    filaAtendimentos.adicionaNoFinal(p);
                }
            }
            atendimentos++;
        }
    
        for(int i = 0; i < 100; i++){
            Pessoa p = filaAtendimentos.removeDoInicio();
            atendidos.add(p);
        }

        for(int i = 0; i < filaAtendimentos.size(); i++){
            Pessoa p = filaAtendimentos.removeDoInicio();
            naoAtendidos.add(p);
        }
    }

}
