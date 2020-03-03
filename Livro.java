public class FabricaAbstrataLivro {

    public static void main(String[] args) {

        FabricaAbstrataLivro fabrica1 = new FabricaConcreta1EditoraIntrínseca();
        Cliente cliente1 = new Cliente(fabrica1);
        cliente1.executar();

        FabricaAbstrataLivro fabrica2 = new FabricaConcreta2EditoraArqueiro();
        Cliente cliente2 = new Cliente(fabrica2);
        cliente2.executar();
    }
}

class Cliente {
    private ProdutoAbstratoA produtoA;
    private ProdutoAbstratoB produtoB;

    Cliente(FabricaAbstrataLivro fabrica) {
        produtoA = fabrica.criarLivroJohnGreen();
        produtoB = fabrica.criarLivroNicholasSparks();
    }

    void executar() {
        produtoB.interagir(produtoA);
    }
}

interface FabricaAbstrataLivro {
    ProdutoAbstratoA criarLivroJohnGreen();
    ProdutoAbstratoB criarLivroNicholasSparks();
}

interface ProdutoAbstratoA {

}

interface ProdutoAbstratoB {
    void interagir(ProdutoAbstratoA a);
}

class FabricaConcreta1EditoraIntrínseca implements FabricaAbstrataLivro {

    @Override
    public ProdutoAbstratoA criarProdutoACidadesDePapel() {
        return new CidadesDePapelProdutoA1();
    }
    @Override
    public ProdutoAbstratoB criarProdutoBTeoremaKatherine() {
        return new TeoremaKatherineProdutoB1();
    }
}

class FabricaConcreta2EditoraArqueiro implements FabricaAbstrataLivro {

    @Override
    public ProdutoAbstratoA criarProdutoANoSeuOlhar() {
        return new NoSeuOlharProdutoA2();
    }
    @Override
    public ProdutoAbstratoB criarProdutoBUmPortoSeguro() {
        return new UmPortoSeguroProdutoB2();
    }
}

class CidadesDePapelProdutoA1 implements ProdutoAbstratoA {

}

class TeoremaKatherineProdutoB1 implements ProdutoAbstratoB {

    @Override
    public void interagir(ProdutoAbstratoA a) {
        System.out.println(this.getClass().getNome() + " interage com " + a.getClass().getNome());
    }

}

class NoSeuOlharProdutoA2 implements ProdutoAbstratoA {

}

class UmPortoSeguroProdutoB2 implements ProdutoAbstratoB {

    @Override
    public void interagir(ProdutoAbstratoA a) {
        System.out.println(this.getClass().getNome() + " interage com " + a.getClass().getNome());
    }

}