package view;

public enum Opcao {
	
	LISTA_PUBLISHERS(1, "Listar todos os Publishers"), 
	LISTA_AUTHORS(2, "Listar todos os Authors"), 
	LISTA_BOOKS(3, "Listar todos os Books"),
	LISTA_BOOKSAUTHORS(4, "Listar todos os Booksauthors"),
	ADICIONA_PUBLISHERS(5, "Cadastrar um novo Publishers"),
	ADICIONA_AUTHORS(6, "Cadastrar um novo Authors"),
	ADICIONA_BOOKS(7, "Adicionar um novo Books"),
	ADICIONA_BOOKSAUTHORS(8, "Adicionar uma relacao entre Books e Authors"),
	REMOVER_PUBLISHERS(9, "Remover um Publishers"),
	REMOVER_AUTHORS(10, "Remover um Authors"),
	REMOVER_BOOKS(11, "Remover um Books"),
	REMOVER_BOOKSAUTHORS(12, "Remover uma relacao entre Books e Authors"),
	UPDATE_PUBLISHERS(13, "Atualizar um Publishers"),
	UPDATE_AUTHORS(14, "Atualizarr um Authors"),
	UPDATE_BOOKS(15, "Atualizar um Books"),
	UPDATE_BOOKSAUTHORS(16, "Atualizar a relacao entre Books e Authors"),
	SAIR(0, "Sair do programa e salvar os dados");
	
	public String descricao;
	public int codigo;
	
	private Opcao(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

}
