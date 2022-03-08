abstract class Conta {
    private long conta;
    private double caixa;

    public Conta(long conta, double caixa) {
        this.setConta(conta);
        this.setCaixa(caixa);
    }

    // getters
    public long getConta() {
        return conta;
    }

    public void setConta(long conta) {
        this.conta = conta;
    }

    // setters
    public double getCaixa() {
        return caixa;
    }

    public void setCaixa(double caixa) {
        this.caixa = caixa;
    }
}
