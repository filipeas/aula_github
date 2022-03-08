public class ContaPoupanca extends Conta {

    private double rendimento;

    public ContaPoupanca(long conta, double caixa) {
        super(conta, caixa);
        // TODO Auto-generated constructor stub
        this.setRendimento(0.001);
    }

    // getters
    public double getRendimento() {
        return rendimento;
    }

    // setters
    private void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
    
    public void setValor(double valor){
        this.setCaixa(this.getCaixa() + valor);
    }

    @Override
    public double getCaixa() {
        return (this.getCaixa() * this.getRendimento()) + this.getCaixa();
    }
}
