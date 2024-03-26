package contaBanco;

public class Conta {

	public static void main(String[] args) {
		ContaBanco c1 = new ContaBanco();
		ContaBanco c2 = new ContaBanco();
		
		c1.setNumConta(1);
		c1.setDono("chiquinho");
		c1.abrirConta("cc");
		
		c2.setNumConta(2);
		c2.setDono("chiquinha");
		c2.abrirConta("cp");

		c1.depositar(600);
		c2.depositar(1000);
		
		c1.sacar(120);
		c1.pagarMensalidade();
		c2.pagarMensalidade();
		
		c1.statusConta();
		c2.statusConta();
	}

}
