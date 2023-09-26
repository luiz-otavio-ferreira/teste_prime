package classes;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private String funcao;
    private String empresa;
    private String veiculo;
    private Double peso;
    private Integer altura;
    private String CEP;

    public Pessoa(String nome, String sobrenome, String funcao, String empresa, String veiculo, Double peso, Integer altura, String CEP) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.funcao = funcao;
        this.empresa = empresa;
        this.veiculo = veiculo;
        this.peso = peso;
        this.altura = altura;
        this.CEP = CEP;
    }

    public Pessoa(String nome, String sobrenome, String funcao, String empresa, String veiculo, Double peso, Integer altura) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.funcao = funcao;
        this.empresa = empresa;
        this.veiculo = veiculo;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
}
