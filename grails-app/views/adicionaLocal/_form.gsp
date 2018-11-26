<div id="divMenssagem"></div>
<g:formRemote name="frmProduto" url="[controller: 'adicionaLocal', action: 'salvar']" update="divMenssagem" onSuccess="carregarLista()">
    Nome do local <input type="text" name="nome" value="${locais.nome}" /> <br/>
    Capacidade <input type="text" name="nome" value="${locais.capacidade}" /> <br/>
    <input type="submit" name="btnSalvar" value="Salvar" />
    <input type="button" name="btnCancelar" id="123" value="Cancelar" onclick="cancelar()"/>
    <input type="hidden" name="id" value="${locais.id}" />
</g:formRemote>