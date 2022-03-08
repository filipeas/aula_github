public class ContaCorrente extends Conta {

    public ContaCorrente(long conta, double caixa) {
        super(conta, caixa);
        //TODO Auto-generated constructor stub
    }

    public void setValor(double valor){
        this.setCaixa(this.getCaixa() + valor);
    }
}
