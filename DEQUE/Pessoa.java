public class Pessoa {
    String id;
    String sexo;
    int idade;
    boolean gestante;
    boolean lactante;
    boolean capacitista;
    int tipo;


    public Pessoa(String id, String sexo, int idade, boolean gestante, boolean lactante, boolean capacitista) {
        this.id = id;
        this.sexo = sexo;
        this.idade = idade;
        this.gestante = gestante;
        this.lactante = lactante;
        this.capacitista = capacitista;
        tipo = 0;
        if(idade > 60){
            tipo = 1;
        }
        if(capacitista){
            tipo = 2;
        }
        if(lactante){
            tipo = 3;
        }
    }
}
