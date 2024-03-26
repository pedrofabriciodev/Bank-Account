package contaBanco;

public class ContaBanco {
//	ATRIBUTOS
	public int numConta;
	protected String tipo; //so aceitar cc(conta-corrente) ou cp(conta-poupança)
	private String dono;
	private float saldo;
	private boolean status;
	
//	CONSTRUTOR
	
	public ContaBanco() {
		this.saldo = 0;
		this.status = false;
	}
	
//	METODOS
	
	public void statusConta() {
		System.out.println("SOBRE A CONTA:");
		System.out.println(getDono()+ " abriu uma " + getTipo());
		System.out.println("Com numero de conta " + getNumConta());
		System.out.println("Com saldo de R$" + getSaldo());
		System.out.println("Status de conta:  " + isStatus());
		System.out.println("--------------------");
	}
	
	//mudar status para true, falar o tipo de conta, cc = 50saldo/cp=150saldo,
	public void abrirConta(String tipo) {
		setStatus(true);
		setTipo(tipo);
		if(getTipo()=="cc"){
			setSaldo(50);
			setTipo("Conta Corrente");
		}
		else if(getTipo()== "cp") {
				setSaldo(150);
				setTipo("Conta Poupança");
		}
	} 
	
	//nao pode ter dinheiro e nao pode ter debito 
	public void fecharConta() {
		if (getSaldo()> 0){
			System.out.println("Voce ainda possui saldo na conta, retire todo saldo antes do fechamento da conta!!!");
		}else if(getSaldo()< 0){
			System.out.print("A sua conta esta em debito, regularize antes de efetuar o fechamento da conta!!!");
		}else {
			setStatus(false);
		}		
	} 
	
	//conta tem que estar aberta(status==true)
	public void depositar(float valorDeposito) {
		if(isStatus() == true) {
			setSaldo(getSaldo() + valorDeposito);
		}else {
			System.out.print("Sua conta esta fechada, abra para realizar depositos!!!");
		}
	} 
	
	//conta tem que estar aberta(status==true), limitar o saque ao valor do saldo
	public void sacar(float valorSaque) {
		if (isStatus() == true) {
			if(getSaldo()>0) {
				setSaldo(getSaldo() - valorSaque);
			}else {
				System.out.print("Sua conta não possui saldo para saques!!!");
			}
		}else {
			System.out.print("Sua conta não esta aberta!!!");
		}
	} 
	
	//cc paga 12, cp paga 20, conta tem que estar aberta (status== true), tem quer ter dinheiro na conta
	public void pagarMensalidade() {
		int valorMensalidade = 0;
		
		if (getTipo().equals("Conta Corrente")) {
			valorMensalidade = 12;
			}else if(getTipo().equals("Conta Poupança")){
			valorMensalidade = 20;
		}
		if(isStatus()) {
			if(getSaldo()< valorMensalidade) {
				System.out.println("Saldo insuficiente!!!");
			}else {
				setSaldo(getSaldo()- valorMensalidade);
			}
		}else {
			System.out.println("Sua conta esta fechada, impossivel realizar o pagamento da mensalidade!!!");
		}
		
	}
	
	
//	GETTERS E SETTERS
	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}